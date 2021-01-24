<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/common/taglib.jsp" %>
<form method="post" action="">
<div class="box_general padding_bottom">
  <div class="header_box version_2">
    <h2><i class="fa fa-file"></i>Update couces</h2>
  </div>
  <div class="row">
    <div class="col-md-6">
      <div class="form-group">
        <label>Course name</label>
        <input type="text" class="form-control" name="name" value="${course.name}" placeholder="Course name" required="required">
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-group">
        <label>Course category</label>
        <select class="form-control" name="category" >
        	<c:forEach items="${categories}" var="item">
	        	<c:set value="" var="select"></c:set>
	        	<c:if test="${course.category.id == item.id}">
	        		<c:set var="select" value="selected='selected'"></c:set>
	        	</c:if>
        		<option value="${item.id}" ${select}>${item.name}</option>
        	</c:forEach>
        </select>
      </div>
    </div>
  </div>
  <!-- /row-->
  <div class="row">
    <div class="col-md-6">
      <div class="form-group">
        <label>Course images</label>
        <input type="text" class="form-control" name="images" value="${course.images }" placeholder="Course images" required="required">
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-group">
        <label>Course prices</label>
        <input type="number" step="" class="form-control" name="prices" value="${course.price }" placeholder="courses price" required="required">
      </div>
    </div>
  </div>
  <!-- /row-->
  <div class="row">
    <div class="col-md-12">
      <div class="form-group">
        <label>Course status</label>
        <select class="form-control" name="status" name="status">
        	<c:set var="completed" value=""></c:set>
        	<c:set var="uncompleted" value=""></c:set>
        	<c:if test="${ course.status == 'completed'}">
        		<c:set var="completed" value="selected='selected'"></c:set>
        	</c:if>
        	<c:if test="${ course.status == 'uncompleted'}">
        		<c:set var="uncompleted" value="selected='selected'"></c:set>
        	</c:if>
        	<option selected="selected" ${completed } value="completed">completed</option>
        	<option value="incompleted" ${uncompleted }>uncompleted</option>
        </select>
      </div>
    </div>
  </div>
  <!-- /row-->
</div>
<!-- /box_general-->

<div class="box_general padding_bottom">
  <div class="header_box version_2">
    <h2><i class="fa fa-file-text"></i>Description</h2>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="form-group">
        <label>Course description</label>
        <textarea rows="5" class="form-control" style="height:100px;" name="description" placeholder="Description" required="required">${course.description }</textarea>
      </div>
    </div>
  </div>
  <div class="header_box version_2">
    <h2><i class="fa fa-file-text"></i>Detail</h2>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="form-group">
        <textarea  name="detail" cols="80" id="ckeditor" rows="10" required="required">${course.detail }</textarea>
      </div>
    </div>
  </div>
 
</div>
<!-- /box_general-->

<p><button type="submit" class="btn_1 medium">Save</button></p>

</form>
<content tag="script">
<script>
  CKEDITOR.replace('ckeditor');
</script>
</content>