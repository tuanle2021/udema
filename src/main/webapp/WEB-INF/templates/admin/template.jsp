<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Udema">
  <title>${title == null ? 'Udema' : title}</title>
  <!-- Favicons-->
  <link rel="shortcut icon" href="/assets/admin/img/favicon.ico" type="image/x-icon">
  <link rel="apple-touch-icon" type="image/x-icon" href="/assets/admin/img/apple-touch-icon-57x57-precomposed.png">
  <link rel="apple-touch-icon" type="image/x-icon" sizes="72x72" href="/assets/admin/img/apple-touch-icon-72x72-precomposed.png">
  <link rel="apple-touch-icon" type="image/x-icon" sizes="114x114" href="/assets/admin/img/apple-touch-icon-114x114-precomposed.png">
  <link rel="apple-touch-icon" type="image/x-icon" sizes="144x144" href="/assets/admin/img/apple-touch-icon-144x144-precomposed.png">
  <%@ include file="/WEB-INF/partials/admin/styles.jsp" %>
  <decorator:getProperty property="page.stylesheet" />
</head>
<body class="fixed-nav sticky-footer" id="page-top">
  <!-- Navigation-->
  <%@ include file="/WEB-INF/partials/admin/header.jsp" %>
  <!-- /Navigation-->
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">My Dashboard</li>
      </ol>
      <!-- Icon Cards-->
      <decorator:body />
    </div>
    <!-- /.container-fluid-->
  </div>
  <!-- /.container-wrapper-->
  <%@ include file="/WEB-INF/partials/admin/footer.jsp" %>
  <%@ include file="/WEB-INF/partials/admin/javascripts.jsp" %>
  <decorator:getProperty property="page.script" />
</body>
</html>