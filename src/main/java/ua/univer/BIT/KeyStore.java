package ua.univer.BIT;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class KeyStore {

    public static byte[] sessionKey = null;
    public static byte[] sessionKeyProd = null;

    public static String login;
    public static String password;

    static {
        List<String> list;
        try {
            list = Files.readAllLines(Paths.get("cred/credentials.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, String> map = list.stream()
                .collect(Collectors.toMap(el -> el.split("=")[0].trim(), el -> el.split("=")[1].trim()));
        login = map.get("login");
        password = map.get("password");
    }


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
