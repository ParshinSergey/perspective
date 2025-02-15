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
@XmlRootElement(name = "Portfolio", namespace = "")
@XmlAccessorType (XmlAccessType.FIELD)
public class Paper {
    public String ISIN;
    public String SecurityType;
    public double CurrentQuantity;
    public double BlockQuantity;
    public String Account;
}
