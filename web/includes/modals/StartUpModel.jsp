<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" tabindex="-1" role="dialog" id="start">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Enter following detils to continue</h4>
            </div>
            <div class="modal-body">
                    <form id="StartUpForm">

                <div class="row clearfix">
                        <div class="col-md-6">
                            <h6 class="col-teal">Company Information</h6>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="text" required id="CompanyName"
                                           name="CompanyName">
                                    <label class="form-label">Company Name</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="text" required id="Address1" name="Address1">
                                    <label class="form-label">Address Line 1</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="text" id="Address2" name="Address2">
                                    <label class="form-label">Address Line 2</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="text" required id="City" name="City">
                                    <label class="form-label">City</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="tel" name="contact1" required id="contact1">
                                    <label class="form-label">Contact No 1</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="tel" id="contact2" name="contact2">
                                    <label class="form-label">Contact No 2</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="email" id="email" name="email" required>
                                    <label class="form-label">email</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <h6 class="col-teal">Admin Information</h6>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="text" required id="nic" name="nic">
                                    <label class="form-label">NIC</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="text" id="fname" name="fname" required>
                                    <label class="form-label">First Name</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="text" required id="lname" name="lname">
                                    <label class="form-label">Last Name</label>
                                </div>
                            </div>

                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="tel" required id="uconctact1" name="ucontact1">
                                    <label class="form-label">Contact No 1</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="tel" id="ucontact2" name="ucontact2">
                                    <label class="form-label">Contact No 2</label>
                                </div>
                            </div>
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="text" required name="uemail" id="uemail">
                                    <label class="form-label">email</label>
                                </div>
                            </div>

                        </div>


                </div>
                <div class="row clearfix">

                    <h6 class="col-teal">Enter Login Details</h6>

                    <div class="col-md-4">

                        <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="material-icons">person</i>
                                        </span>
                            <div class="form-line">
                                <input class="form-control" type="text" placeholder="Username" id="username"
                                       name="username">

                            </div>
                        </div>

                    </div>

                    <div class="col-md-4">

                        <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="material-icons">lock</i>
                                        </span>
                            <div class="form-line">
                                <input class="form-control" type="password" placeholder="Enter Password" name="password"
                                       required id="password">

                            </div>
                        </div>

                    </div>

                    <div class="col-md-4">

                        <div class="input-group">
                                        <span class="input-group-addon">
                                            <i class="material-icons">lock</i>
                                        </span>
                            <div class="form-line">
                                <input class="form-control" type="password" placeholder="Confirm Password" required
                                       id="repassword" name="repassword">

                            </div>
                        </div>

                    </div>

                </div>
</form>
            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-danger m-t-15 waves-effect" id="reset">Save</button>
                <button type="button" class="btn btn-primary m-t-15 waves-effect" id="savesetup">Save</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>