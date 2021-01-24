<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/common/taglib.jsp" %>
<div class="box_general">
	<div class="header_box">
		<h2 class="d-inline-block">Your Courses <a href="courses/add"><i class="fa fa-plus"></i></a></h2>
		<!-- <div class="filter">
			<select name="orderby" class="selectbox">
				<option value="Any status">Any status</option>
				<option value="Approved">Started</option>
				<option value="Pending">Pending</option>
				<option value="Cancelled">Cancelled</option>
			</select>
		</div> -->
	</div>
	<div class="list_general">
		<div class="card-body">
		    <div class="table-responsive">
		      <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
		        <thead>
		          <tr>
		            <th>Id</th>
		            <th>Name</th>
		            <th>Image</th>
		            <th>Price</th>
		            <th>Views</th>
		            <th>CreatedAt</th>
		            <th>Status</th>
		            <th>Action</th>
		          </tr>
		        </thead>
		        <tbody>
		        <c:if test="${not empty courses}">
		        	<c:forEach items="${courses}" var="item">
		        		<tr>
				            <td>${item.id}</td>
							<td>${item.name}</td>
				            <td>
				            	<img alt="No images found" src="${item.images}">
				            </td>
				            <td>$ ${item.price}</td>
				            
				            <td>${item.viewCount}</td>
				            <td>
				            	<fmt:formatDate type="date" value="${item.createdAt}" />  
				           </td>
				            <td>${item.status}</td>
				            <td>
				            	<a href="courses/edit?id=${item.id}">Edit</a>
				            </td>
				          </tr>
		        	</c:forEach>
		        </c:if>
		        <c:if test="${empty courses}">
		        	<tr>
		        		<td colspan="8">No courses found</td>
		        	</tr>
		        </c:if>
		        </tbody>
		      </table>
		    </div>
  		</div>
	</div>
</div>
<!-- /box_general-->
<nav aria-label="...">
	<ul class="pagination pagination-sm add_bottom_30">
		<li class="page-item disabled">
			<a class="page-link" href="#" tabindex="-1">Previous</a>
		</li>
		<li class="page-item"><a class="page-link" href="#">1</a></li>
		<li class="page-item"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
		<li class="page-item">
			<a class="page-link" href="#">Next</a>
		</li>
	</ul>
</nav>