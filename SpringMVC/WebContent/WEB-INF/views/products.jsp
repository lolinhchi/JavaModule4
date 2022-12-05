<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="display: flex;flex-flow: row wrap;">
	<c:forEach items="${products }" var="p">
		<figure style="width: 250px;">
			<img alt="" src="${pageContext.request.contextPath}/img/${p.imageUrl }" width="200" height="200">
			<figcaption>${p.title }</figcaption>
		</figure>
	</c:forEach>
</div>