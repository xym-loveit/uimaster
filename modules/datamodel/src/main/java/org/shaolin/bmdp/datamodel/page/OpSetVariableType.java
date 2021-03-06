//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.20 at 04:07:50 PM CST 
//


package org.shaolin.bmdp.datamodel.page;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.shaolin.bmdp.datamodel.common.ExpressionType;


/**
 * Single expression. Most commonly used.
 * 
 * <p>Java class for OpSetVariableType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpSetVariableType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://bmdp.shaolin.org/datamodel/Page}OpType">
 *       &lt;sequence>
 *         &lt;element name="exp" type="{http://bmdp.shaolin.org/datamodel/Common}ExpressionType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="varName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpSetVariableType", propOrder = {
    "exp"
})
public class OpSetVariableType
    extends OpType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected ExpressionType exp;
    @XmlAttribute(name = "varName")
    protected String varName;

    /**
     * Gets the value of the exp property.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionType }
     *     
     */
    public ExpressionType getExp() {
        return exp;
    }

    /**
     * Sets the value of the exp property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionType }
     *     
     */
    public void setExp(ExpressionType value) {
        this.exp = value;
    }

    /**
     * Gets the value of the varName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVarName() {
        return varName;
    }

    /**
     * Sets the value of the varName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVarName(String value) {
        this.varName = value;
    }

}
