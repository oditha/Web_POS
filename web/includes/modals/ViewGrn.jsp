<%--
  Created by IntelliJ IDEA.
  User: Thilakshi
  Date: 7/10/2018
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" tabindex="-1" role="dialog" id="viewGrn">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="title">View GRN Details</h4>
            </div>
            <div class="modal-body">

                <div class="row">


                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs tab-col-deep-orange" role="tablist">
                        <li role="presentation" class="active">
                            <a href="#home_with_icon_title" data-toggle="tab" aria-expanded="false">
                                <i class="material-icons">view_agenda</i> General
                            </a>
                        </li>
                        <li role="presentation" class="">
                            <a href="#profile_with_icon_title" data-toggle="tab" aria-expanded="false">
                                <i class="material-icons">local_grocery_store</i> Items
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#messages_with_icon_title" data-toggle="tab">
                                <i class="material-icons">attach_money</i> Payments
                            </a>
                        </li>

                    </ul>

                    <form id="productForm">
                        <!-- Tab panes -->
                        <div class="tab-content">


                            <div role="tabpanel" class="tab-pane fade active in" id="home_with_icon_title">

                                <div class="col-md-12" style="margin-top: 15px">

                                    <div class="row">

                                        <div class="col-md-6">
                                            <label>GRN Code : </label>
                                            <span id="grnid">Product Code </span>

                                        </div>
                                        <div class="col-md-6">
                                            <label>GRN Date : </label>
                                            <span id="date">Product Code </span>
                                        </div>

                                    </div>


                                    <div class="row">

                                        <div class="col-md-12">
                                            <label>Supplier : </label>
                                            <span id="supplier">Product Code </span>
                                        </div>


                                    </div>

                                    <div class="row">

                                        <div class="col-md-6">
                                            <label>Total : </label>
                                            <span id="total">Product Code </span>

                                        </div>
                                        <div class="col-md-6">
                                            <label>Create By : </label>
                                            <span id="createby">Product Code </span>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="profile_with_icon_title">

                                <div class="col-md-12">

                                    <div class="row clearfix" style="margin-top: 15px">

                                        <div class="table-responsive">

                                            <table class="table table-striped" id="producttable">
                                                <thead>
                                                <tr>
                                                    <th style="width: 60%">Item</th>
                                                    <th class="text-right">Price</th>
                                                    <th>QTY</th>
                                                    <th>Total</th>
                                                </tr>
                                                </thead>
                                                <tbody>

                                                </tbody>
                                            </table>

                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="messages_with_icon_title">


                                <div class="col-md-12">

                                    <div class="row" style="margin-top: 15px">

                                        <div class="col-md-4">
                                            <label>GRN Total : </label>
                                            <span id="grntotal">Product Code </span>
                                        </div>

                                        <div class="col-md-4">
                                            <label>Total Paid : </label>
                                            <span id="totalpaid">Product Code </span>
                                        </div>
                                        <div class="col-md-4">
                                            <label>Outstanding : </label>
                                            <span id="outstanding">Product Code </span>
                                        </div>


                                    </div>
                                    <div class="row">

                                        <div class="col-md-12">

                                            <div class="table-responsive">

                                                <table class="table table-striped" id="paymentTable">
                                                    <thead>
                                                    <tr>
                                                        <th>Date</th>
                                                        <th>Type</th>
                                                        <th class="text-right">Amount</th>
                                                        <th>Add By</th>
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

                            <%--ddd--%>

                        </div>

                    </form>

                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger waves-effect btn-sm" id="delete">Delete</button>
                <%--<button type="button" class="btn btn-warning waves-effect btn-sm" id="update">Update</button>--%>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>