<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>


<div class="row clearfix">
    <div class="col-md-12">

        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    Add Products
                    <small>Add products here...</small>
                </h2>
            </div>
            <div class="body">

                <div class="demo-masked-input">

                    <form id="productform">

                        <div class="row clearfix">


                            <div class="col-md-2">
                                <label for="productcode">Product Code *</label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input id="productcode" class="form-control required"
                                               placeholder="Product code will generate automatically"
                                               type="text" name="productcode" required>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label for="barcode">Barcode</label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input id="barcode" class="form-control" placeholder="Enter your Barcode"
                                               type="text"
                                               name="barcode">

                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                                <button type="button" class="btn bg-indigo waves-effect btn-sm"
                                        style="margin-top: 23px " id="generateBarcode">
                                    <i class="material-icons">trending_up</i>
                                    <span>GENERATE BARCODE</span>
                                </button>
                            </div>
                            <div class="col-md-4">
                                <label for="department">Department *</label>
                                <select class="form-control myselect" id="department" name="department">
                                    <option>Select</option>

                                </select>
                            </div>
                            <div class="col-md-8">
                                <label for="productName">Product Name *</label>
                                <div class="form-group">
                                    <div class="form-line">
                                        <input id="productName" class="form-control required"
                                               placeholder="Enter your Product Name"
                                               type="text" name="productName" required>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-4">
                                <label for="category">Category *</label>
                                <select class="form-control myselect" id="category" name="category">
                                    <option>Select</option>
                                </select>
                            </div>


                        </div>
                        <div class="row clearfix">

                            <div class="col-md-3">
                                <label for="unitprice">Unit Price *</label>
                                <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">attach_money</i>
                                            </span>
                                    <div class="form-line focused">
                                        <input class="form-control money-dollar required" placeholder="Ex: 99,99 $"
                                               type="text"
                                               id="unitprice" name="unitprice" required>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <label for="sellingprice">Selling Price *</label>
                                <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">attach_money</i>
                                            </span>
                                    <div class="form-line focused">
                                        <input class="form-control money-dollar required" placeholder="Ex: 99,99 $"
                                               type="text"
                                               id="sellingprice" name="sellingprice" required>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">

                                <label for="specialprice">Special Price</label>
                                <div class="input-group">
                                            <span class="input-group-addon">
                                                <i class="material-icons">attach_money</i>
                                            </span>
                                    <div class="form-line focused">
                                        <input class="form-control money-dollar" placeholder="Ex: 99,99 $" type="text"
                                               id="specialprice" name="specialprice">
                                    </div>
                                </div>

                                <%--<div class="form-group">--%>
                                <%--<div class="form-line">--%>
                                <%--<input id="specialprice" class="form-control" placeholder="Enter your Special Price"--%>
                                <%--type="tel" name="specialprice">--%>
                                <%--</div>--%>
                                <%--</div>--%>
                            </div>
                            <div class="col-md-2">
                                <label for="messuringunit">Messuring Unit *</label>
                                <select class="form-control myselect" id="messuringunit" name="messuringunit">
                                    <option>Select</option>
                                </select>
                            </div>
                            <div class="col-md-1">

                                <button type="button" class="btn bg-teal waves-effect" style="margin-top: 23px"
                                        id="addUnit">
                                    <i class="material-icons">add</i>
                                </button>

                            </div>

                        </div>
                        <div class="row clearfix">

                            <div class="col-md-3">
                                <label for="currentstock">Current Stock *</label>

                                <div class="input-group spinner" data-trigger="spinner">
                                    <div class="form-line">
                                        <input class="form-control text-center spinnumber required" value="0"
                                               data-rule="quantity"
                                               type="text" id="currentstock" name="currentstock">
                                    </div>
                                    <span class="input-group-addon">
                                            <a href="javascript:;" class="spin-up" data-spin="up"><i
                                                    class="glyphicon glyphicon-chevron-up"></i></a>
                                            <a href="javascript:;" class="spin-down" data-spin="down"><i
                                                    class="glyphicon glyphicon-chevron-down"></i></a>
                                        </span>
                                </div>

                            </div>


                            <div class="col-md-3">
                                <label for="reorderlevel">Re-order Level *</label>
                                <div class="input-group spinner" data-trigger="spinner">
                                    <div class="form-line">
                                        <input class="form-control text-center spinnumber required" value="0"
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

                            <div class="col-md-3">
                                <input id="addthistostock" class="filled-in" type="radio" name="stcokcheck" checked
                                       value="stock">
                                <label for="addthistostock">Add This To Stock</label>
                                <input id="thisisservice" class="filled-in" type="radio" name="stcokcheck"
                                       value="service">
                                <label for="thisisservice">This Is Service</label>
                            </div>

                        </div>
                        <div class="row clearfix">

                            <div class="col-md-12">


                                <div class="pull-right">
                                    <button type="reset" class="btn btn-danger m-t-15 waves-effect">Reset</button>
                                    <button type="button" class="btn btn-primary m-t-15 waves-effect" id="saveBtn">
                                        Save
                                    </button>
                                </div>
                            </div>

                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="/footer.jsp"/>
<script src="${pageContext.request.contextPath}/js/customescripts/AddProducts.js"></script>

