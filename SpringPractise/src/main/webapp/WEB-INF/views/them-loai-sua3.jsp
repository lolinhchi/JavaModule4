<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm</title>
</head>
<body>
	<form action="them-loai-sua3" method="post">
		<h1>Thêm loại sữa</h1>
		<p><label>Mã loại:</label><input type="text" name="maLoai"></p>
		<p><label>Tên loại:</label><input type="text" name="tenLoai"></p>
		<p><input type="submit" name="btnThem" value="Thêm"></p>
	</form>
	<c:if test="${not empty tb}">
		<p style="color: red;">${tb}</p>
	</c:if>
</body>
</html>