<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br>
<br>
<div align="center" >
	<form action="add-author" method="get">
		<button style="background-color: lightBlue"  >Add New</button>
	</form>
</div>
<br>
<br>
<form action="del-multi-author" method="post">
	<table border="1" align="center">
	<tr>
		<th><button style="background-color: lightBlue"  >Delete</button></th>
		<th>Id</th>
		<th>Name</th>
		<th>Edit</th>
		<th>Del</th>
	</tr>
	<c:forEach items="${authors}" var="au">
		<tr>
			<td><input type="checkbox" name="idDel" value="${au.id }" /></td>
			<td>${au.id }</td>
			<td>${au.name }</td>
			<td>
				<a href="edit-author?id=${au.id }">
					<img alt="" src="img/edit.png">
				</a>
				
			</td>
			<td>
				<a href="del-author?id=${au.id }">
					<img src="img/trash.png">
				</a>
				
			</td>
		</tr>
	</c:forEach>
	
</table>
</form>
