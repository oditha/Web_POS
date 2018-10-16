package ORM;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Customerpaymentcheque {
    private int idcustomerpaymentc;
    private String chequeno;
    private Date dueDate;
    private Double amount;
    private String isActive;
    private String createBy;
    private int idcustomerpaymentsFk;
    private int idcustomerFk;
    private String companyCode;
    private Customerpayments customerpaymentsByIdcustomerpaymentsFk;
    private Customers customersByIdcustomerFk;

    @Id
    @Column(name = "idcustomerpaymentc")
    public int getIdcustomerpaymentc() {
        return idcustomerpaymentc;
    }

    public void setIdcustomerpaymentc(int idcustomerpaymentc) {
        this.idcustomerpaymentc = idcustomerpaymentc;
    }

    @Basic
    @Column(name = "chequeno")
    public String getChequeno() {
        return chequeno;
    }

    public void setChequeno(String chequeno) {
        this.chequeno = chequeno;
    }

    @Basic
    @Column(name = "dueDate")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "Amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
    @Column(name = "idcustomerpaymentsFK" ,insertable = false,  updatable = false)
    public int getIdcustomerpaymentsFk() {
        return idcustomerpaymentsFk;
    }

    public void setIdcustomerpaymentsFk(int idcustomerpaymentsFk) {
        this.idcustomerpaymentsFk = idcustomerpaymentsFk;
    }

    @Basic
    @Column(name = "idcustomerFK" ,insertable = false,  updatable = false)
    public int getIdcustomerFk() {
        return idcustomerFk;
    }

    public void setIdcustomerFk(int idcustomerFk) {
        this.idcustomerFk = idcustomerFk;
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
        Customerpaymentcheque that = (Customerpaymentcheque) o;
        return idcustomerpaymentc == that.idcustomerpaymentc &&
                idcustomerpaymentsFk == that.idcustomerpaymentsFk &&
                idcustomerFk == that.idcustomerFk &&
                Objects.equals(chequeno, that.chequeno) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(companyCode, that.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idcustomerpaymentc, chequeno, dueDate, amount, isActive, createBy, idcustomerpaymentsFk, idcustomerFk, companyCode);
    }

    @ManyToOne
    @JoinColumn(name = "idcustomerpaymentsFK", referencedColumnName = "idcustomerpayments", nullable = false)
    public Customerpayments getCustomerpaymentsByIdcustomerpaymentsFk() {
        return customerpaymentsByIdcustomerpaymentsFk;
    }

    public void setCustomerpaymentsByIdcustomerpaymentsFk(Customerpayments customerpaymentsByIdcustomerpaymentsFk) {
        this.customerpaymentsByIdcustomerpaymentsFk = customerpaymentsByIdcustomerpaymentsFk;
    }

    @ManyToOne
    @JoinColumn(name = "idcustomerFK", referencedColumnName = "idcustomer", nullable = false)
    public Customers getCustomersByIdcustomerFk() {
        return customersByIdcustomerFk;
    }

    public void setCustomersByIdcustomerFk(Customers customersByIdcustomerFk) {
        this.customersByIdcustomerFk = customersByIdcustomerFk;
    }
}
