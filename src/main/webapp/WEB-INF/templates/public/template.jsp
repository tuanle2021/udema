<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/common/taglib.jsp" %>
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
    <decorator:getProperty property="page.stylesheet" />
</head>

<body>
	<div id="page">
    <%@ include file="/WEB-INF/partials/public/header.jsp" %>
    <!-- /header -->

    <main>
      <decorator:body />
    </main>
    <!-- /main -->

    <%@ include file="/WEB-INF/partials/public/footer.jsp" %>
    <!--/footer-->
	</div>
	<!-- page -->
  <%@ include file="/WEB-INF/partials/public/javascripts.jsp" %>
  <decorator:getProperty property="page.script" />
</body>
</html>