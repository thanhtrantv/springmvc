<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/home.css"/>
	 <link rel="stylesheet" href="styles/bootstrap.min.css"/>
</head>
<body>
    <jsp:include page="header.jsp" />
	<main>
		<div class="container-fluid" style="padding:0;">
			<section id="slideshow" class="container">
				<div class="row">
					<div class="slideshow-container">
						<div class="mySlides ">
							<div class="numbertext">1 / 3</div>
							<img src="images/s1.jpg" style="width:100%">
							<div class="text">Caption Text</div>
						</div>
						<div class="mySlides ">
							<div class="numbertext">2 / 3</div>
							<img src="images/s2.jpg" style="width:100%">
							<div class="text">Caption Two</div>
						</div>
						<div class="mySlides  ">
							<div class="numbertext">3 / 3</div>
							<img src="images/s3.jpg" style="width:100%">
							<div class="text">Caption Three</div>
						</div>
					</div>
				</div>
				<br>
				<div style="text-align:center">
					<span class="dot" ></span>
					<span class="dot" ></span>
					<span class="dot" ></span>
				</div>
			</section>
			<section id="listProduct" class="bg-light">
				<div class="container">
				  <div class="row">
					  <c:forEach items="${listProduct}" var="item">
						  <div class="col-md-4">
							  <div class="card mb-4 box-shadow">
								  <img class="card-img-top" src="${item.image}" alt="Card image cap">
								  <div class="card-body">
									  <p class="card-text">${item.description}</p>
									  <div class="d-flex justify-content-between align-items-center">
										  <div class="btn-group">
											  <a class="btn btn-sm btn-outline-secondary" href="productDetail?id=${item.productId}">View</a>
											  </div>
									  </div>
								  </div>
							  </div>
						  </div>
					  </c:forEach>
				  </div>
				</div>
			</section>

		</div>
	</main>
    <jsp:include page="footer.jsp" />
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="javascript/jquery-3.3.1.min.js">  </script>
	<script src="javascript/bootstrap.min.js">  </script>
	<script src="javascript/home.js">  </script>
</body>
</html>
