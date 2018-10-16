<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>

<div class=" row clearfix ">
    <div class="col-md-12">

        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    View Works
                    <small>View Works here</small>
                </h2>
            </div>
            <div class="body">

                <div class="row">
                    <form id="worksForm">

                        <div class="col-md-3">
                            <label for="user">User</label>
                            <select class="form-control" id="user" name="user">
                                <option>All Users</option>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <label for="OrderType">Order Type</label>
                            <select class="form-control" id="OrderType" name="OrderType">
                                <option>New Order</option>
                                <option>Modification</option>
                            </select>
                        </div>
                        <div class="col-md-3">
                            <label for="datestart">Date Range</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="datestart" class="form-control" type="text"
                                           name="datestart">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3" style="margin-top: 20px">

                            <button type="button" class="btn btn-info waves-effect" id="filterBtn">Filter</button>
                            <button type="button" class="btn btn-danger waves-effect" id="resetBtn">Reset</button>


                        </div>

                    </form>
                    <div class="row">
                        <div class="col-md-12 table-responsive">

                            <table class="table" id="workstable">
                                <thead>
                                <tr>
                                    <th>User</th>
                                    <th>Date</th>
                                    <th>Order</th>
                                    <th>Account</th>
                                    <th>Type</th>
                                    <th>Update No</th>
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
<script src="${pageContext.request.contextPath}/js/customescripts/ViewWorks.js"></script>