<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/index.js"></script>
<title>welcome</title>
</head>
<body>
<div>
<h1>图书管理系统</h1>
</div>
<div >
	<a href="login.jsp">管理员登陆</a>
</div>
<div>
	<span onclick="openUrl('lend_query.jsp')">借阅查询</span>
	<span onclick="openUrl('book_query.jsp')">图书查询</span>
	<span id="about" onclick="openUrl('about.html');">关于</span>
</div>
<iframe id="container" width="100%" height="500px" src="book_query.jsp">
</iframe>
</body>
</html>