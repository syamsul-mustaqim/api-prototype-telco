//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.16 at 03:38:42 AM ICT 
//


package syam.project.authentication;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the syam.project.authentication package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: syam.project.authentication
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Input }
     * 
     */
    public Input createInput() {
        return new Input();
    }

    /**
     * Create an instance of {@link Output }
     * 
     */
    public Output createOutput() {
        return new Output();
    }

    /**
     * Create an instance of {@link Input.Header }
     * 
     */
    public Input.Header createInputHeader() {
        return new Input.Header();
    }

    /**
     * Create an instance of {@link Input.Body }
     * 
     */
    public Input.Body createInputBody() {
        return new Input.Body();
    }

    /**
     * Create an instance of {@link Output.Header }
     * 
     */
    public Output.Header createOutputHeader() {
        return new Output.Header();
    }

    /**
     * Create an instance of {@link Output.Body }
     * 
     */
    public Output.Body createOutputBody() {
        return new Output.Body();
    }

}
