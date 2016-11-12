/**
 * 
 */
function check(){
	document.getElementById("msg").innerHTML="";
	var bookname = document.getElementById("name").value;
	if(bookname==""){
		document.getElementById("msg").innerHTML="不能输入为空";
		return false;
	}
		
	return true;
}