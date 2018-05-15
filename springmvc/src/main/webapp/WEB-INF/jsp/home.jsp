<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/home.css"/>
	 <link rel="stylesheet" href="styles/bootstrap.min.css"/>
</head>
<body>
	<header>
      <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
          <div class="row">
            <div class="col-sm-8 col-md-7 py-4">
              <h4 class="text-white">About</h4>
              <p class="text-muted">Add some information.</p>
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
          <a href="#" class="navbar-brand d-flex align-items-center">
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
											  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
											  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
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
	<section id="footer">
		<div class="container">
			<p>Copyright Msita.</p>
		</div>
	</section>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="javascript/jquery-3.3.1.min.js">  </script>
	<script src="javascript/bootstrap.min.js">  </script>
	<script src="javascript/home.js">  </script>
</body>
</html>
