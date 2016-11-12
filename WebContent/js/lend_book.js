/**
 * 
 */
function check(){
	var correct = true;
	var readerId = document.getElementById("readerId").value;
	var isbn = document.getElementById("isbn").value;
	var reg = /^(?:ISBN(?:-13)?:?\ )?(?=[0-9]{13}$|(?=(?:[0-9]+[-\ ]){4})[-\ 0-9]{17}$)97[89][-\ ]?[0-9]{1,5}[-\ ]?[0-9]+[-\ ]?[0-9]+[-\ ]?[0-9]$/;
	var msg = document.getElementById("msg");
	msg.innerHTML="";
	var number = document.getElementById("number").value;
	if(readerId==""){
		msg.innerHTML="id不能为空";
		correct = false;
	}else if(readerId.length<6){
			msg.innerHTML="id长度不少于6位";
			correct = false;
		}
	
	if(isbn==""){
		msg.innerHTML="ISBN不能为空";
		correct = false;
	}else if(!reg.test(isbn)){
		msg.innerHTML="ISBN格式不正确";
		correct = false;
	}
	
	if(number==""){
		msg.innerHTML="数量不能为空";
		correct = false;
	}else if(number==0){
		msg.innerHTML="数量不能为0";
		correct = false;
	}
	return correct;
}
