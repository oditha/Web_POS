
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" tabindex="-1" role="dialog" id="stockModalODL">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Stock Record</h4>
            </div>
            <div class="modal-body">
                <div class="dropdown">
                    <button id="selectproduct" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Dropdown trigger
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="selectproduct">
                        ...
                    </ul>
                </div>
            </div>
            <div class="col-md-6">
                    <label for="aubqty">AUB QTY</label>
                    <div class="form-group">
                        <div class="form-line">
                            <input id="aubqty" class="form-control" placeholder="Enter your AUB QTY" type="text" name="aubqty">
                        </div>
                    </div>
                </div>
            <div class="col-md-6">
                <label for="aubstk">AUB STK</label>
                <div class="form-group">
                    <div class="form-line">
                        <input id="aubstk" class="form-control" placeholder="Enter your AUB STK" type="text" name="aubstk">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="pull-right">
                <button type="button" class="btn btn-primary">Save</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
</div>