
// <!-- Click event for password js --> 

$(document).ready(function(){
	$(".pass").click(function(){
		$(".pass-small").html("Mixing of Alphabates, numbers, special charecters with upper and lowercase provides a better security.");
		$(".pass-small").css({"background-color":"#ffe0b2", "color":"black"});	
	});
});

$(document).ready(function(){
	$(".pass").keyup(function(e){
		let key = e.keyCode;
		if(key==9)
		{
			$(".pass-small").html("Mixing of Alphabates, numbers, special charecters with upper and lowercase provides a better security.");
			$(".pass-small").css({"background-color":"#ffe0b2", "color":"black"});	
		}
	});
});


// <!-- end of Click event for password js --> 



// <!-- login js -->

function check()
{
	let type = document.getElementById("Password-input");
	
	if(type.type === "password")
	{
		type.type = "text";
	}
	else
	{
		type.type = "password"
	}
}

// <!-- end of login js -->



// <!-- Register js -->

function validation()
{
	let email_val = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	
	let name_val = /^[0-9]+$/;
	
	let mobile_val = /^\(?([0-9]{3})\)?[-]?([0-9]{3})[-]?([0-9]{4})$/;
	
	let name, email, password, conf_pass, mobile, check;
	
	let sname, semail, spassword, sconf_pass, smobile, scheck;
	
	let submit=false;
	
	name = $("#name_input").val()
	{
		if(name == "" || name == undefined || name.charAt(0) == " ")
		{
			$("#name-small").html("Please Enter Valid Name");
			$("#name-small").addClass("text-danger");
			sname = false;
		}
		else if(name_val.test(name) == true)
		{
			$("#name-small").html("Please Enter Valid Name");
			$("#name-small").addClass("text-danger");
			sname = false;	
		}
		else
		{ 
			$("#name-small").html("Valid Name");
			$("#name-small").removeClass("text-danger");
			$("#name-small").addClass("text-success");
			sname = true;
		}
	}
	
	
	email = $("#email-input").val()
	{
		if(email == "" || email == undefined || email.charAt(0) == " ")
		{
			$("#email-small").html("Please Enter Valid Email");
			$("#email-small").addClass("text-danger");
			semail = false;
		}
		else if (email_val.test(email) == false)
		{
			$("#email-small").html("Please Enter Valid Email");
			$("#email-small").addClass("text-danger");
			semail = false;	
		}
		else
		{
			$("#email-small").html("Valid email");
			$("#email-small").removeClass("text-danger");
			$("#email-small").addClass("text-success");
			semail = true;
		}	
	}
		
	password = $("#password-input").val()
	{
		if(password == "" || password == undefined || password.charAt(0) == " ")
		{
			$("#password-small").html("Please Enter Valid Password");
			$("#password-small").addClass("text-danger");
			spassword = false;
		}
		else if(password.length<8)
		{
			$("#password-small").html("Please Enter Valid Password");
			$("#password-small").addClass("text-danger");
			spassword = false;
		}
		else
		{
			$("#password-small").html("Password Accepted");
			$("#password-small").removeClass("text-danger");
			$("#password-small").addClass("text-success");
			spassword = true;
		}
	}
	
	conf_pass = $("#conf_password_input").val()
	{
		if(conf_pass == password)
		{
			$("#confirm_password-small").html("Password Matched");
			$("#confirm_password-small").removeClass("text-danger");
			$("#confirm_password-small").addClass("text-success");
			sconf_pass = true;
		}
		else
		{
			$("#confirm_password-small").html("Password is Not Matching");
			$("#confirm_password-small").removeClass("text-success");
			$("#confirm_password-small").addClass("text-danger");
			sconf_pass = false;
		}
	}
	
	mobile = $("#mobilel_input").val()
	{
		if(mobile.charAt(0) == " ")
		{
			$("#mobile-small").html("Please Enter Valid Mobile Number");
			$("#mobile-small").addClass("text-danger");
			smobile = false;
		}
		else if(mobile_val.test(mobile) == false)
		{
			$("#mobile-small").html("Please Enter Valid Mobile Number");
			$("#mobile-small").addClass("text-danger");
			smobile = false;
		}
		else
		{
			$("#mobile-small").html("Valid Mobile Number");
			$("#mobile-small").removeClass("text-danger");
			$("#mobile-small").addClass("text-success");
			smobile = true;
		}
	}	
	
	if(sname == true && semail == true && spassword == true && sconf_pass == true && smobile == true)
	{
		return submit = true;
	}
	else
	{
		return submit = false;
	}
}

function add_cart(id, name, price)
{
	let cart = localStorage.getItem("cart");
	if(cart == null)
	{
		let products = [];
		let product = {proid: id, proname: name, proprice: price, proquentity:1};
		products.push(product);
		localStorage.setItem("cart", JSON.stringify(products));
		console.log("First Product added");
	}
	
		else
		{
			let product = {proid:id, proname:name, proprice:price, proquentity:1};
			localStorage.setItem("cart", JSON.stringify(product));
			console.log("Product added");
		}
	}

function add_cart()
{
	let newcart = localStorage.getItem("cart");
	let cart = JSON.parse(newcart);
	if(cart == null || cart.length == 0)
	{
		$(".cart-count").html("&nbsp<small>( 0 )</small>");
		$(".cart-body").html("<h5>Cart is empty. Fill Me</h5>");
		$(".cart-checkout").addClass('disabled');
	}
	else
	{
		$(".cart-count").html("( ${cart.length} )");
	}
}


$(document).ready(function(){
	add_cart()
})

//<!-- end of Register js -->

function abc(ref)
{
	$(ref).addClass('active').siblings().removeClass('active');
}
