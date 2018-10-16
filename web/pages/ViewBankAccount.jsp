<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>

<div class="row clearfix">
    <div class="col-md-12">
        <div class="col-md-12">
            <div class="card">
                <div class="header bg-light-blue">
                    <h2>
                        Manage Bank Accounts
                        <small>Manage Bank Accounts</small>
                    </h2>
                </div>
                <div class="body">


                    <form>

                        <div class="col-md-6">
                            <label for="bank">Bank Name</label>
                            <select class="form-control" id="bank" name="bank">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="branch">Branch</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="branch" class="form-control" placeholder="Enter Branch" type="text"
                                           name="branch">

                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label for="accno">Account No</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="accno" class="form-control" placeholder="Enter Account No"
                                           type="text" name="lname">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label for="acctype">Account Types</label>
                            <select class="form-control" id="acctype" name="acctype">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                        <br>
                        <div class="pull-right">
                            <button type="reset" class="btn btn-danger m-t-15 waves-effect">Reset</button>
                            <button type="button" class="btn btn-primary m-t-15 waves-effect">SAVE</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 col-lg-12">

            <div class="card">
                <div class="header bg-light-green">
                    <h2>
                        View All Bank Accounts
                        <small>Your Bank Accounts Listed here...</small>
                    </h2>
                </div>
                <div class="body">
                    <div class="col-md-12 table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>NIC</th>
                                <th>First Name</th>
                                <th>Email Address</th>
                                <th>Contact No</th>
                                <th>Options</th>
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


<jsp:include page="/footer.jsp"/>