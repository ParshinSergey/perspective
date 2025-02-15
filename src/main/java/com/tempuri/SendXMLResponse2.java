
package com.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="strArmID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SignedData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="nData" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="WithShemaResponse" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "strArmID",
    "signedData",
    "nData",
    "withShemaResponse"
})
@XmlRootElement(name = "SendXML_Response")
public class SendXMLResponse2 {

    @XmlElementRef(name = "strArmID", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> strArmID;
    @XmlElementRef(name = "SignedData", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> signedData;
    protected Integer nData;
    @XmlElement(name = "WithShemaResponse")
    protected Boolean withShemaResponse;

    /**
     * Gets the value of the strArmID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStrArmID() {
        return strArmID;
    }

    /**
     * Sets the value of the strArmID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStrArmID(JAXBElement<String> value) {
        this.strArmID = value;
    }

    /**
     * Gets the value of the signedData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getSignedData() {
        return signedData;
    }

    /**
     * Sets the value of the signedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setSignedData(JAXBElement<byte[]> value) {
        this.signedData = value;
    }

    /**
     * Gets the value of the nData property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNData() {
        return nData;
    }

    /**
     * Sets the value of the nData property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNData(Integer value) {
        this.nData = value;
    }

    /**
     * Gets the value of the withShemaResponse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWithShemaResponse() {
        return withShemaResponse;
    }

    /**
     * Sets the value of the withShemaResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWithShemaResponse(Boolean value) {
        this.withShemaResponse = value;
    }

}
