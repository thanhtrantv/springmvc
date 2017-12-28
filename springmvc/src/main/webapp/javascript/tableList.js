// alternative to DOMContentLoaded event
document.onreadystatechange = function () {
    if (document.readyState === "complete") {
        getTable();
    }
}
function getTable(){
	
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        	loadData(JSON.parse(this.response));
        }
    }
    xhttp.open("GET", "tableList/getTables", true);
    xhttp.send();
}

function loadData(data){
	for(var i=0;i<data.length;i++){
		console.log(data[i])
		var table = document.getElementById('load-table-content');
		
		var item= document.getElementById('item-templeted').cloneNode(true);;
		item.style.display = 'inline-block'
		
		item.getElementsByClassName("name-table")[0]
		.innerHTML = "Table "+data[i].idTable;	
		
		table.appendChild(item);		
	}
}