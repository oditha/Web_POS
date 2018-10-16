package ORM;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Company {
    private int idcompany;
    private String comapanyName;
    private String address1;
    private String address2;
    private String city;
    private String email;
    private String contactNo1;
    private String contactNo2;
    private String isActive;
    private String createBy;
    private String companyCode;
    private Collection<Department> departmentsByIdcompany;
    private Collection<Bankaccounts> bankaccountsByIdcompany;

    @Id
    @Column(name = "idcompany")
    public int getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(int idcompany) {
        this.idcompany = idcompany;
    }

    @Basic
    @Column(name = "comapanyName")
    public String getComapanyName() {
        return comapanyName;
    }

    public void setComapanyName(String comapanyName) {
        this.comapanyName = comapanyName;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        Company Company = (Company) o;
        return idcompany == Company.idcompany &&
                Objects.equals(comapanyName, Company.comapanyName) &&
                Objects.equals(address1, Company.address1) &&
                Objects.equals(address2, Company.address2) &&
                Objects.equals(city, Company.city) &&
                Objects.equals(email, Company.email) &&
                Objects.equals(contactNo1, Company.contactNo1) &&
                Objects.equals(contactNo2, Company.contactNo2) &&
                Objects.equals(isActive, Company.isActive) &&
                Objects.equals(createBy, Company.createBy) &&
                Objects.equals(companyCode, Company.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idcompany, comapanyName, address1, address2, city, email, contactNo1, contactNo2, isActive, createBy, companyCode);
    }

    @OneToMany(mappedBy = "companyByIdcompanyFk")
    public Collection<Department> getDepartmentsByIdcompany() {
        return departmentsByIdcompany;
    }

    public void setDepartmentsByIdcompany(Collection<Department> departmentsByIdcompany) {
        this.departmentsByIdcompany = departmentsByIdcompany;
    }

    @OneToMany(mappedBy = "companyByIdcompanyFk")
    public Collection<Bankaccounts> getBankaccountsByIdcompany() {
        return bankaccountsByIdcompany;
    }

    public void setBankaccountsByIdcompany(Collection<Bankaccounts> bankaccountsByIdcompany) {
        this.bankaccountsByIdcompany = bankaccountsByIdcompany;
    }
}
