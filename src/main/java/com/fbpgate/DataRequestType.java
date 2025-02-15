
package com.fbpgate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GateDataRequestList" type="{http://schemas.datacontract.org/2004/07/FBPGate}ArrayOfGateDataRequest" minOccurs="0"/>
 *         &lt;element name="TradeStep" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="strArmID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataRequest", propOrder = {
    "gateDataRequestList",
    "tradeStep",
    "strArmID"
})
public class DataRequestType {

    @XmlElementRef(name = "GateDataRequestList", namespace = "http://schemas.datacontract.org/2004/07/FBPGate", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfGateDataRequestType> gateDataRequestList;
    @XmlElement(name = "TradeStep")
    protected Long tradeStep;
    @XmlElementRef(name = "strArmID", namespace = "http://schemas.datacontract.org/2004/07/FBPGate", type = JAXBElement.class, required = false)
    protected JAXBElement<String> strArmID;

    /**
     * Gets the value of the gateDataRequestList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfGateDataRequestType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfGateDataRequestType> getGateDataRequestList() {
        return gateDataRequestList;
    }

    /**
     * Sets the value of the gateDataRequestList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfGateDataRequestType }{@code >}
     *     
     */
    public void setGateDataRequestList(JAXBElement<ArrayOfGateDataRequestType> value) {
        this.gateDataRequestList = value;
    }

    /**
     * Gets the value of the tradeStep property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTradeStep() {
        return tradeStep;
    }

    /**
     * Sets the value of the tradeStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTradeStep(Long value) {
        this.tradeStep = value;
    }

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

}
