<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Mail</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/send-mail" method="post">
			<p><label>Email    </label><input type="text" name="email" /> </p>
			<p><label>Subject  </label><input type="text" name="subject" /> </p>
			<p><label>Content  </label><input type="text" name="content"  size="80" /> </p>
			<input type="submit" value="Send"" /> 
			<input type="reset" value="Reset"" /> 
	</form>
</body>
</html>