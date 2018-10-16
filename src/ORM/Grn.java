package ORM;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Grn {
    private int idGrn;
    private Date grnDate;
    private Double grnTotal;
    private Double grnDiscount;
    private Double grnNettotal;
    private String isActive;
    private String createBy;
    private String paymentType;
    private int idsuppliersFk;
    private String grnNo;
    private String department;
    private String companyCode;
    private Suppliers suppliersByIdsuppliersFk;
    private Collection<GrnItems> grnItemsByIdGrn;
    private Collection<Supplierpayments> supplierpaymentsByIdGrn;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idGRN", unique = true)
    public int getIdGrn() {
        return idGrn;
    }

    public void setIdGrn(int idGrn) {
        this.idGrn = idGrn;
    }

    @Basic
    @Column(name = "grnDate")
    public Date getGrnDate() {
        return grnDate;
    }

    public void setGrnDate(Date grnDate) {
        this.grnDate = grnDate;
    }

    @Basic
    @Column(name = "grnTotal")
    public Double getGrnTotal() {
        return grnTotal;
    }

    public void setGrnTotal(Double grnTotal) {
        this.grnTotal = grnTotal;
    }

    @Basic
    @Column(name = "grnDiscount")
    public Double getGrnDiscount() {
        return grnDiscount;
    }

    public void setGrnDiscount(Double grnDiscount) {
        this.grnDiscount = grnDiscount;
    }

    @Basic
    @Column(name = "grnNettotal")
    public Double getGrnNettotal() {
        return grnNettotal;
    }

    public void setGrnNettotal(Double grnNettotal) {
        this.grnNettotal = grnNettotal;
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
    @Column(name = "PaymentType")
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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
    @Column(name = "GRNNo")
    public String getGrnNo() {
        return grnNo;
    }

    public void setGrnNo(String grnNo) {
        this.grnNo = grnNo;
    }

    @Basic
    @Column(name = "Department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
        Grn grn = (Grn) o;
        return idGrn == grn.idGrn &&
                idsuppliersFk == grn.idsuppliersFk &&
                Objects.equals(grnDate, grn.grnDate) &&
                Objects.equals(grnTotal, grn.grnTotal) &&
                Objects.equals(grnDiscount, grn.grnDiscount) &&
                Objects.equals(grnNettotal, grn.grnNettotal) &&
                Objects.equals(isActive, grn.isActive) &&
                Objects.equals(createBy, grn.createBy) &&
                Objects.equals(paymentType, grn.paymentType) &&
                Objects.equals(grnNo, grn.grnNo) &&
                Objects.equals(department, grn.department) &&
                Objects.equals(companyCode, grn.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idGrn, grnDate, grnTotal, grnDiscount, grnNettotal, isActive, createBy, paymentType, idsuppliersFk, grnNo, department, companyCode);
    }

    @ManyToOne
    @JoinColumn(name = "idsuppliersFK", referencedColumnName = "idsuppliers", nullable = false)
    public Suppliers getSuppliersByIdsuppliersFk() {
        return suppliersByIdsuppliersFk;
    }

    public void setSuppliersByIdsuppliersFk(Suppliers suppliersByIdsuppliersFk) {
        this.suppliersByIdsuppliersFk = suppliersByIdsuppliersFk;
    }

    @OneToMany(mappedBy = "grnByIdGrnfk")
    public Collection<GrnItems> getGrnItemsByIdGrn() {
        return grnItemsByIdGrn;
    }

    public void setGrnItemsByIdGrn(Collection<GrnItems> grnItemsByIdGrn) {
        this.grnItemsByIdGrn = grnItemsByIdGrn;
    }

    @OneToMany(mappedBy = "grnByIdGrnfk")
    public Collection<Supplierpayments> getSupplierpaymentsByIdGrn() {
        return supplierpaymentsByIdGrn;
    }

    public void setSupplierpaymentsByIdGrn(Collection<Supplierpayments> supplierpaymentsByIdGrn) {
        this.supplierpaymentsByIdGrn = supplierpaymentsByIdGrn;
    }
}
