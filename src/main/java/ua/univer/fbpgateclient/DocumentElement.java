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
@XmlRootElement(name = "DocumentElement", namespace = "")
@XmlAccessorType (XmlAccessType.FIELD)
public class DocumentElement {
    @XmlElement(name="Portfolio", type=Paper.class)
    public List<Paper> papers = new ArrayList<Paper>();
    
    @XmlElement(name="UnblockOrder", type=UnblockOrder.class)
    public List<UnblockOrder> unblockOrders = new ArrayList<UnblockOrder>();
}
