package ua.univer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.IFBPGateService;
import ua.univer.BIT.CertGenerator;
import ua.univer.BIT.KeyStore;
import ua.univer.BIT.cDevice;
import ua.univer.exeptions.MyException;
import ua.univer.fbpgateclient.AddressOrder;
import ua.univer.fbpgateclient.DocumentElement;
import ua.univer.fbpgateclient.ExchData;
import ua.univer.util.ConverterUtil;

import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;

import static ua.univer.util.FileUtil.writeStringToFile;

@RestController
@RequestMapping(value = "/api/order")
public class OrderController extends BaseController{


    public OrderController(HttpClient httpClient, IFBPGateService gate, CertGenerator genRSA, cDevice dev, KeyStore keyStore) {
        super(httpClient, gate, genRSA, dev, keyStore);
    }


    @PostMapping(value = "/v1/newOrders")
    public ResponseEntity<String> newOrders (@RequestBody AddressOrder order){

        DocumentElement document = new DocumentElement();
        document.addressOrder.add(order);

        String xmlString = ConverterUtil.objectToXML(document);
        writeStringToFile( xmlString, "NewOrder", ".xml");
        //System.out.println(xmlString);

        byte[] signedXml = tokenLib.SignData(dev.certificate, dev.UsbSlot, pin, xmlString.getBytes(), true, avPath, err);
        byte[] crypt = genRSA.EncryptAES(signedXml, KeyStore.getFirst(), KeyStore.getSecond());
        byte[] response = gate.sendXMLResponse(dev.armID, crypt, ExchData.NewAddressOrder, false);
        byte[] decryptedResponse = genRSA.DecryptAES(response, KeyStore.getFirst(), KeyStore.getSecond());

        String responseStr = new String(decryptedResponse, StandardCharsets.UTF_8);
        writeStringToFile( xmlString, "Response", ".xml");
        DocumentElement de = ConverterUtil.xmlToObject(responseStr, DocumentElement.class);
        if (de.getAddressOrder() == null) throw new MyException("Список AddressOrders пуст");
        AddressOrder result = de.getAddressOrder().get(0);

        return ResponseEntity.ok().body(ConverterUtil.objectToJson(result));
    }

}
