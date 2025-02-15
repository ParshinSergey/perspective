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
@XmlRootElement(name = "UnblockOrder", namespace = "")
@XmlAccessorType (XmlAccessType.FIELD)
public class UnblockOrder {
    public String OrderType;
    public String ArmID;
    public String Account;
    public String ISIN;
    public double Quantity;
    public String OrderContext;
}
