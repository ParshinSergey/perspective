package ua.univer.ua.BIT;
import java.awt.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import sun.security.pkcs11.wrapper.CK_ATTRIBUTE;
import sun.security.pkcs11.wrapper.PKCS11Exception;
import ua.avtor.DsLib.*;
import ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module;
import ua.avtor.DsLib.PrivateKeys.PrivateKey;
import ua.avtor.DsLib.PrivateKeys.PrivateKeyDstu;
import ua.avtor.DsLib.Transport.HttpTransport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author V.Shevchenko
 */
public class BIT_PKCS11CL3 {

    public static String Av337PathChip = "Av337CryptokiD.dll";
    public static String Av337PathProg = "AvSW1CryptokiD.dll";
    private static Component modalToComponent;
    
      
    private static ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module _moduleChip = null;
    private static ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module _moduleProg = null;
    
    public static boolean bMustTimeStamped = true;
    
    public static String TSP_SERVER_URL = "http://ca.informjust.ua/services/tsp/";
    
    // Установите следующие значения в NULL, если прокси-сервер не используется.
    public static String HTTP_PROXY = null;
    public static int HTTP_PROXY_PORT = 0;
    // Аутентификация на прокси-сервере. Установите следующие значения в NULL для анонимного использования прокси.
    public static String HTTP_PROXY_USER = null;
    public static String HTTP_PROXY_PASSWORD = null;
    
    public static String LastError = "";
    
    static
    {
        InitAvSW1();
        InitAv337();
    }
    
    private static void InitAvSW1()
    {
        String libraryPath = "";
        
        if (OSValidator.isWindows())
        {
            if(!System.getProperty("sun.arch.data.model").contains("64"))
            {
                libraryPath = "PKCS11/AvSW1/Windows_x86/AvSW1CryptokiD.dll";
            }
            else
            {
                libraryPath = "PKCS11/AvSW1/Windows_x64/AvSW1CryptokiD.dll";
            }
        }
        else if (OSValidator.isMac())
        {
            libraryPath = "PKCS11/AvSW1/MacOS_x64/libavSW1p11d.dylib";
        }
        else
        {
            if(!System.getProperty("sun.arch.data.model").contains("64"))
            {
                libraryPath = "PKCS11/AvSW1/Linux_x86/libavSW1p11d.so";
            }
            else
            {
                libraryPath = "PKCS11/AvSW1/Linux_x64/libavSW1p11d.so";
            }
        }
        
        String tmpDir = System.getProperty("java.io.tmpdir");
        File filename = new File(libraryPath);
        InputStream is = BIT_PKCS11CL3.class.getClassLoader().getResourceAsStream(libraryPath);
        
        if (is == null)
        {
            SetError("Can't get jar resource " + libraryPath, "InitAvSW1");
            return;
        }
        
        File fNewPath = new File(tmpDir + "/" + filename.getName());
        
        try
        {
            if(fNewPath.exists())
            {            
               fNewPath.delete();
            }
            
            OutputStream os = new FileOutputStream(fNewPath);

            byte[] buffer = new byte[1024];
            int bytesRead;
            //read from is to buffer
            while((bytesRead = is.read(buffer)) !=-1){
                os.write(buffer, 0, bytesRead);
            }
            is.close();
            //flush OutputStream to write any buffered data to file
            os.flush();
            os.close();

            fNewPath.deleteOnExit();
            
        }
        catch(Exception ex)
        {
            String errMes = ex.getMessage();
            
            if (errMes == null)
            {
                errMes = ex.getClass().toString();
            }
            
            SetError(errMes, "InitAvSW1");
        }
        
        if (fNewPath.exists())
        {
            Av337PathProg = fNewPath.getPath();
        }
        else
        {
            SetError("Temp library path not exists " + fNewPath.getPath(), "InitAvSW1");
        }
    }
    
    private static void InitAv337()
    {
        String libraryPath = "";
        
        if (OSValidator.isWindows())
        {
            if(!System.getProperty("sun.arch.data.model").contains("64"))
            {
                libraryPath = "PKCS11/Av337/Windows_x86/Av337CryptokiD.dll";
            }
            else
            {
                libraryPath = "PKCS11/Av337/Windows_x64/Av337CryptokiD.dll";
            }
        }
        else if (OSValidator.isMac())
        {
            libraryPath = "PKCS11/Av337/MacOS_x64/libav337p11d.dylib";
        }
        else
        {
            if(!System.getProperty("sun.arch.data.model").contains("64"))
            {
                libraryPath = "PKCS11/Av337/Linux_x86/libav337p11d.so";
            }
            else
            {
                libraryPath = "PKCS11/Av337/Linux_x64/libav337p11d.so";
            }
        }
        
        String tmpDir = System.getProperty("java.io.tmpdir");
        File filename = new File(libraryPath);
        InputStream is = BIT_PKCS11CL3.class.getClassLoader().getResourceAsStream(libraryPath);
        
        if (is == null)
        {
            SetError("Can't get jar resource " + libraryPath, "InitAv337");
            return;
        }
        
        File fNewPath = new File(tmpDir + "/" + filename.getName());
        
        try
        {
            if(fNewPath.exists())
            {            
               fNewPath.delete();
            }
            
            OutputStream os = new FileOutputStream(fNewPath);

            byte[] buffer = new byte[1024];
            int bytesRead;
            //read from is to buffer
            while((bytesRead = is.read(buffer)) !=-1){
                os.write(buffer, 0, bytesRead);
            }
            is.close();
            //flush OutputStream to write any buffered data to file
            os.flush();
            os.close();

            fNewPath.deleteOnExit();
            
        }
        catch(Exception ex)
        {
            String errMes = ex.getMessage();
            
            if (errMes == null)
            {
                errMes = ex.getClass().toString();
            }
            
            SetError(errMes, "InitAv337");            
        }
        
        if (fNewPath.exists())
        {
            Av337PathChip = fNewPath.getPath();
        }
        else
        {
            SetError("Temp library path not exists " + fNewPath.getPath(), "InitAv337");
        }
    }
    
    public static void SetError(Holder<String> strError, String Proc)
    {
        if (strError.value != null && strError.value.length()>0)
        {
            LastError += Proc + ": " + strError.value + "|";
        }
    }
    
    public static void SetError(String strError, String Proc)
    {
        if (strError != null && strError.length()>0)
        {
            LastError += Proc + ": " + strError + "|";
        }
    }
    
    public static String GetError()
    {
        String retVal = LastError.toString();
        LastError = "";
        return retVal;
    }
    
    public static boolean IsSetTSPServer()
    {
        return (!(TSP_SERVER_URL == null || TSP_SERVER_URL.length() < 1));
    }
    
    public static boolean IsSetHTTPProxy()
    {
        return (!(HTTP_PROXY == null || HTTP_PROXY.length() < 1 || HTTP_PROXY_PORT < 1));
    }
    
    private ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module GetModule(final String Av337Path)
    {
        if (!new File(Av337Path).exists())
        {
            SetError("Module not found " + Av337Path, "GetModule");
        }
        
        if (Av337Path.equalsIgnoreCase(Av337PathChip))
        {
            if (_moduleChip == null)
            {
             _moduleChip = AccessController.doPrivileged(new PrivilegedAction <ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module>()
                            {
                                @Override
                                public ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module run()
                               {
                                    try {
                                        return new Pkcs11Module(Av337Path);
                                    } catch (PKCS11Exception ex) {
                                        SetError(ex.getMessage(), "GetModule");
                                        return null;
                                    }
                               }
                                });
            }
            return _moduleChip;
        }
        else
        if (Av337Path.equalsIgnoreCase(Av337PathProg))
        {
            if (_moduleProg == null)
            {
            _moduleProg = AccessController.doPrivileged(new PrivilegedAction <ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module>()
                            {
                                @Override
                                public ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module run()
                               {
                                    try {
                                        return new Pkcs11Module(Av337Path);
                                    } catch (PKCS11Exception ex) {
                                        SetError(ex.getMessage(), "GetModule");
                                        return null;
                                    }
                               }
                                });
            }
             return _moduleProg;
        }
        else return null;
    }
    
    //////// СПИСОК УСТРОЙСТВ
    public ArrayList<cDevice> GetDeviceList(final boolean bWithToken, final String Av337Path, final Holder<String> strError)
    {
        return AccessController.doPrivileged(new PrivilegedAction <ArrayList<cDevice>>()
    {
      @Override
      public ArrayList<cDevice> run()
       {
        try  
        {
            ArrayList<cDevice> lst = new ArrayList<cDevice>();
            long[] nSlots = null;
            
            ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module module = GetModule(Av337Path);
            
            if (module == null)
            {
                strError.value = "Module not initialized";
                return null;
            }
            
            nSlots = module.getSlotList(bWithToken);
            
            if((nSlots != null) && (nSlots.length > 0))
                {
                    for (int i = 0; i<nSlots.length; i++)
                    {
                        cDevice dev = new cDevice();
                        dev.UsbSlot = nSlots[i];
                        dev.DeviceType = Av337Path;
                        
                        if (Av337Path.equalsIgnoreCase("AV337CRYPTOKID.DLL"))
                        {
                            dev.DeviceType = "Avtor337chip";
                        }
                        else if (Av337Path.equalsIgnoreCase("AVSW1CRYPTOKID.DLL"))
                        {
                            dev.DeviceType = "Avtor337prog";
                        }
                        else
                        {
                            dev.DeviceType = "TokenUnknown";
                        }
                        
                        dev.DeviceName = dev.DeviceType + " " + i;
                        
                        lst.add(dev);
                    }
                }
            
            return lst;
        }
        catch(Throwable ex)
        {             
            Throwable inner = ex.getCause();
            String Message = "";
            if (inner != null)
            {
                Message = inner.getMessage() + "; ";
            }
            
            strError.value = Message + ex.getMessage();
            return null;}
       }
       });
    }
    //////// СПИСОК УСТРОЙСТВ
    
    //////// СПИСОК Сертификаторв
    public ArrayList<Certificate> GetCertificateList(final long nSlotID, final String Av337Path, final Holder<String> strError)
    {
              return AccessController.doPrivileged(new PrivilegedAction <ArrayList<Certificate>>()
    {
      @Override
      public ArrayList<Certificate> run()
       {
           try
           {
                ArrayList<Certificate> lst = new ArrayList<Certificate>();
                ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module module = GetModule(Av337Path);
            
                if (module == null)
                {
                    strError.value = "Module not initialized";
                    return null;
                }
                
                ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Session p11Sess = module.newSession(nSlotID);
                
                sun.security.pkcs11.wrapper.CK_ATTRIBUTE[] attr = new CK_ATTRIBUTE[1];
                
                attr[0] = new CK_ATTRIBUTE();
                
                attr[0].type = sun.security.pkcs11.wrapper.PKCS11Constants.CKA_CLASS;
                attr[0].pValue = new Long(sun.security.pkcs11.wrapper.PKCS11Constants.CKO_CERTIFICATE);
                
                long[] objects = null;

                p11Sess.findObjectsInit(attr);
                objects = p11Sess.findObjects(999);
                p11Sess.findObjectsFinal();
                
                attr[0] = new CK_ATTRIBUTE();
                
                attr[0].type = sun.security.pkcs11.wrapper.PKCS11Constants.CKA_VALUE;
                
                if (objects != null)
                for (int i = 0; i< objects.length; i++)
                {
                    attr[0].pValue = null;
                    try
                    {
                        p11Sess.getAttributeValue(objects[i], attr);
                        Certificate crt = new Certificate((byte[])attr[0].pValue);
                        lst.add(crt);
                    }
                    catch(Exception ex) {continue;}
                }
                
            return lst;
           }
            catch(Throwable ex)
            {             
                Throwable inner = ex.getCause();
                String Message = "";
                if (inner != null)
                {
                    Message = inner.getMessage() + "; ";
                }

                strError.value = Message + ex.getMessage();
                return null;}
           }
       });
    }
    //////// СПИСОК Сертификаторв
    
    /////// Проверка ПИН кода
    public boolean CheckPin(final long nSlotID, final String Av337Path, final String strPIN)
    {
        Object obj = AccessController.doPrivileged(new PrivilegedAction <Object>()
            {
             @Override
             public Object run()
            {
                Object temp = new Object();
                ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Session p11Sess = null;
                try
                {
                    ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module module = GetModule(Av337Path);
                    
                    if (module == null)
                    {
                        temp = false;
                        return temp;
                    }
                    
                    p11Sess = module.newSession(nSlotID);
               
                    p11Sess.login(strPIN);
                    
                    temp = true;
                    return temp;
                }
                catch(Exception ex)
                {
                    temp = false;
                    
                    SetError(ex.getMessage(), "CheckPin");
                    
                    return temp;
                }
                finally
                {
                    if (p11Sess != null) try {
                        p11Sess.logout();
                        p11Sess = null;
                    } catch (PKCS11Exception ex) {
                    }
                }
                        
            }
            });
        
        if (obj != null)
        {
            return Boolean.parseBoolean(obj.toString());
        }
        
        return false;
    }
    /////// Проверка ПИН кода    

    //////// Подписание
    public byte[] SignData(final Certificate cert, final long nSlotID, final String strPin, final byte[] rawData, final boolean bDataAtached, final String Av337Path, final Holder<String> strError)
    {
        if ((rawData == null) || (rawData.length <= 0) || (cert == null))
            {
                if (cert == null)
                {
                    strError.value = "Сертифікат пидписувача відсутній";
                }
                else
                {
                    strError.value = "Дані на підпис відсутні";
                }

                return null;
            }
        
          return AccessController.doPrivileged(new PrivilegedAction <byte[]>()
    {
      @Override
      public byte[] run()
       {
           try
           {
                ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module module = GetModule(Av337Path);
            
                if (module == null)
                {
                    strError.value = "Module not initialized";
                    return null;
                }
                
                ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Session p11Sess = null;
                try
                {
                p11Sess = module.newSession(nSlotID);
               
                p11Sess.login(strPin);
                
                ua.avtor.DsLib.Algorithms.CryptoAlgorithmFactory algFactory = new ua.avtor.DsLib.Algorithms.CryptolibAlgFactory();
                
                CmsAdvanced cms = new CmsAdvanced(bDataAtached, algFactory);
                
                if (bMustTimeStamped)
                {
                    cms.mustAttachSigningTime(true);
                    
                    HttpTransport transport = new HttpTransport();
                    
                    if (IsSetHTTPProxy())
                    {
                        transport.setProxy(HTTP_PROXY, HTTP_PROXY_PORT, HTTP_PROXY_USER, HTTP_PROXY_PASSWORD);
                    }
                    
                    if (!IsSetTSPServer())
                    {
                        strError.value = "Не указан сервер метки времени!";
                        return null;
                    }
                     
                    cms.setSignatureTimeStampServer(transport, TSP_SERVER_URL);
                }
                
                PrivateKey keyPriv = new PrivateKeyDstu(p11Sess, cert.getPublicKeyInfo());
                
                cms.addSigner(cert.getEncoded(), keyPriv);
                
                cms.addCertificate(cert.getEncoded());

                cms.update(rawData);
                
                return cms.getEncoded();
                }
                catch(Exception ex)
                {
                    strError.value = ex.getMessage();
                    return null;
                }
                finally
                {
                    if (p11Sess != null) p11Sess.logout();
                    p11Sess = null;
                }
           }
           catch(Exception ex) {strError.value = ex.getMessage(); return null;}
       }
    });
    }
    //////// Подписание
    
    /////// Генерация сессионного ключа симметричного шифрования
    public byte[] GenerateSessionKeyB(final Certificate cert, final long nSlotID, final String strPin, final byte[] rawCmsEnv, final String Av337Path, final Holder<String> strError)
    {
        if ((rawCmsEnv == null) || (rawCmsEnv.length <= 0) || (cert == null))
        {
            if (cert == null)
            {
                strError.value = "Сертифікат пидписувача відсутній";
            }
            else
            {
                strError.value = "Дані на розшифрування відсутні";
            }

            return null;
        }

        return AccessController.doPrivileged(new PrivilegedAction <byte[]>()
        {
          @Override
          public byte[] run()
           {
               try
               {
                    ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Module module = GetModule(Av337Path);

                    if (module == null)
                    {
                        strError.value = "Module not initialized";
                        return null;
                    }

                    ua.avtor.DsLib.PrivateKeys.PKCS11Utils.Pkcs11Session p11Sess = null;
                    try
                    {
                        p11Sess = module.newSession(nSlotID);

                        p11Sess.login(strPin);

                        ua.avtor.DsLib.Algorithms.CryptoAlgorithmFactory algFactory = new ua.avtor.DsLib.Algorithms.CryptolibAlgFactory();

                        CmsEnveloped cms = new CmsEnveloped(rawCmsEnv);

                        PrivateKey keyPriv = new PrivateKeyDstu(p11Sess, cert.getPublicKeyInfo());
                        int rix = cms.getRecipientIndex(cert.getEncoded());
                        if (rix < 0)
                        {
                            strError.value = "Ви не належете до переліку отрумувачів повідомлення.";
                            return null;
                        }

                        ua.avtor.DsLib.Algorithms.ContentEncryptionAlg algE = cms.newContentDecryptor(rix, keyPriv, algFactory);

                        return algE.getKeyOctets();
                    }
                    catch(Exception ex)
                    {
                        strError.value = ex.getMessage();
                        return null;
                    }
                    finally
                    {
                        if (p11Sess != null) p11Sess.logout();
                        p11Sess = null;
                    }
           }
           catch(Exception ex) {strError.value = ex.getMessage(); return null;}
       }
    });
    }
    /////// Генерация сессионного ключа симметричного шифрования
    
    public static byte[] Encrypt(final byte[] rawInput, final byte[] Key, final Holder<String> strError)
    {
        try
        {
            byte[] rawData = rawInput.clone();
            ua.avtor.DsLib.Algorithms.CryptolibAlgFactory algFactory = new ua.avtor.DsLib.Algorithms.CryptolibAlgFactory();
            ua.avtor.DsLib.Algorithms.ContentEncryptionAlg alg = algFactory.getEncryptionAlg("1.2.804.2.1.1.1.1.1.1.3", null, Key);
            
            alg.encrypt(rawData, 0, rawData.length);

            return rawData;
        }
        catch (Exception ex)
        {
            strError.value = ex.getMessage(); return null;
        }
    }
    
    public static byte[] Decrypt(final byte[] rawInput, final byte[] Key, final Holder<String> strError)
    {
        try
        {
            byte[] rawData = rawInput.clone();
            ua.avtor.DsLib.Algorithms.CryptolibAlgFactory algFactory = new ua.avtor.DsLib.Algorithms.CryptolibAlgFactory();
            ua.avtor.DsLib.Algorithms.ContentEncryptionAlg alg = algFactory.getEncryptionAlg("1.2.804.2.1.1.1.1.1.1.3", null, Key);

            alg.decrypt(rawData, 0, rawData.length);

            return rawData;
        }
        catch (Exception ex)
        {
            strError.value = ex.getMessage(); return null;
        }
    }
}
