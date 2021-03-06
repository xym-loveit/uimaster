package org.shaolin.uimaster.page.widgets;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.shaolin.bmdp.json.JSONException;
import org.shaolin.bmdp.json.JSONObject;
import org.shaolin.bmdp.runtime.security.UserContext;
import org.shaolin.uimaster.page.DisposableBfString;
import org.shaolin.uimaster.page.HTMLUtil;
import org.shaolin.uimaster.page.UserRequestContext;
import org.shaolin.uimaster.page.WebConfig;
import org.shaolin.uimaster.page.ajax.Image;
import org.shaolin.uimaster.page.ajax.Layout;
import org.shaolin.uimaster.page.cache.UIFormObject;
import org.shaolin.uimaster.page.javacc.VariableEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTMLImageType extends HTMLTextWidgetType
{
	private static final long serialVersionUID = 24011835838546883L;
	
    private static final Logger logger = LoggerFactory.getLogger(HTMLImageType.class);

    public HTMLImageType(String id)
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
        	String root = UserContext.isAppClient() ? WebConfig.getAppContextRoot(context.getRequest()) : WebConfig.getResourceContextRoot();
        	String imageRoot = WebConfig.getAppImageContextRoot(context.getRequest());
        	if (this.getAttribute("captureScreen") != null) {
        		HTMLUtil.generateTab(context, depth);
                context.generateHTML("<script type=\"text/javascript\" src=\""+root+"/js/controls/html2canvas.js\"></script>");
            }
            generateWidget(context);
            if (this.getAttribute("isGallery") != null && ("true".equals(String.valueOf(this.getAttribute("isGallery"))))) {
	        	context.generateHTML("<div id=\"");
	        	context.generateHTML(getName());
	            context.generateHTML("\" class=\"swiper-container\">");
	            
	            HTMLUtil.generateTab(context, depth + 1);
	            context.generateHTML("<div class=\"swiper-wrapper\">");
	            String path = this.getValue();
	            if (path != null && !path.trim().isEmpty()) {
		            if (path.indexOf(";") != -1) {
		            	HTMLUtil.generateTab(context, depth + 1);
		            	String[] images = path.split(";");
		            	for (String i : images) {
		            		String item = imageRoot + "/" +  i;
		            		context.generateHTML("<span class=\"swiper-slide\" style=\"background-image:url(" + item + ")\" alt=\""+i+"\" img=\""+item+"\"/></span>");
		            		HTMLUtil.generateTab(context, depth + 2);
		            	}
		            } else {
			            File directory = new File(WebConfig.getResourcePath() + path);
			            if (directory.exists()) {
			            	String[] images = directory.list();
			            	for (String i : images) {
			            		File f = new File(directory, i);
			            		if (f.isFile()) {
				            		String item = imageRoot + path + "/" +  i;
				            		context.generateHTML("<span class=\"swiper-slide\" style=\"background-image:url("+ item +")\" alt=\""+i+"\" img=\""+item+"\"/></span>");
				            		HTMLUtil.generateTab(context, depth + 2);
			            		}
			            	}
			            	// don't display sub folder.
//			            	for (String i : images) {
//			            		File f = new File(directory, i);
//			            		if (f.isDirectory()) {
//			            			genarateAblum(imageRoot + path + "/" + i, context, f);
//			            		}
//			            	}
			            } else {
			            	String v = imageRoot + path;
			            	context.generateHTML("<span class=\"swiper-slide\" style=\"background-image:url(" + v + ")\" img=\""+ v +"\"/></span>");
			            	HTMLUtil.generateTab(context, depth + 2);
			            }
		            }
	            }
	            HTMLUtil.generateTab(context, depth + 1);
	            context.generateHTML("</div>");
	            HTMLUtil.generateTab(context, depth);
	            context.generateHTML("</div>");
        	} else {
	            context.generateHTML("<input type=hidden name=\"");
	            context.generateHTML(getName());
	            context.generateHTML("\">");
	            context.generateHTML("<img");
	            context.generateHTML(" src=\"");
	            context.generateHTML(getSrc(context));
	            context.generateHTML("\"");
	            generateAttributes(context);
	            generateEventListeners(context);
	            context.generateHTML(" style=\"cursor:pointer;\"/>");
	            if (this.getAttribute("sampleImagePath") != null) {
	            	context.generateHTML("<img");
            		context.generateHTML(" width='100px'");
		            context.generateHTML(" src=\"");
		            context.generateHTML(this.getAttribute("sampleImagePath").toString());
		            context.generateHTML("\" />");
	            }
	            if (this.getAttribute("showWords") != null) {
	            	context.generateHTML("<span>" + this.getAttribute("text") + "</span>");
	            }
        	}
            generateEndWidget(context);
        }
        catch (Exception e)
        {
            logger.error("error. in entity: " + getUIEntityName(), e);
        }
    }
    
    private void genarateAblum(String imageRoot, UserRequestContext context, File directory) {
    	String[] images = directory.list();
    	context.generateHTML("<div class=\"album\" data-jgallery-album-title=\""+directory.getName()+"\">");
    	for (String i : images) {
    		File f = new File(directory, i);
    		if (f.isFile()) {
        		String item = imageRoot + "/" +  i;
        		context.generateHTML("<a href=\""+ item +"\"><img src=\""+ item +"\" alt=\""+i+"\"/></a>");
    		}
    	}
    	context.generateHTML("</div>");
    }

    private String getSrc(UserRequestContext context)
    {
    	if (this.getAttribute("custDirectory") != null && "true".equals(String.valueOf(this.getAttribute("custDirectory")))) {
    		String url = (String)getAttribute("src");
            if(url == null) {
            	return "";
            }
            if (url.startsWith("http") || url.startsWith("https")) {
            	return url;
            }
    		return WebConfig.getResourceContextRoot() + url;
    	}
    	
        return context.getImageUrl(getUIEntityName(), (String) getAttribute("src"));
    }

    public void generateAttribute(UserRequestContext context, String attributeName, Object attributeValue) throws IOException
    {
        if ("src".equals(attributeName))
        {
        }
        else
        {
            super.generateAttribute(context, attributeName, attributeValue);
        }
    }

    /**
     * Whether this component can have editPermission.
     */
    @Override
    public boolean isEditPermissionEnabled()
    {
        return false;
    }
    
    public JSONObject createJsonModel(VariableEvaluator ee) throws JSONException 
    {
		boolean hasGallery = this.getAttribute("isGallery") != null && ("true".equals(String.valueOf(this.getAttribute("isGallery"))));
		if (!needAjaxSupport() && !hasGallery) {
    		Object oneditable = this.getAttribute("oneditable");
            if (oneditable == null || oneditable.toString().equalsIgnoreCase("false")){
            	return null;
            }
    	}
		
		Image image = new Image(getName(), Layout.NULL);

		image.setReadOnly(isReadOnly());
		image.setUIEntityName(getUIEntityName());

		if (getValue() != null && !"".equals(getValue())) {
			image.setSrc(getValue());
		} else {
			image.setSrc((String) getAttribute("src"));
		}
		image.setIsGallery(hasGallery);
		image.setListened(true);

//		Object expr = this.removeAttribute("selectedImageExpr");
//		if (expr != null) {
//			image.setSelectedImageExpr((ExpressionType)expr);
//		}
		JSONObject json = super.createJsonModel(ee);
		image.toJSON(json);
		return json;
	}
	
	public static String generateSimple(HttpServletRequest request, String srcs, int width, int height) {
		if (srcs == null || srcs.trim().length() == 0) {
			return "";
		}
		
		String imageRoot = WebConfig.getAppImageContextRoot(request);
		StringBuilder sb = DisposableBfString.getBuffer();
		try {
			sb.append("<div>");
			String[] list = srcs.split(",");
			for (String image : list) {
				String realImage = image;
				if (image.startsWith(WebConfig.getResourceContextRoot())) {
					realImage = realImage.replaceFirst(WebConfig.getResourceContextRoot(), "");
				}
				File directory = new File(WebConfig.getResourcePath() + realImage);
				if (directory.isDirectory()) {
					File[] files = directory.listFiles();
					for (File f : files) {
	            		if (f.isFile()) {
		            		String realPath = realImage + "/" +  f.getName();
		            		sb.append("<div img=\"").append(imageRoot).append(realImage).append("\" style=\"background-image:url(").append(imageRoot).append(realPath);
		            		sb.append(");width:").append(width).append("px;height:").append(height).append("px;background-size:contain;\" ></div>");
		            		break; //only generated the first image as simple mode.
	            		}
	            	}
				} else {
					if (realImage.startsWith("http") || realImage.startsWith("https")) {
						sb.append("<div img=\"").append(realImage).append("\" style=\"background-image:url(").append(realImage);
					} else {
						sb.append("<div img=\"").append(imageRoot).append(realImage).append("\" style=\"background-image:url(").append(imageRoot).append(realImage);
					}
					sb.append(");width:").append(width).append("px;height:").append(height).append("px;background-size:contain;\" ></div>");
					break; //only generated the first image as simple mode.
				}
			}
			sb.append("</div>");
			return sb.toString();
		} finally {
			DisposableBfString.release(sb);
		}
	}

	public static String getFirst(String path) {
		String imageRoot = WebConfig.getResourceContextRoot();
		if (path.indexOf(";") != -1) {
        	String[] images = path.split(";");
    		return imageRoot + "/" +  images[0];
        } else {
            File directory = new File(WebConfig.getResourcePath() + path);
            if (directory.exists()) {
            	String[] list = directory.list();
				if (list != null && list.length > 0) {
            		File a = new File(directory, list[0]);
            		if (a.isFile()) {
            		    return imageRoot + "/" +  path + "/" + list[0];
            		} else if (list.length > 1) {
        				return imageRoot + "/" +  path + "/" + list[1];
            		}
            	}
            	return imageRoot + "/" +  path;
            } else {
            	return imageRoot + "/" +  path;
            }
        }
	}
}
