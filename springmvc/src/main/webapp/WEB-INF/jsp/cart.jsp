<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/productDetail.css"/>
	 <link rel="stylesheet" href="styles/bootstrap.min.css"/>

</head>
<body>
	<jsp:include page="header.jsp" />
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
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
						<c:set var="total" value="${0}"/>
							<c:forEach items="${cart}" var="item">
								<c:set var="total" value="${total + (item.price*item.quantity)}" />
								<tr>
									<td class="col-sm-8 col-md-6">
										<div class="media">
											<a class="thumbnail pull-left" href="#"style="padding-right: 15px;">
												<img class="media-object" src="${item.image}" style="width: 72px; height: 72px;"> </a>
											<div class="media-body">
												<h4 class="media-heading"><a href="#">${item.title}</a></h4>
												<h5 class="media-heading"> by ${item.brand}</h5>
												<span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
											</div>
										</div>
									</td>
									<td class="col-sm-1 col-md-1" style="text-align: center">
										<input type="email" class="form-control" disabled id="quantity-${item.productId}" value="${item.quantity}">
									</td>
									<td class="col-sm-1 col-md-1 text-center"><strong>${item.price}</strong></td>
									<td class="col-sm-1 col-md-1 text-center"><strong>${item.price*item.quantity}</strong></td>
									<td class="col-sm-1 col-md-1">
                                        <form action="cart/removeProduct?id=${item.productId}" method="post">
                                            <button type="submit" class="btn btn-danger">
                                                <span class="glyphicon glyphicon-remove"></span> Remove
                                            </button>
                                        </form>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td><h3>Total</h3></td>
								<td class="text-right"><h3><strong>$${total}</strong></h3></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td>
                                    <a href="home" class="btn btn-default">
                                        <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                                    </a>
                                </td>
								<td>
                                    <a href="cart/checkout"  class="btn btn-success">
                                        Checkout <span class="glyphicon glyphicon-play"></span>
                                    </a>
                                </td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-12">
					<label for="fname">First Name</label>
					<input type="text" id="fname" name="firstname" placeholder="Your name..">

					<label for="lname">Last Name</label>
					<input type="text" id="lname" name="lastname" placeholder="Your last name..">

				</div>
			</div>
        </div>
	</main>
	<jsp:include page="footer.jsp" />
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="javascript/jquery-3.3.1.min.js">  </script>
	<script src="javascript/bootstrap.min.js">  </script>
	<script src="javascript/productDetail.js">  </script>
</body>
</html>
