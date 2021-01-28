<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/common/taglib.jsp" %>
<section class="hero_single version_2">
  <div class="wrapper">
    <div class="container">
      <h3>What would you learn?</h3>
      <p>Increase your expertise in business, technology and personal development</p>
      <form>
        <div id="custom-search-input">
          <div class="input-group">
            <input type="text" class=" search-query" placeholder="Ex. Architecture, Specialization...">
            <input type="submit" class="btn_search" value="Search">
          </div>
        </div>
      </form>
    </div>
  </div>
</section>
<!-- /hero_single -->

<div class="features clearfix">
  <div class="container">
    <ul>
      <li><i class="pe-7s-study"></i>
        <h4>+200 courses</h4><span>Explore a variety of fresh topics</span>
      </li>
      <li><i class="pe-7s-cup"></i>
        <h4>Expert teachers</h4><span>Find the right instructor for you</span>
      </li>
      <li><i class="pe-7s-target"></i>
        <h4>Focus on target</h4><span>Increase your personal expertise</span>
      </li>
    </ul>
  </div>
</div>
<!-- /features -->

<div class="container-fluid margin_120_0">
  <div class="main_title_2">
    <span><em></em></span>
    <h2>Udema Popular Courses</h2>
    <p>Cum doctus civibus efficiantur in imperdiet deterruisset.</p>
  </div>
  <div id="reccomended" class="owl-carousel owl-theme">
  	<c:forEach items="${courses}" var="item">
	    <div class="item">
	      <div class="box_grid">
	        <figure>
	          <a href="${pageContext.request.contextPath}/course-detail?id=${item.id}" class="wish_bt"></a>
	          <a href="${pageContext.request.contextPath}/course-detail?id=${item.id}">
	            <div class="preview"><span>Preview course</span></div><img
	              src="${item.images}" class="img-fluid" alt="">
	          </a>
	          <div class="price">$${item.price}</div>
	
	        </figure>
	        <div class="wrapper">
	          <small>Category</small>
	          <h3>${item.name}</h3>
	          <p>${item.description}</p>
	          <div class="rating"><i class="icon_star voted"></i><i class="icon_star voted"></i><i
	              class="icon_star voted"></i><i class="icon_star"></i><i class="icon_star"></i> <small>(145)</small>
	          </div>
	        </div>
	        <ul>
	          <li><i class="icon_clock_alt"></i> 1h 30min</li>
	          <li><i class="icon_like"></i> 890</li>
	          <li><a href="${pageContext.request.contextPath}/cart-payment">Enroll now</a></li>
	        </ul>
	      </div>
	    </div>
    </c:forEach>
    <!-- /item -->
  </div>
  <!-- /carousel -->
  <div class="container">
    <p class="btn_home_align"><a href="courses-grid.html" class="btn_1 rounded">View all courses</a></p>
  </div>
  <!-- /container -->
  <hr>
</div>
<!-- /container -->

<div class="container margin_30_95">
  <div class="main_title_2">
    <span><em></em></span>
    <h2>Udema Categories Courses</h2>
    <p>Top Course by View</p>
  </div>
  <div class="row">
    <c:forEach items="${topcoursesbyview}" var="item">
    <div class="col-lg-4 col-md-6 wow" data-wow-offset="150">
      <a href="${pageContext.request.contextPath}/course-detail?id=${item.id}" class="grid_item">
        <figure class="block-reveal">
          <div class="block-horizzontal"></div>
          <img src="${item.images}" class="img-fluid" alt="">
          <div class="info">
            <small><i class="ti-layers"></i>${item.viewCount}</small>
            <h3>${item.name}</h3>
          </div>
        </figure>
      </a>
    </div>
      </c:forEach>
    <!-- /grid_item -->
  </div>
  <!-- /row -->
</div>
<!-- /container -->
<!-- /bg_color_1 -->

<div class="call_section">
  <div class="container clearfix">
    <div class="col-lg-5 col-md-6 float-right wow" data-wow-offset="250">
      <div class="block-reveal">
        <div class="block-vertical"></div>
        <div class="box_1">
          <h3>Enjoy a great students community</h3>
          <p>Ius cu tamquam persequeris, eu veniam apeirian platonem qui, id aliquip voluptatibus pri. Ei mea primis
            ornatus disputationi. Menandri erroribus cu per, duo solet congue ut. </p>
          <a href="#0" class="btn_1 rounded">Read more</a>
        </div>
      </div>
    </div>
  </div>
</div>
<!--/call_section-->