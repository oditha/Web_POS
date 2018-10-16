package ORM;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Supplierpaymentcheque {
    private int idsupplierpaymentcheque;
    private String cequeNo;
    private Date dueDate;
    private Double amount;
    private String isActive;
    private int idsupplierpaymentsFk;
    private int idsuppliersFk;
    private String createBy;
    private int idbankaccountsFk;
    private String companyCode;
    private Supplierpayments supplierpaymentsByIdsupplierpaymentsFk;
    private Suppliers suppliersByIdsuppliersFk;
    private Bankaccounts bankaccountsByIdbankaccountsFk;

    @Id
    @Column(name = "idsupplierpaymentcheque")
    public int getIdsupplierpaymentcheque() {
        return idsupplierpaymentcheque;
    }

    public void setIdsupplierpaymentcheque(int idsupplierpaymentcheque) {
        this.idsupplierpaymentcheque = idsupplierpaymentcheque;
    }

    @Basic
    @Column(name = "cequeNo")
    public String getCequeNo() {
        return cequeNo;
    }

    public void setCequeNo(String cequeNo) {
        this.cequeNo = cequeNo;
    }

    @Basic
    @Column(name = "dueDate")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "Amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
    @Column(name = "idsupplierpaymentsFK" ,insertable = false,  updatable = false)
    public int getIdsupplierpaymentsFk() {
        return idsupplierpaymentsFk;
    }

    public void setIdsupplierpaymentsFk(int idsupplierpaymentsFk) {
        this.idsupplierpaymentsFk = idsupplierpaymentsFk;
    }

    @Basic
    @Column(name = "idsuppliersFK" ,insertable = false,  updatable = false)
    public int getIdsuppliersFk() {
        return idsuppliersFk;
    }

    public void setIdsuppliersFk(int idsuppliersFk) {
        this.idsuppliersFk = idsuppliersFk;
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
    @Column(name = "idbankaccountsFK" ,insertable = false,  updatable = false)
    public int getIdbankaccountsFk() {
        return idbankaccountsFk;
    }

    public void setIdbankaccountsFk(int idbankaccountsFk) {
        this.idbankaccountsFk = idbankaccountsFk;
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
        Supplierpaymentcheque that = (Supplierpaymentcheque) o;
        return idsupplierpaymentcheque == that.idsupplierpaymentcheque &&
                idsupplierpaymentsFk == that.idsupplierpaymentsFk &&
                idsuppliersFk == that.idsuppliersFk &&
                idbankaccountsFk == that.idbankaccountsFk &&
                Objects.equals(cequeNo, that.cequeNo) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(companyCode, that.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idsupplierpaymentcheque, cequeNo, dueDate, amount, isActive, idsupplierpaymentsFk, idsuppliersFk, createBy, idbankaccountsFk, companyCode);
    }

    @ManyToOne
    @JoinColumn(name = "idsupplierpaymentsFK", referencedColumnName = "idsupplierpayments", nullable = false)
    public Supplierpayments getSupplierpaymentsByIdsupplierpaymentsFk() {
        return supplierpaymentsByIdsupplierpaymentsFk;
    }

    public void setSupplierpaymentsByIdsupplierpaymentsFk(Supplierpayments supplierpaymentsByIdsupplierpaymentsFk) {
        this.supplierpaymentsByIdsupplierpaymentsFk = supplierpaymentsByIdsupplierpaymentsFk;
    }

    @ManyToOne
    @JoinColumn(name = "idsuppliersFK", referencedColumnName = "idsuppliers", nullable = false)
    public Suppliers getSuppliersByIdsuppliersFk() {
        return suppliersByIdsuppliersFk;
    }

    public void setSuppliersByIdsuppliersFk(Suppliers suppliersByIdsuppliersFk) {
        this.suppliersByIdsuppliersFk = suppliersByIdsuppliersFk;
    }

    @ManyToOne
    @JoinColumn(name = "idbankaccountsFK", referencedColumnName = "idbankaccounts", nullable = false)
    public Bankaccounts getBankaccountsByIdbankaccountsFk() {
        return bankaccountsByIdbankaccountsFk;
    }

    public void setBankaccountsByIdbankaccountsFk(Bankaccounts bankaccountsByIdbankaccountsFk) {
        this.bankaccountsByIdbankaccountsFk = bankaccountsByIdbankaccountsFk;
    }
}
