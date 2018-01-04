<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Table List</title>
		<link rel="stylesheet" type="text/css" href="styles/tableList.css">
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
						<img src="img/logo-burst.png" alt="logo platz" height="38"
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
					<label>Driking</label>
				</div>
			</div>
			<div class="item-content">
				<div class="time">In: 17:50</div>
				<div class="table-content">
					<h5>Table Item</h5>
					<table id="itemList" class="itemList">
						<thead>
							<tr>
								<th>Order</th>
								<th>Item Name</th>
								<th>Price</th>
								<th>Status</th>
								<th>Delete</th>
							</tr>
						</thead>
						
					</table>
					<div class="sum">Sum: 32k</div>
				</div>
				<div class="button-table">
					<button>Export Bill</button>
					<button>Add Item</button>
				</div>
			</div>
		</div>
	</body>
</html>