<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>

<div class="row clearfix">
    <div class="col-md-12">
        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    Company Setting
                    <small>Your Company Settings here</small>
                </h2>
            </div>
            <div class="body">

                <form>

                    <div class="col-md-12">
                        <label for="companyName">Company Name</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="companyName" class="form-control" placeholder="Enter your Company Name"
                                       type="text" name="companyName">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="address1">Address Line 1</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="address1" class="form-control" placeholder="Enter Address Line 1"
                                       type="text" name="address1">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="address2">Address Line 2</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="address2" class="form-control" placeholder="Enter Address Line 2"
                                       type="text" name="address2">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="city">City</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="city" class="form-control" placeholder="Enter City"
                                       type="text" name="city">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="email">Email Address</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="email" class="form-control" placeholder="Enter Email Address" type="email"
                                       name="name">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="contact1">Contact no main</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="contact1" class="form-control" placeholder="Enter Contact no main"
                                       type="text" name="conatact1">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="contact2">Contact No Secondary</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="contact2" class="form-control" placeholder="Enter Secondary contact no"
                                       type="text" name="contact2">
                            </div>
                        </div>
                    </div>
                    <br>
                    <button type="button" class="btn btn-danger m-t-15 waves-effect pull-right">Reset</button>
                    <button type="button" class="btn btn-primary m-t-15 waves-effect pull-right">SAVE</button>
                </form>

            </div>
        </div>
        </div>
    </div>



<jsp:include page="/footer.jsp"/>