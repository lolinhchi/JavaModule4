<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form:form action="them-loai" method="post" modelAttribute="category">
	<h1>Thêm loại</h1>
	<p>
		<form:label path="categoryName">Tên loại:</form:label>
		<form:input path="categoryName" />
	</p>
	<p>
		<form:label path="parentId">Parent:</form:label>
		<form:select path="parentId">
			<form:options items="${parents}" itemLabel="categoryName"
				itemValue="categoryId" />
		</form:select>
	</p>
	<p>
		<form:button>Save</form:button>
	</p>
	
</form:form>
<c:if test="${not empty msg }">
	<p style="color: blue">${msg }</p>
</c:if>
