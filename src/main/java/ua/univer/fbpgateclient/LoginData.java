/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.univer.fbpgateclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author v_shevchenko
 */

@XmlRootElement(name = "LoginData", namespace = "")
@XmlAccessorType (XmlAccessType.FIELD)
public class LoginData {
    @XmlElement(name="LoginMsg", type=LoginMsg.class)
    public List<LoginMsg> login = new ArrayList<LoginMsg>();
}
