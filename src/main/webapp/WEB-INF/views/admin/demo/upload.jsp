<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="box_general padding_bottom">
  <div class="header_box version_2">
    <h2><i class="fa fa-file"></i>Basic info</h2>
  </div>
  <form action="/admin/demo/upload" method="POST" enctype="multipart/form-data">
    <div class="row">
      <div class="col-md-6">
        <div class="form-group">
          <label>Name</label>
          <input type="file" name="image" class="form-control">
        </div>
      </div>
      <div class="col-md-6">
        <div class="form-group">
          <label>Last name</label>
          <input type="text" class="form-control" placeholder="Your last name">
        </div>
      </div>
      <button type="submit" class="btn_1 gray add-pricing-list-item"><i class="fa fa-fw fa-plus-circle"></i>Submit</a>
    </div>
  </form>
  <!-- /row-->
</div>
<!-- /box_general-->