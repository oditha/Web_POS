package ORM;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Cashbook {
    private int idcashbook;
    private Date recordDate;
    private String description;
    private Double income;
    private Double expense;
    private String isActive;
    private String createBy;
    private int idcashbooktypesFk;
    private String department;
    private String companyCode;
    private Cashbooktypes cashbooktypesByIdcashbooktypesFk;

    @Id
    @Column(name = "idcashbook")
    public int getIdcashbook() {
        return idcashbook;
    }

    public void setIdcashbook(int idcashbook) {
        this.idcashbook = idcashbook;
    }

    @Basic
    @Column(name = "recordDate")
    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "income")
    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    @Basic
    @Column(name = "expense")
    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
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
    @Column(name = "idcashbooktypesFK" ,insertable = false,  updatable = false)
    public int getIdcashbooktypesFk() {
        return idcashbooktypesFk;
    }

    public void setIdcashbooktypesFk(int idcashbooktypesFk) {
        this.idcashbooktypesFk = idcashbooktypesFk;
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
        Cashbook cashbook = (Cashbook) o;
        return idcashbook == cashbook.idcashbook &&
                idcashbooktypesFk == cashbook.idcashbooktypesFk &&
                Objects.equals(recordDate, cashbook.recordDate) &&
                Objects.equals(description, cashbook.description) &&
                Objects.equals(income, cashbook.income) &&
                Objects.equals(expense, cashbook.expense) &&
                Objects.equals(isActive, cashbook.isActive) &&
                Objects.equals(createBy, cashbook.createBy) &&
                Objects.equals(department, cashbook.department) &&
                Objects.equals(companyCode, cashbook.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idcashbook, recordDate, description, income, expense, isActive, createBy, idcashbooktypesFk, department, companyCode);
    }

    @ManyToOne
    @JoinColumn(name = "idcashbooktypesFK", referencedColumnName = "idcashbooktypes", nullable = false)
    public Cashbooktypes getCashbooktypesByIdcashbooktypesFk() {
        return cashbooktypesByIdcashbooktypesFk;
    }

    public void setCashbooktypesByIdcashbooktypesFk(Cashbooktypes cashbooktypesByIdcashbooktypesFk) {
        this.cashbooktypesByIdcashbooktypesFk = cashbooktypesByIdcashbooktypesFk;
    }
}
