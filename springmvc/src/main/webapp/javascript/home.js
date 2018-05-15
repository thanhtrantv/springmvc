var slideIndex = 0;
    showSlides();

    function showSlides() {
        var i;
        var slides = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("dot");
        //hide all slide
		for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
		//go to next image
        slideIndex++;
		//if greater than max image. go to first 
        if (slideIndex > slides.length) {
            slideIndex = 1
        }
		//remove active class on dot button
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
		//show slide
        slides[slideIndex - 1].style.display = "block";
		//active dot
        dots[slideIndex - 1].className += " active";
        setTimeout(showSlides, 2000); // Change image every 2 seconds
    }
