/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.univer.fbpgateclient;

import javax.xml.bind.annotation.*;

/**
 *
 * @author v_shevchenko
 */

@XmlRootElement(name = "LoginMsg", namespace = "")
@XmlAccessorType (XmlAccessType.FIELD)
public class LoginMsg {
    public String IsLoginOk;
    public int ClientID;
    public String BrokerID;
    public String InfoMessage;
    public String Base64Cert;
    public String Base64Token;
    public String IsNBUBroker;
}
