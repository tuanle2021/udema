<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
  <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
    <a class="nav-link" href="/admin/dashboard">
      <i class="fa fa-fw fa-dashboard"></i>
      <span class="nav-link-text">Dashboard</span>
    </a>
  </li>
  <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Messages">
    <a class="nav-link" href="messages">
      <i class="fa fa-fw fa-envelope-open"></i>
      <span class="nav-link-text">Messages</span>
    </a>
  </li>
  <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Bookings">
    <a class="nav-link" href="/admin/courses">
      <i class="fa fa-fw fa-archive"></i>
      <span class="nav-link-text">Courses <span class="badge badge-pill badge-primary">6 New</span></span>
    </a>
  </li>
  <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Reviews">
    <a class="nav-link" href="/admin/reviews">
      <i class="fa fa-fw fa-star"></i>
      <span class="nav-link-text">Reviews</span>
    </a>
  </li>
  <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Bookmarks">
    <a class="nav-link" href="/admin/users">
      <i class="fa fa-fw fa-user"></i>
      <span class="nav-link-text">Users</span>
    </a>
  </li>
  <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Add listing">
    <a class="nav-link" href="/admin/add-listing">
      <i class="fa fa-fw fa-plus-circle"></i>
      <span class="nav-link-text">Add listing</span>
    </a>
  </li>
  <li class="nav-item" data-toggle="tooltip" data-placement="right" title="My profile">
    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseProfile"
      data-parent="#exampleAccordion">
      <i class="fa fa-fw fa-wrench"></i>
      <span class="nav-link-text">My profile</span>
    </a>
    <ul class="sidenav-second-level collapse" id="collapseProfile">
      <li>
        <a href="/admin/user-profile">User profile</a>
      </li>
      <li>
        <a href="/admin/teacher-profile">Teacher profile</a>
      </li>
    </ul>
  </li>
</ul>