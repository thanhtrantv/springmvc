// alternative to DOMContentLoaded event
document.onreadystatechange = function () {
    if (document.readyState === "complete") {
        loadData();
    }
}
function loadData(){
    var id=document.getElementsByClassName('id-student')[0].innerHTML;
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "student-detail?idStudent="+id, true);
    xhttp.send();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var jsondata=JSON.parse(this.response);
            document.getElementsByClassName("id-student")[0].innerHTML=jsondata.id;
            document.getElementsByClassName("mark-student")[0].innerHTML=jsondata.mark;
            document.getElementsByClassName("class-student")[0].innerHTML=jsondata.className;
            document.getElementsByClassName("name-student")[0].innerHTML=jsondata.name;
            document.getElementsByClassName("content-detail")[0].style="display:block";
            document.getElementsByClassName('loading-bar')[0].style="display:none";
        }
    };
}