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
<body id="login_bg">
	<nav id="menu" class="fake_menu"></nav>
	<div id="preloader">
		<div data-loader="circle-side"></div>
	</div>
	<!-- End Preload -->
	<div id="login">
		<aside>
			<figure>
				<a href="${pageContext.request.contextPath}/home"><img src="/assets/public/img/logo.png" width="149" height="42" data-retina="true" alt=""></a>
			</figure>
			<form action="/login" method="POST" data-parsley-validate>
				<div class="access_social">
					<!-- <a href="#0" class="social_bt facebook">Login with Facebook</a> -->
					<a href="#0" class="social_bt google">Login with Google</a>
					<!-- <a href="#0" class="social_bt linkedin">Login with Linkedin</a> -->
				</div>
				<div class="divider"><span>Or</span></div>
				<div class="form-group">
					<span class="input">
					<input class="input_field" type="email" autocomplete="off" name="email" value=""
						data-parsley-type="email" data-parsley-type-message="Please type a correct email format"
						data-parsley-required data-parsley-required-message="Please type your email" >
						<label class="input_label">
						<span class="input__label-content">Your email</span>
					</label>
					</span>
					<span class="input">
					<input class="input_field" type="password" autocomplete="off" name="password" value=""
						data-parsley-required data-parsley-required-message="Please type your password">
						<label class="input_label">
						<span class="input__label-content">Your password</span>
					</label>
					</span>
					<small><a href="/forgot-password">Forgot password?</a></small>
				</div>
				<button type="submit" class="btn_1 rounded full-width add_top_60">Login to Udema</button>
				<div class="text-center add_top_10">New to Udema? <strong><a href="/register">Register!</a></strong></div>
			</form>
			<div class="copy">© 2021 Udema</div>
		</aside>
	</div>
	<!-- /login -->
  <%@ include file="/WEB-INF/partials/public/javascripts.jsp" %>
</body>
</html>
