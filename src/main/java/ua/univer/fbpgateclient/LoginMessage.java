package ua.univer.fbpgateclient;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@XmlRootElement(name = "LoginMsg", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "brokSystem",
        "armID",
        "isLoginOk",
        "clientID",
        "brokerID",
        "infoMessage",
        "base64Cert",
        "base64Token",
        "isNBUBroker",
        "login",
        "pwd",
        "tokenMediaType",
        "RSAEncCert"
})
public class LoginMessage {

    @XmlElement(name = "BrokSystem")
    private String brokSystem;

    @XmlElement(name = "ArmID")
    private String armID;

    @XmlElement(name = "IsLoginOk")
    private String isLoginOk;

    @XmlElement(name = "ClientID")
    private int clientID;

    @XmlElement(name = "BrokerID")
    private String brokerID;

    @XmlElement(name = "InfoMessage")
    private String infoMessage;

    @XmlElement(name = "Base64Cert")
    private String base64Cert;

    @XmlElement(name = "Base64Token")
    private String base64Token;

    @XmlElement(name = "IsNBUBroker")
    private String isNBUBroker;

    @XmlElement(name = "Login")
    private String login;

    @XmlElement(name = "Pwd")
    private String pwd;

    @XmlElement(name = "TokenMediaType")
    private String tokenMediaType;

    @XmlElement(name = "RSAEncCert")
    private String RSAEncCert;



}
