package ORM;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Category {
    private int idcategory;
    private String categoryCode;
    private String categoryname;
    private String categoryType;
    private String isActive;
    private String createBy;
    private int idDepartmentFk;
    private String companyCode;
    private Department departmentByIdDepartmentFk;
    private Collection<Products> productsByIdcategory;

    @Id
    @Column(name = "idcategory")
    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    @Basic
    @Column(name = "categoryCode")
    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Basic
    @Column(name = "categoryname")
    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Basic
    @Column(name = "categoryType")
    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
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
    @Column(name = "idDepartmentFK" ,insertable = false,  updatable = false)
    public int getIdDepartmentFk() {
        return idDepartmentFk;
    }

    public void setIdDepartmentFk(int idDepartmentFk) {
        this.idDepartmentFk = idDepartmentFk;
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
        Category category = (Category) o;
        return idcategory == category.idcategory &&
                idDepartmentFk == category.idDepartmentFk &&
                Objects.equals(categoryCode, category.categoryCode) &&
                Objects.equals(categoryname, category.categoryname) &&
                Objects.equals(categoryType, category.categoryType) &&
                Objects.equals(isActive, category.isActive) &&
                Objects.equals(createBy, category.createBy) &&
                Objects.equals(companyCode, category.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idcategory, categoryCode, categoryname, categoryType, isActive, createBy, idDepartmentFk, companyCode);
    }

    @ManyToOne
    @JoinColumn(name = "idDepartmentFK", referencedColumnName = "idDepartment", nullable = false)
    public Department getDepartmentByIdDepartmentFk() {
        return departmentByIdDepartmentFk;
    }

    public void setDepartmentByIdDepartmentFk(Department departmentByIdDepartmentFk) {
        this.departmentByIdDepartmentFk = departmentByIdDepartmentFk;
    }

    @OneToMany(mappedBy = "categoryByIdcategoryFk")
    public Collection<Products> getProductsByIdcategory() {
        return productsByIdcategory;
    }

    public void setProductsByIdcategory(Collection<Products> productsByIdcategory) {
        this.productsByIdcategory = productsByIdcategory;
    }
}
