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
package org.shaolin.uimaster.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.shaolin.bmdp.json.JSONObject;
import org.shaolin.javacc.exception.EvaluationException;
import org.shaolin.uimaster.page.ajax.json.DataItem;
import org.shaolin.uimaster.page.ajax.json.IDataItem;
import org.shaolin.uimaster.page.ajax.json.IRequestData;
import org.shaolin.uimaster.page.ajax.json.RequestData;
import org.shaolin.uimaster.page.exception.AjaxException;
import org.shaolin.uimaster.page.flow.WebflowConstants;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author wushaol
 */
public class AjaxContextHelper {

	private static final ThreadLocal<AjaxContext> threadLocal = new ThreadLocal<AjaxContext>();

	/**
	 * create ajax context.
	 * 
	 * @param context
	 */
	public static void createAjaxContext(AjaxContext context) {
		threadLocal.set(context);
	}

	/**
	 * get ajax context
	 * 
	 * @return the ajaxcontext gotten by thread local
	 */
	public static AjaxContext getAjaxContext() {
		return threadLocal.get();
	}

	public static void removeAjaxContext() {
		threadLocal.set(null);
	}

	public static AjaxContext createUI2DataAjaxContext(String entityUiid, String uiform, HttpServletRequest request) 
			throws AjaxException  {
		Map<String, JSONObject> uiMap = AjaxContextHelper.getFrameMap(request);
		IRequestData requestData = AjaxContextHelper.createRequestData();
		requestData.setEntityName(uiform);
		requestData.setUiid(entityUiid);
		requestData.setEntityUiid(entityUiid);
        requestData.setFrameId("");
        JSONObject comp = uiMap.get(requestData.getUiid());
        if (comp == null) {
            throw new AjaxException("Can not find this component[" + requestData.getUiid() + "] in the UI map!");
        }
        AjaxContext context = new AjaxContext(uiMap, requestData);
        try {
			context.initData();
		} catch (EvaluationException e) {
			throw new AjaxException(e.getMessage(), e);
		}
        return context;
	}
	
	public static List<String> getAllCachedPages(HttpSession session) {
		return (List<String>)session.getAttribute(AjaxContext.ALL_CACHED_PAGES);
	}
	
	public static void addCachePage(HttpSession session, String name) {
		if (session.getAttribute(AjaxContext.ALL_CACHED_PAGES) == null) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(name);
			session.setAttribute(AjaxContext.ALL_CACHED_PAGES, list);
		} else {
			List<String> list = getAllCachedPages(session);
			if (!list.contains(name)) {
				list.add(name);
			}
		}
	}
	
	public static void removeAllCachedPages(HttpSession session) {
		session.removeAttribute(AjaxContext.ALL_CACHED_PAGES);
	}
	
	public static void removeCachedPage(HttpSession session, String name) {
		List<String> list = getAllCachedPages(session);
		if (list != null) {
			list.remove(name);
		}
	}
	
	public static void removeAllExcludedPages(HttpSession session, String name) {
		List<String> list = getAllCachedPages(session);
		if (list != null) {
			list.remove(name);
		}
	}
	
	
	/**
	 * get frame map which is decide to the '_framePrefix' parameter.
	 * 
	 * @param request
	 * @return the frame map
	 */
	public static Map<String, JSONObject> getFrameMap(HttpServletRequest request) throws AjaxException {
		String framePrefix = request.getParameter("_framePrefix");
		Map<String, ?> ajaxComponentMap = (Map<String, ?>) request.getSession().getAttribute(AjaxContext.AJAX_COMP_MAP);
		if (ajaxComponentMap == null) {
			throw new AjaxException("Please re-initialize the whole page.");
		}
		Map<String, JSONObject> pageComponentMap;
		if (framePrefix == null || "null".equalsIgnoreCase(framePrefix)
				|| framePrefix.length() == 0) {
			pageComponentMap = (Map<String, JSONObject>) ajaxComponentMap.get(AjaxContext.GLOBAL_PAGE);
		} else {
			pageComponentMap = (Map<String, JSONObject>) ajaxComponentMap.get(framePrefix);
		}
		if (pageComponentMap == null) {
			LoggerFactory.getLogger(AjaxContextHelper.class).warn(
					"Cannot found frame map by this frame prefix["
							+ framePrefix + "].");
		}
		return pageComponentMap;
	}
	
	public static void updateFrameMap(HttpServletRequest request, Map<String, JSONObject> pageComponentMap) throws AjaxException {
		String framePrefix = request.getParameter("_framePrefix");
		Map ajaxComponentMap = (Map) request.getSession().getAttribute(AjaxContext.AJAX_COMP_MAP);
		if (ajaxComponentMap == null) {
			throw new AjaxException("Please re-initialize the whole page.");
		}
		if (framePrefix == null || "null".equalsIgnoreCase(framePrefix)
				|| framePrefix.length() == 0) {
			ajaxComponentMap.put(AjaxContext.GLOBAL_PAGE, pageComponentMap);
		} else {
			ajaxComponentMap.put(framePrefix, pageComponentMap);
		}
		// mark as session changed.
		request.getSession().setAttribute(AjaxContext.AJAX_COMP_MAP, ajaxComponentMap);
	}

	/**
	 * get ui map in whole page, it includes all frame maps.
	 * 
	 * @param session
	 * @return ui map which is in the whole page.
	 */
	public static Map<String, ?> getAjaxWidgetMap(HttpSession session) {
		if (session != null) {
			return (Map<String, ?>) session.getAttribute(AjaxContext.AJAX_COMP_MAP);
		}
		return Collections.EMPTY_MAP;
	}
	
	public static JSONObject getCachedAjaxWidget(String name,
			UserRequestContext htmlContext) throws AjaxException {
		Map<String, JSONObject> uiMap = AjaxContextHelper.getFrameMap(htmlContext.getRequest());
		JSONObject obj = uiMap.get(name);
		if (obj == null) {
			throw new AjaxException("Can not be found this uiid["
					+ name + "] in UI map! make sure this widget is needAjaxSupported!");
		}
		return obj;
	}

	public static String getFrameId(HttpServletRequest request) {
		String frameName = request.getParameter(WebflowConstants.FRAME_NAME);
        String superPrefix = "";
        String framePrefix = request.getParameter("_framePrefix");
        String frameTarget = request.getParameter("_frameTarget");
		if (frameTarget != null && !frameTarget.equals("null")) {
			superPrefix = frameTarget;
		} else if (framePrefix != null && !framePrefix.equals("null")
				&& framePrefix.length() != 0) {
			superPrefix = framePrefix;
			if (frameName != null) {
				superPrefix += '.' + frameName;
			}
		} else if (frameName != null) {
			superPrefix = frameName;
		}
		if (frameTarget == null || frameTarget.equals("null"))
        {
            frameTarget = superPrefix;
        }
		return frameTarget;
	}

	public static IRequestData createRequestData() {
		return new RequestData();
	}

	public static IDataItem createDataItem() {
		IDataItem dataItem = new DataItem();
		dataItem.setJsHandler(IJSHandlerCollections.MSG_INFO);
		return dataItem;
	}

	public static IDataItem createErrorDataItem(String msg) {
		IDataItem dataItem = new DataItem();
		dataItem.setJsHandler(IJSHandlerCollections.MSG_ERROR);
		dataItem.setData(msg);
		return dataItem;
	}

	public static IDataItem createJavaItem() {
		IDataItem dataItem = new DataItem();
		dataItem.setJsHandler(IJSHandlerCollections.JAVA_OBJECT);
		return dataItem;
	}

	public static IDataItem createDataItem(IRequestData data) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(data.getUiid());
		dataItem.setJsHandler(IJSHandlerCollections.MSG_INFO);
		return dataItem;
	}

	public static IDataItem createAppendItem(String parentId, String uiid) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setParent(parentId);
		dataItem.setJsHandler(IJSHandlerCollections.HTML_APPEND);
		return dataItem;
	}
	
	public static IDataItem createAppendItemToTab(String parentId, String uiid) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setParent(parentId);
		dataItem.setJsHandler(IJSHandlerCollections.TAB_APPEND);
		return dataItem;
	}

	public static IDataItem createRemoveItem(String parentId, String uiid) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setParent(parentId);
		dataItem.setJsHandler(IJSHandlerCollections.HTML_REMOVE);
		return dataItem;
	}

	public static IDataItem createReadOnlyItem(String uiid) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setJsHandler(IJSHandlerCollections.HTML_UPDATE_READONLY);
		return dataItem;
	}

	public static IDataItem updateAttrItem(String uiid, String data) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setData(data);
		dataItem.setJsHandler(IJSHandlerCollections.HTML_UPDATE_ATTR);
		return dataItem;
	}

	public static IDataItem updateEventItem(String uiid, String data) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setData(data);
		dataItem.setJsHandler(IJSHandlerCollections.HTML_UPDATE_EVENT);
		return dataItem;
	}

	public static IDataItem updateCssItem(String uiid, String data) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setData(data);
		dataItem.setJsHandler(IJSHandlerCollections.HTML_UPDATE_CSS);
		return dataItem;
	}

	public static IDataItem updateConstraintItem(String uiid, String data) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setData(data);
		dataItem.setJsHandler(IJSHandlerCollections.HTML_UPDATE_CONST);
		return dataItem;
	}
	
	public static IDataItem showConstraint(String uiid, String message) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setData(message);
		dataItem.setJsHandler(IJSHandlerCollections.SHOW_CONSTRAINT);
		return dataItem;
	}
	
	public static IDataItem removeConstraint(String uiid) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setJsHandler(IJSHandlerCollections.REMOVE_CONSTRAINT);
		return dataItem;
	}

	public static IDataItem removeAttrItem(String uiid, String data) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setData(data);
		dataItem.setJsHandler(IJSHandlerCollections.HTML_REMOVE_ATTR);
		return dataItem;
	}

	public static IDataItem removeEventItem(String uiid, String data) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setData(data);
		dataItem.setJsHandler(IJSHandlerCollections.HTML_REMOVE_EVENT);
		return dataItem;
	}

	public static IDataItem removeCssItem(String uiid, String data) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setData(data);
		dataItem.setJsHandler(IJSHandlerCollections.HTML_REMOVE_CSS);
		return dataItem;
	}

	public static IDataItem removeConstraintItem(String uiid, String data) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setData(data);
		dataItem.setJsHandler(IJSHandlerCollections.HTML_REMOVE_CONST);
		return dataItem;
	}

	public static IDataItem updateTableItem(String uiid, String data) {
		IDataItem dataItem = new DataItem();
		dataItem.setUiid(uiid);
		dataItem.setData(data);
		dataItem.setJsHandler(IJSHandlerCollections.TABLE_UPDATE);
		return dataItem;
	}
	
	public static IDataItem createLoadJS(String uiid, String data) {
		IDataItem dataItem = new DataItem();
		dataItem.setJsHandler(IJSHandlerCollections.LOAD_JS);
		dataItem.setUiid(uiid);
		dataItem.setData(data);
		return dataItem;
	}
	
	public static IDataItem createSessionTimeOut(String msg) {
		IDataItem dataItem = new DataItem();
		dataItem.setJsHandler(IJSHandlerCollections.SESSION_TIME_OUT);
		dataItem.setData(msg);
		return dataItem;
	}
	
	public static IDataItem createNoPermission(String msg) {
		IDataItem dataItem = new DataItem();
		dataItem.setJsHandler(IJSHandlerCollections.NO_PERMISSION);
		dataItem.setData(msg);
		return dataItem;
	}

}
