<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" tabindex="-1" role="dialog" id="worksModel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Add Works</h4>
            </div>
            <div class="modal-body">

                <form id="worksForm">
                    <div class="row">

                        <div class="col-md-6">

                            <label for="account">Account</label>
                            <select class="form-control" id="account" name="account">
                                <option>Fiverr_GSANDARU</option>
                                <option>Fiverr_DILL</option>
                                <option>Fiverr_ODK</option>
                                <option>Upwork</option>
                                <option>Sri_Lanka</option>

                            </select>

                        </div>
                        <div class="col-md-6">

                            <label for="orderno">Order No</label>
                            <div class="form-group">
                                <div class="form-line">
                                    <input id="orderno" class="form-control" placeholder="Enter Order No"
                                           type="text"
                                           name="orderno">

                                </div>
                            </div>

                        </div>

                    </div>

                    <div class="row">

                        <div class="col-md-6">

                            <label for="type">Type</label>
                            <select class="form-control" id="type" name="type">

                                <option>New Order</option>
                                <option>Modification</option>

                            </select>

                        </div>
                        <div class="col-md-6">

                            <label for="updateno">Update No</label>

                            <div class="input-group spinner" data-trigger="spinner">
                                <div class="form-line">
                                    <input class="form-control text-center spinnumber required" value="0"
                                           data-rule="updateno"
                                           type="text" id="updateno" name="updateno">
                                </div>
                                <span class="input-group-addon">
                                            <a href="javascript:;" class="spin-up" data-spin="up"><i
                                                    class="glyphicon glyphicon-chevron-up"></i></a>
                                            <a href="javascript:;" class="spin-down" data-spin="down"><i
                                                    class="glyphicon glyphicon-chevron-down"></i></a>
                                        </span>
                            </div>

                        </div>

                    </div>


            </div>
            </form>
            <div class="modal-footer">
                <div class="pull-right">
                    <button type="button" class="btn btn-primary" id="saveWorks">Save</button>
                </div>
            </div>
        </div>
    </div>
</div>
