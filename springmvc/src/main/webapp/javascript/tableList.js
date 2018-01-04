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
		var orderData=data[i].orderNotPay;
		var table = document.getElementById('load-table-content');
		var items =null;
		var items= document.getElementById('item-templeted').cloneNode(true);;
		items.style.display = 'inline-block'
		
		items.getElementsByClassName("name-table")[0]
		.innerHTML = "Table "+data[i].idTable;	
		
		if(orderData!=null){
			var tableOrderItem = items.getElementsByClassName('itemList')[0];
			for(var j=0;j<orderData.lstOrderItem.length;j++){
				var item=orderData.lstOrderItem[j];
				var itemElement = document.createElement("tr");
				
				var itemElement1 = document.createElement("td");
				itemElement1.innerHTML=orderData.idOrder;
				
				var itemElement2 = document.createElement("td");
				itemElement2.innerHTML=item.item.name;
				
				var itemElement3 = document.createElement("td");
				itemElement3.innerHTML=item.item.price;
				
				var itemElement4 = document.createElement("td");
				var itemElement5 = document.createElement("td");
				
				itemElement.appendChild(itemElement1);
				itemElement.appendChild(itemElement2);
				itemElement.appendChild(itemElement3);
				itemElement.appendChild(itemElement4);
				itemElement.appendChild(itemElement5);
				
				tableOrderItem.appendChild(itemElement);
			}
		}
		table.appendChild(items);	
	}
}
