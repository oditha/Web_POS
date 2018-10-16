<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>
<div class="row clearfix">
    <div class="col-md-12">
        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    Add Customer Payment
                    <small>Add Customer Payment here...</small>
                </h2>
            </div>
            <div class="body">

                <div class="row">

                    <div class="col-md-4">
                        <label for="selectcustomer">Select Customer</label>
                        <select class="form-control" id="selectcustomer" name="selectcustomer">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <label for="selectpaytype">Select Pay Type</label>
                        <select class="form-control" id="selectpaytype" name="selectpaytype">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                </div>
                <div class="row">

                    <div class="col-md-12 table-responsive">

                        <table class="table" id="">
                            <thead>
                            <tr>
                                <th>Customer</th>
                                <th> Address</th>
                                <th>Total</th>
                                <th>Paid</th>
                                <th>Paid Amount</th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>

                    </div>

                </div>
                <br>
                <div class="pull-right">
                    <button type="button" class="btn btn-primary m-t-15 waves-effect">SAVE</button>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/footer.jsp"/>
