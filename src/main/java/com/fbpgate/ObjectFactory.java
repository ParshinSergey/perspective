
package com.fbpgate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fbpgate package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DataResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "DataResponse");
    private final static QName _MassXMLData_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "MassXMLData");
    private final static QName _ArrayOfGateDataResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "ArrayOfGateDataResponse");
    private final static QName _GateDataResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "GateDataResponse");
    private final static QName _DataChanges_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "DataChanges");
    private final static QName _DataRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "DataRequest");
    private final static QName _ArrayOfMassXMLData_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "ArrayOfMassXMLData");
    private final static QName _ArrayOfGateDataRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "ArrayOfGateDataRequest");
    private final static QName _GateDataRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "GateDataRequest");
    private final static QName _MassXMLDataTypeSignedData_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "SignedData");
    private final static QName _GateDataResponseTypeLastErrors_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "LastErrors");
    private final static QName _GateDataResponseTypeXMLData_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "XMLData");
    private final static QName _GateDataResponseTypeEncryptedData_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "EncryptedData");
    private final static QName _DataRequestTypeStrArmID_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "strArmID");
    private final static QName _DataRequestTypeGateDataRequestList_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "GateDataRequestList");
    private final static QName _DataResponseTypeGateDataResponseList_QNAME = new QName("http://schemas.datacontract.org/2004/07/FBPGate", "GateDataResponseList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fbpgate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DataChangesType }
     * 
     */
    public DataChangesType createDataChangesType() {
        return new DataChangesType();
    }

    /**
     * Create an instance of {@link DataResponseType }
     * 
     */
    public DataResponseType createDataResponseType() {
        return new DataResponseType();
    }

    /**
     * Create an instance of {@link ArrayOfMassXMLDataType }
     * 
     */
    public ArrayOfMassXMLDataType createArrayOfMassXMLDataType() {
        return new ArrayOfMassXMLDataType();
    }

    /**
     * Create an instance of {@link DataRequestType }
     * 
     */
    public DataRequestType createDataRequestType() {
        return new DataRequestType();
    }

    /**
     * Create an instance of {@link ArrayOfGateDataResponseType }
     * 
     */
    public ArrayOfGateDataResponseType createArrayOfGateDataResponseType() {
        return new ArrayOfGateDataResponseType();
    }

    /**
     * Create an instance of {@link GateDataResponseType }
     * 
     */
    public GateDataResponseType createGateDataResponseType() {
        return new GateDataResponseType();
    }

    /**
     * Create an instance of {@link ArrayOfGateDataRequestType }
     * 
     */
    public ArrayOfGateDataRequestType createArrayOfGateDataRequestType() {
        return new ArrayOfGateDataRequestType();
    }

    /**
     * Create an instance of {@link GateDataRequestType }
     * 
     */
    public GateDataRequestType createGateDataRequestType() {
        return new GateDataRequestType();
    }

    /**
     * Create an instance of {@link MassXMLDataType }
     * 
     */
    public MassXMLDataType createMassXMLDataType() {
        return new MassXMLDataType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "DataResponse")
    public JAXBElement<DataResponseType> createDataResponse(DataResponseType value) {
        return new JAXBElement<DataResponseType>(_DataResponse_QNAME, DataResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MassXMLDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "MassXMLData")
    public JAXBElement<MassXMLDataType> createMassXMLData(MassXMLDataType value) {
        return new JAXBElement<MassXMLDataType>(_MassXMLData_QNAME, MassXMLDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfGateDataResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "ArrayOfGateDataResponse")
    public JAXBElement<ArrayOfGateDataResponseType> createArrayOfGateDataResponse(ArrayOfGateDataResponseType value) {
        return new JAXBElement<ArrayOfGateDataResponseType>(_ArrayOfGateDataResponse_QNAME, ArrayOfGateDataResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GateDataResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "GateDataResponse")
    public JAXBElement<GateDataResponseType> createGateDataResponse(GateDataResponseType value) {
        return new JAXBElement<GateDataResponseType>(_GateDataResponse_QNAME, GateDataResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataChangesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "DataChanges")
    public JAXBElement<DataChangesType> createDataChanges(DataChangesType value) {
        return new JAXBElement<DataChangesType>(_DataChanges_QNAME, DataChangesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "DataRequest")
    public JAXBElement<DataRequestType> createDataRequest(DataRequestType value) {
        return new JAXBElement<DataRequestType>(_DataRequest_QNAME, DataRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfMassXMLDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "ArrayOfMassXMLData")
    public JAXBElement<ArrayOfMassXMLDataType> createArrayOfMassXMLData(ArrayOfMassXMLDataType value) {
        return new JAXBElement<ArrayOfMassXMLDataType>(_ArrayOfMassXMLData_QNAME, ArrayOfMassXMLDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfGateDataRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "ArrayOfGateDataRequest")
    public JAXBElement<ArrayOfGateDataRequestType> createArrayOfGateDataRequest(ArrayOfGateDataRequestType value) {
        return new JAXBElement<ArrayOfGateDataRequestType>(_ArrayOfGateDataRequest_QNAME, ArrayOfGateDataRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GateDataRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "GateDataRequest")
    public JAXBElement<GateDataRequestType> createGateDataRequest(GateDataRequestType value) {
        return new JAXBElement<GateDataRequestType>(_GateDataRequest_QNAME, GateDataRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "SignedData", scope = MassXMLDataType.class)
    public JAXBElement<byte[]> createMassXMLDataTypeSignedData(byte[] value) {
        return new JAXBElement<byte[]>(_MassXMLDataTypeSignedData_QNAME, byte[].class, MassXMLDataType.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "LastErrors", scope = GateDataResponseType.class)
    public JAXBElement<String> createGateDataResponseTypeLastErrors(String value) {
        return new JAXBElement<String>(_GateDataResponseTypeLastErrors_QNAME, String.class, GateDataResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "XMLData", scope = GateDataResponseType.class)
    public JAXBElement<String> createGateDataResponseTypeXMLData(String value) {
        return new JAXBElement<String>(_GateDataResponseTypeXMLData_QNAME, String.class, GateDataResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "EncryptedData", scope = GateDataResponseType.class)
    public JAXBElement<byte[]> createGateDataResponseTypeEncryptedData(byte[] value) {
        return new JAXBElement<byte[]>(_GateDataResponseTypeEncryptedData_QNAME, byte[].class, GateDataResponseType.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "EncryptedData", scope = DataChangesType.class)
    public JAXBElement<byte[]> createDataChangesTypeEncryptedData(byte[] value) {
        return new JAXBElement<byte[]>(_GateDataResponseTypeEncryptedData_QNAME, byte[].class, DataChangesType.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "strArmID", scope = DataRequestType.class)
    public JAXBElement<String> createDataRequestTypeStrArmID(String value) {
        return new JAXBElement<String>(_DataRequestTypeStrArmID_QNAME, String.class, DataRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfGateDataRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "GateDataRequestList", scope = DataRequestType.class)
    public JAXBElement<ArrayOfGateDataRequestType> createDataRequestTypeGateDataRequestList(ArrayOfGateDataRequestType value) {
        return new JAXBElement<ArrayOfGateDataRequestType>(_DataRequestTypeGateDataRequestList_QNAME, ArrayOfGateDataRequestType.class, DataRequestType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "LastErrors", scope = DataResponseType.class)
    public JAXBElement<String> createDataResponseTypeLastErrors(String value) {
        return new JAXBElement<String>(_GateDataResponseTypeLastErrors_QNAME, String.class, DataResponseType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfGateDataResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/FBPGate", name = "GateDataResponseList", scope = DataResponseType.class)
    public JAXBElement<ArrayOfGateDataResponseType> createDataResponseTypeGateDataResponseList(ArrayOfGateDataResponseType value) {
        return new JAXBElement<ArrayOfGateDataResponseType>(_DataResponseTypeGateDataResponseList_QNAME, ArrayOfGateDataResponseType.class, DataResponseType.class, value);
    }

}
