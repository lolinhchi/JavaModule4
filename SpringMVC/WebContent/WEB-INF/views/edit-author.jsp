<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="edit-author" method="post">
	<input type="hidden" name="txtId" value="${author.id }" />
	<p><label>Author Name: </label><input type="text" name="txtName" value="${author.name}" /></p>
	<button style="background-color: lightBlue">Edit</button>
</form>
<c:if test="${not empty msg }">
	<p style="color: blue">${msg }</p>
</c:if>
