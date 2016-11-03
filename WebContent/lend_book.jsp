<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>lend-book</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/lend_book.css">
</head>
<body>
<form class="form-inline definewidth m20" action="#" method="post">
     <font color="#777777"><strong>借阅号</strong></font>
    <input type="text" name="menuname" id="menuname"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <font color="#777777"><strong>ISBN</strong></font>
    <input type="text" name="menuname" id="menuname"class="abc input-default" placeholder="" value="">
    <font color="#777777"><strong>数量</strong></font>
    <input type="text" name="menuname" id="menuname"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button> 
</form>
<table class="table table-bordered table-hover definewidth m10">
	<caption><h2>查询结果</h2></caption>
    <thead>
    <tr>
        <th>ISBN</th>
        <th>姓名</th>
        <th>书名</th>
        <th>时间</th>
		<th>数量</th>
     </tr>
    </thead>
        <tr>
                <td>978-12-1231-132-1</td>
                <td>刘福名</td>
                <td>计算机网络</td>
                <td>2016-11-2</td>
                <td>5</td>
			<!-- <td><button type="submit">注销</button></td> -->
        </tr>
       </table>
</body>
</html>