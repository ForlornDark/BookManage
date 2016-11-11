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
		<s:form class="form-inline definewidth m20" action="queryBookManager" method ="post" onsubmit="return check();">
			<font color="#777777"><strong>书名或作者：</strong></font>
			<input type="text" class="abc input-default" autocomplete="off" placeholder="输入书名或作者" name="page.index">
			&nbsp;&nbsp;<button type="submit" class="btn btn-primary">查询</button>
			<span style="color:#ff0000;" id="msg"></span>
		</s:form>
	</div>
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
				<th>总量</th>
				<th>剩余量</th>
				<th>书标</th>
				<th>操作</th>
			</tr>
			</thead>
			<s:if test="page.result!=null&&page.result.size>0">
				<s:iterator value="page.result">
				<tr>
					<td><s:property value="top.ISBN"/></td>
					<td><s:property value="top.bookName"/></td>
					<td><s:property value="top.author"/></td>
					<td><s:property value="top.publisher"/></td>
					<td><s:property value="top.price"/></td>
					<td><s:property value="top.cnum"/></td>
					<td><s:property value="top.snum"/></td>
					<td></td>
				 <!--<td><s:property value="top.photo"/><td>-->
				 	<td><a href="deleteBook.action?ISBN=${top.ISBN }">删除</a></td>
				</tr>
				</s:iterator>
			</s:if>
			<s:elseif test="state!=null">
				<tr>
					<td colspan="8" style="color:#ff0000;text-align:center ;border-collapse:collapse;"><s:property value="state"/></td>
				</tr>
			</s:elseif>
		</table>
	</div>
	<s:if test="page.maxPage>1">
	<div class = "page">
				<form action="queryBookManager" class="form-inline definewidth m10" method ="post">
				<s:if test="page.pageCount>1">
					<a href="queryBookManager?page.index=${page.index}&page.pageCount=${page.pageCount-1}">上一页</a>
				</s:if>
					<s:if test="page.pageCount<page.maxPage">
					<a href="queryBookManager?page.index=${page.index}&page.pageCount=${page.pageCount+1}">下一页</a>
					</s:if>
			
					<input type="hidden" name="page.index" value="${page.index}" >
					<input type="number" autocomplete="off"name="page.pageCount" size="3">&nbsp&nbsp<button type="submit" class="btn btn-primary">跳转</button>&nbsp&nbsp<span>${page.pageCount}页 / ${page.maxPage}页</span>
				</form>
			</div>
	</s:if>
</body>
</html>