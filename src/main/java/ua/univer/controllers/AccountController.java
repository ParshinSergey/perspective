package ua.univer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.IFBPGateService;
import ua.univer.BIT.KeyStore;
import ua.univer.BIT.cDevice;
import ua.univer.exeptions.MyException;
import ua.univer.fbpgateclient.CertGenerator;
import ua.univer.fbpgateclient.DocumentElement;
import ua.univer.fbpgateclient.ExchData;
import ua.univer.fbpgateclient.NewClient;
import ua.univer.util.ConverterUtil;

import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController extends BaseController{


    public AccountController(HttpClient httpClient, IFBPGateService gate, CertGenerator genRSA, cDevice dev, KeyStore keyStore) {
        super(httpClient, gate, genRSA, dev, keyStore);
    }

    @PostMapping(value = "/v1/createClient")
    public ResponseEntity<String> createClient(@RequestBody NewClient newClient) {

        DocumentElement document = new DocumentElement();
        document.newClients.add(newClient);

        String xmlString = ConverterUtil.objectToXML(document);
        System.out.println(xmlString);

        byte[] signedXml = tokenLib.SignData(dev.certificate, dev.UsbSlot, pin, xmlString.getBytes(), true, avPath, err);
        byte[] crypt = genRSA.EncryptAES(signedXml, KeyStore.getFirst(), KeyStore.getSecond());
        byte[] response = gate.sendXMLResponse(dev.armID, crypt, ExchData.AddNewClient, false);
        byte[] decryptedResponse = genRSA.DecryptAES(response, KeyStore.getFirst(), KeyStore.getSecond());

        String responseStr = new String(decryptedResponse, StandardCharsets.UTF_8);
        DocumentElement de = ConverterUtil.xmlToObject(responseStr, DocumentElement.class);
        if (de.getNewClients() == null) throw new MyException("Список NewClients пуст");
        NewClient result = de.getNewClients().get(0);

        return ResponseEntity.ok().body(ConverterUtil.objectToJson(result));
    }






}
