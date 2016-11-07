<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title>add-book</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/lend_book.css">
</head>
<body>
<form class="form-inline definewidth m20" action="addBook" method="post" enctype="multipart/form-data">
	<table class="table table-bordered table-hover definewidth m10">
		<tr>
			<td><font color="#777777"><strong>ISBN：&nbsp&nbsp</strong></font>
    			<input autocomplete="off" type="text" name="book.ISBN" class="abc input-default" placeholder="978-7-121-25457-4" >
    		</td>
    		<td><font color="#777777"><strong>书名：</strong></font>
    			<input autocomplete="off" type="text" name="book.bookName" class="abc input-default" placeholder="图书名" >
    		</td>
    		<td><font color="#777777"><strong>作者：</strong></font>
    			<input autocomplete="off" type="text" name="book.author" class="abc input-default" placeholder="作者" >
    		</td>
		</tr>
		<tr>
			<td><font color="#777777"><strong>出版社：</strong></font>
    			<input autocomplete="off" type="text" name="book.publisher" class="abc input-default" placeholder="XXX出版社" >
    		</td>
    		<td><font color="#777777"><strong>价格：</strong></font>
    			<input autocomplete="off" type="text" name="book.price" class="abc input-default" placeholder="默认为0" >
    		</td>
    		<td><font color="#777777"><strong>数量：</strong></font>
    			<input autocomplete="off" type="number" name="book.cnum" class="abc input-default" placeholder="大于0" >
    		</td>
		</tr>
		<tr>
			<td><font color="#777777"><strong>封&nbsp&nbsp面：&nbsp</strong></font>
    			<input autocomplete="off" type="file" name="photo" class="abc input-default" >
    		</td>
    		<td><button type="submit" class="btn btn-primary">添加</button><span class="msg"></span>
    		</td>
		</tr>
	</table>
</form>
<table class="table table-bordered table-hover definewidth m10">
	<caption><h2>添加结果</h2></caption>
    <thead>
    <tr>
        <th>ISBN</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>价格</th>
		<th>总量</th>
		<th>余量</th>
		<th>封面</th>
     </tr>
    </thead>
      	<tr>
      		<td><s:property value="book.ISBN"/></td>
      		<td><s:property value="book.bookName"/></td>
      		<td><s:property value="book.author"/></td>
      		<td><s:property value="book.publisher"/></td>
      		<td><s:property value="book.price"/></td>
      		<td><s:property value="book.cnum"/></td>
      		<td><s:property value="book.snum"/></td>
      		<td><img src="${book.path}" width="20px" height="20px"></td>
      	</tr> 
      </table>
</body>
</html>