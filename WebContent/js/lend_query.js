/**
 * 
 */
function check(){
	document.getElementById("msg").innerHTML="";
	var bookname = document.getElementById("id").value;
	if(bookname==null||bookname.length==""){
		document.getElementById("msg").innerHTML="不能输入为空";
		return false;
	}
		
	return true;
}