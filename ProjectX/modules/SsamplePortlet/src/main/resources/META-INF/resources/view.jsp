<%@ include file="/init.jsp" %>
Welcome to <%=request.getAttribute("siteName") %>
<table class="table-striped">
	<tr><th>UACS</th><th>Deparment</th><th>Agency</th></tr>
	<%=request.getAttribute("data") %>
</table>