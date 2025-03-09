package ua.univer.BIT;
//import java.security.cert.Certificate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ua.avtor.DsLib.Certificate;

/**
 *
 * @author b.ponasyuk
 */
public class cDevice
    {
        public long UsbSlot = -1;

        // "Avtor318"
        // "Avtor337chip"
        // "Avtor337prog"
        // "TokenUnknown"
        public String DeviceType = "TokenUnknown";
        
        public Certificate certificate = null;
        
        public String DeviceName = "";

        public String armID;
    }