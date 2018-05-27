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
			<div class="pull-right">
				<a class="thumbnail pull-left" href="cart" style="padding-right: 15px;">
					<img class="media-object" src="images/cart.png" style="width: 40px; height: 40px;">
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</div>
			
          </button>
        </div>
      </div>
    </header>
	<main>
		<div class="container">
			<div style="margin:10px 0;">
				<nav class="breadcrumb">
				  <a class="breadcrumb-item" href="home">Home</a>
				  <a class="breadcrumb-item" href="#">Phone</a>
				 <span class="breadcrumb-item active">SamSung</span>
				</nav>
			</div>
        	<div class="row">
               <div class="col-md-5 item-photo">
                    <img style="max-width:100%;" src="${product.image}" />
                </div>
                <div class="col-md-7" style="border:0px solid gray">
                    <!-- info -->
                    <h3>${product.title}</h3>
                    <h5 style="color:#337ab7">Brand: <a href="#">Samsung</a> · <small style="color:#337ab7">(5054 votes)</small></h5>
        
                    <!-- price -->
                    <h6 class="title-price"><small>Price</small></h6>
                    <h3 style="margin-top:0px;">${product.price}$</h3>
        
                    <!-- product detail choice -->
                    <div class="section">
                        <h6 class="title-attr" style="margin-top:15px;" ><small>COLOR</small></h6>                    
                        <div>
                            <div class="attr" style="width:25px;background:#5a5a5a;"></div>
                            <div class="attr" style="width:25px;background:white;"></div>
                        </div>
                    </div>
                    <div class="section" style="padding-bottom:5px;">
                        <h6 class="title-attr"><small>Memory</small></h6>                    
                        <div>
                            <div class="attr2">16 GB</div>
                            <div class="attr2">32 GB</div>
                        </div>
                    </div>   
                    <div class="section" style="padding-bottom:20px;">
                        <h6 class="title-attr"><small>Quantity</small></h6>                    
                        <div>
                            <div class="btn-minus"><span class="glyphicon glyphicon-minus"></span></div>
                            <input value="1" />
                            <div class="btn-plus"><span class="glyphicon glyphicon-plus"></span></div>
                        </div>
                    </div>                
        
                    <!-- add to cart -->
                    <div class="section" style="padding-bottom:20px;">
                        <button class="btn btn-success">
							<span style="margin-right:20px" class="glyphicon glyphicon-shopping-cart" aria-hidden="true">
							</span> 
							Add to cart
						</button>
                    </div>                                        
                </div>                              
        
                <div class="col-xs-9">
                    <ul class="menu-items">
                        <li class="active">Product Detail</li>
                        <li>Guarantee</li>
                        <li>Buyer</li>
                        <li>Comments</li>
                    </ul>
                    <div style="width:100%;border-top:1px solid silver">
                        <p style="padding:15px;">
                            <small>
                            ${product.description}</small>
                        </p>
                        <small>
                            <ul>
                                <li>Super AMOLED capacitive touchscreen display with 16M colors</li>
                                <li>Available on GSM, AT T, T-Mobile and other carriers</li>
                                <li>Compatible with GSM 850 / 900 / 1800; HSDPA 850 / 1900 / 2100 LTE; 700 MHz Class 17 / 1700 / 2100 networks</li>
                                <li>MicroUSB and USB connectivity</li>
                                <li>Interfaces with Wi-Fi 802.11 a/b/g/n/ac, dual band and Bluetooth</li>
                                <li>Wi-Fi hotspot to keep other devices online when a connection is not available</li>
                                <li>SMS, MMS, email, Push Mail, IM and RSS messaging</li>
                                <li>Front-facing camera features autofocus, an LED flash, dual video call capability and a sharp 4128 x 3096 pixel picture</li>
                                <li>Features 16 GB memory and 2 GB RAM</li>
                                <li>Upgradeable Jelly Bean v4.2.2 to Jelly Bean v4.3 Android OS</li>
                                <li>17 hours of talk time, 350 hours standby time on one charge</li>
                                <li>Available in white or black</li>
                                <li>Model I337</li>
                                <li>Package includes phone, charger, battery and user manual</li>
                                <li>Phone is 5.38 inches high x 2.75 inches wide x 0.13 inches deep and weighs a mere 4.59 oz </li>
                            </ul>  
                        </small>
                    </div>
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
	<script src="javascript/home.js">  </script>
</body>
</html> 
