<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/book_query.js"></script>
<title>book_query</title>
</head>
<body>
	<div>
		<s:form action="queryBook" method ="post" onsubmit="return check();">
			<span style="color:#ff0000;" id="msg"></span><input id="bookname" autocomplete="off" placeholder="输入书名或作者" name="param">
			<s:submit value="提交"></s:submit>
		</s:form>
	</div>
	<div>
		<table>
			<caption><h2>查询结果</h2></caption>
			<tr>
				<th>ISBN</th>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>价格</th>
				<th>总量</th>
				<th>剩余量</th>
				<th>书标</th>
			</tr>
			<s:if test="list!=null&&list.size>0">
				<s:iterator value="list">
				<tr>
					<td><s:property value="top.ISBN"/><td>
					<td><s:property value="top.bookName"/><td>
					<td><s:property value="top.author"/><td>
					<td><s:property value="top.publisher"/><td>
					<td><s:property value="top.price"/><td>
					<td><s:property value="top.cnum"/><td>
					<td><s:property value="top.snum"/><td>
					<td><s:property value="top.photo"/><td>
				</tr>
				</s:iterator>
			</s:if>
			<s:elseif test="param!=null">
				<tr>
					<td>没有查询结果<td>
				</tr>
			</s:elseif>
		</table>
	</div>
</body>
</html>