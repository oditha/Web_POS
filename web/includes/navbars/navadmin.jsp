<%--
  Created by IntelliJ IDEA.
  User: oditha
  Date: 7/6/18
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:include page="/includes/modals/StartUpModel.jsp">--%>
<div class="menu">
    <ul class="list">
        <li class="header">MAIN NAVIGATION</li>
        <li class="active">
            <a href="dashboard">
                <i class="material-icons">home</i>
                <span>Home</span>
            </a>
        </li>
        <li>
            <a href="AddInvoice">
                <i class="material-icons">text_fields</i>
                <span>Invoice</span>
            </a>
        </li>
        <li>
            <a id="works">
                <i class="material-icons">text_fields</i>
                <span>Add Work</span>
            </a>
        </li>

        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons">swap_calls</i>
                <span>Products</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="AddProducts">Add Products</a>
                </li>
                <li>
                    <a href="ViewProducts">View Products</a>
                </li>
                <li>
                    <a href="AddCategory">Categories</a>
                </li>

            </ul>
        </li>
        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons">assignment</i>
                <span>Stock</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="ViewStock">View Stock</a>
                </li>
                <li>
                    <a id="stockrecord">Add Stock Record</a>
                </li>
                <li>
                    <a href="ViewStockRecord">View Stock Records</a>
                </li>
                <li>
                    <a href="ViewReorderRemainder">Reorder Reminder</a>
                </li>

            </ul>
        </li>
        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons">view_list</i>
                <span>Good Receive Notice</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="AddGrn">Add GRN</a>
                </li>
                <li>
                    <a href="ViewGrn">View GRN</a>
                </li>

            </ul>
        </li>
        <%--<li disabled="">--%>
            <%--<a href="javascript:void(0);" class="menu-toggle">--%>
                <%--<i class="material-icons">perm_media</i>--%>
                <%--<span>Purchase Order</span>--%>
            <%--</a>--%>
            <%--<ul class="ml-menu">--%>
                <%--<li>--%>
                    <%--<a href="AddPo">Add PO</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="ViewPo">View PO</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</li>--%>
        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons">pie_chart</i>
                <span>Payments</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="AddCustomerPayments">Customers Payments</a>
                </li>
                <li>
                    <a href="AddSupplierPayment">Supplier Payments</a>
                </li>
                <li>
                    <a href="ViewCustomerPaymentHistory">Customer Payment History</a>
                </li>
                <li>
                    <a href="ViewSupplierPaymentHistory">Supplier Payment History</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons">content_copy</i>
                <span>Customers</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="AddCustomers">Add Customers</a>
                </li>
                <li>
                    <a href="ViewCustomerOutstanding">Customer Outstanding</a>
                </li>

            </ul>
        </li>

        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons">content_copy</i>
                <span>Suppliers</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="AddSuppliers">Manage Suppliers</a>
                </li>
                <li>
                    <a href="ViewSupplierOutstanding">Suppliers Outstanding</a>
                </li>

            </ul>
        </li>

        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons">map</i>
                <span>Reports</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="ViewWorks">View Works</a>
                </li>
                <li>
                    <a href="ViewInvoice">View Invoices</a>
                </li>
                <li>
                    <a href="ViewSalesSummery">Sales Summery</a>
                </li>
                <li>
                    <a href="ViewSalesLedger">Sales Ledger</a>
                </li>
                <li>
                    <a href="ViewProductMoving">Products Moving</a>
                </li>

            </ul>
        </li>

        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons">map</i>
                <span>Accounting</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="ViewBankAccount">Bank Accounts</a>
                </li>
                <li>
                    <a href="ViewCheque">Cheque Management</a>
                </li>
                <li>
                    <a href="ViewCashBook">Cash Book</a>
                </li>
                <li>
                    <a href="ViewCashBookCategories">Acc Categories</a>
                </li>

            </ul>
        </li>

        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons">map</i>
                <span>Settings</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="CompanySettings">Company Settings</a>
                </li>
                <li>
                    <a href="DepartmentSettings">Department Settings</a>
                </li>
                <li>
                    <a href="UserSettings">User Settings</a>
                </li>

            </ul>
        </li>

    </ul>
</div>

