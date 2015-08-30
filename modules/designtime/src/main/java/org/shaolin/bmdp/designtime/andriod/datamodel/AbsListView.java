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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AbsListView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbsListView">
 *   &lt;complexContent>
 *     &lt;extension base="{}AdapterView">
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}cacheColorHint"/>
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}choiceMode"/>
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}drawSelectorOnTop"/>
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}fastScrollAlwaysVisible"/>
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}fastScrollEnabled"/>
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}listSelector"/>
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}scrollingCache"/>
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}smoothScrollbar"/>
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}stackFromBottom"/>
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}textFilterEnabled"/>
 *       &lt;attribute ref="{http://schemas.android.com/apk/res/android}transcriptMode"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbsListView")
@XmlSeeAlso({
    GridView.class,
    ListView.class
})
public class AbsListView
    extends AdapterView
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "cacheColorHint", namespace = "http://schemas.android.com/apk/res/android")
    protected String cacheColorHint;
    @XmlAttribute(name = "choiceMode", namespace = "http://schemas.android.com/apk/res/android")
    protected String choiceMode;
    @XmlAttribute(name = "drawSelectorOnTop", namespace = "http://schemas.android.com/apk/res/android")
    protected String drawSelectorOnTop;
    @XmlAttribute(name = "fastScrollAlwaysVisible", namespace = "http://schemas.android.com/apk/res/android")
    protected String fastScrollAlwaysVisible;
    @XmlAttribute(name = "fastScrollEnabled", namespace = "http://schemas.android.com/apk/res/android")
    protected String fastScrollEnabled;
    @XmlAttribute(name = "listSelector", namespace = "http://schemas.android.com/apk/res/android")
    protected String listSelector;
    @XmlAttribute(name = "scrollingCache", namespace = "http://schemas.android.com/apk/res/android")
    protected String scrollingCache;
    @XmlAttribute(name = "smoothScrollbar", namespace = "http://schemas.android.com/apk/res/android")
    protected String smoothScrollbar;
    @XmlAttribute(name = "stackFromBottom", namespace = "http://schemas.android.com/apk/res/android")
    protected String stackFromBottom;
    @XmlAttribute(name = "textFilterEnabled", namespace = "http://schemas.android.com/apk/res/android")
    protected String textFilterEnabled;
    @XmlAttribute(name = "transcriptMode", namespace = "http://schemas.android.com/apk/res/android")
    protected String transcriptMode;

    /**
     * Gets the value of the cacheColorHint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCacheColorHint() {
        return cacheColorHint;
    }

    /**
     * Sets the value of the cacheColorHint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCacheColorHint(String value) {
        this.cacheColorHint = value;
    }

    /**
     * Gets the value of the choiceMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChoiceMode() {
        return choiceMode;
    }

    /**
     * Sets the value of the choiceMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChoiceMode(String value) {
        this.choiceMode = value;
    }

    /**
     * Gets the value of the drawSelectorOnTop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrawSelectorOnTop() {
        return drawSelectorOnTop;
    }

    /**
     * Sets the value of the drawSelectorOnTop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrawSelectorOnTop(String value) {
        this.drawSelectorOnTop = value;
    }

    /**
     * Gets the value of the fastScrollAlwaysVisible property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFastScrollAlwaysVisible() {
        return fastScrollAlwaysVisible;
    }

    /**
     * Sets the value of the fastScrollAlwaysVisible property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFastScrollAlwaysVisible(String value) {
        this.fastScrollAlwaysVisible = value;
    }

    /**
     * Gets the value of the fastScrollEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFastScrollEnabled() {
        return fastScrollEnabled;
    }

    /**
     * Sets the value of the fastScrollEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFastScrollEnabled(String value) {
        this.fastScrollEnabled = value;
    }

    /**
     * Gets the value of the listSelector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListSelector() {
        return listSelector;
    }

    /**
     * Sets the value of the listSelector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListSelector(String value) {
        this.listSelector = value;
    }

    /**
     * Gets the value of the scrollingCache property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScrollingCache() {
        return scrollingCache;
    }

    /**
     * Sets the value of the scrollingCache property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScrollingCache(String value) {
        this.scrollingCache = value;
    }

    /**
     * Gets the value of the smoothScrollbar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmoothScrollbar() {
        return smoothScrollbar;
    }

    /**
     * Sets the value of the smoothScrollbar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmoothScrollbar(String value) {
        this.smoothScrollbar = value;
    }

    /**
     * Gets the value of the stackFromBottom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStackFromBottom() {
        return stackFromBottom;
    }

    /**
     * Sets the value of the stackFromBottom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStackFromBottom(String value) {
        this.stackFromBottom = value;
    }

    /**
     * Gets the value of the textFilterEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextFilterEnabled() {
        return textFilterEnabled;
    }

    /**
     * Sets the value of the textFilterEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextFilterEnabled(String value) {
        this.textFilterEnabled = value;
    }

    /**
     * Gets the value of the transcriptMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranscriptMode() {
        return transcriptMode;
    }

    /**
     * Sets the value of the transcriptMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranscriptMode(String value) {
        this.transcriptMode = value;
    }

}