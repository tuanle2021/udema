<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/common/taglib.jsp" %>
<header class="header menu_2">
  <div id="preloader">
    <div data-loader="circle-side"></div>
  </div><!-- /Preload -->
  <div id="logo">
    <a href="${pageContext.request.contextPath}/home"><img src="/assets/public/img/logo.png" width="149" height="42" data-retina="true" alt=""></a>
  </div>
  <!-- <ul id="top_menu">
    <li><a href="login.html" class="login">Login</a></li>
    <li><a href="#0" class="search-overlay-menu-btn" style="top: 6px">Search</a></li>
    <li class="hidden_tablet"><a href="admission.html" class="btn_1 rounded">Admission</a></li>
  </ul> -->
  <!-- /top_menu -->
  <a href="#menu" class="btn_mobile">
    <div class="hamburger hamburger--spin" id="hamburger">
      <div class="hamburger-box">
        <div class="hamburger-inner"></div>
      </div>
    </div>
  </a>
  <nav id="menu" class="main-menu">
    <ul>
      <li><span><a href="${pageContext.request.contextPath}/home">Home</a></span>
      </li>
      <li><span><a href="#0">Courses</a></span>
        <ul>
          <li><a href="${pageContext.request.contextPath}/filter?id=2">Web DEV</a></li>
          <li><a href="${pageContext.request.contextPath}/filter?id=3">Mobile DEV</a></li>
        </ul>
      </li>
      <c:if test="${credentials != null}">
      <li class="user-icon">
        <span>
          <a href="#0">
            <img src="${credentials.avatar}" />
          </a>
        </span>
        <ul>
          <li><a href="/myprofile">${credentials.email}</a></li>
          <li><a href="/logout">Logout</a></li>
        </ul>
      </li>
      </c:if>
      <c:if test="${credentials == null}">
      <li>
      	 <span>
          <a href="/login">Login</a>
        </span>
      </li>
      </c:if>
    </ul>
  </nav>
  <!-- Search Menu -->
  <div class="search-overlay-menu">
    <span class="search-overlay-close"><span class="closebt"><i class="ti-close"></i></span></span>
    <form role="search" id="searchform" method="get">
      <input value="" name="q" type="search" placeholder="Search..." />
      <button type="submit"><i class="icon_search"></i>
      </button>
    </form>
  </div><!-- End Search Menu -->
</header>