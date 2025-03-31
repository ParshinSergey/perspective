package ua.univer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    private String addrDISTRICT;

    private String addrCITY;
    private String addrZIP;
    private String addrSTREET;
    private String addrBUILDING;
    private String addrHOUSE;
    private String addrOFFICE;

/*
    эти поля для Юрлиц
    private String fmSTATEREGNO;
    private XMLGregorianCalendar fmSTATEREGDT;
    private String fmSTATEREGAUTH;
    private String fmSTATEREGNOBASED;

*/

    private Boolean isAllowNBU;
    private Boolean isAllowNDU;
    private String error;
    private String gateData;


}
