/**
 * 
 */
function check(){
	var correct = true;
	var name = document.getElementById("name").value;
	var checkcode =  document.getElementById("checkcode").value;
	var email =  document.getElementById("mail").value;
	var msg = document.getElementById("msg");
	msg.innerHTML="";
	if(name==""){
		msg.innerHTML="姓名不能为空";
		correct = false;
	}
	if(email==""){
		msg.innerHTML="请输入邮箱";
		correct = false;
	}
	if(checkcode==""){
		msg.innerHTML="输入邮箱验证码";
		correct = false;
	}else if(checkcode.length!=4){
		msg.innerHTML="输入4位邮箱验证码";
		correct = false;
	}
	return correct;
}
function send(){
	var msg =document.getElementById("msg");
	msg.innerHTML="";
	var email = document.getElementById("mail").value;
	if(email==""){
		msg.innerHTML="请输入邮箱";
		return;
	}
	var button = document.getElementById("sendcode");
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		  	var result =xmlhttp.responseText;
		  	if(result=="success"){
		  		time(button)
		  	}else{
		  		msg.innerHTML="发送邮件失败，请检查邮箱";
		  	}
	    }
	  }
	xmlhttp.open("POST","sendMail","ture");
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("mail="+email);
}
	var wait = 120;
function time(btn) {
		if (wait == 0) {
			btn.removeAttribute("disabled");
			btn.innerHTML = "重新发送";
			wait = 60;
            } else {
			btn.setAttribute("disabled", true);
			btn.innerHTML = wait + "s重新获取";
			wait--;
			setTimeout(function () {
				time(btn);
				},1000)
            }
}