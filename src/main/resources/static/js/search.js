//MULTI SLIDER ==============================================================
//year ======================================================================
var yearInputLeft = document.getElementById("year-input-left");
var yearInputRight = document.getElementById("year-input-right");
var yearLeft = document.getElementById("year_left");
var yearRight = document.getElementById("year_right");

var yearThumbLeft = document.querySelector(".slider.year>.thumb.left");
var yearThumbRight = document.querySelector(".slider.year>.thumb.right");
var yearRange = document.querySelector(".slider.year>.range");


function setLeftValue_year() {
    var _this = yearInputLeft,
        min = parseInt(_this.min),
        max = parseInt(_this.max);

    _this.value = Math.min(parseInt(_this.value), parseInt(yearInputRight.value)-1);

    var percent = ((_this.value - min) / (max - min))*100;

    // thumbLeft.style.left = percent + "%";
    // range.style.left = percent + "%";

    yearThumbLeft.style.left = (percent+((-3)*percent/(max-min))+1) + "%";
    yearRange.style.left = (percent+((-3)*percent/(max-min))+1) + "%";
    yearLeft.style.left = (percent+((-3)*percent/(max-min))) + "%";
}
setLeftValue_year();


function setRightValue_year() {
    var _this = yearInputRight,
        min = parseInt(_this.min),
        max = parseInt(_this.max);

    _this.value = Math.max(parseInt(_this.value), parseInt(yearInputLeft.value)+1);

    var percent = ((_this.value - min) / (max - min))*100;

    yearThumbRight.style.right = (((100 - percent)+((-3)*(100 - percent)/(max-min))+1)) + "%";
    yearRange.style.right = (((100 - percent)+((-3)*(100 - percent)/(max-min))+1)) + "%";
    yearRight.style.right =  (((100 - percent)+((-3)*(100 - percent)/(max-min))+1)) + "%";
}
setRightValue_year();


yearInputLeft.addEventListener("input", setLeftValue_year);
yearInputRight.addEventListener("input", setRightValue_year);



yearInputLeft.addEventListener("mouseover", function() {
    yearThumbLeft.classList.add("hover");
});
yearInputLeft.addEventListener("mouseout", function() {
    yearThumbLeft.classList.remove("hover");
});
yearInputLeft.addEventListener("mousedown", function() {
    yearThumbLeft.classList.add("active");
});
yearInputLeft.addEventListener("mouseup", function() {
    yearThumbLeft.classList.remove("active");
});



yearInputRight.addEventListener("mouseover", function() {
    yearThumbRight.classList.add("hover");
});
yearInputRight.addEventListener("mouseout", function() {
    yearThumbRight.classList.remove("hover");
});
yearInputRight.addEventListener("mousedown", function() {
    yearThumbRight.classList.add("active");
});
yearInputRight.addEventListener("mouseup", function() {
    yearThumbRight.classList.remove("active");
});


//rate ======================================================================
var rateInputLeft = document.getElementById("rate-input-left");
var rateInputRight = document.getElementById("rate-input-right");
var rateLeft = document.getElementById("rate_left");
var rateRight = document.getElementById("rate_right");

var rateThumbLeft = document.querySelector(".slider.rate>.thumb.left");
var rateThumbRight = document.querySelector(".slider.rate>.thumb.right");
var rateRange = document.querySelector(".slider.rate>.range");


function setLeftValue_rate() {
    var _this = rateInputLeft,
        min = parseInt(_this.min),
        max = parseInt(_this.max);

    _this.value = Math.min(parseInt(_this.value), parseInt(rateInputRight.value)-0.1);

    var percent = ((_this.value - min) / (max - min))*100;

    // rateThumbLeft.style.left = percent + "%";
    // rateRange.style.left = percent + "%";

    rateThumbLeft.style.left = (percent+((-0.1)*percent/(max-min))+0.1) + "%";
    rateRange.style.left = (percent+((-0.1)*percent/(max-min))+0.1) + "%";
    rateLeft.style.left = (percent+((-0.1)*percent/(max-min))) + "%";
}
setLeftValue_rate();


function setRightValue_rate() {
    var _this = rateInputRight,
        min = parseInt(_this.min),
        max = parseInt(_this.max);

    _this.value = Math.max(parseInt(_this.value), parseInt(rateInputLeft.value)+0.1);

    var percent = ((_this.value - min) / (max - min))*100;

    // rateThumbRight.style.right = percent + "%";
    // rateRange.style.right = percent + "%";


    rateThumbRight.style.right = (((100 - percent)+((-0.1)*(100 - percent)/(max-min))+0.1)) + "%";
    rateRange.style.right = (((100 - percent)+((-0.1)*(100 - percent)/(max-min))+0.1)) + "%";
    rateRight.style.right =  (((100 - percent)+((-0.1)*(100 - percent)/(max-min))+0.1)) + "%";
}
setRightValue_rate();


rateInputLeft.addEventListener("input", setLeftValue_rate);
rateInputRight.addEventListener("input", setRightValue_rate);



rateInputLeft.addEventListener("mouseover", function() {
    rateThumbLeft.classList.add("hover");
});
rateInputLeft.addEventListener("mouseout", function() {
    rateThumbLeft.classList.remove("hover");
});
rateInputLeft.addEventListener("mousedown", function() {
    rateThumbLeft.classList.add("active");
});
rateInputLeft.addEventListener("mouseup", function() {
    rateThumbLeft.classList.remove("active");
});



rateInputRight.addEventListener("mouseover", function() {
    rateThumbRight.classList.add("hover");
});
rateInputRight.addEventListener("mouseout", function() {
    rateThumbRight.classList.remove("hover");
});
rateInputRight.addEventListener("mousedown", function() {
    rateThumbRight.classList.add("active");
});
rateInputRight.addEventListener("mouseup", function() {
    rateThumbRight.classList.remove("active");
});

//rate_number ======================================================================
var rate_numberInputLeft = document.getElementById("rate_number-input-left");
var rate_numberInputRight = document.getElementById("rate_number-input-right");
var rate_numberLeft = document.getElementById("rate_number_left");
var rate_numberRight = document.getElementById("rate_number_right");

var rate_numberThumbLeft = document.querySelector(".slider.rate_number>.thumb.left");
var rate_numberThumbRight = document.querySelector(".slider.rate_number>.thumb.right");
var rate_numberRange = document.querySelector(".slider.rate_number>.range");


function setLeftValue_rate_number() {
    var _this = rate_numberInputLeft,
        min = parseInt(_this.min),
        max = parseInt(_this.max);

    _this.value = Math.min(parseInt(_this.value), parseInt(rate_numberInputRight.value)-1);

    var percent = ((_this.value - min) / (max - min))*100;

    // thumbLeft.style.left = percent + "%";
    // range.style.left = percent + "%";

    rate_numberThumbLeft.style.left = (percent+((-3)*percent/(max-min))+1) + "%";
    rate_numberRange.style.left = (percent+((-3)*percent/(max-min))+1) + "%";
    rate_numberLeft.style.left = (percent+((-3)*percent/(max-min))) + "%";
}
setLeftValue_rate_number();


function setRightValue_rate_number() {
    var _this = rate_numberInputRight,
        min = parseInt(_this.min),
        max = parseInt(_this.max);

    _this.value = Math.max(parseInt(_this.value), parseInt(rate_numberInputLeft.value)+1);

    var percent = ((_this.value - min) / (max - min))*100;

    rate_numberThumbRight.style.right = (((100 - percent)+((-3)*(100 - percent)/(max-min))+1)) + "%";
    rate_numberRange.style.right = (((100 - percent)+((-3)*(100 - percent)/(max-min))+1)) + "%";
    rate_numberRight.style.right =  (((100 - percent)+((-3)*(100 - percent)/(max-min))+1)) + "%";
}
setRightValue_rate_number();


rate_numberInputLeft.addEventListener("input", setLeftValue_rate_number);
rate_numberInputRight.addEventListener("input", setRightValue_rate_number);



rate_numberInputLeft.addEventListener("mouseover", function() {
    rate_numberThumbLeft.classList.add("hover");
});
rate_numberInputLeft.addEventListener("mouseout", function() {
    rate_numberThumbLeft.classList.remove("hover");
});
rate_numberInputLeft.addEventListener("mousedown", function() {
    rate_numberThumbLeft.classList.add("active");
});
rate_numberInputLeft.addEventListener("mouseup", function() {
    rate_numberThumbLeft.classList.remove("active");
});



rate_numberInputRight.addEventListener("mouseover", function() {
    rate_numberThumbRight.classList.add("hover");
});
rate_numberInputRight.addEventListener("mouseout", function() {
    rate_numberThumbRight.classList.remove("hover");
});
rate_numberInputRight.addEventListener("mousedown", function() {
    rate_numberThumbRight.classList.add("active");
});
rate_numberInputRight.addEventListener("mouseup", function() {
    rate_numberThumbRight.classList.remove("active");
});



