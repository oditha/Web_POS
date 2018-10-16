package ORM;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Supplierpayments {
    private int idsupplierpayments;
    private Date paymentDate;
    private String paymentType;
    private Double amount;
    private String isActive;
    private String createBy;
    private int idGrnfk;
    private int idsuppliersFk;
    private String companyCode;
    private Collection<Supplierpaymentcheque> supplierpaymentchequesByIdsupplierpayments;
    private Grn grnByIdGrnfk;
    private Suppliers suppliersByIdsuppliersFk;

    @Id
    @Column(name = "idsupplierpayments")
    public int getIdsupplierpayments() {
        return idsupplierpayments;
    }

    public void setIdsupplierpayments(int idsupplierpayments) {
        this.idsupplierpayments = idsupplierpayments;
    }

    @Basic
    @Column(name = "paymentDate")
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Basic
    @Column(name = "PaymentType")
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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
    @Column(name = "createBy")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "idGRNFK" ,insertable = false,  updatable = false)
    public int getIdGrnfk() {
        return idGrnfk;
    }

    public void setIdGrnfk(int idGrnfk) {
        this.idGrnfk = idGrnfk;
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
        Supplierpayments that = (Supplierpayments) o;
        return idsupplierpayments == that.idsupplierpayments &&
                idGrnfk == that.idGrnfk &&
                idsuppliersFk == that.idsuppliersFk &&
                Objects.equals(paymentDate, that.paymentDate) &&
                Objects.equals(paymentType, that.paymentType) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(companyCode, that.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idsupplierpayments, paymentDate, paymentType, amount, isActive, createBy, idGrnfk, idsuppliersFk, companyCode);
    }

    @OneToMany(mappedBy = "supplierpaymentsByIdsupplierpaymentsFk")
    public Collection<Supplierpaymentcheque> getSupplierpaymentchequesByIdsupplierpayments() {
        return supplierpaymentchequesByIdsupplierpayments;
    }

    public void setSupplierpaymentchequesByIdsupplierpayments(Collection<Supplierpaymentcheque> supplierpaymentchequesByIdsupplierpayments) {
        this.supplierpaymentchequesByIdsupplierpayments = supplierpaymentchequesByIdsupplierpayments;
    }

    @ManyToOne
    @JoinColumn(name = "idGRNFK", referencedColumnName = "idGRN", nullable = false)
    public Grn getGrnByIdGrnfk() {
        return grnByIdGrnfk;
    }

    public void setGrnByIdGrnfk(Grn grnByIdGrnfk) {
        this.grnByIdGrnfk = grnByIdGrnfk;
    }

    @ManyToOne
    @JoinColumn(name = "idsuppliersFK", referencedColumnName = "idsuppliers", nullable = false)
    public Suppliers getSuppliersByIdsuppliersFk() {
        return suppliersByIdsuppliersFk;
    }

    public void setSuppliersByIdsuppliersFk(Suppliers suppliersByIdsuppliersFk) {
        this.suppliersByIdsuppliersFk = suppliersByIdsuppliersFk;
    }
}
