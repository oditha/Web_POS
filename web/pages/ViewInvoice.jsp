<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>

<div class=" row clearfix ">
    <div class="col-md-12">

        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    View Invoice
                    <small>View Invoice here...</small>
                </h2>
            </div>
            <div class="body">

                <div class="row">

                    <div class="col-md-4">
                        <label for="selectsupplier">Supplier</label>
                        <select class="form-control" id="selectsupplier" name="selectsupplier">
                            <option>All Customers</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <label for="datestart">Date Range</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="datestart" class="form-control" type="text"
                                       name="datestart">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4" style="margin-top: 20px">

                        <button type="button" class="btn btn-info waves-effect" id="filterBtn">Filter</button>
                        <button type="button" class="btn btn-danger waves-effect" id="resetBtn">Reset</button>


                    </div>

                    <div class="row">
                        <div class="col-md-12 table-responsive">

                            <table class="table" id="grntable">
                                <thead>
                                <tr>
                                    <th>Invoice No</th>
                                    <th style="width: 40%">Customer</th>
                                    <th>Invoice Date</th>
                                    <th>Invoice Total</th>
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
    </div>
</div>

<jsp:include page="/includes/modals/ViewInvoice.jsp"/>
<jsp:include page="/footer.jsp"/>
<script src="${pageContext.request.contextPath}/js/customescripts/ViewInvoice.js"></script>