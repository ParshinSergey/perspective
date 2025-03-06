package ua.univer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.IFBPGateService;
import ua.univer.fbpgateclient.CertGenerator;
import ua.univer.fbpgateclient.DocumentElement;
import ua.univer.fbpgateclient.ExchData;
import ua.univer.fbpgateclient.NewClient;
import ua.univer.util.ConverterUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.io.Writer;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController extends BaseController{

    public AccountController(HttpClient httpClient, IFBPGateService gate, CertGenerator genRSA) {
        super(httpClient, gate, genRSA);
    }


    @PostMapping(value = "/v1/createClient")
    public ResponseEntity<String> createClient(@RequestBody NewClient newClient) throws JAXBException {

        DocumentElement document = new DocumentElement();
        document.newClients.add(newClient);

/*        JAXBContext jc = JAXBContext.newInstance(DocumentElement.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Writer writer = new StringWriter();
        marshaller.marshal(de, writer);
        String xmlString = writer.toString();*/

        String xmlString = ConverterUtil.objectToXML(document);
        System.out.println(xmlString);


        byte[] signedXml = tokenLib.SignData(certificate, dev.UsbSlot, pin, xmlString.getBytes(), true, avPath, err);


        byte[] keyAES = new byte[16];
        for (int i=0; i<16; i++)
        {
            keyAES[i] = sessionKey[i];
        }
        byte[] ivAES = new byte[16];
        for (int i=0; i<16; i++)
        {
            ivAES[i] = sessionKey[i+16];
        }
        byte[] crypt = genRSA.EncryptAES(signedXml, keyAES, ivAES);

        byte[] response = gate.sendXMLResponse(armID, crypt, ExchData.AddNewClient, false);

        byte[] decryptedResponse = genRSA.DecryptAES(response, keyAES, ivAES);

        String responseStr = new String(decryptedResponse, StandardCharsets.UTF_8);
/*        JAXBContext jaxbContext = JAXBContext.newInstance(DocumentElement.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        // Убираем мусор вначале xml
        responseStr = responseStr.trim().replaceFirst("^([\\W]+)<","<");
        DocumentElement portfolio = (DocumentElement) jaxbUnmarshaller.unmarshal(new StringReader(responseStr));*/


        return ResponseEntity.ok().body(responseStr);
    }






}
