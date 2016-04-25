//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.25 at 11:47:13 PM CST 
//


package org.shaolin.bmdp.datamodel.page;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.shaolin.bmdp.datamodel.common.ExpressionType;


/**
 * the Out that contains output data Mapping
 * 
 * <p>Java class for PageOutType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageOutType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientAction" type="{http://bmdp.shaolin.org/datamodel/Common}ExpressionType" minOccurs="0"/>
 *         &lt;element name="serverOperation" type="{http://bmdp.shaolin.org/datamodel/Common}ExpressionType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="functionName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="frameName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="validate" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageOutType", propOrder = {
    "clientAction",
    "serverOperation"
})
public class PageOutType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected ExpressionType clientAction;
    protected ExpressionType serverOperation;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "functionName", required = true)
    protected String functionName;
    @XmlAttribute(name = "frameName")
    protected String frameName;
    @XmlAttribute(name = "validate")
    protected Boolean validate;

    /**
     * Gets the value of the clientAction property.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getClientAction() {
        return clientAction;
    }

    /**
     * Sets the value of the clientAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setClientAction(ExpressionType value) {
        this.clientAction = value;
    }

    /**
     * Gets the value of the serverOperation property.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getServerOperation() {
        return serverOperation;
    }

    /**
     * Sets the value of the serverOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setServerOperation(ExpressionType value) {
        this.serverOperation = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the functionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * Sets the value of the functionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionName(String value) {
        this.functionName = value;
    }

    /**
     * Gets the value of the frameName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrameName() {
        return frameName;
    }

    /**
     * Sets the value of the frameName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrameName(String value) {
        this.frameName = value;
    }

    /**
     * Gets the value of the validate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isValidate() {
        return validate;
    }

    /**
     * Sets the value of the validate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setValidate(Boolean value) {
        this.validate = value;
    }

}
