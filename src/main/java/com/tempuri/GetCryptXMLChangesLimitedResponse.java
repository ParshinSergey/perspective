
package com.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fbpgate.DataChangesType;


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
 *         &lt;element name="GetCryptXMLChangesLimitedResult" type="{http://schemas.datacontract.org/2004/07/FBPGate}DataChanges" minOccurs="0"/>
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
    "getCryptXMLChangesLimitedResult"
})
@XmlRootElement(name = "GetCryptXMLChangesLimitedResponse")
public class GetCryptXMLChangesLimitedResponse {

    @XmlElement(name = "GetCryptXMLChangesLimitedResult")
    protected DataChangesType getCryptXMLChangesLimitedResult;

    /**
     * Gets the value of the getCryptXMLChangesLimitedResult property.
     * 
     * @return
     *     possible object is
     *     {@link DataChangesType }
     *     
     */
    public DataChangesType getGetCryptXMLChangesLimitedResult() {
        return getCryptXMLChangesLimitedResult;
    }

    /**
     * Sets the value of the getCryptXMLChangesLimitedResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataChangesType }
     *     
     */
    public void setGetCryptXMLChangesLimitedResult(DataChangesType value) {
        this.getCryptXMLChangesLimitedResult = value;
    }

}
