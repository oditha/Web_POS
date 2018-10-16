<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>
<div class="row clearfix">
    <div class="col-md-12">
        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    View Customer
                    <small>View Customer Outstanding here...</small>
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
                    <div class="row">

                        <div class="col-md-12 table-responsive">

                            <table class="table" id="">
                                <thead>
                                <tr>
                                    <th>Customer Name</th>
                                    <th> Contact No</th>
                                    <th>No of Investment</th>
                                    <th>Total</th>
                                    <th>Paid</th>
                                    <th>Outstanding</th>
                                    <th>Option</th>
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
</div>


<jsp:include page="/footer.jsp"/>