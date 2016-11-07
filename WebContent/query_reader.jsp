<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/book_query.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/lend_book.css">
<title>book_query</title>
</head>
<body>
	<div>
		<s:form class="form-inline definewidth m20" action="queryBook" method ="post" onsubmit="return check();">
			<font color="#777777"><strong>ID或姓名：</strong></font>
			<input type="text" class="abc input-default" autocomplete="off" placeholder="ID或姓名" name="param">
			&nbsp;&nbsp;<button type="submit" class="btn btn-primary">查询</button>
			<span style="color:#ff0000;" id="msg"></span>
		</s:form>
	</div>
	<div>
		<table class="table table-bordered table-hover definewidth m10">
			<caption><h2>查询结果</h2></caption>
			<thead>
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>性别</th>
				<th>生日</th>
				<th>职业</th>
				<th>头像</th>
			</tr>
			</thead>
		</table>
	</div>
</body>
</html>