/**
 * 
 */
function check(){
	var correct = true;
	var isbn = document.getElementById("isbn").value;
	var bookname = document.getElementById("bookname").value;
	var author = document.getElementById("author").value;
	var publisher =document.getElementById("publisher").value;
	var price = document.getElementById("price").value;
	var number = document.getElementById("number").value;
	var reg = /^(?:ISBN(?:-13)?:?\ )?(?=[0-9]{13}$|(?=(?:[0-9]+[-\ ]){4})[-\ 0-9]{17}$)97[89][-\ ]?[0-9]{1,5}[-\ ]?[0-9]+[-\ ]?[0-9]+[-\ ]?[0-9]$/;
	var reg2=/^(\d*\.)?\d+$/;
	var msg = document.getElementById("msg");
	msg.innerHTML="";
	if(isbn==""){
		msg.innerHTML="ISBN不能为空";
		correct = false;
	}else if(!reg.test(isbn)){
		msg.innerHTML="ISBN格式不正确";
		correct = false;
	}
	if(bookname==""){
		msg.innerHTML = "图书名不能为空";
		correct=false;
	}
	if(author==""){
		msg.innerHTML = "作者不能为空";
		correct=false;
	}
	if(publisher==""){
		msg.innerHTML = "出版社不能为空";
		correct=false;
	}
	else if(publisher.length<="出版社".length){
		msg.innerHTML = "请填写完成出版社名";
		correct=false;
	}
	else if(!publisher.endsWith("出版社")){
		msg.innerHTML = "出版社格式不正确";
		correct=false;
	}
	if(price==""){
		document.getElementById("price").value = 0;
		correct = false;
	}else if(!reg2.test(price)){
		msg.innerHTML="请正确输入价格";
		correct = false;
	}
	if(number==""){
		msg.innerHTML="数量不能为空";
		correct = false;
	}else if(number<0){
		msg.innerHTML="请正确输入数量";
		correct = false;
	}
	/*
	if(number==""){
		msg.innerHTML="数量不能为空";
		correct = false;
	}else if(number==0){
		msg.innerHTML="数量不能为0";
		correct = false;
	}
	*/
	return correct;
}