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
				Your order has been submit.
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