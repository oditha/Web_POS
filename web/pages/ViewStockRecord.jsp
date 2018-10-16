<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>


<div class="row clearfix">
    <div class="col-md-12">
        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    Add Customer Payment History
                    <small>Add Customer Payment History here...</small>
                </h2>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="form-group form-float">
                    <div class="form-line">
                        <input class="form-control" type="text">
                        <label class="form-label">Start Date</label>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="form-group form-float">
                    <div class="form-line">
                        <input class="form-control" type="text">
                        <label class="form-label">End Date</label>
                    </div>
                </div>
            </div>
            <br>
            <div class="pull-right">
                <button type="button" class="btn btn-primary btn-lg m-l-15 waves-effect">Filter</button>
            </div>
            <div class="row">

                <div class="col-md-12 table-responsive">

                    <table class="table" id="">
                        <thead>
                        <tr>
                            <th>Product Code</th>
                            <th>Product</th>
                            <th>Category</th>
                            <th>QTY</th>
                            <th>Get by</th>
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