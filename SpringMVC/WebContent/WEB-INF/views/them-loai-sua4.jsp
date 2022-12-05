<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form method="post" modelAttribute="loaiSua">

	<p>
		<form:label path="maLoai">Ma loai:</form:label>
		<form:input path="maLoai"/>
	</p>
	<p>
		<form:label path="tenLoai">Ten loai:</form:label>
		<form:input path="tenLoai"/>
	</p>
	<p>
		<form:button>Save</form:button>
	</p>
</form:form>


<c:if test="${not empty msg }">
	<p style="color: blue">${msg }</p>
</c:if>