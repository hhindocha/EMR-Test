<%
	response.setHeader("Cache-Control", "no-cache");
	out.print(request.getQueryString());
%>
