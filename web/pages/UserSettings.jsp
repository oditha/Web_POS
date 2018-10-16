<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>

<div class="row clearfix">
    <div class="col-md-12">
        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    User Management
                    <small>Manage System Users</small>
                </h2>
            </div>
            <div class="body">


                <form id="userFrame">

                    <div class="col-md-6">
                        <label for="nic">NIC</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="nic" class="form-control required" placeholder="Enter NIC"
                                       type="text" name="nic">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="fname">First Name</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="fname" class="form-control required" placeholder="Enter First Name" type="text"
                                       name="fname">

                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="lname">Last Name</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="lname" class="form-control required" placeholder="Enter Last Name"
                                       type="text" name="lname">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="email">Email Address</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="email" class="form-control required" placeholder="Email Address"
                                       type="text" name="email">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="contact1">Contact no 1</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="contact1" class="form-control required" placeholder="Enter Contact No 1" type="text"
                                       name="contact1">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="contact2">Contact No 2</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="contact2" class="form-control required" placeholder="Enter Contact No 2"
                                       type="text" name="contact2">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="role">System Role</label>
                        <select class="form-control" id="role" name="role">
                            <option>Admin</option>
                            <option>User</option>
                        </select>
                    </div>
                    <br>
                    <div class="pull-right">
                        <button type="reset" class="btn btn-danger m-t-15 waves-effect">Reset</button>
                        <button type="button" class="btn btn-primary m-t-15 waves-effect" id="saveBtn">Save</button>
                    </div>
                </form>

                <div class="row">

                    <div class="col-md-12 table-responsive">


                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>NIC</th>
                                <th>Name</th>
                                <th>Email Address</th>
                                <th>Contact No</th>
                                <%--<th>Options</th>--%>

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

<a href="SignUp">Click here to set user account</a>

<jsp:include page="/footer.jsp"/>
<script src="${pageContext.request.contextPath}/js/customescripts/UserSettings.js"></script>