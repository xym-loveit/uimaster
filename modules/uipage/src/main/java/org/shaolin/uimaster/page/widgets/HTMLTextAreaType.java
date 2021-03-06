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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;

import org.shaolin.bmdp.json.JSONException;
import org.shaolin.bmdp.json.JSONObject;
import org.shaolin.bmdp.runtime.security.UserContext;
import org.shaolin.bmdp.utils.FileUtil;
import org.shaolin.uimaster.page.HTMLUtil;
import org.shaolin.uimaster.page.UserRequestContext;
import org.shaolin.uimaster.page.WebConfig;
import org.shaolin.uimaster.page.cache.UIFormObject;
import org.shaolin.uimaster.page.javacc.VariableEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTMLTextAreaType extends HTMLTextWidgetType implements Consumer<String>
{
	private static final long serialVersionUID = -2216731075469117671L;
	
    private static Logger logger = LoggerFactory.getLogger(HTMLTextAreaType.class);

    public HTMLTextAreaType(String id) {
        super(id);
    }

    @Override
	public void generateBeginHTML(UserRequestContext context, UIFormObject ownerEntity, int depth) {
		
	}
    
    public void generateEndHTML(UserRequestContext context, UIFormObject ownerEntity, int depth)
    {
        try
        {
            generateWidget(context);
            if ( isReadOnly() != null && isReadOnly().booleanValue() )
            {
                addAttribute("allowBlank", "true");
                addAttribute("readOnly", "true");
            }
            boolean isHTMLSupported = this.getAttribute("htmlSupport") != null && 
            		"true".equals(this.getAttribute("htmlSupport").toString());
            if (isHTMLSupported && context.getRequest().getAttribute("_hasCKeditor") == null) {
				context.getRequest().setAttribute("_hasCKeditor", Boolean.TRUE);
	            String root = (UserContext.isMobileRequest() && UserContext.isAppClient()) 
	        			? WebConfig.getAppContextRoot(context.getRequest()) : WebConfig.getResourceContextRoot();
	        	context.generateHTML("<script type=\"text/javascript\" src=\""+root+"/js/controls/ckeditor/ckeditor.js\"></script>");
            }
            boolean emojiSupport = this.getAttribute("emojiSupport") != null 
            		&& "true".equals(this.getAttribute("emojiSupport").toString());
            if (emojiSupport && context.getRequest().getAttribute("_emojiSupport") == null) {
            	context.getRequest().setAttribute("_emojiSupport", Boolean.TRUE);
	            String root = (UserContext.isMobileRequest() && UserContext.isAppClient()) 
	        			? WebConfig.getAppContextRoot(context.getRequest()) : WebConfig.getResourceContextRoot();
            	context.generateHTML("<script type=\"text/javascript\" src=\""+root+"/js/controls/emoji/jquery.emoji.js\"></script>");
            }
            context.generateHTML("<textarea name=\"");
            context.generateHTML(getName());
            context.generateHTML("\"");
            generateAttributes(context);
            if (getAttribute("rows") == null)
            {
                context.generateHTML(" rows=\"4\"");
            }
            if (getAttribute("cols") == null)
            {
                context.generateHTML(" cols=\"30\"");
            }
            generateEventListeners(context);
			if (isHTMLSupported) {
            	context.generateHTML(" style=\"display:none;\"");
            }
            context.generateHTML(">");
            if (context.isValueMask())
            {
                context.generateHTML(WebConfig.getHiddenValueMask());
            }
            else
            {
        		context.generateHTML(HTMLUtil.formatHtmlValue(getValue()));
            }
            context.generateHTML("</textarea>");
            if (isHTMLSupported) {
            	if (this.getAttribute("viewMode") != null && 
                		"true".equals(this.getAttribute("viewMode").toString())) {
            		context.generateHTML("<div id=\"");
        			context.generateHTML(getName());
        			context.generateHTML("\" name=\"");
        			context.generateHTML(getName());
        			context.generateHTML("\" src=\"");
        			context.generateHTML(WebConfig.getAppImageContextRoot(context.getRequest()));
        			context.generateHTML("\"/>");
        			try {
        			BufferedReader reader = Files.newBufferedReader(Paths.get(new File(WebConfig.getRealPath(getValue())).toURI()));
        			reader.lines().forEach(this);
        			reader.close();
        			} catch (Throwable e) {
        				logger.warn("Failed to read file: " + WebConfig.getRealPath(getValue()));
        			}
//        			context.generateHTML("\" frameborder=\"0\" width=\"100%\" height=\"100%\" scrolling='yes'>");
        			context.generateHTML("</div>");
            	} else {
	            	context.generateHTML("<div>");
	            	HTMLUtil.generateTab(context, depth);
	            	context.generateHTML("<textarea name=\"");
	            	context.generateHTML(getName());
	                context.generateHTML("_ckeditor\" style=\"display:none\">");
	            	File file = new File(WebConfig.getResourcePath() + getValue());
	        		if (file.exists() && file.isFile()) {
	        			String content = FileUtil.readFile(new FileInputStream(file));
	        			context.generateHTML(content);
	        		}
	        		context.generateHTML("</textarea>");
	        		HTMLUtil.generateTab(context, depth);
		        	HTMLUtil.generateTab(context, depth);
		        	context.generateHTML("</div>");
            	}
            }
            
            generateEndWidget(context);
        }
        catch (Exception e)
        {
            logger.error("error. in entity: " + getUIEntityName(), e);
        }
    }

    @Override
	public void accept(String t) {
    	UserRequestContext.UserContext.get().generateHTML(t);
	}
    
    public void generateAttribute(UserRequestContext context, String attributeName, Object attributeValue) throws IOException
    {
        if ("initValidation".equals(attributeName) || "validator".equals(attributeName))
        {
        	return;
        }
        if ("editable".equals(attributeName))
        {
            if ("false".equals(String.valueOf(attributeValue)))
            {
                context.generateHTML(" readOnly=\"true\"");
            }
        }
        else if ("prompt".equals(attributeName))
        {
            if ( attributeValue != null && !((String)attributeValue).trim().equals("") )
            {
                context.generateHTML(" title=\"");
                context.generateHTML((String)attributeValue);
                context.generateHTML("\"");
            }
        }
        else
        {
            super.generateAttribute(context, attributeName, attributeValue);
        }
    }

    public JSONObject createJsonModel(VariableEvaluator ee) throws JSONException 
    {
    	JSONObject json = super.createJsonModel(ee);
//        TextArea textArea = new TextArea(getName(), Layout.NULL);
//
//        textArea.setReadOnly(isReadOnly());
//        textArea.setUIEntityName(getUIEntityName());
//
//        // we don't expect to anything except the pure value 
//        // what we really need in the backend.
//        textArea.setValue(getValue());
        if (this.getAttribute("htmlSupport") != null && 
        		"true".equals(this.getAttribute("htmlSupport").toString())) {
        	json.put("htmlSupport", true);
        	if (this.getAttribute("viewMode") != null && 
            		"true".equals(this.getAttribute("viewMode").toString())) {
        		json.put("viewMode", true);
        	}
        }
//        
//        setAJAXConstraints(textArea);
//        setAJAXAttributes(UserRequestContext.UserContext.get(), textArea);
//        
//        textArea.setListened(true);

    	return json;
    }
    
}
