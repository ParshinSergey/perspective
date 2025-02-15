
package com.fbpgate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GateDataResponseList" type="{http://schemas.datacontract.org/2004/07/FBPGate}ArrayOfGateDataResponse" minOccurs="0"/>
 *         &lt;element name="LastErrors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TradeStep" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataResponse", propOrder = {
    "gateDataResponseList",
    "lastErrors",
    "tradeStep"
})
public class DataResponseType {

    @XmlElementRef(name = "GateDataResponseList", namespace = "http://schemas.datacontract.org/2004/07/FBPGate", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfGateDataResponseType> gateDataResponseList;
    @XmlElementRef(name = "LastErrors", namespace = "http://schemas.datacontract.org/2004/07/FBPGate", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastErrors;
    @XmlElement(name = "TradeStep")
    protected Long tradeStep;

    /**
     * Gets the value of the gateDataResponseList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfGateDataResponseType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfGateDataResponseType> getGateDataResponseList() {
        return gateDataResponseList;
    }

    /**
     * Sets the value of the gateDataResponseList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfGateDataResponseType }{@code >}
     *     
     */
    public void setGateDataResponseList(JAXBElement<ArrayOfGateDataResponseType> value) {
        this.gateDataResponseList = value;
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

}
