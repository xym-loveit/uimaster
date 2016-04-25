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
import javax.xml.bind.annotation.XmlType;
import org.shaolin.bmdp.datamodel.common.ExpressionType;


/**
 * <p>Java class for PageInType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageInType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientAction" type="{http://bmdp.shaolin.org/datamodel/Common}ExpressionType" minOccurs="0"/>
 *         &lt;element name="serverOperation" type="{http://bmdp.shaolin.org/datamodel/Common}ExpressionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageInType", propOrder = {
    "clientAction",
    "serverOperation"
})
public class PageInType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected ExpressionType clientAction;
    protected ExpressionType serverOperation;

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

}
