<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.shaolin.uimaster.page.flow.WebflowConstants" %>
<%@ page import="org.shaolin.bmdp.i18n.ResourceUtil" %>
<% String webRoot = "/uimaster";%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<%=webRoot%>/css/main.css" type="text/css">
	</head>

	<body>
		<% long suffix = System.currentTimeMillis();%>
		<DIV id="uIPanel1Root.titlePanel" class=table-tp name="uIPanel1Root">
			<DIV class=title-tp>
				<DIV style="WIDTH: 20px; Height: 23px; FLOAT: left">&nbsp;
				</DIV>
			</DIV>
			<DIV class=content-tp>
				<DIV id="uIPanel1Root.wrapperPanel">
					<DIV style="width:100%;">
						<DIV style="width:50px;height:100%;FLOAT: left">
							<img src="<%=webRoot%>/images/Warning.png"></img>
						</DIV>
						<DIV
							style="width:100%;height:100%;vertical-align:bottom;padding-top:10px;padding-bottom:10px;">
							Sorry, you have no permission to access this page!
						</DIV>
					</DIV>
					<br>

				</DIV>
			</DIV>
		</DIV>

	</body>
</html>