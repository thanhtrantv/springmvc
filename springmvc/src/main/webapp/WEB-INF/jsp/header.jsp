<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>
<header>
    <div class="collapse bg-dark" id="navbarHeader">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-md-7 py-4">
                    <h4 class="text-white">About</h4>
                    <p style="color:white;">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
                </div>
                <div class="col-sm-4 offset-md-1 py-4">
                    <h4 class="text-white">Contact</h4>
                    <ul class="list-unstyled">
                        <li><a href="#" class="text-white">Follow on Twitter</a></li>
                        <li><a href="#" class="text-white">Like on Facebook</a></li>
                        <c:if test = "${user==null}">
                            <li><a href="login" class="text-white">Login</a></li>
                        </c:if>
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
                <c:if test = "${user!=null}">
                    <div style="float: left; color: white;padding-top: 10px;">
                        Welcome ${user.fullname}
                        <a class="thumbnail pull-right" href="logout" style="padding-right: 15px;">Logout</a>
                    </div>
                </c:if>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
        </div>
    </div>
</header>