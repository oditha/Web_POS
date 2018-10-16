<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>
<div class="row clearfix">
    <div class="col-md-12">
        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    Re order Level Reminder
                    <small>View your running low stock</small>
                </h2>
            </div>
            <div class="body">

                <div class="row">
                    <div class="col-md-12 table-responsive">

                        <table class="table table-striped" id="stockTable">
                            <thead>
                            <tr>
                                <th>Product</th>
                                <th>Category</th>
                                <th>Department</th>
                                <th>AVB Stock</th>
                                <th>Price</th>

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
<script src="${pageContext.request.contextPath}/js/customescripts/ViewStockRefill.js"></script>