package ORM;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Suppliers {
    private int idsuppliers;
    private String supplierName;
    private String supplierAddress1;
    private String supplierAddress2;
    private String city;
    private String contactNo1;
    private String contactNo2;
    private String emailAdress;
    private String contactPerson;
    private String isActive;
    private String createBy;
    private String department;
    private String companyCode;
    private Collection<Grn> grnsByIdsuppliers;
    private Collection<Purchaseorder> purchaseordersByIdsuppliers;
    private Collection<Supplierpaymentcheque> supplierpaymentchequesByIdsuppliers;
    private Collection<Supplierpayments> supplierpaymentsByIdsuppliers;

    @Id
    @Column(name = "idsuppliers")
    public int getIdsuppliers() {
        return idsuppliers;
    }

    public void setIdsuppliers(int idsuppliers) {
        this.idsuppliers = idsuppliers;
    }

    @Basic
    @Column(name = "supplierName")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "supplierAddress1")
    public String getSupplierAddress1() {
        return supplierAddress1;
    }

    public void setSupplierAddress1(String supplierAddress1) {
        this.supplierAddress1 = supplierAddress1;
    }

    @Basic
    @Column(name = "supplierAddress2")
    public String getSupplierAddress2() {
        return supplierAddress2;
    }

    public void setSupplierAddress2(String supplierAddress2) {
        this.supplierAddress2 = supplierAddress2;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "contactNo1")
    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }

    @Basic
    @Column(name = "contactNo2")
    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }

    @Basic
    @Column(name = "emailAdress")
    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    @Basic
    @Column(name = "contactPerson")
    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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
    @Column(name = "department")
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
        Suppliers suppliers = (Suppliers) o;
        return idsuppliers == suppliers.idsuppliers &&
                Objects.equals(supplierName, suppliers.supplierName) &&
                Objects.equals(supplierAddress1, suppliers.supplierAddress1) &&
                Objects.equals(supplierAddress2, suppliers.supplierAddress2) &&
                Objects.equals(city, suppliers.city) &&
                Objects.equals(contactNo1, suppliers.contactNo1) &&
                Objects.equals(contactNo2, suppliers.contactNo2) &&
                Objects.equals(emailAdress, suppliers.emailAdress) &&
                Objects.equals(contactPerson, suppliers.contactPerson) &&
                Objects.equals(isActive, suppliers.isActive) &&
                Objects.equals(createBy, suppliers.createBy) &&
                Objects.equals(department, suppliers.department) &&
                Objects.equals(companyCode, suppliers.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idsuppliers, supplierName, supplierAddress1, supplierAddress2, city, contactNo1, contactNo2, emailAdress, contactPerson, isActive, createBy, department, companyCode);
    }

    @OneToMany(mappedBy = "suppliersByIdsuppliersFk")
    public Collection<Grn> getGrnsByIdsuppliers() {
        return grnsByIdsuppliers;
    }

    public void setGrnsByIdsuppliers(Collection<Grn> grnsByIdsuppliers) {
        this.grnsByIdsuppliers = grnsByIdsuppliers;
    }

    @OneToMany(mappedBy = "suppliersByIdsuppliersFk")
    public Collection<Purchaseorder> getPurchaseordersByIdsuppliers() {
        return purchaseordersByIdsuppliers;
    }

    public void setPurchaseordersByIdsuppliers(Collection<Purchaseorder> purchaseordersByIdsuppliers) {
        this.purchaseordersByIdsuppliers = purchaseordersByIdsuppliers;
    }

    @OneToMany(mappedBy = "suppliersByIdsuppliersFk")
    public Collection<Supplierpaymentcheque> getSupplierpaymentchequesByIdsuppliers() {
        return supplierpaymentchequesByIdsuppliers;
    }

    public void setSupplierpaymentchequesByIdsuppliers(Collection<Supplierpaymentcheque> supplierpaymentchequesByIdsuppliers) {
        this.supplierpaymentchequesByIdsuppliers = supplierpaymentchequesByIdsuppliers;
    }

    @OneToMany(mappedBy = "suppliersByIdsuppliersFk")
    public Collection<Supplierpayments> getSupplierpaymentsByIdsuppliers() {
        return supplierpaymentsByIdsuppliers;
    }

    public void setSupplierpaymentsByIdsuppliers(Collection<Supplierpayments> supplierpaymentsByIdsuppliers) {
        this.supplierpaymentsByIdsuppliers = supplierpaymentsByIdsuppliers;
    }
}
