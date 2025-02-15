
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
 *         &lt;element name="GetTradeStepResult" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "getTradeStepResult"
})
@XmlRootElement(name = "GetTradeStepResponse")
public class GetTradeStepResponse {

    @XmlElement(name = "GetTradeStepResult")
    protected Long getTradeStepResult;

    /**
     * Gets the value of the getTradeStepResult property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGetTradeStepResult() {
        return getTradeStepResult;
    }

    /**
     * Sets the value of the getTradeStepResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGetTradeStepResult(Long value) {
        this.getTradeStepResult = value;
    }

}
