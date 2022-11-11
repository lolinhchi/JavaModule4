<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tiles:insertAttribute name="tieuDe"/></title>
<style type="text/css">
	header, footer {
		height: 100px;
		background-color: lightblue;
	}
	main{
		display: flex;
		width: 100%;
		
	}
	nav{
		width: 20%;
		background-color: khaki;
	}
	article{
		width: 80%;
		background: lightyellow;
	}
</style>
</head>
<body>

<header>
	<h1>Header</h1>
	<tiles:insertAttribute name="dauTrang"/>
</header>
<main>
	<nav>
		<h1>Danh sách</h1>
		<tiles:insertAttribute  name="thucDon"/>
	</nav>
	<article>
		<h1>Nội dung</h1>
		<tiles:insertAttribute name="noiDung" />
	</article>
</main>
<footer>
	<h1>Footer</h1>
	<tiles:insertAttribute name="cuoiTrang"/>
</footer>
</body>
</html>