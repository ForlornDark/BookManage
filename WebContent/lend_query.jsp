<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/lend_query.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
 <link rel="stylesheet" type="text/css" href="css/lend_book.css">
<title>lend_query</title>
</head>
<body>
	<form class="form-inline definewidth m20" action="queryLend" method="post" onsubmit="return check();">
     	<font color="#777777"><strong>借阅号:</strong></font>
    	<input type="text" autocomplete="off" pattern="^[0-9]*$" name="id" id="id" class="abc input-default" placeholder="  您的借阅号">&nbsp;&nbsp;
    	<button type="submit" class="btn btn-primary">查询</button> <span style="color:#ff0000;" id="msg"></span>
	</form>
	<div>
		<table class="table table-bordered table-hover definewidth m10">
			<caption><h2>查询结果</h2></caption>
			<thead>
			<tr>
				<th>ISBN</th>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>价格</th>
				<th>数量</th>
				<th>借书时间</th>
				<th>书标</th>
			</tr>
			</thead>
			<s:if test="list!=null&&list.size>0">
				<s:iterator value="list">
				<tr>
					<td><s:property value="top.ISBN"/></td>
					<td><s:property value="top.book.bookName"/></td>
					<td><s:property value="top.book.author"/></td>
					<td><s:property value="top.book.publisher"/></td>
					<td><s:property value="top.book.price"/></td>
					<td><s:property value="top.num"/></td>
					<td><s:date name="top.time" format="yyyy年MM月dd日"/></td>
			<!--  		<td><s:property value="top.photo"/></td> -->
				</tr>
				</s:iterator>
			</s:if>
			<s:elseif test="id!=null">
				<tr>
					<td colspan="8" style="color:#ff0000;text-align:center ;border-collapse:collapse;">没有记录</td>
				</tr>
			</s:elseif>
		</table>
	</div>
</body>
</html>