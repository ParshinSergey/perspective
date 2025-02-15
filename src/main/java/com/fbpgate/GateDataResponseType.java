
package com.fbpgate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GateDataResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GateDataResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EncryptedData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="LastErrors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="MessageNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="XMLData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GateDataResponse", propOrder = {
    "encryptedData",
    "lastErrors",
    "lastId",
    "messageNumber",
    "xmlData"
})
public class GateDataResponseType {

    @XmlElementRef(name = "EncryptedData", namespace = "http://schemas.datacontract.org/2004/07/FBPGate", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> encryptedData;
    @XmlElementRef(name = "LastErrors", namespace = "http://schemas.datacontract.org/2004/07/FBPGate", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastErrors;
    @XmlElement(name = "LastId")
    protected Long lastId;
    @XmlElement(name = "MessageNumber")
    protected Integer messageNumber;
    @XmlElementRef(name = "XMLData", namespace = "http://schemas.datacontract.org/2004/07/FBPGate", type = JAXBElement.class, required = false)
    protected JAXBElement<String> xmlData;

    /**
     * Gets the value of the encryptedData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getEncryptedData() {
        return encryptedData;
    }

    /**
     * Sets the value of the encryptedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setEncryptedData(JAXBElement<byte[]> value) {
        this.encryptedData = value;
    }

    /**
     * Gets the value of the lastErrors property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastErrors() {
        return lastErrors;
    }

    /**
     * Sets the value of the lastErrors property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastErrors(JAXBElement<String> value) {
        this.lastErrors = value;
    }

    /**
     * Gets the value of the lastId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLastId() {
        return lastId;
    }

    /**
     * Sets the value of the lastId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLastId(Long value) {
        this.lastId = value;
    }

    /**
     * Gets the value of the messageNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMessageNumber() {
        return messageNumber;
    }

    /**
     * Sets the value of the messageNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMessageNumber(Integer value) {
        this.messageNumber = value;
    }

    /**
     * Gets the value of the xmlData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getXMLData() {
        return xmlData;
    }

    /**
     * Sets the value of the xmlData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setXMLData(JAXBElement<String> value) {
        this.xmlData = value;
    }

}
