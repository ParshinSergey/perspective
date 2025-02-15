
package com.fbpgate;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfGateDataResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfGateDataResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GateDataResponse" type="{http://schemas.datacontract.org/2004/07/FBPGate}GateDataResponse" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfGateDataResponse", propOrder = {
    "gateDataResponse"
})
public class ArrayOfGateDataResponseType {

    @XmlElement(name = "GateDataResponse")
    protected List<GateDataResponseType> gateDataResponse;

    /**
     * Gets the value of the gateDataResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gateDataResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGateDataResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GateDataResponseType }
     * 
     * 
     */
    public List<GateDataResponseType> getGateDataResponse() {
        if (gateDataResponse == null) {
            gateDataResponse = new ArrayList<GateDataResponseType>();
        }
        return this.gateDataResponse;
    }

}
