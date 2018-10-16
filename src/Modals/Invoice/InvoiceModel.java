package Modals.Invoice;

public class InvoiceModel {


    private String tabledata, idSupplier, grnno, grndate, grntotal, paid, paytype, idInvoice, discount, netttotal;

    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getNetttotal() {
        return netttotal;
    }

    public void setNetttotal(String netttotal) {
        this.netttotal = netttotal;
    }

    public String getTabledata() {
        return tabledata;
    }

    public void setTabledata(String tabledata) {
        this.tabledata = tabledata;
    }

    public String getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(String idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getGrnno() {
        return grnno;
    }

    public void setGrnno(String grnno) {
        this.grnno = grnno;
    }

    public String getGrndate() {
        return grndate;
    }

    public void setGrndate(String grndate) {
        this.grndate = grndate;
    }

    public String getGrntotal() {
        return grntotal;
    }

    public void setGrntotal(String grntotal) {
        this.grntotal = grntotal;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }
}
