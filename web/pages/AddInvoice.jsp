<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>
<div class="row clearfix">
    <div class="col-md-12">
        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    Create Invoice
                    <small>Add Customer Invoice Here</small>
                </h2>
            </div>
            <div class="body">

                <form id="invoiceForm">
                    <div class="row">

                        <div class="col-md-5">
                            <label for="selectsupplier">Select Customer</label>
                            <select class="form-control" id="selectsupplier" name="selectsupplier">
                                <option>Select Customer</option>
                            </select>
                        </div>
                        <div class="col-md-1">

                            <button type="button" class="btn bg-teal waves-effect" style="margin-top: 23px"
                                    id="addCustomer">
                                <i class="material-icons">add</i>
                            </button>

                        </div>
                        <div class="col-md-3">
                            <label for="grnno">Invoice No</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="grnno" class="form-control" placeholder="GRN No" type="text"
                                           name="grnno" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label for="grndate">Invoice date</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="grndate" class="form-control" placeholder="GRN Date" type="text"
                                           name="grndate">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label for="selectproduct">Select Product</label>
                            <select class="form-control" id="selectproduct" name="selectproduct">
                                <option>Select</option>

                            </select>
                        </div>
                        <div class="col-md-2">
                            <label for="unitprice">Unit Price</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="unitprice" class="form-control text-right" placeholder="Unit Price"
                                           type="tel"
                                           name="unitprice">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <label for="quantity">Quantity</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="quantity" class="form-control text-right" placeholder="Quantity"
                                           type="tel"
                                           name="quantity">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <label for="quantity">Unit</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="Unit" class="form-control" placeholder="Unit" type="text" name="Unit" readonly>
                                </div>
                            </div>
                        </div>

                        <div class="row">

                            <div class="col-md-12 ">
                                <div class="col-md-12">


                                    <div class="table-responsive">

                                        <table class="table table-striped" id="grntable">
                                            <thead class="bg-deep-purple">
                                            <tr>
                                                <th style="width: 500px">Product</th>
                                                <th class="text-right">Unit Price</th>
                                                <th class="text-center">Quantity</th>
                                                <th class="text-right">Total</th>
                                                <th class="text-right"></th>
                                            </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label for="grntotal">Sub Total</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="grntotal" class="form-control text-right" placeholder="Enter GRN Total"
                                           type="text"
                                           name="grntotal" readonly value="0">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label for="discount">Discount</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="discount" class="form-control text-right"
                                           placeholder="Enter Paid Amount" type="text"
                                           name="discount" readonly value="0.00">
                                </div>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label for="nettotal">Net Total</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="nettotal" class="form-control text-right"
                                           placeholder="Enter Paid Amount" type="text"
                                           name="nettotal" value="0.00" readonly>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label for="paidamount">Paid Amount</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="paidamount" class="form-control text-right"
                                           placeholder="Enter Paid Amount" type="tel"
                                           name="paidamount" value="0.00">
                                </div>
                            </div>
                        </div>

                        <%--<div class="col-md-1">--%>
                            <%--<label for="paidby">Paid by</label>--%>
                            <%--<div class="form-group">--%>
                                <%--<div class="form-line">--%>
                                    <%--<input id="paidby" class="form-control" placeholder="Enter Paid by" type="text"--%>
                                           <%--name="paidby" readonly value="CASH">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <br>
                        <div class="pull-right">
                            <button type="button" class="btn btn-primary m-t-15 waves-effect" id="saveBtn">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<jsp:include page="/footer.jsp"/>
<script src="${pageContext.request.contextPath}/js/customescripts/AddInvoice.js"></script>
<script src="${pageContext.request.contextPath}/js/numbersonly.js"></script>