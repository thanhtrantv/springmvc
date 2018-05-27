<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/productDetail.css"/>
	 <link rel="stylesheet" href="styles/bootstrap.min.css"/>

</head>
<body>
	<header>
      <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
          <div class="row">
            <div class="col-sm-8 col-md-7 py-4">
              <h4 class="text-white">About</h4>
              <p class="text-muted">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
            </div>
            <div class="col-sm-4 offset-md-1 py-4">
              <h4 class="text-white">Contact</h4>
              <ul class="list-unstyled">
                <li><a href="#" class="text-white">Follow on Twitter</a></li>
                <li><a href="#" class="text-white">Like on Facebook</a></li>
                <li><a href="#" class="text-white">Email me</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="home" class="navbar-brand d-flex align-items-center">
				<img src="images/money-bag.svg" style="width: 40px;  height: 40px;"/>
				<strong>Shop</strong>
			</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
      </div>
    </header>
	<main>
		<div class="container">
			<div style="margin:10px 0;">
				<nav class="breadcrumb">
				  <a class="breadcrumb-item" href="home">Home</a>
				 <span class="breadcrumb-item active">Cart</span>
				</nav>
			</div>
        	<div class="row">
				<div class="col-sm-12 col-md-12 col-md-offset-1">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Product</th>
								<th>Quantity</th>
								<th class="text-center">Price</th>
								<th class="text-center">Total</th>
								<th> Action</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="col-sm-8 col-md-6">
									<div class="media">
											<a class="thumbnail pull-left" href="#"style="padding-right: 15px;"> <img class="media-object" src="images/product-icon.png" style="width: 72px; height: 72px;"> </a>
											<div class="media-body">
												<h4 class="media-heading"><a href="#">Samsung Galaxy S4 I337 16GB</a></h4>
												<h5 class="media-heading"> by <a href="#">SamSung</a></h5>
												<span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
											</div>
									</div>
								</td>
								<td class="col-sm-1 col-md-1" style="text-align: center">
								<input type="email" class="form-control" id="exampleInputEmail1" value="3">
								</td>
								<td class="col-sm-1 col-md-1 text-center"><strong>$399</strong></td>
								<td class="col-sm-1 col-md-1 text-center"><strong>$430</strong></td>
								<td class="col-sm-1 col-md-1">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Remove
								</button></td>
							</tr>
							<tr>
								<td class="col-md-6">
								<div class="media">
									<a class="thumbnail pull-left" href="#" style="padding-right: 15px;"> <img class="media-object" src="images/product-icon.png" style="width: 72px; height: 72px;"> </a>
									<div class="media-body">
										<h4 class="media-heading"><a href="#">Iphone 7 Plus</a></h4>
										<h5 class="media-heading"> by <a href="#">Apple</a></h5>
										<span>Status: </span><span class="text-warning"><strong>Leaves warehouse in 2 - 3 weeks</strong></span>
									</div>
								</div></td>
								<td class="col-md-1" style="text-align: center">
								<input type="email" class="form-control" id="exampleInputEmail1" value="2">
								</td>
								<td class="col-md-1 text-center"><strong>$1000</strong></td>
								<td class="col-md-1 text-center"><strong>$1100</strong></td>
								<td class="col-md-1">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Remove
								</button></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td><h5>Subtotal</h5></td>
								<td class="text-right"><h5><strong>$1530</strong></h5></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td><h5>Estimated shipping</h5></td>
								<td class="text-right"><h5><strong>$20</strong></h5></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td><h3>Total</h3></td>
								<td class="text-right"><h3><strong>$1550</strong></h3></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td>
                                    <button type="button" class="btn btn-default">
                                        <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                                    </button>
                                </td>
								<td>
                                    <button type="button" class="btn btn-success">
                                        Checkout <span class="glyphicon glyphicon-play"></span>
                                    </button>
                                </td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
        </div>
	</main>
	<footer>
		<section id="footer">
				<div class="container">
					<p>Copyright Msita.</p>
				  </div>
			</section>
	</footer>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="javascript/jquery-3.3.1.min.js">  </script>
	<script src="javascript/bootstrap.min.js">  </script>
	<script src="javascript/productDetail.js">  </script>
</body>
</html>
