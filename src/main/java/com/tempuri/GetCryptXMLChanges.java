
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
 *         &lt;element name="nData" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nLastID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="WithShema" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "nData",
    "nLastID",
    "withShema"
})
@XmlRootElement(name = "GetCryptXMLChanges")
public class GetCryptXMLChanges {

    @XmlElementRef(name = "strArmID", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> strArmID;
    protected Integer nData;
    protected Long nLastID;
    @XmlElement(name = "WithShema")
    protected Boolean withShema;

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
     * Gets the value of the nLastID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNLastID() {
        return nLastID;
    }

    /**
     * Sets the value of the nLastID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNLastID(Long value) {
        this.nLastID = value;
    }

    /**
     * Gets the value of the withShema property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWithShema() {
        return withShema;
    }

    /**
     * Sets the value of the withShema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWithShema(Boolean value) {
        this.withShema = value;
    }

}
