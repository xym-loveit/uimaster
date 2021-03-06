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
import java.util.List;

import org.shaolin.bmdp.json.JSONException;
import org.shaolin.bmdp.json.JSONObject;
import org.shaolin.uimaster.page.HTMLUtil;
import org.shaolin.uimaster.page.UserRequestContext;
import org.shaolin.uimaster.page.WebConfig;
import org.shaolin.uimaster.page.cache.UIFormObject;
import org.shaolin.uimaster.page.javacc.VariableEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTMLRadioButtonGroupType extends HTMLSingleChoiceType
{
    private static final Logger logger = LoggerFactory.getLogger(HTMLRadioButtonGroupType.class);

    public HTMLRadioButtonGroupType(String id)
    {
        super(id);
    }
    
    @Override
	public void generateBeginHTML(UserRequestContext context, UIFormObject ownerEntity, int depth) {
		
	}

    @Override
    public void generateEndHTML(UserRequestContext context, UIFormObject ownerEntity, int depth)
    {
        try
        {
            String name = getName();
            String value = getValue();
            List<String> displayOptions = getOptionDisplayValues();
            List<String> options = getOptionValues();
            if (displayOptions == null)
            {
                displayOptions = options;
            }
            if ("false".equals((String)getAttribute("visible")))
            {
                context.generateHTML("<p style=\"display:none\">");
            }
            else
            {
                context.generateHTML("<p name=\""+name+"\">");
            }
            generateWidget(context);
            if (displayOptions != null && options != null)
            {
                if (displayOptions.size() == 0)
                {
                    displayOptions = options;
                }
                if (displayOptions.size() != options.size())
                {
                    logger.error("display size && output size not equal!", new Exception());
                }
                
                if (this.getAttribute("showProgressBar") != null && 
                		"true".equals(String.valueOf(this.getAttribute("showProgressBar")))) 
                {
                	context.generateHTML("<div class=\"progress-flowsteps\" name=\"");
                    context.generateHTML(name);
                    context.generateHTML("\"><ol class=\"progress-flowstep\">");
                    HTMLUtil.generateTab(context, depth + 1);
					for (int i = 0; i < displayOptions.size(); i++) {
						if (value != null && value.equalsIgnoreCase(String.valueOf(options.get(i)))) {
							context.generateHTML("<li class=\"progress-step-done\">");
						} else {
							context.generateHTML("<li class=\"progress-step\">");
						}
						HTMLUtil.generateTab(context, depth + 2);
						context.generateHTML("<div class=\"progress-step-name\">");
						context.generateHTML(HTMLUtil.htmlEncode(displayOptions.get(i).toString()));
						context.generateHTML("</div><div class=\"progress-step-no\">");
						context.generateHTML(i + "");
						context.generateHTML("</div><div class=\"progress-step-time\"><div class=\"step-time-wraper\">");
						context.generateHTML("2015-05-28 18:12:54");
						context.generateHTML("</div></div>");
						
						HTMLUtil.generateTab(context, depth + 2);
						context.generateHTML("</li>");
					}
					HTMLUtil.generateTab(context, depth + 1);
					context.generateHTML("</ol></div>");
                } 
                else if (isReadOnly() != null && isReadOnly().booleanValue())
                {
                    for (int i = 0; i < displayOptions.size(); i++)
                    {
                        if (value != null && value.equalsIgnoreCase(String.valueOf(options.get(i))))
                        {
                            if (context.isValueMask())
                            {
                                context.generateHTML(WebConfig.getHiddenValueMask());
                            }
                            else
                            {
                                context.generateHTML(HTMLUtil.htmlEncode(displayOptions
                                        .get(i).toString()));
                            }
                            context.generateHTML("<input type=hidden name=\"");
                            context.generateHTML(name);
                            context.generateHTML("\"");
                            context.generateHTML(" value=\"");
                            if (context.isValueMask())
                            {
                                context.generateHTML(WebConfig.getHiddenValueMask());
                            }
                            else
                            {
                                context.generateHTML(HTMLUtil.formatHtmlValue(String.valueOf(options.get(i))));
                            }
                            context.generateHTML("\"");
                            generateAttributes(context);
                            generateEventListeners(context);
                            context.generateHTML(" />");
                            break;
                        }
                    }
                }
                else
                {
                    boolean horizontalLayout = Boolean
                            .parseBoolean((String)getAttribute("horizontalLayout"));
                    int colCount = 15;
                    if (this.getAttribute("colCount") != null) {
                    	colCount = Integer.parseInt(this.getAttribute("colCount").toString());
                    }
                    for (int i = 0; i < displayOptions.size(); i++)
                    {
                        String entryValue = context.isValueMask() ? WebConfig.getHiddenValueMask() : 
                        	HTMLUtil.formatHtmlValue(String.valueOf(options.get(i)));
                        String entryDisplayValue = context.isValueMask() ? WebConfig.getHiddenValueMask() : 
                        	HTMLUtil.htmlEncode(String.valueOf(displayOptions.get(i)));
                        context.generateHTML("<input type=\"radio\" name=\"");
                        context.generateHTML(name);
                        context.generateHTML("\"");
                        context.generateHTML(" value=\"");
                        context.generateHTML(entryValue);
                        context.generateHTML("\"");
                        context.generateHTML(" id=\"");
                        context.generateHTML(entryValue);
                        context.generateHTML("\"");
                        generateAttributes(context);
                        generateEventListeners(context);
                        if (value != null && value.equalsIgnoreCase(String.valueOf(options.get(i))))
                        {
                            context.generateHTML(" checked");
                        }
                        context.generateHTML(" />");
                        context.generateHTML("<label for=\"");
                        context.generateHTML(entryValue);
                        context.generateHTML("\" class=\"uimaster_radio_text_gap\">");
                        context.generateHTML(entryDisplayValue);
                        context.generateHTML("</label>");
                        if (!horizontalLayout)
                        {
                            context.generateHTML("<br />");
                        } else if (i >= (colCount-1) && i % (colCount - 1) == 0) {
                        	// show how many columns in one row.
                        	context.generateHTML("<br />");
						}
                    }
                }
            }
            context.generateHTML("</p>");
            generateEndWidget(context);
        }
        catch (Exception e)
        {
            logger.error("error. in entity: " + getUIEntityName(), e);
        }
    }

    public void generateAttribute(UserRequestContext context, String attributeName,
            Object attributeValue) throws IOException
    {
        if ("visible".equals(attributeName))
        {
        }
        else
        {
            super.generateAttribute(context, attributeName, attributeValue);
        }
    }
    
    public JSONObject createJsonModel(VariableEvaluator ee) throws JSONException 
    {
//        RadioButtonGroup radioButtonGroup = new RadioButtonGroup(getName(), Layout.NULL);
//        radioButtonGroup.setRealValueType(this.getRealValueDataType());
//        radioButtonGroup.setReadOnly(isReadOnly());
//        radioButtonGroup.setUIEntityName(getUIEntityName());
//
//        radioButtonGroup.setOptions(getOptionDisplayValues(), getOptionValues());
//        radioButtonGroup.setValue(getValue());
//
//        setAJAXConstraints(radioButtonGroup);
//        setAJAXAttributes(UserRequestContext.UserContext.get(), radioButtonGroup);
//        
//        radioButtonGroup.setListened(true);
//
//        return radioButtonGroup;
        return super.createJsonModel(ee);
    }

    private static final long serialVersionUID = 7005909032482454931L;

}
