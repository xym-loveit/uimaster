//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.28 at 04:10:22 PM CST 
//


package org.shaolin.bmdp.designtime.andriod.datamodel;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CheckedTextView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckedTextView">
 *   &lt;complexContent>
 *     &lt;extension base="{}TextView">
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}checkMark"/>
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}checked"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckedTextView")
@XmlRootElement(name = "CheckedTextView")
public class CheckedTextView
    extends TextView
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "checkMark", namespace = "http://schemas.android.com/apk/res/android")
    protected String checkMark;
    @XmlAttribute(name = "checked", namespace = "http://schemas.android.com/apk/res/android")
    protected String checked;

    /**
     * Gets the value of the checkMark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckMark() {
        return checkMark;
    }

    /**
     * Sets the value of the checkMark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckMark(String value) {
        this.checkMark = value;
    }

    /**
     * Gets the value of the checked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChecked() {
        return checked;
    }

    /**
     * Sets the value of the checked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChecked(String value) {
        this.checked = value;
    }

}
