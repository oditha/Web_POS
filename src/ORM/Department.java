package ORM;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Department {
    private int idDepartment;
    private String departmentName;
    private String isActive;
    private String createBy;
    private int idcompanyFk;
    private String companyCode;
    private Company companyByIdcompanyFk;
    private Collection<Category> categoriesByIdDepartment;

    @Id
    @Column(name = "idDepartment")
    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Basic
    @Column(name = "DepartmentName")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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
    @Column(name = "idcompanyFK" ,insertable = false,  updatable = false)
    public int getIdcompanyFk() {
        return idcompanyFk;
    }

    public void setIdcompanyFk(int idcompanyFk) {
        this.idcompanyFk = idcompanyFk;
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
        Department that = (Department) o;
        return idDepartment == that.idDepartment &&
                idcompanyFk == that.idcompanyFk &&
                Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(companyCode, that.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDepartment, departmentName, isActive, createBy, idcompanyFk, companyCode);
    }

    @ManyToOne
    @JoinColumn(name = "idcompanyFK", referencedColumnName = "idcompany", nullable = false)
    public Company getCompanyByIdcompanyFk() {
        return companyByIdcompanyFk;
    }

    public void setCompanyByIdcompanyFk(Company companyByIdcompanyFk) {
        this.companyByIdcompanyFk = companyByIdcompanyFk;
    }

    @OneToMany(mappedBy = "departmentByIdDepartmentFk")
    public Collection<Category> getCategoriesByIdDepartment() {
        return categoriesByIdDepartment;
    }

    public void setCategoriesByIdDepartment(Collection<Category> categoriesByIdDepartment) {
        this.categoriesByIdDepartment = categoriesByIdDepartment;
    }
}
