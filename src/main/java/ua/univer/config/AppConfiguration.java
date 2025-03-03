package ua.univer.config;

import com.sun.xml.ws.client.BindingProviderProperties;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tempuri.FBPGateService;
import org.tempuri.IFBPGateService;
import ua.univer.fbpgateclient.CertGenerator;
import ua.univer.fbpgateclient.LoginData;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.ws.BindingProvider;
import java.io.File;
import java.net.http.HttpClient;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

@Configuration
public class AppConfiguration {
    final static String PACKAGE = LoginData.class.getPackage().getName();
    public final static String DIRECTORY = "INBOX_OUTBOX";


    @Bean
    public IFBPGateService getGate() {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        FBPGateService service = new FBPGateService();
        IFBPGateService gate = service.getWSHttpBindingFBPGate();

        Map<String, Object> requestContext = ((BindingProvider)gate).getRequestContext();
        requestContext.put(BindingProviderProperties.REQUEST_TIMEOUT, 3000); // Timeout in millis
        requestContext.put(BindingProviderProperties.CONNECT_TIMEOUT, 1000); // Timeout in millis

        return gate;
    }

    @Bean
    public CertGenerator getCertGenerator(){
        CertGenerator genRSA = new CertGenerator();
        genRSA.GenerateRSA();
        return genRSA;

    }


    @Bean
    public Marshaller getMarshaller() throws JAXBException {
        File directory = new File(DIRECTORY);
        if(!directory.exists()) {
            directory.mkdir();
        }
        JAXBContext jc = JAXBContext.newInstance(LoginData.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return marshaller;
    }

    @Bean
    public Unmarshaller getUnmarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(LoginData.class);
        return context.createUnmarshaller();
    }



    @Bean
    public HttpClient getHttpClient() throws NoSuchAlgorithmException, KeyManagementException {

        // to disable hostname verification
        Properties props = System.getProperties();
        props.setProperty("jdk.internal.httpclient.disableHostnameVerification", Boolean.TRUE.toString());

        // https://stackoverflow.com/questions/1201048/allowing-java-to-use-an-untrusted-certificate-for-ssl-https-connection/1201102#1201102
        // https://stackoverflow.com/questions/52988677/allow-insecure-https-connection-for-java-jdk-11-httpclient

        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        //HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        return HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .sslContext(sc)
                .build();
    }

}
