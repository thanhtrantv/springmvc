// alternative to DOMContentLoaded event
document.onreadystatechange = function () {
    if (document.readyState === "complete") {
        loadData();
    }
}
function loadData(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var jsondata=JSON.parse(this.response);
            var tableUI=document.getElementById("list-student")
            for(var i=0;i<jsondata.length;i++){
                var student=jsondata[i];
                var trElement=document.createElement("tr");
                var td1=document.createElement("td");
                var urlDetail=document.createElement("a");
                urlDetail.setAttribute("href","student-detail.jsp?idStudent="+student.id);
                urlDetail.text=student.id+"";
                td1.appendChild(urlDetail);
                var td2=document.createElement("td");
                td2.innerHTML=student.name+"";
                var td3=document.createElement("td");
                td3.innerHTML=student.mark+"";
                var td4=document.createElement("td");
                td4.innerHTML=student.className+"";
                trElement.appendChild(td1);
                trElement.appendChild(td2);
                trElement.appendChild(td3);
                trElement.appendChild(td4);
                tableUI.appendChild(trElement);
            }
            document.getElementsByClassName('loading-bar')[0].style="display:none";
        }
    };
    xhttp.open("GET", "get-students", true);
    xhttp.send();
}