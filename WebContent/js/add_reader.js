/**
 * 
 */
function check(){
	var correct = true;
	var name = document.getElementById("name").value;
	var spec = document.getElementById("spec").value;
	var msg = document.getElementById("msg");
	if(name==""){
		msg.innerHTML="姓名不能为空";
		correct = false;
	}
	return correct;
}