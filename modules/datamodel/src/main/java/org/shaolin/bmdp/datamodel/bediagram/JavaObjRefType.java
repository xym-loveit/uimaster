//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.27 at 02:34:46 PM CST 
//


package org.shaolin.bmdp.datamodel.bediagram;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.shaolin.bmdp.datamodel.common.TargetJavaType;


/**
 * JavaObjRefType reference java object!
 * 
 * <p>Java class for JavaObjRefType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JavaObjRefType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://bmdp.shaolin.org/datamodel/BEDiagram}ObjectRefType">
 *       &lt;sequence>
 *         &lt;element name="targetJava" type="{http://bmdp.shaolin.org/datamodel/Common}TargetJavaType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JavaObjRefType", propOrder = {
    "targetJava"
})
public class JavaObjRefType
    extends ObjectRefType
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected TargetJavaType targetJava;

    /**
     * Gets the value of the targetJava property.
     * 
     * @return
     *     possible object is
     *     {@link TargetJavaType }
     *     
     */
    public TargetJavaType getTargetJava() {
        return targetJava;
    }

    /**
     * Sets the value of the targetJava property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetJavaType }
     *     
     */
    public void setTargetJava(TargetJavaType value) {
        this.targetJava = value;
    }

}
