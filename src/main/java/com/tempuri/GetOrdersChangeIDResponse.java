
package com.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetOrdersChangeIDResult" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getOrdersChangeIDResult"
})
@XmlRootElement(name = "GetOrdersChangeIDResponse")
public class GetOrdersChangeIDResponse {

    @XmlElement(name = "GetOrdersChangeIDResult")
    protected Long getOrdersChangeIDResult;

    /**
     * Gets the value of the getOrdersChangeIDResult property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGetOrdersChangeIDResult() {
        return getOrdersChangeIDResult;
    }

    /**
     * Sets the value of the getOrdersChangeIDResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGetOrdersChangeIDResult(Long value) {
        this.getOrdersChangeIDResult = value;
    }

}
