<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade" tabindex="-1" role="dialog" id="departmentModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Edit Department</h4>
            </div>
            <div class="modal-body">

                <div class="row clearfix">

                    <div class="col-lg-4 col-md-2 col-sm-4 col-xs-5 form-control-label">
                        <label for="department_name">Department Name</label>
                    </div>
                    <div class="col-lg-8 col-md-10 col-sm-8 col-xs-7">
                        <div class="form-group">
                            <div class="form-line">
                                <input id="department_name" class="form-control" placeholder="Enter Department Name"
                                       type="text">
                            </div>
                        </div>
                    </div>


                </div>
                <input id="IdDepartment" class="form-control" type="text" hidden="">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger waves-effect btn-sm" id="delete">Delete</button>
                <button type="button" class="btn btn-warning waves-effect btn-sm" id="update">Update</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->