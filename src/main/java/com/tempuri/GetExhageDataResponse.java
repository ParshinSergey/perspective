
package com.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fbpgate.DataResponseType;


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
 *         &lt;element name="GetExhageDataResult" type="{http://schemas.datacontract.org/2004/07/FBPGate}DataResponse" minOccurs="0"/>
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
    "getExhageDataResult"
})
@XmlRootElement(name = "GetExhageDataResponse")
public class GetExhageDataResponse {

    @XmlElement(name = "GetExhageDataResult")
    protected DataResponseType getExhageDataResult;

    /**
     * Gets the value of the getExhageDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link DataResponseType }
     *     
     */
    public DataResponseType getGetExhageDataResult() {
        return getExhageDataResult;
    }

    /**
     * Sets the value of the getExhageDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataResponseType }
     *     
     */
    public void setGetExhageDataResult(DataResponseType value) {
        this.getExhageDataResult = value;
    }

}
