/**
 * 
 */
function check(){
	var msg = document.getElementById("msg");
	msg.innerHTML="";
	var readerId = document.getElementById("readerId").value;
	if(readerId==""){
		msg.innerHTML="不能输入为空";
		return false;
	}else if(readerId.length < 6){
		msg.innerHTML="长度少于6位";
		return false;
	}
		
	return true;
}