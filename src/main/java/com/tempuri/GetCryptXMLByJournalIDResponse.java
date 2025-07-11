
package com.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="GetCryptXMLByJournalIDResult" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
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
    "getCryptXMLByJournalIDResult"
})
@XmlRootElement(name = "GetCryptXMLByJournalIDResponse")
public class GetCryptXMLByJournalIDResponse {

    @XmlElementRef(name = "GetCryptXMLByJournalIDResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> getCryptXMLByJournalIDResult;

    /**
     * Gets the value of the getCryptXMLByJournalIDResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getGetCryptXMLByJournalIDResult() {
        return getCryptXMLByJournalIDResult;
    }

    /**
     * Sets the value of the getCryptXMLByJournalIDResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setGetCryptXMLByJournalIDResult(JAXBElement<byte[]> value) {
        this.getCryptXMLByJournalIDResult = value;
    }

}
