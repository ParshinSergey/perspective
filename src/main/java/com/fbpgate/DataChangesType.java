
package com.fbpgate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataChanges complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataChanges">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EncryptedData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="nLastId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataChanges", propOrder = {
    "encryptedData",
    "nLastId"
})
public class DataChangesType {

    @XmlElementRef(name = "EncryptedData", namespace = "http://schemas.datacontract.org/2004/07/FBPGate", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> encryptedData;
    protected Long nLastId;

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
     * Gets the value of the nLastId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNLastId() {
        return nLastId;
    }

    /**
     * Sets the value of the nLastId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNLastId(Long value) {
        this.nLastId = value;
    }

}
