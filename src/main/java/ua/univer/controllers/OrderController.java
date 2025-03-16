package ua.univer.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tempuri.IFBPGateService;
import ua.univer.BIT.BIT_PKCS11CL3;
import ua.univer.BIT.CertGenerator;
import ua.univer.BIT.KeyStore;
import ua.univer.BIT.cDevice;
import ua.univer.dto.FormOrder;
import ua.univer.dto.UtilForm;
import ua.univer.exeptions.MyException;
import ua.univer.fbpgateclient.AddressOrder;
import ua.univer.fbpgateclient.DocumentElement;
import ua.univer.fbpgateclient.ExchData;
import ua.univer.util.ConverterUtil;

import javax.validation.Valid;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;

import static ua.univer.util.FileUtil.writeStringToFile;

@RestController
@RequestMapping(value = "/api/order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController extends BaseController{


    public OrderController(HttpClient httpClient, IFBPGateService gate, CertGenerator genRSA, cDevice dev, KeyStore keyStore) {
        super(httpClient, gate, genRSA, dev, keyStore);
    }


    @GetMapping(value = "/v2/getAddressOrders", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> getAddressOrdersV2() {

        logger.info("Method AddressOrdersV2");
        byte[] response = gate.getCryptXML(cDevice.armID, ExchData.AddressOrders, false);
        byte[] decryptedResponse = genRSA.DecryptAES(response, KeyStore.getFirst(), KeyStore.getSecond());
        String responseStr = new String(decryptedResponse, StandardCharsets.UTF_8);
        writeStringToFile(responseStr, "Response", ".xml");
        DocumentElement de = ConverterUtil.xmlToObject(responseStr, DocumentElement.class);

        return ResponseEntity.ok().body(ConverterUtil.objectToJson(de));
    }



    @PostMapping(value = "/v2/newOrders")
    public ResponseEntity<String> newOrdersV2 (@RequestBody AddressOrder order){

        logger.info("Method NewOrderV2");
        DocumentElement document = new DocumentElement();
        document.addressOrder.add(order);

        String xmlString = ConverterUtil.objectToXML(document);
        writeStringToFile(xmlString, "NewOrder", ".xml");

        byte[] signedXml = tokenLib.SignData(dev.certificate, dev.UsbSlot, pin, xmlString.getBytes(), true, avPath, err);
        byte[] crypt = genRSA.EncryptAES(signedXml, KeyStore.getFirst(), KeyStore.getSecond());
        byte[] response = gate.sendXMLResponse(cDevice.armID, crypt, ExchData.NewAddressOrder, false);
        byte[] decryptedResponse = genRSA.DecryptAES(response, KeyStore.getFirst(), KeyStore.getSecond());

        String responseStr = new String(decryptedResponse, StandardCharsets.UTF_8);
        writeStringToFile( responseStr, "Response", ".xml");
        DocumentElement de = ConverterUtil.xmlToObject(responseStr, DocumentElement.class);
        if (de.getAddressOrder() == null) throw new MyException("Список AddressOrders пуст");
        AddressOrder result = de.getAddressOrder().get(0);

        return ResponseEntity.ok().body(ConverterUtil.objectToJson(result));
    }


    @GetMapping(value = "/v1/getAddressOrders", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> getAddressOrders() {

        logger.info("Method AddressOrders");
        byte[] response = gate.getCryptXML(cDevice.armID, ExchData.AddressOrders, false);
        byte[] decryptedResponse = BIT_PKCS11CL3.Decrypt(response, KeyStore.sessionKey, err);
        if(decryptedResponse == null) throw new MyException("Response is null");
        String responseStr = new String(decryptedResponse, StandardCharsets.UTF_8);
        writeStringToFile(responseStr, "Response", ".xml");
        DocumentElement de = ConverterUtil.xmlToObject(responseStr, DocumentElement.class);

        return ResponseEntity.ok().body(ConverterUtil.objectToJson(de));
    }

    @PostMapping(value = "/v1/newOrders")
    public ResponseEntity<String> newOrders (@RequestBody @Valid FormOrder form){

        logger.info("Method NewOrders");
        DocumentElement document = new DocumentElement();
        AddressOrder order = UtilForm.convertFormToAddressOrder(form);
        document.addressOrder.add(order);

        String xmlString = ConverterUtil.objectToXML(document);
        writeStringToFile(xmlString, "NewOrder", ".xml");

        byte[] signedXml = tokenLib.SignData(dev.certificate, dev.UsbSlot, pin, xmlString.getBytes(), true, avPath, err);
        byte[] crypt = BIT_PKCS11CL3.Encrypt(signedXml, KeyStore.sessionKey, err);
        byte[] response = gate.sendXMLResponse(cDevice.armID, crypt, ExchData.NewAddressOrder, false);
        byte[] decryptedResponse = BIT_PKCS11CL3.Decrypt(response, KeyStore.sessionKey, err);

        if(decryptedResponse == null) throw new MyException("Response is null");
        String responseStr = new String(decryptedResponse, StandardCharsets.UTF_8);
        writeStringToFile( responseStr, "Response", ".xml");
        DocumentElement de = ConverterUtil.xmlToObject(responseStr, DocumentElement.class);
        if (de.getAddressOrder() == null) throw new MyException("Список AddressOrders пуст");
        AddressOrder result = de.getAddressOrder().get(0);

        return ResponseEntity.ok().body(ConverterUtil.objectToJson(result));
    }

}
