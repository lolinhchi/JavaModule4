<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="add-author" method="post">
	<p><label>Author Name: </label><input type="text" name="txtName" /></p>
	<button style="background-color: lightBlue"  >Add</button>
</form>
<c:if test="${not empty msg }">
	<p style="color: blue">${msg }</p>
</c:if>
