package ua.univer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Security;

@SpringBootApplication
public class PerspectiveApplication {

	public static void main(String[] args) {

/*		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");*/
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		SpringApplication.run(PerspectiveApplication.class, args);
	}

}
