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

import org.shaolin.uimaster.page.UserRequestContext;
import org.shaolin.uimaster.page.cache.UIFormObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTMLTableLayoutType extends HTMLLayoutType
{
	private static final Logger logger = LoggerFactory.getLogger(HTMLTableLayoutType.class);

	public HTMLTableLayoutType(String id)
	{
	    super(id);
	}

    public void generateBeginHTML(UserRequestContext context, UIFormObject ownerEntity, int depth)
    {
        try
        {
            context.generateHTML("<td");
    		generateAttributes(context);
    		generateEventListeners(context);
    		context.generateHTML(">");
    	}
    	catch (Exception e)
    	{
    	    logger.error("error. in entity: " + getUIEntityName(), e);
    	}
    }

    public void generateEndHTML(UserRequestContext context, UIFormObject ownerEntity, int depth)
    {
        try
        {
            context.generateHTML("</td>");
        }
        catch (Exception e)
        {
            logger.error("error. in entity: " + getUIEntityName(), e);
        }
    }
    
	public void generateAttribute(UserRequestContext context, String attributeName, Object attributeValue) throws IOException
	{
	    String attrValue = (String)attributeValue;
        if ("align".equals(attributeName))
        {
            if(!"full".equals(attrValue.toLowerCase()))
            {
                context.generateHTML(" align=\"");
                context.generateHTML(attrValue);
                context.generateHTML("\"");
            }
        }
        else if ("valign".equals(attributeName))
        {
            if(!"full".equals(attrValue.toLowerCase()))
            {
                if ("center".equals(attrValue.toLowerCase()))
                {
                    attrValue = "middle";
                }
                context.generateHTML(" vAlign=\"");
                context.generateHTML(attrValue);
                context.generateHTML("\"");
            }
        }
        else if ("cellUIStyle".equals(attributeName))
        {
            if (!"null".equals(attrValue))
            {
                context.generateHTML(" class=\"");
                context.generateHTML(attrValue);
                context.generateHTML("\"");
            }
        }
        else if ( "rowUIStyle".equals(attributeName) || "x".equals(attributeName) || "y".equals(attributeName))
        {
        }
        else if ("colSpan".equals(attributeName))
        {
            int rowSpan = 1;
            if (getAttribute("rowSpan") != null)
            {
                rowSpan = Integer.parseInt((String) getAttribute("rowSpan"));
            }
            if (rowSpan < getTableRowCount())
            {
                context.generateHTML(" colSpan=");
                context.generateHTML(attrValue);
            }
        }
        else if ("rowSpan".equals(attributeName))
        {
            int colSpan = 1;
            if (getAttribute("colSpan") != null)
            {
                colSpan = Integer.parseInt((String) getAttribute("colSpan"));
            }
            if (colSpan < getTableColumnCount())
            {
                context.generateHTML(" rowSpan=");
                context.generateHTML(attrValue);
            }
        }
        else
        {
            super.generateAttribute(context, attributeName, attributeValue);
        }
        
        if( "visible".equals(attributeName) )
        {
            if( "false".equals(String.valueOf(attrValue)))
            {
                addStyle("display", "none");
            }
        }
	}

}
