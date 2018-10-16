<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>
<div class="row clearfix">
    <div class="col-md-12">
        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    Add/View Customer
                    <small>Add/View Customer details here...</small>
                </h2>
            </div>
            <div class="body">
                <div class="row">

                    <div class="col-md-12">

                        <form id="customerForm">


                            <label for="customername">Customer Name</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="customername" class="form-control required" placeholder="Enter your Customer Name"
                                           type="text" name="customername">
                                </div>
                            </div>
                    </div>
                    <div class="col-md-6">
                        <label for="address1">Address1</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="address1" class="form-control" placeholder="Enter your Address Line 1"
                                       type="text"
                                       name="address1">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="address2">Address2</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="address2" class="form-control" placeholder="Enter your Address Line 2  "
                                       type="text"
                                       name="address2">
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <label for="city">City</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="city" class="form-control" placeholder="Enter your City" type="text"
                                       name="city">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="email"> Email</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="email" class="form-control" placeholder="Enter your Email  " type="text"
                                       name="email">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="contact1">Contact1</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="contact1" class="form-control required" placeholder="Enter your Primary Contact No"
                                       type="text"
                                       name="contact1">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="contact2"> Contact2</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="contact2" class="form-control" placeholder="Enter your Secondary Contact No "
                                       type="text"
                                       name="contact2">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <input id="addspecialcustomerbenifits" class="filled-in" type="checkbox"
                               name="addspecialcustomerbenifits" value="TRUE">
                        <label for="addspecialcustomerbenifits">Add Special Customer Benifits</label>
                    </div>
                    <br>
                    <div class="pull-right">
                        <button type="reset" class="btn btn-danger m-t-15 waves-effect">Reset</button>
                        <button type="button" class="btn btn-primary m-t-15 waves-effect" id="saveBtn">Save</button>

                    </div>

                    </form>

                </div>
                <%--div--%>

            </div>
        </div>

    </div>
</div>


<jsp:include page="/footer.jsp"/>
<script src="${pageContext.request.contextPath}/js/customescripts/AddCustomers.js"></script>
