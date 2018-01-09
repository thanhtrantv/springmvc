<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Table List</title>
		<link rel="stylesheet" type="text/css" href="styles/tableList.css">
		<link rel="stylesheet" type="text/css" href="styles/w3.css">
		<script type="text/javascript" src="javascript/tableList.js"></script>
	</head>
	<body>
		<div class="loading-bar" style="display: none;">
			<div class="spiner"></div>
		</div>
		<div class="main-content">
			<div id="wrapper-header" style="width: 100%; opacity: 1;">
				<div id="main-header" class="object">
					<div class="logo">
						<img src="images/logo.png" alt="logo cafe msita" height="38"
							width="90">
					</div>
					<div id="main_tip_search">
						<form>
							<input type="text" name="search" id="tip_search_input"
								list="search" autocomplete="off" required="">
						</form>
					</div>
					<div id="stripes"
						style="transform: rotate(0deg) scale(1, 1); opacity: 1;"></div>
				</div>
			</div>
			<div id="wrapper-navbar" style="opacity: 1; height: 60px;">
				<div class="navbar object">
					<div id="wrapper-sorting">
						<div id="wrapper-title-1">
							<div class="top-rated object">Table List</div>
							<div id="fleche-nav-1"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="wrapper-table">
				<div class="inner-table">
					<div class="grid-container" id="load-table-content"></div>
				</div>
	
			</div>
		</div>
		<div id="item-templeted" style="display: none;">
			<div class="item-header">
				<div class="table-info-left">
					<h5 class="name-table">Table 1</h5>
				</div>
				<div class="table-status-right">
					<label class="status-table">Driking</label>
				</div>
			</div>
			<div class="item-content">
				<div class="order-id time"></div>
				<div class="table-content">
					<h5>Table Item</h5>
					<table id="itemList" class="itemList">
						<thead>
							<tr>
								<th style="width:30%;">Item Name</th>
								<th style="width:10%;">Price</th>
								<th style="width:10%;">Quantity</th>
								<th style="width:20%;">Status</th>
								<th  style="width:10%;">Delete</th>
							</tr>
						</thead>
						
					</table>
					<div class="sum"></div>
				</div>
				<div class="button-table">
					<button class="export-bill">Export Bill</button>
					<button class="add-item">Add Item</button>
				</div>
			</div>
		</div>
		  <div id="id01" class="w3-modal">
		    <div class="w3-modal-content">
		      <div class="w3-container">
		        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span>
		       	<h5>Items to select..</h5>
		       	
		       	<label class="id-table"></label>
		       	<form action="tableList/saveItem" method="post">
		       		<input type="hidden" id="table-id-hidden" name="tableId">
			       	<div id="grid-item">
			       		<div id="row-item-template" class="row-item">
					       <div class="col1 col">
					       			Coca
					       </div>
					       <div class="col2 col">
					       			10k
					       	</div>
					       	<div class="col3 col">
					       		<input type="radio" class="checkitem" name="checkitem" />
					       	</div>
				       	</div>
			       	</div>
			       	<div class="pull-right">
			       			<button type="submit">Save</button>
			       	</div>
		       	</form>
		      </div>
		    </div>
		  </div>
		<div id="id02" class="w3-modal show">
		    <div class="w3-modal-content">
		      <div class="w3-container" style="padding-bottom: 20px;">
		        <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-display-topright">&times;</span>
		       	<h5 style=" text-align: center;background-color: #4de06699;color: #0c0c0c;">Bill for table :<strong class="id-table"></strong></h5>
		       	
		       	<form action="tableList/paid" method="post">
		       		<input type="hidden" class ="order-id-hidden" name="idOrder">
		       		<div class="form-item">
		       			Order Id : <strong class="order-text">001</strong>
		       		</div>
		       		<div class="form-item">
		       			Table Id : <strong class="table-text">1</strong>
		       		</div>
		       		<div class="form-item">
		       			User : <strong class="user-text">user1</strong>
		       		</div>
		       		<div class="form-item">
		       			Status : <strong class="status-text">Drink</strong>
		       		</div>
		       		<h5>Items</h5>
			       	<div id="grid-item-bill">
			       		
			       	</div>
			       	<div id="row-item-template-bill" class="row-item " style="display:none;">
					       <div class="col1 col">
					       			Coca
					       </div>
					       <div class="col2 col">
					       			1
					       	</div>
					       	 <div class="col3 col">
					       			10k
					       	</div>
				       	</div>
			       	<div class="sum"></div>
			       	<div class="pull-right">
			       			<button type="submit">Paid</button>
			       	</div>
		       	</form>
		      </div>
		    </div>
		  </div>
	</body>
</html>