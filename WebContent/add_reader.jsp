<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title>add-book</title>
    <meta charset="UTF-8">
    <script type="text/javascript" src="js/date.js"></script>
    <script type="text/javascript" src="js/add_reader.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/lend_book.css">
    <style>
    	.date{
    	width:70px;
    	}
    	</style>
</head>
<body onLoad="init()">
<form class="form-inline definewidth m20" action="addReader" method="post" enctype="multipart/form-data" onsubmit="return check()">
	<table class="table table-bordered table-hover definewidth m10">
		<tr>
			<td><font color="#777777"><strong>姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名：</strong></font>
    			<input id ="name" autocomplete="off" type="text" name="reader.name" value="${reader.name}" class="abc input-default" placeholder="姓名" >
    		</td>
    		<td><font color="#777777"><strong>性&nbsp&nbsp别：</strong></font>
    			<select name="reader.sex">
    				<option value="1">男</option>
    				<option value="0">女</option>
    			</select>
    		</td>
		</tr>
		<tr>
    		<td><font color="#777777"><strong>出生日期：</strong></font>
    			<select class="date"  id="year" onChange="swap_day()" name="year"></select>年
				<select class="date" id="month" onChange="swap_day()" name="month"></select>月
				<select class="date"  id="day" name="day"></select>日
    		</td>
			<td><font color="#777777"><strong>职&nbsp&nbsp业：</strong></font>
			<select name="reader.spec">
				<option value="学生">学生</option>
				<option value="计算机/互联网/通信">计算机/互联网/通信</option>
				<option value="生产/工艺/制造">生产/工艺/制造</option>
				<option value="医疗/护理/制药">医疗/护理/制药</option>
				<option value="金融/银行/投资/保险">金融/银行/投资/保险</option>
				<option value="商业/服务业/个体经营">商业/服务业/个体经营</option>
				<option value="文化/广告/传媒">文化/广告/传媒</option>
				<option value="娱乐/艺术/表演">娱乐/艺术/表演</option>
				<option value="律师/法务">律师/法务</option>
				<option value="教育/培训">教育/培训</option>
				<option value="公务员/行政/事业单位">公务员/行政/事业单位</option>
				<option value="模特">模特</option>
				<option value="空姐">空姐</option>
				<option value="其他">其他</option>
			</select>
    		</td>
    	</tr>
    	<tr>
    		
    		<td><font color="#777777"><strong>邮&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp箱：</strong></font>
    		<input name="reader.mail" autocomplete="off" value="${reader.mail}" id="mail" type="email" class="abc input-default">&nbsp&nbsp<button type="button" id="sendcode" onclick="send()" class="btn btn-primary">获取验证码</button></td>
		<td><font color="#777777"><strong>验证码：</strong></font><input autocomplete="off" name="checkcode" id="checkcode" type="number" class="abc input-default"></td>
		</tr>
		<tr>
			
			<td><font color="#777777"><strong>照&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp片：</strong></font>
    			<input autocomplete="off" type="file" name="photo" class="abc input-default" >
    		</td>
			<td><button type="submit" class="btn btn-primary">注册</button><span id="msg" class="msg"><s:property value="state"/></span></td>
		</tr>
	</table>
</form>
<table class="table table-bordered table-hover definewidth m10">
	<caption><h2>添加结果</h2></caption>
    <thead>
    <tr>
        <th>借阅号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>出生日期</th>
        <th>职业</th>
        <th>邮箱</th>
		<th>照片</th>
     </tr>
    </thead>
    <s:if test="reader.readerId!=0">
        	<tr>
        	
        		<td><s:property value="reader.readerId"></s:property></td>
                <td><s:property value="reader.name"></s:property></td>
                <td><s:if test="reader.sex==0">女</s:if><s:elseif test="reader.sex==1">男</s:elseif></td>
                <td><s:date name="reader.born" format="yyyy年MM月dd日"/></td>
                <td><s:property value="reader.spec"></s:property></td>
                <td><s:property value="reader.mail"/></td>
                <td><img  src="${reader.photo}" width="35px" height="35px"></td>
            </tr>
            </s:if>
       </table>
</body>
</html>