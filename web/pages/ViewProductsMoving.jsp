<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>
<div class="row clearfix">
    <div class="col-md-12">
        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    Products Moving
                    <small>Products Moving here</small>
                </h2>
            </div>
            <div class="body">

                <div class="row">

                    <div class="col-md-3">
                        <label for="startdate">Start Date</label>
                        <select class="form-control" id="startdate" name="startdate">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                    <div class="col-md-3">
                        <label for="enddate">End Date</label>
                        <select class="form-control" id="enddate" name="enddate">
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
</div>


<jsp:include page="/footer.jsp"/>