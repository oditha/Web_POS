package ORM;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Customerpayments {
    private int idcustomerpayments;
    private Date paymentDate;
    private String paymentType;
    private Double amount;
    private String isActive;
    private String createBy;
    private int idcustomerFk;
    private int idinvoiceFk;
    private String companyCode;
    private Collection<Customerpaymentcheque> customerpaymentchequesByIdcustomerpayments;
    private Customers customersByIdcustomerFk;
    private Invoice invoiceByIdinvoiceFk;

    @Id
    @Column(name = "idcustomerpayments")
    public int getIdcustomerpayments() {
        return idcustomerpayments;
    }

    public void setIdcustomerpayments(int idcustomerpayments) {
        this.idcustomerpayments = idcustomerpayments;
    }

    @Basic
    @Column(name = "paymentDate")
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Basic
    @Column(name = "PaymentType")
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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
    @Column(name = "idcustomerFK" ,insertable = false,  updatable = false)
    public int getIdcustomerFk() {
        return idcustomerFk;
    }

    public void setIdcustomerFk(int idcustomerFk) {
        this.idcustomerFk = idcustomerFk;
    }

    @Basic
    @Column(name = "idinvoiceFK" ,insertable = false,  updatable = false)
    public int getIdinvoiceFk() {
        return idinvoiceFk;
    }

    public void setIdinvoiceFk(int idinvoiceFk) {
        this.idinvoiceFk = idinvoiceFk;
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
        Customerpayments that = (Customerpayments) o;
        return idcustomerpayments == that.idcustomerpayments &&
                idcustomerFk == that.idcustomerFk &&
                idinvoiceFk == that.idinvoiceFk &&
                Objects.equals(paymentDate, that.paymentDate) &&
                Objects.equals(paymentType, that.paymentType) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(companyCode, that.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idcustomerpayments, paymentDate, paymentType, amount, isActive, createBy, idcustomerFk, idinvoiceFk, companyCode);
    }

    @OneToMany(mappedBy = "customerpaymentsByIdcustomerpaymentsFk")
    public Collection<Customerpaymentcheque> getCustomerpaymentchequesByIdcustomerpayments() {
        return customerpaymentchequesByIdcustomerpayments;
    }

    public void setCustomerpaymentchequesByIdcustomerpayments(Collection<Customerpaymentcheque> customerpaymentchequesByIdcustomerpayments) {
        this.customerpaymentchequesByIdcustomerpayments = customerpaymentchequesByIdcustomerpayments;
    }

    @ManyToOne
    @JoinColumn(name = "idcustomerFK", referencedColumnName = "idcustomer", nullable = false)
    public Customers getCustomersByIdcustomerFk() {
        return customersByIdcustomerFk;
    }

    public void setCustomersByIdcustomerFk(Customers customersByIdcustomerFk) {
        this.customersByIdcustomerFk = customersByIdcustomerFk;
    }

    @ManyToOne
    @JoinColumn(name = "idinvoiceFK", referencedColumnName = "idinvoice", nullable = false)
    public Invoice getInvoiceByIdinvoiceFk() {
        return invoiceByIdinvoiceFk;
    }

    public void setInvoiceByIdinvoiceFk(Invoice invoiceByIdinvoiceFk) {
        this.invoiceByIdinvoiceFk = invoiceByIdinvoiceFk;
    }
}
