package org.shaolin.uimaster.html.layout;

import java.io.Serializable;

import org.shaolin.bmdp.datamodel.page.UIContainerType;
import org.shaolin.bmdp.json.JSONException;
import org.shaolin.uimaster.page.HTMLUtil;
import org.shaolin.uimaster.page.UserRequestContext;
import org.shaolin.uimaster.page.cache.UIFormObject;
import org.shaolin.uimaster.page.exception.UIPageException;
import org.shaolin.uimaster.page.widgets.HTMLWidgetType;
import org.slf4j.LoggerFactory;

public class HTMLCellLayout extends HTMLLayout implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String container = "";
	
	/**
	 * only for tomcat session serialization check.
	 * @deprecated
	 */
	public HTMLCellLayout() {
		super(null);
	}

    public HTMLCellLayout(UIContainerType container, UIFormObject entity)
    {
        super(entity);
        
        init(container, null);
    }

    public void setContainer(String container)
    {
        this.container = container;
    }

    public void generateHTML(UserRequestContext context, int depth, Boolean readOnly,
            IUISkin uiskinObj, HTMLWidgetType parentComponent) throws UIPageException
    {
		try {
			generateHidden(context, depth + 1, null);
		} catch (JSONException e) {
			LoggerFactory.getLogger(HTMLCellLayout.class).warn("Generate hidden widget error! " + e.getMessage(), e);
		}
        
        for ( int i = 0, n = layoutComstraintList.size(); i < n; i++ )
        {
            AbstractHTMLLayout layout = (AbstractHTMLLayout)layoutComstraintList.get(i);
            layout.setContainer(container);
            layout.generate(context, depth, readOnly, uiskinObj, parentComponent, null);
        }
        if ( layoutComstraintList.size() != 0 )
        {
            HTMLUtil.generateTab(context, depth);
            context.generateHTML("<div class=\"hardreturn\"></div>");
        }
    }

}
