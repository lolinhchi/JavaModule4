<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul>
	<c:forEach items="${parents }" var="p">
		<li><b>${p.categoryName }</b></li>
		<c:forEach items="${children }" var="c">
			<c:if test="${p.categoryId == c.parentId }">
				<li><a href="#"> ${c.categoryName} </a>
			</c:if>
		</c:forEach>
	</c:forEach>
</ul>