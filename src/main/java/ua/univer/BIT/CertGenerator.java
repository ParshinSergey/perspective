/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.univer.BIT;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import sun.security.util.KnownOIDs;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateValidity;
import sun.security.x509.CertificateVersion;
import sun.security.x509.CertificateX509Key;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

public class CertGenerator {

    public static byte[] RSACert = null;
    KeyPair kp = null;

    public void GenerateRSA() {

        String commonName = "TEST CERT";

        int keySize = 2048;
        int validDays = 365;

        try {

            X500Name distinguishedName = new X500Name(commonName, commonName, commonName, "UA");
            kp = generateRSAKeyPair(keySize);

            PrivateKey privkey = kp.getPrivate();
            X509CertInfo info = new X509CertInfo();

            Date since = new Date(); // Since Now
            Date until = new Date(since.getTime() + validDays * 86400000L); // Until x days (86400000 milliseconds in one day)

            CertificateValidity interval = new CertificateValidity(since, until);
            BigInteger sn = new BigInteger(64, new SecureRandom());

            info.set(X509CertInfo.VALIDITY, interval);
            info.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber(sn));
            info.set(X509CertInfo.SUBJECT, distinguishedName);
            info.set(X509CertInfo.ISSUER, distinguishedName);
            info.set(X509CertInfo.KEY, new CertificateX509Key(kp.getPublic()));
            info.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));

           // AlgorithmId algo = new AlgorithmId(AlgorithmId.md5WithRSAEncryption_oid);
            AlgorithmId algo = new AlgorithmId(ObjectIdentifier.of(KnownOIDs.MD5withRSA));
            info.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algo));

// Sign the cert to identify the algorithm that is used.
            X509CertImpl cert = new X509CertImpl(info);
            cert.sign(privkey, "SHA1withRSA");

// Update the algorithm and sign again
            algo = (AlgorithmId) cert.get(X509CertImpl.SIG_ALG);
            info.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, algo);

            cert = new X509CertImpl(info);
            cert.sign(privkey, "SHA1withRSA");

            RSACert = cert.getEncoded();

        } catch (IOException | NoSuchAlgorithmException | CertificateException | InvalidKeyException | NoSuchProviderException | SignatureException e) {
            e.printStackTrace();
        }
    }

    private static KeyPair generateRSAKeyPair(int keySize) throws NoSuchAlgorithmException {

        KeyPairGenerator kpg;
        kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(keySize);

        return kpg.genKeyPair();
    }


    private static String byteArraytoBase64String(final byte[] data) {

        Base64.Encoder enc = Base64.getEncoder();
        return enc.encodeToString(data);
    }


    public byte[] GenerateSessionKeyB(final byte[] token) {
        try {
            Cipher decrypt = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            decrypt.init(Cipher.DECRYPT_MODE, kp.getPrivate());
            return decrypt.doFinal(token);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Cipher cipher = null;
    
    public byte[] EncryptAES(final byte[] data, final byte[] key, final byte[] iv) {
        try {
            if (cipher == null)
            {
                //Security.addProvider(new BouncyCastleProvider());
                cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            }
            
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);

            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public byte[] DecryptAES(final byte[] data, final byte[] key, final byte[] iv) {
        try {
            if (cipher == null)
            {
                //Security.addProvider(new BouncyCastleProvider());
                cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            }
            
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);

            return cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
