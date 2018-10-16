<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>

<div class="row clearfix">

    <div class="col-md-12">

        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    View Products
                    <small>View your product here</small>
                </h2>
            </div>
            <div class="body">

                <div class="row">

                    <div class="col-md-3">
                        <label for="department">Filter by Department</label>
                        <select class="form-control" id="department" name="department">
                            <option>Select</option>

                        </select>
                    </div>
                    <div class="col-md-3">
                        <label for="category">Filter by Category</label>
                        <select class="form-control" id="category" name="category">
                            <option>Select</option>

                        </select>
                    </div>
                    <div class="col-md-3">
                        <label for="type">Filter by Type</label>
                        <select class="form-control" id="type" name="type">
                            <option>Select</option>
                            <option>Products</option>
                            <option>Services</option>
                        </select>
                    </div>
                    <div class="col-md-3">
                        <button type="button" class="btn bg-purple waves-effect " style="margin-top: 23px" id="loadAll">
                            <i class="material-icons">refresh</i>
                        </button>
                    </div>
                </div>
                <hr>
                <div class="row">

                    <div class="col-md-12 table-responsive">

                        <table class="table table-striped" id="productTable">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Product Name</th>
                                <th>Category</th>
                                <th>Department</th>
                                <th>Selling Price</th>
                                <th>Options</th>
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
</div>


<jsp:include page="/includes/modals/ViewProducts.jsp"/>
<jsp:include page="/footer.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/customescripts/ViewProducts.js"></script>