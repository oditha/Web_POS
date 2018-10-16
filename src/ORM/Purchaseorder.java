package ORM;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Purchaseorder {
    private int idporder;
    private Date poDate;
    private Double poTotal;
    private String isActive;
    private String createBy;
    private int idsuppliersFk;
    private String poNo;
    private String department;
    private String companyCode;
    private Collection<Poitems> poitemsByIdporder;
    private Suppliers suppliersByIdsuppliersFk;

    @Id
    @Column(name = "idporder")
    public int getIdporder() {
        return idporder;
    }

    public void setIdporder(int idporder) {
        this.idporder = idporder;
    }

    @Basic
    @Column(name = "poDate")
    public Date getPoDate() {
        return poDate;
    }

    public void setPoDate(Date poDate) {
        this.poDate = poDate;
    }

    @Basic
    @Column(name = "poTotal")
    public Double getPoTotal() {
        return poTotal;
    }

    public void setPoTotal(Double poTotal) {
        this.poTotal = poTotal;
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
    @Column(name = "idsuppliersFK" ,insertable = false,  updatable = false)
    public int getIdsuppliersFk() {
        return idsuppliersFk;
    }

    public void setIdsuppliersFk(int idsuppliersFk) {
        this.idsuppliersFk = idsuppliersFk;
    }

    @Basic
    @Column(name = "poNO")
    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
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
        Purchaseorder that = (Purchaseorder) o;
        return idporder == that.idporder &&
                idsuppliersFk == that.idsuppliersFk &&
                Objects.equals(poDate, that.poDate) &&
                Objects.equals(poTotal, that.poTotal) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(poNo, that.poNo) &&
                Objects.equals(department, that.department) &&
                Objects.equals(companyCode, that.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idporder, poDate, poTotal, isActive, createBy, idsuppliersFk, poNo, department, companyCode);
    }

    @OneToMany(mappedBy = "purchaseorderByIdporderFk")
    public Collection<Poitems> getPoitemsByIdporder() {
        return poitemsByIdporder;
    }

    public void setPoitemsByIdporder(Collection<Poitems> poitemsByIdporder) {
        this.poitemsByIdporder = poitemsByIdporder;
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
