
package com.fbpgate;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMassXMLData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMassXMLData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MassXMLData" type="{http://schemas.datacontract.org/2004/07/FBPGate}MassXMLData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMassXMLData", propOrder = {
    "massXMLData"
})
public class ArrayOfMassXMLDataType {

    @XmlElement(name = "MassXMLData")
    protected List<MassXMLDataType> massXMLData;

    /**
     * Gets the value of the massXMLData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the massXMLData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMassXMLData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MassXMLDataType }
     * 
     * 
     */
    public List<MassXMLDataType> getMassXMLData() {
        if (massXMLData == null) {
            massXMLData = new ArrayList<MassXMLDataType>();
        }
        return this.massXMLData;
    }

}
