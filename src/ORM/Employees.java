package ORM;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Employees {
    private int idemployees;
    private String nic;
    private String firstName;
    private String lastName;
    private String emailAdress;
    private String contactNo1;
    private String contactNo2;
    private String isActive;
    private String createBy;
    private String companyCode;
    private Collection<Stockmaintain> stockmaintainsByIdemployees;
    private Collection<Users> usersByIdemployees;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idemployees")
    public int getIdemployees() {
        return idemployees;
    }

    public void setIdemployees(int idemployees) {
        this.idemployees = idemployees;
    }

    @Basic
    @Column(name = "NIC")
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Basic
    @Column(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        Employees employees = (Employees) o;
        return idemployees == employees.idemployees &&
                Objects.equals(nic, employees.nic) &&
                Objects.equals(firstName, employees.firstName) &&
                Objects.equals(lastName, employees.lastName) &&
                Objects.equals(emailAdress, employees.emailAdress) &&
                Objects.equals(contactNo1, employees.contactNo1) &&
                Objects.equals(contactNo2, employees.contactNo2) &&
                Objects.equals(isActive, employees.isActive) &&
                Objects.equals(createBy, employees.createBy) &&
                Objects.equals(companyCode, employees.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idemployees, nic, firstName, lastName, emailAdress, contactNo1, contactNo2, isActive, createBy, companyCode);
    }

    @OneToMany(mappedBy = "employeesByIdemployeesFk")
    public Collection<Stockmaintain> getStockmaintainsByIdemployees() {
        return stockmaintainsByIdemployees;
    }

    public void setStockmaintainsByIdemployees(Collection<Stockmaintain> stockmaintainsByIdemployees) {
        this.stockmaintainsByIdemployees = stockmaintainsByIdemployees;
    }

    @OneToMany(mappedBy = "employeesByIdemployeesFk")
    public Collection<Users> getUsersByIdemployees() {
        return usersByIdemployees;
    }

    public void setUsersByIdemployees(Collection<Users> usersByIdemployees) {
        this.usersByIdemployees = usersByIdemployees;
    }
}
