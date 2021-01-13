<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>${title == null ? 'Udema' : title}</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="shortcut icon" type="image/x-icon" href="" />
  <link rel="stylesheet" href="/assets/admin/index.css">
  <decorator:getProperty property="page.stylesheet" />
</head>
<body>
  <%@ include file="/WEB-INF/partials/admin/menu.jsp" %>
  <decorator:body />
  <script src="/assets/admin/index.js"></script>
  <decorator:getProperty property="page.script" />
</body>
</html>