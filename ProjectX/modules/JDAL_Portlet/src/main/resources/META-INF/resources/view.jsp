<%@ include file="/init.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<p>
	<b><liferay-ui:message key="jda_portletconstructor.caption"/></b>
	<button class="btn btn-primary">Click me!</button>
	Today's date: <%= (new java.util.Date()).toLocaleString()%>
	<%=request.getAttribute("obj") %>khkjhkj
</p>