function addStudent(){
    document.getElementsByClassName('loading-bar')[0].style="display:block";
    var name=document.getElementById('student-name').value;
    var classname=document.getElementById('class-name').value;
    var mark=document.getElementById('mark').value;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "add-student?name="+name
                                    +"&className="+classname
                                    +"&mark="+mark, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            alert(this.response)
            document.getElementsByClassName('loading-bar')[0].style="display:none";
        }
    };
}