/*
* Copyright 2015 The UIMaster Project
*
* The UIMaster Project licenses this file to you under the Apache License,
* version 2.0 (the "License"); you may not use this file except in compliance
* with the License. You may obtain a copy of the License at:
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations
* under the License.
*/
package org.shaolin.uimaster.page.widgets;

import java.io.IOException;

import org.shaolin.bmdp.runtime.security.UserContext;
import org.shaolin.uimaster.page.HTMLSnapshotContext;
import org.shaolin.uimaster.page.HTMLUtil;
import org.shaolin.uimaster.page.WebConfig;
import org.shaolin.uimaster.page.ajax.Label;
import org.shaolin.uimaster.page.ajax.Layout;
import org.shaolin.uimaster.page.ajax.Widget;
import org.shaolin.uimaster.page.cache.UIFormObject;
import org.shaolin.uimaster.page.javacc.VariableEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTMLLabelType extends HTMLTextWidgetType
{
    private static Logger logger = LoggerFactory.getLogger(HTMLLabelType.class);

    public HTMLLabelType()
    {
    }

    public HTMLLabelType(HTMLSnapshotContext context)
    {
        super(context);
    }

    public HTMLLabelType(HTMLSnapshotContext context, String id)
    {
        super(context, id);
    }

    @Override
	public void generateBeginHTML(HTMLSnapshotContext context, UIFormObject ownerEntity, int depth) {
		
	}
    
    @Override
    public void generateEndHTML(HTMLSnapshotContext context, UIFormObject ownerEntity, int depth)
    {
    	if (this.getAttribute("captureScreen") != null) {
    		String root = (UserContext.isMobileRequest() && UserContext.isAppClient()) 
        			? WebConfig.getAppContextRoot(context.getRequest()) : WebConfig.getResourceContextRoot();
    		HTMLUtil.generateTab(context, depth);
            context.generateHTML("<script type=\"text/javascript\" src=\""+root+"/js/controls/html2canvas.js\"></script>");
        }
    	String htmlValue = (String)this.removeAttribute("htmlValue");
    	
        generateWidget(context);
        String currencySymbol = getCurrencySymbol();
        if ( currencySymbol == null || currencySymbol.equals("") )
        {
            context.generateHTML("<div>");
            generateContent(context, htmlValue);
            context.generateHTML("</div>");
        }
        else if ( getIsSymbolLeft() )
        {
            context.generateHTML("<div>");
            generateCurrencySymbol(context, currencySymbol);
            generateContent(context, htmlValue);
            context.generateHTML("</div>");
        }
        else
        {
            context.generateHTML("<div>");
            generateContent(context, htmlValue);
            generateCurrencySymbol(context, currencySymbol);
            context.generateHTML("</div>");
        }
        generateEndWidget(context);
    }

    public void generateCurrencySymbol(HTMLSnapshotContext context, String currencySymbol)
    {
        context.generateHTML("<span class=\"currencySymbol\"");
        context.generateHTML(" id=\"" + getName() + "_currencySymbol\" >");
        context.generateHTML(currencySymbol);
        context.generateHTML("</span>");
    }
    
    private void generateContent(HTMLSnapshotContext context, String htmlValue)
    {
        try
        {
            context.generateHTML("<span id=\"");
            context.generateHTML(getName());
            context.generateHTML("_Label\" name=\"");
            context.generateHTML(getName());
            context.generateHTML("_Label\"");
            generateAttributes(context);
            generateEventListeners(context);
            context.generateHTML(">");
            if (htmlValue != null) {
            	context.generateHTML(htmlValue);
            } else {
            	String text = getDisplayValue();
            	if (this.getAttribute("showMaxLength") != null) {
            		int mlength = Integer.parseInt(this.getAttribute("showMaxLength").toString());
            		if (text.length() > mlength) {
            			text = text.substring(0, mlength - 1) + "...";
            		} 
            	}
            	context.generateHTML(HTMLUtil.htmlEncode(text));
            }
            context.generateHTML("<input type=hidden name=\"");
            context.generateHTML(getName());
            context.generateHTML("\"");
            context.generateHTML(" value=\"");
            context.generateHTML(HTMLUtil.formatHtmlValue(getValue()));
            context.generateHTML("\" />");
            context.generateHTML("</span>");
        }
        catch (Exception e)
        {
            logger.error("error. in entity: " + getUIEntityName(), e);
        }
    }

    public void generateAttribute(HTMLSnapshotContext context, String attributeName, Object attributeValue) throws IOException
    {
        if("colorType".equals(attributeName))
        {
            String attrValue = (String)attributeValue;
            if (attrValue.startsWith("#"))
            {
                addStyle("color", attrValue);
            }
            else
            {
                addStyle("color", "rgb(" + attrValue + ")");
            }
        }
        else if("fontType".equals(attributeName))
        {
            String attrValue = (String)attributeValue;
            String[] fontInfo  = attrValue.split(",");
            if (fontInfo.length != 3)
            {
                logger.warn("fontType error:" + attrValue);
            }
            else
            {
                String fontStyle = "Plain".equals(fontInfo[2]) ? "normal" : fontInfo[2];
                fontStyle += " " + fontInfo[1] + "pt";
                fontStyle += " " + fontInfo[0];
                addStyle("font", fontStyle);
            }
        }
        else if("displayValue".equals(attributeName))
        {
        }
        else
        {
            super.generateAttribute(context, attributeName, attributeValue);
        }
    }

    public void setDisplayValue(String displayValue)
    {
        setHTMLAttribute("displayValue", displayValue);
    }

    public String getDisplayValue()
    {
        if (context.isValueMask())
        {
            return WebConfig.getHiddenValueMask();
        }
        Object displayValue = getAllAttribute("displayValue");
        if (displayValue == null)
        {
            displayValue = getValue();
        }
        return displayValue.toString();
    }

    /**
     * Whether this component can have editPermission.
     */
    @Override
    public boolean isEditPermissionEnabled()
    {
        return false;
    }

    public Widget createAjaxWidget(VariableEvaluator ee)
    {
    	if (!needAjaxSupport()) {
    		return null;
    	}
    	
        Label label = new Label(getName(), Layout.NULL);

        label.setReadOnly(isReadOnly());
        label.setUIEntityName(getUIEntityName());

        label.setValue(getValue());
        label.setDisplayValue(getDisplayValue());

        label.setListened(true);
        label.setFrameInfo(getFrameInfo());

        return label;
    }
    
    private static final long serialVersionUID = 4001953636235186944L;
}
