package ua.univer.dto;

import ua.univer.BIT.cDevice;
import ua.univer.fbpgateclient.AddressOrder;
import ua.univer.fbpgateclient.NewClient;

import static ua.univer.util.DateTimeUtil.*;

import java.time.LocalDateTime;


public class UtilForm {

    public UtilForm() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static NewClient convertFormToNewClient (FormNewClient form){

        NewClient client = new NewClient();
        client.setClientName(form.getClientName());
        client.setClientNameFull(form.getClientNameFull());
        client.setIsLegalEntity(form.getIsLegalEntity());
        client.setInn(form.getInn());
        client.setEdrpou(form.getEdrpou());
        client.setEdrisi(form.getEdrisi());
        client.setCountryCode(form.getCountryCode());
        client.setPassportDateOf(oneBoxCalendar(form.getPassportDateOf()));
        client.setPassportIssuerOf(form.getPassportIssuerOf());
        client.setPassportNumOf(form.getPassportNumOf());
        client.setPassportSerOf(form.getPassportSerOf());
        client.setDateOfBirth(oneBoxCalendar(form.getDateOfBirth()));
        client.setPlaceOfBirth(form.getPlaceOfBirth());
        client.setAccNoNBU(form.getAccNoNBU());
        client.setAccountTypeNBU(form.getAccountTypeNBU());
        client.setAccNoNDU(form.getAccNoNDU());
        client.setAccountTypeNDU(form.getAccountTypeNDU());
        client.setAccNoInNDU(form.getAccNoInNDU().length() == 17 ? form.getAccNoInNDU().substring(7) : form.getAccNoInNDU());
        client.setAddrFMAREACODE(form.getAddrFMAREACODE());
        // client.setAddrDISTRICT(form.getAddrDISTRICT());
        client.setAddrSTREET(form.getAddrSTREET());

        String phrase = "фактична адреса проживання";
        String[] arrAddress = form.getAddrDISTRICT().split(phrase, 2);
        client.setAddrDISTRICT(arrAddress[0].trim());
        if (arrAddress.length > 1) {
            client.setAddrSTREET(phrase + " " + arrAddress[1].trim());
        }

        return client;
    }


    public static AddressOrder convertFormToAddressOrder (FormOrder form){

        AddressOrder order = new AddressOrder();
        order.setApplicationID(form.getApplicationID());
        order.setCrossApplicationID(form.getCrossApplicationID());
        order.setMainAppID(form.getMainAppID());
        order.setBrokerID(form.getBrokerID());
        order.setArmID(cDevice.armID);
        order.setOrderTypeID(form.getOrderTypeID());
        order.setIsAddressToBroker(form.getIsAddressToBroker());
        order.setToBrokerID(form.getToBrokerID());
        order.setToBrokerEdrpou(form.getToBrokerEdrpou());
        order.setToBrokerTicket(form.getToBrokerTicket());
        order.setListingID(form.getListingID());
        order.setPaperTypeID(form.getPaperTypeID());
        order.setTicker(form.getTicker());
        order.setIsin(form.getIsin());
        order.setListingTypeID(form.getListingTypeID());
        order.setCurrencyCode(form.getCurrencyCode());
        order.setIsBuy(form.getIsBuy());
        order.setPrice(form.getPrice());
        order.setNomPercent(form.getNomPercent());
        order.setQuantity(form.getQuantity());

        order.setTermDelivery(xmlGregorianCalendar(LocalDateTime.now()));
        order.setTetmPayment(oneBoxCalendar(form.getTetmPayment()));
        // depoID;
        // payKeeperID;
        // payKeeperName;
        // payKeeperAccNo;
        // payBankName;
        // nbuDealTypeID;
        // clcode;
        // payBank;
        // payEdrpou;
        order.setPayAccount(form.getPayAccount());
        order.setPayAccountPaper(form.getPayAccountPaper());
        // clientType;
        // clientID;
        // clientName;
        order.setClientEdrpou(form.getClientEdrpou());
        // isLawerClient;
        // isNerez;
        // startDate;
        // stopDate;
        order.setIsFullPackage(form.getIsFullPackage());
        // isEmitBackPay;
        order.setAgreements(form.getAgreements());
        order.setContractNum(form.getContractNum());
        order.setIsCCP(form.getIsCCP());

        order.setApplicationContext(form.getApplicationContext());
        order.setPayAccountPaper2(form.getPayAccountPaper2());
        order.setClientEdrpou2(form.getClientEdrpou2());
        // clientID2;
        order.setContractNum2(form.getContractNum2());
        order.setAgreements2(form.getAgreements2());
        // crossApplicationContext;
        order.setTradeCurrency(form.getTradeCurrency());
        order.setApplicationContextUnique(form.getApplicationContextUnique());

        return order;
    }






}
