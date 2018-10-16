package ORM;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Users {
    private int idusers;
    private String username;
    private String password;
    private String isActive;
    private String loginBlock;
    private int idemployeesFk;
    private String role;
    private String companyCode;
    private Employees employeesByIdemployeesFk;

    @Id
    @Column(name = "idusers")
    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "loginBlock")
    public String getLoginBlock() {
        return loginBlock;
    }

    public void setLoginBlock(String loginBlock) {
        this.loginBlock = loginBlock;
    }

    @Basic
    @Column(name = "idemployeesFK" ,insertable = false,  updatable = false)
    public int getIdemployeesFk() {
        return idemployeesFk;
    }

    public void setIdemployeesFk(int idemployeesFk) {
        this.idemployeesFk = idemployeesFk;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        Users users = (Users) o;
        return idusers == users.idusers &&
                idemployeesFk == users.idemployeesFk &&
                Objects.equals(username, users.username) &&
                Objects.equals(password, users.password) &&
                Objects.equals(isActive, users.isActive) &&
                Objects.equals(loginBlock, users.loginBlock) &&
                Objects.equals(role, users.role) &&
                Objects.equals(companyCode, users.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idusers, username, password, isActive, loginBlock, idemployeesFk, role, companyCode);
    }

    @ManyToOne
    @JoinColumn(name = "idemployeesFK", referencedColumnName = "idemployees", nullable = false)
    public Employees getEmployeesByIdemployeesFk() {
        return employeesByIdemployeesFk;
    }

    public void setEmployeesByIdemployeesFk(Employees employeesByIdemployeesFk) {
        this.employeesByIdemployeesFk = employeesByIdemployeesFk;
    }
}
