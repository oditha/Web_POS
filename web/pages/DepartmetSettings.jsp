<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/header.jsp"/>
<div class="row clearfix">
    <div class="col-md-12">
        <div class="card">
            <div class="header bg-light-blue">
                <h2>
                    Department
                    <small>Manage your departments...</small>
                </h2>
            </div>
            <div class="body">


                <form id="DepartmentForm">
                    <div class="row clearfix">
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-6">
                            <div class="form-group form-float">
                                <div class="form-line">
                                    <input class="form-control" type="text" id="departmentname" name="departmentname">
                                    <label class="form-label">Department Name</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                            <button type="button" class="btn btn-primary btn-lg m-l-15 waves-effect" id="SaveBtn">Save
                            </button>
                        </div>
                    </div>
                </form>

                <div class="row clearfix">

                    <div class="col-md-12 table-responsive">

                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Department Name</th>
                                <th>Company</th>
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


<jsp:include page="/includes/modals/ViewDepartmentName.jsp"/>
<jsp:include page="/footer.jsp"/>
<script src="${pageContext.request.contextPath}/js/customescripts/DepartmentSettings.js" type="text/javascript"></script>