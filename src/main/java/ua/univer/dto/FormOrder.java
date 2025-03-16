package ua.univer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.datatype.XMLGregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
public class FormOrder {

    private Integer applicationID;
    private Integer crossApplicationID;
    private Integer mainAppID;
    private String brokerID;
    private String armID;
    private Integer orderTypeID;
    private Boolean isAddressToBroker;
    private String toBrokerID;
    private String toBrokerEdrpou;
    private String toBrokerTicket;
    private Integer listingID;
    private Integer paperTypeID;
    private String ticker;
    private String isin;
    private Integer listingTypeID;
    private String currencyCode;
    private Boolean isBuy;
    private Double price;
    private Double nomPercent;
    private Integer quantity;
    private Double completePrice;
    private Integer completeQuantity;
    private XMLGregorianCalendar createDate;
    private String termDelivery;
    private String tetmPayment;
    private Integer depoID;
    private String payKeeperID;
    private String payKeeperName;
    private String payKeeperAccNo;
    private String payBankName;
    private Integer nbuDealTypeID;
    private String clcode;
    private String payBank;
    private String payEdrpou;
    private String payAccount;
    private String payAccountPaper;
    private Integer clientType;
    private Integer clientID;
    private String clientName;
    private String clientEdrpou;
    private Boolean isLawerClient;
    private Boolean isNerez;
    private XMLGregorianCalendar startDate;
    private XMLGregorianCalendar stopDate;
    private Boolean isFullPackage;
    private Boolean isEmitBackPay;
    private String agreements;
    private String contractNum;
    private Boolean isCCP;
    private XMLGregorianCalendar isComplete;
    private XMLGregorianCalendar isRemoval;
    private XMLGregorianCalendar isRejected;
    private String discription;
    private String applicationContext;
    private String payAccountPaper2;
    private String clientEdrpou2;
    private Integer clientID2;
    private String contractNum2;
    private String agreements2;
    private String crossApplicationContext;
    private String tradeCurrency;
    private String applicationContextUnique;
}
