package ua.univer.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.IFBPGateService;
import ua.univer.BIT.BIT_PKCS11CL3;
import ua.univer.BIT.CertGenerator;
import ua.univer.BIT.KeyStore;
import ua.univer.BIT.cDevice;
import ua.univer.exeptions.MyException;
import ua.univer.fbpgateclient.DocumentElement;
import ua.univer.fbpgateclient.ExchData;
import ua.univer.fbpgateclient.LoginData;
import ua.univer.util.ConverterUtil;

import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static ua.univer.util.FileUtil.writeStringToFile;

@RestController
@RequestMapping(value = "/api")
public class LoginController extends BaseController{


    public LoginController(HttpClient httpClient, IFBPGateService gate, CertGenerator genRSA, cDevice dev, KeyStore keyStore) {
        super(httpClient, gate, genRSA, dev, keyStore);
    }


    @Scheduled(cron="0 0 10 * * MON-FRI")
    @GetMapping(value = "/v1/login", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> login() {

        logger.info("Method Login");

        String strLoginData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<LoginData>" +
                "<LoginMsg>" +
                "<BrokSystem>Test</BrokSystem>" +
                "<ArmID>" + cDevice.armID + "</ArmID>" +
                "<Base64Cert>" + Base64.getEncoder().encodeToString(dev.getCertificate().getEncoded()) +"</Base64Cert>" +
                "<Login>1</Login>" + // Логин
                "<Pwd>1</Pwd>" + // Пароль
                "<TokenMediaType>129</TokenMediaType>" + // Тип AES_GOST
                "<RSAEncCert>" + Base64.getEncoder().encodeToString(CertGenerator.RSACert) + "</RSAEncCert>" +
                "</LoginMsg>" +
                "</LoginData>";

        // Подпись данных для входа
        byte[] signedLogin = tokenLib.SignData(dev.getCertificate(), dev.UsbSlot, pin, strLoginData.getBytes(), true, avPath, err);

        String responseStr = gate.login(cDevice.armID, signedLogin);
        writeStringToFile(responseStr, "Response", ".xml");
        LoginData loginData = ConverterUtil.xmlToObject(responseStr, LoginData.class);
        if (loginData.login == null || loginData.login.isEmpty() || loginData.login.get(0).IsLoginOk == null || !loginData.login.get(0).IsLoginOk.equalsIgnoreCase("True")) {
            throw new MyException("Вход не выполнен !!");
        }
        // Генерируем ключ симметричного шифрования ДСТУ
        KeyStore.sessionKey = genRSA.GenerateSessionKeyB(Base64.getDecoder().decode(loginData.login.get(0).Base64Token));

        return ResponseEntity.ok().body(responseStr);
    }


    @GetMapping(value = "/v1/getPortfolio", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPortfolio() {

        logger.info("Method GetPortfolio");
        byte[] response = gate.getCryptXML(cDevice.armID, ExchData.Portfolio, false);
        byte[] decryptedResponse = BIT_PKCS11CL3.Decrypt(response, KeyStore.sessionKey, err);
        if(decryptedResponse == null) throw new MyException("Response is null");
        String responseStr = new String(decryptedResponse, StandardCharsets.UTF_8);
        writeStringToFile(responseStr, "Response", ".xml");
        DocumentElement de = ConverterUtil.xmlToObject(responseStr, DocumentElement.class);

        return ResponseEntity.ok().body(ConverterUtil.objectToJson(de));
    }


}
