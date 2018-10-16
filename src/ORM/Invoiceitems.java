package ORM;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Invoiceitems {
    private int idinvoiceitem;
    private Double qty;
    private Double unitPrice;
    private Double lineTotal;
    private String isActive;
    private String createBy;
    private int idinvoiceFk;
    private int idproductsFk;
    private String companyCode;
    private Invoice invoiceByIdinvoiceFk;
    private Products productsByIdproductsFk;

    @Id
    @Column(name = "idinvoiceitem")
    public int getIdinvoiceitem() {
        return idinvoiceitem;
    }

    public void setIdinvoiceitem(int idinvoiceitem) {
        this.idinvoiceitem = idinvoiceitem;
    }

    @Basic
    @Column(name = "qty")
    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "unitPrice")
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "lineTotal")
    public Double getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(Double lineTotal) {
        this.lineTotal = lineTotal;
    }

    @Basic
    @Column(name = "isActive")
    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "createBy")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "idinvoiceFK" ,insertable = false,  updatable = false)
    public int getIdinvoiceFk() {
        return idinvoiceFk;
    }

    public void setIdinvoiceFk(int idinvoiceFk) {
        this.idinvoiceFk = idinvoiceFk;
    }

    @Basic
    @Column(name = "idproductsFK" ,insertable = false,  updatable = false)
    public int getIdproductsFk() {
        return idproductsFk;
    }

    public void setIdproductsFk(int idproductsFk) {
        this.idproductsFk = idproductsFk;
    }

    @Basic
    @Column(name = "CompanyCode")
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoiceitems that = (Invoiceitems) o;
        return idinvoiceitem == that.idinvoiceitem &&
                idinvoiceFk == that.idinvoiceFk &&
                idproductsFk == that.idproductsFk &&
                Objects.equals(qty, that.qty) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(lineTotal, that.lineTotal) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(companyCode, that.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idinvoiceitem, qty, unitPrice, lineTotal, isActive, createBy, idinvoiceFk, idproductsFk, companyCode);
    }

    @ManyToOne
    @JoinColumn(name = "idinvoiceFK", referencedColumnName = "idinvoice", nullable = false)
    public Invoice getInvoiceByIdinvoiceFk() {
        return invoiceByIdinvoiceFk;
    }

    public void setInvoiceByIdinvoiceFk(Invoice invoiceByIdinvoiceFk) {
        this.invoiceByIdinvoiceFk = invoiceByIdinvoiceFk;
    }

    @ManyToOne
    @JoinColumn(name = "idproductsFK", referencedColumnName = "idproducts", nullable = false)
    public Products getProductsByIdproductsFk() {
        return productsByIdproductsFk;
    }

    public void setProductsByIdproductsFk(Products productsByIdproductsFk) {
        this.productsByIdproductsFk = productsByIdproductsFk;
    }
}
