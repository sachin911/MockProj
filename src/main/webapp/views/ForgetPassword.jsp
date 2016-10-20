<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot password</title>

<link rel='stylesheet prefetch'
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<style>
body {
	background: #98AFC7;
	color: #3090C7;
	font-family: 'RobotoDraft', 'Roboto', sans-serif;
	font-size: 14px;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}

/* Pen Title */
.pen-title {
	padding: 50px 0;
	text-align: center;
	letter-spacing: 2px;
}

.pen-title h1 {
	margin: 0 0 20px;
	font-size: 48px;
	font-weight: 300;
}

.pen-title span {
	font-size: 12px;
}

.pen-title span .fa {
	color: #33b5e5;
}

.pen-title span a {
	color: #33b5e5;
	font-weight: 600;
	text-decoration: none;
}

/* Form Module */
.form-module {
	position: relative;
	background: #ffffff;
	max-width: 320px;
	width: 100%;
	border-top: 5px solid #33b5e5;
	box-shadow: 0 0 3px rgba(0, 0, 0, 0.1);
	margin: 0 auto;
}

.form-module .toggle {
	cursor: pointer;
	position: absolute;
	top: -0;
	right: -0;
	background: #33b5e5;
	width: 30px;
	height: 30px;
	margin: -5px 0 0;
	color: #ffffff;
	font-size: 12px;
	line-height: 30px;
	text-align: center;
}

.form-module .toggle .tooltip {
	position: absolute;
	top: 5px;
	right: -65px;
	display: block;
	background: rgba(0, 0, 0, 0.6);
	width: auto;
	padding: 5px;
	font-size: 10px;
	line-height: 1;
	text-transform: uppercase;
}

.form-module .toggle .tooltip:before {
	content: '';
	position: absolute;
	top: 5px;
	left: -5px;
	display: block;
	border-top: 5px solid transparent;
	border-bottom: 5px solid transparent;
	border-right: 5px solid rgba(0, 0, 0, 0.6);
}

.form-module .form {
	display: none;
	padding: 40px;
}

.form-module .form:nth-child(2) {
	display: block;
}

.form-module h2 {
	margin: 0 0 20px;
	color: #33b5e5;
	font-size: 18px;
	font-weight: 400;
	line-height: 1;
}

.form-module input {
	outline: none;
	display: block;
	width: 100%;
	border: 1px solid #d9d9d9;
	margin: 0 0 20px;
	padding: 10px 15px;
	box-sizing: border-box;
	font-wieght: 400;
	-webkit-transition: 0.3s ease;
	transition: 0.3s ease;
}

.form-module input:focus {
	border: 1px solid #33b5e5;
	color: #333333;
}

.form-module button {
	cursor: pointer;
	background: #33b5e5;
	width: 100%;
	border: 0;
	padding: 10px 15px;
	color: #ffffff;
	-webkit-transition: 0.3s ease;
	transition: 0.3s ease;
}

.form-module button:hover {
	background: #178ab4;
}

.form-module .cta {
	background: #f2f2f2;
	width: 100%;
	padding: 15px 40px;
	box-sizing: border-box;
	color: #666666;
	font-size: 12px;
	text-align: center;
}

.form-module .cta a {
	color: #333333;
	text-decoration: none;
}

html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline
}

article, aside, details, figcaption, figure, footer, header, hgroup,
	menu, nav, section {
	display: block
}

body {
	line-height: 1
}

ol, ul {
	list-style: none
}

blockquote, q {
	quotes: none
}

blockquote:before, blockquote:after, q:before, q:after {
	content: '';
	content: none
}

table {
	border-collapse: collapse;
	border-spacing: 0
}
</style>
</head>
<body>

<div class="pen-title">
		<h1>Change Password</h1>
		
	</div>
	<!-- Form Module-->
	<div class="module form-module">
		<div class="toggle">
			<i class="fa fa-times fa-pencil"></i>
			
		</div>
		<div class="form">
<table align="center">
<form method="post" action="changepassword">
<tr><td>Username</td></tr><tr><td><input type="text" id="username" name="username" autofocus required/></td></tr>
<tr><td>SecretKey</td></tr><tr><td><input type="text" name="secret_key" required/></td></tr>
<tr><td>NewPassword</td></tr><tr><td><input type="password" id="password" name="newpass"  onblur="check_Password();" required/></td></tr>
<tr><td>ConfirmPassword</td></tr><tr><td><input type="password" name="confirmpass" required /></td></tr>
<tr><td></td></tr><tr><td><input type="submit" name="submit" value="submit"/></td></tr>
</form>

</div>
		
		
	</div>
	<%
    if (request.getSession().getAttribute("message") == null) {
       
    } else {
        out.println(request.getSession().getAttribute("message"));
        request.getSession().setAttribute("message",null);
    }
%>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<!-- <script src='http://codepen.io/andytran/pen/vLmRVp.js'></script> -->


</table>

<script>
		// Toggle Function
		$('.toggle').click(function() {
			// Switches the Icon
			$(this).children('i').toggleClass('fa-pencil');
			// Switches the forms  
			$('.form').animate({
				height : "toggle",
				'padding-top' : 'toggle',
				'padding-bottom' : 'toggle',
				opacity : "toggle"
			}, "slow");
		});
		</script>
		<script>
		function check_Password() {
            var str = document.getElementById("password").value;
            var uName = document.getElementById("username").value;

            if (str.length < 8) {
                  alert("Password too short : Enter 8 or more character");
                  //return ("too_short");
            } else if (str.search(/\d/) == -1) {
                  alert("Password must contain atleast 1 digit");
                  //return ("no_num");
            } else if (str.search(/[a-zA-Z]/) == -1) {
                  alert("Password must contain atleast 1 alphabet");
                  //return ("n_letter");
            } else if (str
                         .search(/[^a-zA-Z0-9\!\@\#\$\%\^\&\*\(\)\_\+\.\,\;\:]/) != -1) {
                  alert("Password must contain atleast 1 special character");
                  //return ("bad_char");
            }
            if (document.getElementById("password").value !== document
                         .getElementById("username").value) {
            } else {
                  alert("Username and Password Cannot be same");
            }
     }

	</script>
</body>
</html>