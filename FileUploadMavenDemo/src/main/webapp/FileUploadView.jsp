<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Page</title>
</head>
<body>
	<br/><h2>This is file Upload result page....</h2><br/>
	<h3>Files loaded:</h3>
	
	<!--  Java -->
	<%
		ArrayList<?> files =  (ArrayList<?>)request.getAttribute("files");
		for (Object f: files) {
	%>
	<%= f %> <br/>
	<% } %> <br/>
	
	<!-- JSTL -->
	<% request.setAttribute("files", files); %>
	
 	<c:set var="total" value="0"></c:set>

	<c:forEach  var="file" items="${files}" >
		<c:set var="total" value="${total} + 1"></c:set>
		<br/>File ${total }: ${file} <c:out value="${file.value}" />
		<!-- <c:out value="${requestScope[\"file\"]}"/> -->
	</c:forEach>
	 
</body>
</html>