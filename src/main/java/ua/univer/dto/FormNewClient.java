package ua.univer.dto;

//import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.datatype.XMLGregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
public class FormNewClient {

    private Integer idClient;

    @NotBlank
    private String clientName;

    private String clientNameFull;

    private Boolean isLegalEntity;

    @NotBlank
    @Pattern(regexp = "^\\d{8}|\\d{10}$", message = "должно состоять из 8 или 10 цифр")
    private String inn;

    @NotBlank
    private String edrpou;

    private String edrisi;

    private String countryCode;

    @NotBlank
    private String passportDateOf;

    @NotBlank
    private String passportIssuerOf;

    @NotBlank
    private String passportNumOf;

    @NotBlank
    private String passportSerOf;

    private String dateOfBirth;

    private String placeOfBirth;

    private String accNoNBU;

    private Integer accountTypeNBU;

    private String accNoNDU;

    private Integer accountTypeNDU;

    @NotBlank
    private String accNoInNDU;

    private String addrFMAREACODE;

    @Size(max = 256)
    protected String addrDISTRICT;

    protected String addrCITY;
    protected String addrZIP;
    protected String addrSTREET;
    protected String addrBUILDING;
    protected String addrHOUSE;
    protected String addrOFFICE;
    protected String fmSTATEREGNO;
    protected XMLGregorianCalendar fmSTATEREGDT;
    protected String fmSTATEREGAUTH;
    protected String fmSTATEREGNOBASED;
    protected Boolean isAllowNBU;
    protected Boolean isAllowNDU;
    protected String error;
    protected String gateData;


}
