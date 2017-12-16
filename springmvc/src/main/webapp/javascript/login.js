
// alternative to DOMContentLoaded event
document.onreadystatechange = function () {
    if (document.readyState === "complete") {
       
    }
}
function login(){
	var username=document.getElementById("username").value;
	var pass=document.getElementById("password").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        	alert("ok")
        }
    }
    xhttp.open("POST", "login/authenticate?username="+username+"&password="+pass, true);
    xhttp.send();
}