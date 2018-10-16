<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>
<div class="row clearfix">
    <div class="col-md-12">
        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    View Purchase Order
                    <small>View Purchase Order here...</small>
                </h2>
            </div>
            <div class="body">

                <div class="row">

                    <div class="col-md-4">
                        <label for="supplier">Supplier</label>
                        <select class="form-control" id="supplier" name="supplier">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                    <div class="col-md-4">
                        <label for="datestart">Date Start</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="datestart" class="form-control" placeholder="Date Start" type="text"
                                       name="datestart">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label for="dateend">Date End</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="dateend" class="form-control" placeholder="Date End" type="text"
                                       name="dateend">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12 table-responsive">

                            <table class="table" id="">
                                <thead>
                                <tr>
                                    <th>PO No</th>
                                    <th>PO Date</th>
                                    <th>PO Total</th>
                                    <th>Paid</th>
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