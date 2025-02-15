
package com.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.fbpgate.DataRequestType;


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
 *         &lt;element name="dataRequest" type="{http://schemas.datacontract.org/2004/07/FBPGate}DataRequest" minOccurs="0"/>
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
    "dataRequest"
})
@XmlRootElement(name = "GetExhageData")
public class GetExhageData {

    protected DataRequestType dataRequest;

    /**
     * Gets the value of the dataRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DataRequestType }
     *     
     */
    public DataRequestType getDataRequest() {
        return dataRequest;
    }

    /**
     * Sets the value of the dataRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataRequestType }
     *     
     */
    public void setDataRequest(DataRequestType value) {
        this.dataRequest = value;
    }

}
