package ORM;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Customers {
    private int idcustomer;
    private String customersName;
    private String address1;
    private String address2;
    private String city;
    private String contactNo1;
    private String contactNo2;
    private String createBy;
    private String isActive;
    private String email;
    private String isSpecial;
    private String department;
    private String companyCode;
    private Collection<Customerpaymentcheque> customerpaymentchequesByIdcustomer;
    private Collection<Customerpayments> customerpaymentsByIdcustomer;
    private Collection<Invoice> invoicesByIdcustomer;

    @Id
    @Column(name = "idcustomer")
    public int getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }

    @Basic
    @Column(name = "customersName")
    public String getCustomersName() {
        return customersName;
    }

    public void setCustomersName(String customersName) {
        this.customersName = customersName;
    }

    @Basic
    @Column(name = "Address1")
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Basic
    @Column(name = "Address2")
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "City")
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
    @Column(name = "createBy")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "isSpecial")
    public String getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(String isSpecial) {
        this.isSpecial = isSpecial;
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
        Customers customers = (Customers) o;
        return idcustomer == customers.idcustomer &&
                Objects.equals(customersName, customers.customersName) &&
                Objects.equals(address1, customers.address1) &&
                Objects.equals(address2, customers.address2) &&
                Objects.equals(city, customers.city) &&
                Objects.equals(contactNo1, customers.contactNo1) &&
                Objects.equals(contactNo2, customers.contactNo2) &&
                Objects.equals(createBy, customers.createBy) &&
                Objects.equals(isActive, customers.isActive) &&
                Objects.equals(email, customers.email) &&
                Objects.equals(isSpecial, customers.isSpecial) &&
                Objects.equals(department, customers.department) &&
                Objects.equals(companyCode, customers.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idcustomer, customersName, address1, address2, city, contactNo1, contactNo2, createBy, isActive, email, isSpecial, department, companyCode);
    }

    @OneToMany(mappedBy = "customersByIdcustomerFk")
    public Collection<Customerpaymentcheque> getCustomerpaymentchequesByIdcustomer() {
        return customerpaymentchequesByIdcustomer;
    }

    public void setCustomerpaymentchequesByIdcustomer(Collection<Customerpaymentcheque> customerpaymentchequesByIdcustomer) {
        this.customerpaymentchequesByIdcustomer = customerpaymentchequesByIdcustomer;
    }

    @OneToMany(mappedBy = "customersByIdcustomerFk")
    public Collection<Customerpayments> getCustomerpaymentsByIdcustomer() {
        return customerpaymentsByIdcustomer;
    }

    public void setCustomerpaymentsByIdcustomer(Collection<Customerpayments> customerpaymentsByIdcustomer) {
        this.customerpaymentsByIdcustomer = customerpaymentsByIdcustomer;
    }

    @OneToMany(mappedBy = "customersByIdcustomerFk")
    public Collection<Invoice> getInvoicesByIdcustomer() {
        return invoicesByIdcustomer;
    }

    public void setInvoicesByIdcustomer(Collection<Invoice> invoicesByIdcustomer) {
        this.invoicesByIdcustomer = invoicesByIdcustomer;
    }
}
