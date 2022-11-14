<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/upload-file" method="post" enctype="multipart/form-data">
		<h1>Minh họa Upload file</h1>
		<p><lable>Tập tin: </lable><input type="file" name="file" /></p>
		<p><input type="submit" name="upload" value="Upload" /></p>
		
	</form>
	<c:if test="${not empty msg }">
		<p style="color: blue"> ${msg }</p>
	</c:if>
	<c:if test="${not empty tapTin }">
		<img alt="" src="img/${tapTin }">
	</c:if>
</body>
</html>