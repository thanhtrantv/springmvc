// alternative to DOMContentLoaded event
document.onreadystatechange = function() {
	if (document.readyState === "complete") {
		getTable();
		getItem();
	}
}
function getTable() {

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			loadData(JSON.parse(this.response));
		}
	}
	xhttp.open("GET", "tableList/getTables", true);
	xhttp.send();
}
var dataTable;
function loadData(data) {
	dataTable=data;
	for (var i = 0; i < data.length; i++) {
		console.log(data[i])
		var orderData = data[i].orderNotPay;
		var table = document.getElementById('load-table-content');

		var items = document.getElementById('item-templeted').cloneNode(true);
		items.id = 'table-' + data[i].idTable;
		items.style.display = 'inline-block'

		// name id table and status
		items.getElementsByClassName("name-table")[0].innerHTML = "Table "
				+ data[i].idTable;
		items.getElementsByClassName('status-table')[0].innerHTML = data[i].status;

		// add item to order
		items.getElementsByClassName('add-item')[0].id = data[i].idTable;
		items.getElementsByClassName('export-bill')[0].id = data[i].idTable;
		items.getElementsByClassName('add-item')[0].onclick = function() {
			document.getElementById('id01').style.display = 'block';
			document.getElementById('id01').getElementsByClassName('id-table')[0].innerHTML = 'Table : '
					+ this.id;
			document.getElementById('table-id-hidden').value= this.id;
		};
		
		items.getElementsByClassName('export-bill')[0].onclick = function() {
			document.getElementById('id02').style.display = 'block';
			document.getElementById('id02').getElementsByClassName('id-table')[0].innerHTML =''+ this.id;
			generateBill(this.id)
		};

		if (orderData != null) {
			items.getElementsByClassName('order-id')[0].innerHTML = 'Order ID: '+orderData.idOrder;

			items.getElementsByClassName('sum')[0].innerHTML = "Sum: "
					+ orderData.sum + "k";
			var tableOrderItem = items.getElementsByClassName('itemList')[0];
			for (var j = 0; j < orderData.lstOrderItem.length; j++) {
				var item = orderData.lstOrderItem[j];
				var itemElement = document.createElement("tr");

				var itemElement1 = document.createElement("td");
				itemElement1.innerHTML = item.item.name;

				var itemElement2 = document.createElement("td");
				itemElement2.innerHTML = item.item.price;
				
				 var itemElement3 = document.createElement("td");
				 itemElement3.innerHTML=item.quantity;
				 
				var itemElement4 = document.createElement("td");
				itemElement4.innerHTML = item.status.name;

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

function generateBill(id){
	
	var orderData= null;
	
	for (var i = 0; i < dataTable.length; i++) {
		
		if(id==dataTable[i].idTable){
			
			orderData = dataTable[i].orderNotPay;
			document.getElementsByClassName('order-id-hidden')[0].value=orderData.idOrder;
			var gridItem = document.getElementById('grid-item-bill');
			var gridItemRemove=document.getElementsByClassName("my-elements");
			var lengthArr=gridItemRemove.length;
			if(gridItemRemove!=null && gridItemRemove.length>0){
				for(var o=0;o<gridItemRemove.length;o++){
					gridItem.removeChild(gridItemRemove[0]);
				}
			}
				
				
			//set id order
			var billElement=document.getElementById('id02');
			billElement.getElementsByClassName('order-text')[0].innerHTML=orderData.idOrder;	
			billElement.getElementsByClassName('table-text')[0].innerHTML=dataTable[i].idTable;
			billElement.getElementsByClassName('user-text')[0].innerHTML=orderData.user.name;
			
			for (var j = 0; j < orderData.lstOrderItem.length; j++) {
				var itemData = orderData.lstOrderItem[j];
				var itemTemplate = document.getElementById('row-item-template-bill')
						.cloneNode(true);
				itemTemplate.style.display = 'inline-block';

				itemTemplate.id = itemData.key.idItem+'-item-bill';

				itemTemplate.getElementsByClassName('col1')[0].innerHTML = itemData.item.name;
				itemTemplate.getElementsByClassName('col2')[0].innerHTML = itemData.quantity;
				itemTemplate.getElementsByClassName('col3')[0].innerHTML = itemData.item.price+'k';
				itemTemplate.classList.add("my-elements");
				gridItem.appendChild(itemTemplate);
			}
			billElement.getElementsByClassName('sum')[0].innerHTML = "Sum: "
				+ orderData.sum + "k";
		}
		
	}
	
}
function getItem() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			generateItems(JSON.parse(this.response));
		}
	}
	xhttp.open("GET", "tableList/getItems", true);
	xhttp.send();
}
function generateItems(itemss) {
	var gridItem = document.getElementById('grid-item');
	for (var k = 0; k < itemss.length; k++) {
		console.log(itemss[k])
		var itemData = itemss[k];

		var items = document.getElementById('grid-item');
		var itemTemplate = document.getElementById('row-item-template')
				.cloneNode(true);
		itemTemplate.style.display = 'inline-block';

		itemTemplate.id = itemData.idItem;

		itemTemplate.getElementsByClassName('col1')[0].innerHTML = itemData.name;
		itemTemplate.getElementsByClassName('col2')[0].innerHTML = itemData.price
				+ 'k';
		
		itemTemplate.getElementsByClassName('checkitem')[0].value = itemData.idItem;
		gridItem.appendChild(itemTemplate);
	}

}

function saveItemSelect(){
	var gridItem = document.getElementById('grid-item');
	var lstCheckItem=gridItem.getElementsByClassName('checkitem');
	var lstItemSelect = [];
	for (var k = 0; k < lstCheckItem.length; k++) {
		var checkbox= lstCheckItem[k];
		if(checkbox.checked){
			lstItemSelect.push
		}
	}
}
