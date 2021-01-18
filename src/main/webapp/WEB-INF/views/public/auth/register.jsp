<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Udema a modern educational site template">
    <meta name="author" content="Ansonika">
    <title>UDEMA | Modern Educational site template</title>
    <!-- Favicons-->
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" type="image/x-icon" href="img/apple-touch-icon-57x57-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="72x72" href="img/apple-touch-icon-72x72-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="114x114" href="img/apple-touch-icon-114x114-precomposed.png">
    <link rel="apple-touch-icon" type="image/x-icon" sizes="144x144" href="img/apple-touch-icon-144x144-precomposed.png">
    <%@ include file="/WEB-INF/partials/public/styles.jsp" %>
</head>
<body id="register_bg">
	<nav id="menu" class="fake_menu"></nav>
	
	<div id="preloader">
		<div data-loader="circle-side"></div>
	</div>
	<!-- End Preload -->
	
	<div id="login">
		<aside>
			<figure>
				<a href="index.html"><img src="/assets/public/img/logo.png" width="149" height="42" data-retina="true" alt=""></a>
			</figure>
			<form autocomplete="off" data-parsley-validate method="post">
				<div class="form-group">

					<span class="input">
					<input class="input_field" type="text" name="fullname"
						data-parsley-required data-parsley-required-message="Please type your name" >
						<label class="input_label">
						<span class="input__label-content">Your Name</span>
					</label>
					</span>

					<span class="input">
					<input class="input_field" type="email" name="email"
						data-parsley-type="email" data-parsley-type-message="Please type a correct email format"
						data-parsley-required data-parsley-required-message="Please type your email" >
						<label class="input_label">
						<span class="input__label-content">Your Email</span>
					</label>
					</span>

					<span class="input">
							<select id="gender" class="input_field" name="gender"
							data-parsley-required data-parsley-required-message="Please select you gender" >
								<option value="male">Male</option>
								<option value="female">Female</option>
								<option value="unknow">Unknow</option>
							</select>
							<label class="input_label">
							<!-- <span class="input__label-content">Your Gender</span> -->
						</label>
					</span>

					<span class="input">
					<input class="input_field" type="password" id="password1" name="password"
						data-parsley-required data-parsley-required-message="Please type your password">
						<label class="input_label">
						<span class="input__label-content">Your password</span>
					</label>
					</span>

					<span class="input">
					<input class="input_field" type="password" id="password2" name="confirmPassword"
						data-parsley-required data-parsley-required-message="Please type again your password">
						<label class="input_label">
						<span class="input__label-content">Confirm password</span>
					</label>
					</span>
					
					<div id="pass-info" class="clearfix"></div>
					
				</div>
				<button type="submit" class="btn_1 rounded full-width add_top_30">Register to Udema</button>
				<div class="text-center add_top_10">Already have an acccount? <strong><a href="login">Sign In</a></strong></div>
			</form>
			<div class="copy">© 2017 Udema</div>
		</aside>
	</div>
	<!-- /login -->
  <%@ include file="/WEB-INF/partials/public/javascripts.jsp" %>
</body>
</html>
