
package test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the test package. 
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

    private final static QName _HiWebServiceResponse_QNAME = new QName("http://webservicetest.example.com/", "hiWebServiceResponse");
    private final static QName _HiWebService_QNAME = new QName("http://webservicetest.example.com/", "hiWebService");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HiWebServiceResponse }
     * 
     */
    public HiWebServiceResponse createHiWebServiceResponse() {
        return new HiWebServiceResponse();
    }

    /**
     * Create an instance of {@link HiWebService }
     * 
     */
    public HiWebService createHiWebService() {
        return new HiWebService();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HiWebServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservicetest.example.com/", name = "hiWebServiceResponse")
    public JAXBElement<HiWebServiceResponse> createHiWebServiceResponse(HiWebServiceResponse value) {
        return new JAXBElement<HiWebServiceResponse>(_HiWebServiceResponse_QNAME, HiWebServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HiWebService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservicetest.example.com/", name = "hiWebService")
    public JAXBElement<HiWebService> createHiWebService(HiWebService value) {
        return new JAXBElement<HiWebService>(_HiWebService_QNAME, HiWebService.class, null, value);
    }

}
