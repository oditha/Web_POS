<%--
  Created by IntelliJ IDEA.
  User: Thilakshi
  Date: 7/10/2018
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>
<div class="row clearfix">

    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    Add Category
                    <small>Add Category here</small>
                </h2>

            </div>
            <div class="body">


                <div class="row clearfix">

                    <form id="categoryForm">


                        <div class="col-md-6">
                            <label for="categorycode">Category Code</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="categorycode" class="form-control" placeholder="Enter your Category Name"
                                           type="text"
                                           name="categorycode" maxlength="4">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label for="categoryname">Category Name</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="categoryname" class="form-control" placeholder="Enter your Category Code"
                                           type="text"
                                           name="categoryname">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label for="department">Department</label>
                            <select class="form-control" id="department" name="department">
                                <option>Select Department</option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="categorytype">Category Type </label>
                            <select class="form-control" id="categorytype" name="categorytype">
                                <option>Service</option>
                                <option>Products</option>
                            </select>
                        </div>
                        <br>
                        <div class="pull-right">
                            <button type="reset" class="btn btn-danger m-t-15 waves-effect">Reset</button>
                            <button type="button" class="btn btn-primary m-t-15 waves-effect" id="saveBtn">Save</button>

                        </div>
                    </form>

                </div>


            </div>

        </div>
    </div>
</div>
<div class="row clearfix">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="card">
            <div class="header">
                <h2>
                    View Categories
                </h2>
            </div>
            <div class="body">
                <div class="body table-responsive">
                    <table class="table table-striped" id="categoryTable">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Category Code</th>
                            <th>Category Name</th>
                            <th>Category Type</th>
                            <th>Department</th>
                            <th>Add By</th>
                            <th>Option</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/footer.jsp"/>

<%--<script src="/js/pages/tables/jquery-datatable.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/js/customescripts/Categories.js" type="text/javascript"></script>

