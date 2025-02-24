package ua.univer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.FBPGateService;
import org.tempuri.IFBPGateService;
import ua.avtor.DsLib.Certificate;
import ua.avtor.DsLib.CertificateException;
import ua.univer.BIT.BIT_PKCS11CL3;
import ua.univer.BIT.Holder;
import ua.univer.BIT.cDevice;
import ua.univer.fbpgateclient.DocumentElement;
import ua.univer.fbpgateclient.ExchData;
import ua.univer.fbpgateclient.LoginData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class BaseController {

    public static final String FBP_URL = "http://77.88.202.130:4000/FBPGate.IFBPGateService";

    Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected final HttpClient httpClient;
    protected final IFBPGateService gate;
    private String armID;
    private final BIT_PKCS11CL3 tokenLib = new BIT_PKCS11CL3();
    private byte[] sessionKey;
    private Holder<String> err = new Holder<>("");


    public BaseController(HttpClient httpClient, IFBPGateService gate) {
        this.httpClient = httpClient;
        this.gate = gate;
    }

    @GetMapping(value = "/v1/test", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> test(){

        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump","true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump","true");

        FBPGateService srv = new FBPGateService();
        IFBPGateService gate = srv.getWSHttpBindingFBPGate();

        String armID = "OU";
        byte[] signedLogin = "Example".getBytes();

        String xmlResponse = gate.login(armID, signedLogin);
        System.out.println(xmlResponse);


        return ResponseEntity.ok().body(xmlResponse);
    }


    @GetMapping(value = "/v1/login", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> login() throws CertificateException, JAXBException {

        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");

        // Библиотека подпись/шифрование/дешифрование/сессионный ключ
        /*BIT_PKCS11CL3 tokenLib = new BIT_PKCS11CL3();
        String strError = "";
        Holder<String> err = new Holder<>(strError);*/

        // Аппаратные ключи - BIT_PKCS11CL3.Av337PathChip
        // Программные ключи
        String avPath = BIT_PKCS11CL3.Av337PathProg;
        ArrayList<cDevice> devices = tokenLib.GetDeviceList(true, avPath, err);

        // Первое устройство
        cDevice dev = devices.get(0);

        // Список сертификатов устройства
        ArrayList<Certificate> certificates = tokenLib.GetCertificateList(dev.UsbSlot, avPath, err);

        // Первый сертификат из списка
        Certificate cer = certificates.get(3);

        String pin = "12345678";

        // Проверка пина
        if (!tokenLib.CheckPin(dev.UsbSlot, avPath, pin))
            return ResponseEntity.badRequest().body("Ошибка проверки ПИНа");

        // Рабочее место из сертификата
        armID = cer.getSubjectName("OU");

        // XML для входа
        String strLoginData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<LoginData>" +
                "<LoginMsg>" +
                "<BrokSystem>Test</BrokSystem>" +
                "<ArmID>" + armID + "</ArmID>" +
                "<Base64Cert>" + Base64.getEncoder().encodeToString(cer.getEncoded()) + "</Base64Cert>" +
                "<Login>1</Login>" + // Логин
                "<Pwd>1</Pwd>" + // Пароль
                "</LoginMsg>" +
                "</LoginData>";


        // Подпись данных для входа
        byte[] signedLogin = tokenLib.SignData(cer, dev.UsbSlot, pin, strLoginData.getBytes(), true, avPath, err);

        String xmlResponse = gate.login(armID, signedLogin);
        System.out.println(xmlResponse);

        // Парсим ответ xml
        JAXBContext jaxbContextLogin = JAXBContext.newInstance(LoginData.class);
        Unmarshaller unmarshaller = jaxbContextLogin.createUnmarshaller();
        LoginData loginData = (LoginData) unmarshaller.unmarshal(new StringReader(xmlResponse));

        if (loginData.login == null || loginData.login.isEmpty() || loginData.login.get(0).IsLoginOk == null || !loginData.login.get(0).IsLoginOk.equalsIgnoreCase("True")) {
            logger.warn(" Логина нет, или там пусто");
            return ResponseEntity.ok(xmlResponse);
        }

        // Генерируем ключ симметричного шифрования ДСТУ
        sessionKey = tokenLib.GenerateSessionKeyB(cer, dev.UsbSlot, pin, Base64.getDecoder().decode(loginData.login.get(0).Base64Token), avPath, err);


        return ResponseEntity.ok().body(xmlResponse);
    }


    @PostMapping(value = "/v1/getPortfolio", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> getPortfolio() throws JAXBException {

        byte[] bportfolio = gate.getCryptXML(armID, ExchData.Portfolio, false);
        byte[] decryptedPortfolio = BIT_PKCS11CL3.Decrypt(bportfolio, sessionKey, err);
        String portfolioXML = new String(decryptedPortfolio, StandardCharsets.UTF_8);
        JAXBContext jaxbContext = JAXBContext.newInstance(DocumentElement.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        // Убираем мусор вначале xml
        portfolioXML = portfolioXML.trim().replaceFirst("^([\\W]+)<","<");
        DocumentElement portfolio = (DocumentElement) jaxbUnmarshaller.unmarshal(new StringReader(portfolioXML));

        return ResponseEntity.ok().body(portfolioXML);
    }



    @GetMapping(value = "/v1/loginT", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> loginT() throws CertificateException, JAXBException, IllegalAccessException, InvocationTargetException {

        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump","true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump","true");

        // Библиотека подпись/шифрование/дешифрование/сессионный ключ
        BIT_PKCS11CL3 tokenLib = new BIT_PKCS11CL3();
        String strError = "";
        Holder<String> err = new Holder<>(strError);

        // Аппаратные ключи - BIT_PKCS11CL3.Av337PathChip
        // Программные ключи
        String avPath = BIT_PKCS11CL3.Av337PathProg;
        logger.info("Программные ключи " + avPath);

        ArrayList<cDevice> devices = tokenLib.GetDeviceList(true, avPath, err);

        // Первое устройство
        cDevice dev = new cDevice();
        if(devices.isEmpty()) {
            logger.info("Список устройств пуст");
        }
        else {
            dev = devices.get(0);
            logger.info("Имя устройства " + dev.DeviceName + " Тип устройства " + dev.DeviceType + " конец");
        }

        // Список сертификатов устройства
        ArrayList<Certificate> certificates = tokenLib.GetCertificateList(dev.UsbSlot, avPath, err);

        // Первый сертификат из списка
        Certificate cer = certificates.get(3);
        logger.info("Сертификат ");
        logger.info(new String(cer.getEncoded(), StandardCharsets.UTF_8));
        logger.info("getAuthorityKeyIdentifier " + new String(cer.getAuthorityKeyIdentifier(), StandardCharsets.UTF_8));
        logger.info("getSubjectName " + cer.getSubjectName("OU"));
        logger.info("getEMail " + cer.getEMail());
        logger.info("getSerial " + new String(cer.getSerial(), StandardCharsets.UTF_8));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dd1 = Instant.ofEpochMilli(cer.getNotBefore()).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dd2 = Instant.ofEpochMilli(cer.getNotAfter()).atZone(ZoneId.systemDefault()).toLocalDate();
       // Date date = new Date(cer.getNotBefore());
        logger.info("NotBefore " + dd1.format(dateTimeFormatter));
       // Date date2 = new Date(cer.getNotAfter());
        logger.info("NotAfter " + dd2.format(dateTimeFormatter));
        logger.info("_____________________________________");


       // Object someObject = getItSomehow();
        for (Field field : cer.getClass().getDeclaredFields()) {
            field.setAccessible(true); // You might want to set modifier to public first.
            Object value = field.get(cer);
            if (value != null) {
                System.out.println(field.getName() + " = " + value);
            }
        }

        logger.info("_____________________________________");

        for (Method method : cer.getClass().getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())
                    && method.getParameterTypes().length == 0
                    && method.getReturnType() != void.class
                    && (method.getName().startsWith("get") || method.getName().startsWith("is"))
            ) {
                Object value = method.invoke(cer);
                if (value != null) {
                    System.out.println(method.getName() + " = " + value);
                }
            }
        }

        logger.info("_____________________________________");


        String pin = "12345678";
        logger.info(pin);
        // Проверка пина
        if (!tokenLib.CheckPin(dev.UsbSlot, avPath, pin)) return ResponseEntity.badRequest().body("Ошибка проверки ПИНа");

        // Рабочее место из сертификата
        String armID = cer.getSubjectName("OU");

        // XML для входа
        String strLoginData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<LoginData>" +
                "<LoginMsg>" +
                "<BrokSystem>Test</BrokSystem>" +
                "<ArmID>" + armID + "</ArmID>" +
                "<Base64Cert>" + Base64.getEncoder().encodeToString(cer.getEncoded()) +"</Base64Cert>" +
                "<Login>1</Login>" + // Логин
                "<Pwd>1</Pwd>" + // Пароль
                "</LoginMsg>" +
                "</LoginData>";

        // Клиент WCF сервиса
        // http://77.88.202.130:4000/FBPGate.IFBPGateService/?wsdl
        // Перед добавлением в новом проекте обязательно добавить библиотеку METRO 2.0
        // Проверить прокси, оно куда-то записало по умолчанию
        FBPGateService srv = new FBPGateService();
        IFBPGateService gate = srv.getWSHttpBindingFBPGate();

        // Подпись данных для входа
        byte[] signedLogin = tokenLib.SignData(cer, dev.UsbSlot, pin, strLoginData.getBytes(), true, avPath, err);

        String xmlResponse = gate.login(armID, signedLogin);
        System.out.println(xmlResponse);

        // Парсим ответ xml
        JAXBContext jaxbContextLogin = JAXBContext.newInstance(LoginData.class);
        Unmarshaller unmarshaller = jaxbContextLogin.createUnmarshaller();
        LoginData loginData = (LoginData) unmarshaller.unmarshal(new StringReader(xmlResponse));

        if (loginData.login == null || loginData.login.isEmpty() || loginData.login.get(0).IsLoginOk == null || !loginData.login.get(0).IsLoginOk.equalsIgnoreCase("True"))
        {
            logger.warn("Логина нет, или там пусто");
            return ResponseEntity.ok(xmlResponse);
        }


        return ResponseEntity.ok().body(xmlResponse);
    }


    @GetMapping(value = "/v1/crypt", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
    public ResponseEntity<String> crypt(){

        String example = "example";

        BIT_PKCS11CL3 tokenLib = new BIT_PKCS11CL3();
        String strError = "";
        Holder<String> err = new Holder<>(strError);
/*

        String avPath = BIT_PKCS11CL3.Av337PathProg;
        ArrayList<cDevice> devices = tokenLib.GetDeviceList(true, avPath, err);
        cDevice dev = devices.get(0);

        ArrayList<Certificate> certificates = tokenLib.GetCertificateList(dev.UsbSlot, avPath, err);
        Certificate cer = certificates.get(0);
        String pin = "12345678";
        if (!tokenLib.CheckPin(dev.UsbSlot, avPath, pin)) return ResponseEntity.badRequest().body("Ошибка проверки ПИНа");

        // Генерируем ключ симметричного шифрования ДСТУ
        byte[] sessionKey = tokenLib.GenerateSessionKeyB(cer, dev.UsbSlot, pin, Base64.getDecoder().decode(login.login.get(0).Base64Token), avPath, err);

*/

        byte[] encryptedMessage = tokenLib.Encrypt(example.getBytes(StandardCharsets.UTF_8), "s".getBytes(), err);
        byte[] decryptedMessage = tokenLib.Decrypt(encryptedMessage, "s".getBytes(), err);

        if (decryptedMessage == null){
            return ResponseEntity.ok().body("там пусто");
        }

        return ResponseEntity.ok().body(new String(decryptedMessage));
    }



}
