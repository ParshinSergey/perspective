package ua.univer.fbpgateclient;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


@Getter
@Setter
@XmlRootElement(name = "NewClient", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "idClient",
        "clientName",
        "clientNameFull",
        "isLegalEntity",
        "inn",
        "edrpou",
        "edrisi",
        "countryCode",
        "passportDateOf",
        "passportIssuerOf",
        "passportNumOf",
        "passportSerOf",
        "dateOfBirth",
        "placeOfBirth",
        "accNoNBU",
        "accountTypeNBU",
        "accNoNDU",
        "accountTypeNDU",
        "accNoInNDU",
        "addrFMAREACODE",
        "addrDISTRICT",
        "addrCITY",
        "addrZIP",
        "addrSTREET",
        "addrBUILDING",
        "addrHOUSE",
        "addrOFFICE",
        "fmSTATEREGNO",
        "fmSTATEREGDT",
        "fmSTATEREGAUTH",
        "fmSTATEREGNOBASED",
        "isAllowNBU",
        "isAllowNDU",
        "error",
        "gateData"
})
public class NewClient {

    @XmlElement(name = "ID_Client")
    protected Integer idClient;
    @XmlElement(name = "ClientName")
    protected String clientName;
    @XmlElement(name = "ClientNameFull")
    protected String clientNameFull;
    @XmlElement(name = "IsLegalEntity")
    protected Boolean isLegalEntity;
    @XmlElement(name = "INN")
    protected String inn;
    @XmlElement(name = "EDRPOU")
    protected String edrpou;
    @XmlElement(name = "EDRISI")
    protected String edrisi;
    @XmlElement(name = "CountryCode")
    protected String countryCode;
    @XmlElement(name = "PassportDateOf")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar passportDateOf;
    @XmlElement(name = "PassportIssuerOf")
    protected String passportIssuerOf;
    @XmlElement(name = "PassportNumOf")
    protected String passportNumOf;
    @XmlElement(name = "PassportSerOf")
    protected String passportSerOf;
    @XmlElement(name = "DateOfBirth")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfBirth;
    @XmlElement(name = "PlaceOfBirth")
    protected String placeOfBirth;
    @XmlElement(name = "AccNoNBU")
    protected String accNoNBU;
    @XmlElement(name = "AccountTypeNBU")
    protected Integer accountTypeNBU;
    @XmlElement(name = "AccNoNDU")
    protected String accNoNDU;
    @XmlElement(name = "AccountTypeNDU")
    protected Integer accountTypeNDU;
    @XmlElement(name = "AccNoInNDU")
    protected String accNoInNDU;
    @XmlElement(name = "addr_FM_AREA_CODE")
    protected String addrFMAREACODE;
    @XmlElement(name = "addr_DISTRICT")
    protected String addrDISTRICT;
    @XmlElement(name = "addr_CITY")
    protected String addrCITY;
    @XmlElement(name = "addr_ZIP")
    protected String addrZIP;
    @XmlElement(name = "addr_STREET")
    protected String addrSTREET;
    @XmlElement(name = "addr_BUILDING")
    protected String addrBUILDING;
    @XmlElement(name = "addr_HOUSE")
    protected String addrHOUSE;
    @XmlElement(name = "addr_OFFICE")
    protected String addrOFFICE;
    @XmlElement(name = "fm_STATE_REG_NO")
    protected String fmSTATEREGNO;
    @XmlElement(name = "fm_STATE_REG_DT")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fmSTATEREGDT;
    @XmlElement(name = "fm_STATE_REG_AUTH")
    protected String fmSTATEREGAUTH;
    @XmlElement(name = "fm_STATE_REG_NO_BASED")
    protected String fmSTATEREGNOBASED;
    @XmlElement(name = "IsAllowNBU")
    protected Boolean isAllowNBU;
    @XmlElement(name = "IsAllowNDU")
    protected Boolean isAllowNDU;
    @XmlElement(name = "Error")
    protected String error;
    @XmlElement(name = "GateData")
    protected String gateData;
}
