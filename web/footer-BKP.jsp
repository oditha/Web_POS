<%--
  Created by IntelliJ IDEA.
  User: oditha
  Date: 7/6/18
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</div>
</section>

<jsp:include page="/includes/modals/AddWorks.jsp"/>
<div class="modal fade" tabindex="-1" role="dialog" id="stockModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Stock Record</h4>
            </div>
            <div class="modal-body">


                <div class="row">

                    <div class="col-md-12">

                        <label for="aubqty">Available Stock</label>
                        <div class="form-group">
                            <div class="form-line">
                                <select class="selectpicker" data-live-search="true">
                                    <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                                    <option data-tokens="mustard">Burger, Shake and a Smile</option>
                                    <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                                </select>
                            </div>
                        </div>


                    </div>

                    <div class="col-md-6">
                        <label for="aubqty">Available Stock</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="product" class="form-control" placeholder="Enter your AUB QTY" type="text"
                                       name="product">
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <label for="aubqty">Available Stock</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="aubqty" class="form-control" placeholder="Enter your AUB QTY" type="text"
                                       name="aubqty">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="aubstk">Enter Quantity</label>
                        <div class="form-group">
                            <div class="form-line">
                                <input id="aubstk" class="form-control" placeholder="Enter your AUB STK" type="text"
                                       name="avbstk">
                            </div>
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


    <!-- Jquery Core Js -->
    <script src="/plugins/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="/plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Select Plugin Js -->
    <script src="/plugins/bootstrap-select/js/bootstrap-select.js"></script>

    <!-- Slimscroll Plugin Js -->
    <script src="/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="/plugins/node-waves/waves.js"></script>

    <!-- Jquery CountTo Plugin Js -->
    <script src="/plugins/jquery-countto/jquery.countTo.js"></script>

    <!-- Morris Plugin Js -->
    <script src="/plugins/raphael/raphael.min.js"></script>
    <script src="/plugins/morrisjs/morris.js"></script>

    <!-- ChartJs -->
    <script src="/plugins/chartjs/Chart.bundle.js"></script>


    <!-- Jquery DataTable Plugin Js -->
    <script src="/plugins/jquery-datatable/jquery.dataTables.js"></script>
    <script src="/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
    <script src="/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"></script>
    <script src="/plugins/jquery-datatable/extensions/export/buttons.flash.min.js"></script>
    <script src="/plugins/jquery-datatable/extensions/export/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.37/pdfmake.js"></script>
    <script src="/plugins/jquery-datatable/extensions/export/vfs_fonts.js"></script>
    <script src="/plugins/jquery-datatable/extensions/export/buttons.html5.min.js"></script>
    <script src="/plugins/jquery-datatable/extensions/export/buttons.print.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>

    <!-- Flot Charts Plugin Js -->
    <%--<script src="plugins/flot-charts/jquery.flot.js"></script>--%>
    <%--<script src="plugins/flot-charts/jquery.flot.resize.js"></script>--%>
    <%--<script src="plugins/flot-charts/jquery.flot.pie.js"></script>--%>
    <%--<script src="plugins/flot-charts/jquery.flot.categories.js"></script>--%>
    <%--<script src="plugins/flot-charts/jquery.flot.time.js"></script>--%>

    <!-- Sparkline Chart Plugin Js -->
    <script src="/plugins/jquery-sparkline/jquery.sparkline.js"></script>

    <!-- Custom Js -->
    <script src="/js/admin.js"></script>
    <%--<script src="js/pages/index.js"></script>--%>

    <!-- Demo Js -->
    <script src="/js/demo.js"></script>

    <!-- JQuery Steps Plugin Js -->
    <script src="/plugins/jquery-steps/jquery.steps.js"></script>

    <!-- Sweet Alert Plugin Js -->
    <%--<script src="/plugins/sweetalert/sweetalert.min.js"></script>--%>

    <!-- Dropzone Plugin Js -->
    <script src="/plugins/dropzone/dropzone.js"></script>

    <!-- Input Mask Plugin Js -->
    <script src="/plugins/jquery-inputmask/jquery.inputmask.bundle.js"></script>

    <!-- Multi Select Plugin Js -->
    <script src="/plugins/multi-select/js/jquery.multi-select.js"></script>

    <!-- Jquery Spinner Plugin Js -->
    <script src="/plugins/jquery-spinner/js/jquery.spinner.js"></script>

    <!-- Bootstrap Tags Input Plugin Js -->
    <script src="/plugins/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>

    <!-- noUISlider Plugin Js -->
    <script src="/plugins/nouislider/nouislider.js"></script>
    <!-- Autosize Plugin Js -->
    <script src="/plugins/autosize/autosize.js"></script>

    <!-- Moment Plugin Js -->
    <script src="/plugins/momentjs/moment.js"></script>

    <script src="/js/customescripts/footer.js"></script>

    <!-- Jquery Validation Plugin Css -->
    <script src="/plugins/jquery-validation/jquery.validate.js"></script>

    <!-- Editable Table Plugin Js -->
    <script src="/plugins/editable-table/mindmup-editabletable.js"></script>

    <!-- date-range-picker -->
    <script src="/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap datepicker -->
    <script src="/plugins/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

    </body>

    </html>
