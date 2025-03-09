package ua.univer.BIT;

import org.springframework.stereotype.Component;

@Component
public class KeyStore {

    public static byte[] sessionKey = null;


    public static byte[] getFirst() {
        byte[] keyAES = new byte[16];
        System.arraycopy(sessionKey, 0, keyAES, 0, 16);
        return keyAES;
    }

    public static byte[] getSecond() {
        byte[] ivAES = new byte[16];
        System.arraycopy(sessionKey, 16, ivAES, 0, 16);
        return ivAES;
    }

}
