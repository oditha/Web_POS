<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp" />
<div class="row clearfix">
    <div class="card">
        <div class="header bg-light-blue">
            <h2>
                 Sale Summery
                <small>Fast Moving / Slow Moving Sale Summery here...</small>
            </h2>
        </div>
        <div class="body">

            <div class="row">

                <div class="col-md-3">
                    <label for="selectdate">Select Date</label>
                    <select class="form-control" id="selectdate" name="selectdate">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
                <div class="col-md-3">
                    <label for="selectcustomer">Select Customer</label>
                    <select class="form-control" id="selectcustomer" name="selectcustomer">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
                <div class="col-md-3">
                    <label for="selectmonth">Select Month</label>
                    <select class="form-control" id="selectmonth" name="selectmonth">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
                <div class="col-md-3">
                    <label for="year">D</label>
                    <div class="form-group">
                        <div class="form-line">
                            <input id="year" class="form-control" placeholder="Year" type="text" name="year">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 table-responsive">

                        <table class="table" id="">
                            <thead>
                            <tr>
                                <th>Product Code</th>
                                <th> Product name</th>
                                <th> Selling Quantity</th>
                                <th>Income</th>
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





<jsp:include page="/footer.jsp" />