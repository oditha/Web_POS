<%--
  Created by IntelliJ IDEA.
  User: Thilakshi
  Date: 7/10/2018
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" tabindex="-1" role="dialog" id="ViewProducts">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="title">View Products Details</h4>
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
                                <i class="material-icons">attach_money</i> Pricing
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#messages_with_icon_title" data-toggle="tab">
                                <i class="material-icons">local_grocery_store</i> Stock
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="#settings_with_icon_title" data-toggle="tab">
                                <i class="material-icons">info</i> Information
                            </a>
                        </li>
                    </ul>

                        <form id="productForm">
                    <!-- Tab panes -->
                    <div class="tab-content">


                            <div role="tabpanel" class="tab-pane fade active in" id="home_with_icon_title">

                                <div class="col-md-12" style="margin-top: 15px">

                                    <div class="row">

                                        <div class="col-md-6" >
                                            <label for="productcode">Product Code</label>
                                            <div class="form-group">
                                                <div class="form-line">
                                                    <input id="productcode" class="form-control required"
                                                           placeholder="Product code will generate automatically"
                                                           type="text" name="productcode" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="barcode">Barcode</label>
                                            <div class="form-group">
                                                <div class="form-line">
                                                    <input id="barcode" class="form-control"
                                                           placeholder="Enter your Barcode"
                                                           type="text"
                                                           name="barcode">

                                                </div>
                                            </div>
                                        </div>

                                    </div>

                                    <div class="row">

                                        <div class="col-md-6">
                                            <label for="departmentm">Department</label>
                                            <select class="form-control" id="departmentm" name="department">
                                                <option>Select</option>

                                            </select>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="categorym">Category</label>
                                            <select class="form-control" id="categorym" name="category">
                                                <option>Select</option>
                                            </select>
                                        </div>


                                    </div>

                                    <div class="row">

                                        <div class="col-md-12" style="margin-top: 15px">
                                            <label for="productName">Product Name</label>
                                            <div class="form-group">
                                                <div class="form-line">
                                                    <input id="productName" class="form-control required"
                                                           placeholder="Enter your Product Name"
                                                           type="text" name="productName" required>
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="profile_with_icon_title">

                                <div class="col-md-12">

                                    <div class="row clearfix"  style="margin-top: 15px">

                                        <div class="col-md-4">
                                            <label for="unitprice">Unit Price *</label>
                                            <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">attach_money</i>
                                            </span>
                                                <div class="form-line focused">
                                                    <input class="form-control money-dollar required"
                                                           placeholder="Ex: 99,99 $"
                                                           type="text"
                                                           id="unitprice" name="unitprice" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <label for="sellingprice">Selling Price *</label>
                                            <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">attach_money</i>
                                            </span>
                                                <div class="form-line focused">
                                                    <input class="form-control money-dollar required"
                                                           placeholder="Ex: 99,99 $"
                                                           type="text"
                                                           id="sellingprice" name="sellingprice" required>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">

                                            <label for="specialprice">Special Price</label>
                                            <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">attach_money</i>
                                            </span>
                                                <div class="form-line focused">
                                                    <input class="form-control money-dollar" placeholder="Ex: 99,99 $"
                                                           type="text"
                                                           id="specialprice" name="specialprice">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="messages_with_icon_title">


                                <div class="col-md-12">

                                    <div class="row"  style="margin-top: 15px">

                                        <div class="col-md-4">
                                            <label for="stock">Current Stock</label>
                                            <div class="form-group">
                                                <div class="form-line">
                                                    <input id="stock" class="form-control required"
                                                           placeholder="Product code will generate automatically"
                                                           type="text" name="stock" required>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-4">
                                            <label for="messuringunit">Messuring Unit</label>
                                            <select class="form-control" id="messuringunit" name="messuringunit">
                                                <option>Select</option>
                                            </select>
                                        </div>

                                        <div class="col-md-4">
                                            <label for="reorderlevel">Re-order Level *</label>
                                            <div class="input-group spinner" data-trigger="spinner">
                                                <div class="form-line">
                                                    <input class="form-control text-center spinnumber required"
                                                           value="0"
                                                           data-rule="quantity"
                                                           type="text" id="reorderlevel" name="reorderlevel">
                                                </div>
                                                <span class="input-group-addon">
                                            <a href="javascript:;" class="spin-up" data-spin="up"><i
                                                    class="glyphicon glyphicon-chevron-up"></i></a>
                                            <a href="javascript:;" class="spin-down" data-spin="down"><i
                                                    class="glyphicon glyphicon-chevron-down"></i></a>
                                        </span>
                                            </div>
                                        </div>

                                    </div>

                                </div>

                            </div>
                            <div role="tabpanel" class="tab-pane fade" id="settings_with_icon_title">

                                <div class="col-md-12">

                                    <div class="row" style="margin-top: 15px">

                                        <div class="col-md-4">
                                            <label><strong>Item Type : </strong></label>
                                            <span class="label bg-indigo" id="typee">Green</span>
                                        </div>
                                        <div class="col-md-4">

                                            <label><strong>Item Status : </strong></label>
                                            <span class="label bg-green" id="status">Green</span>
                                        </div>
                                        <div class="col-md-4">
                                            <label><strong>Add By : </strong></label>
                                            <span class="label bg-deep-orange" id="addby">Green</span>
                                            <input type="text" id="idproduct" name="idproduts" hidden>
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
                <button type="button" class="btn btn-warning waves-effect btn-sm" id="update">Update</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>