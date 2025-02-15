
package com.fbpgate;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfGateDataRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfGateDataRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GateDataRequest" type="{http://schemas.datacontract.org/2004/07/FBPGate}GateDataRequest" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfGateDataRequest", propOrder = {
    "gateDataRequest"
})
public class ArrayOfGateDataRequestType {

    @XmlElement(name = "GateDataRequest")
    protected List<GateDataRequestType> gateDataRequest;

    /**
     * Gets the value of the gateDataRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gateDataRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGateDataRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GateDataRequestType }
     * 
     * 
     */
    public List<GateDataRequestType> getGateDataRequest() {
        if (gateDataRequest == null) {
            gateDataRequest = new ArrayList<GateDataRequestType>();
        }
        return this.gateDataRequest;
    }

}
