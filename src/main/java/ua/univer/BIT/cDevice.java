package ua.univer.BIT;

import lombok.Getter;
import lombok.Setter;
import ua.avtor.DsLib.Certificate;


public class cDevice {

    public static String armID;


    public long UsbSlot = -1;

    // "Avtor318"
    // "Avtor337chip"
    // "Avtor337prog"
    // "TokenUnknown"
    public String DeviceType = "TokenUnknown";

    @Setter
    @Getter
    private Certificate certificate = null;

    public String DeviceName = "";

}