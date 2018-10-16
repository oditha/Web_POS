package ORM;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Invoice {
    private int idinvoice;
    private String invoiceNo;
    private Date invoiceDate;
    private Double total;
    private Double discount;
    private Double nettotal;
    private String paymentType;
    private String isActive;
    private String createBy;
    private int idcustomerFk;
    private Timestamp invoiceTime;
    private String department;
    private String companyCode;
    private Collection<Customerpayments> customerpaymentsByIdinvoice;
    private Customers customersByIdcustomerFk;
    private Collection<Invoiceitems> invoiceitemsByIdinvoice;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idinvoice")
    public int getIdinvoice() {
        return idinvoice;
    }

    public void setIdinvoice(int idinvoice) {
        this.idinvoice = idinvoice;
    }

    @Basic
    @Column(name = "invoiceNo")
    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    @Basic
    @Column(name = "invoiceDate")
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Basic
    @Column(name = "total")
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "discount")
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "nettotal")
    public Double getNettotal() {
        return nettotal;
    }

    public void setNettotal(Double nettotal) {
        this.nettotal = nettotal;
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
    @Column(name = "invoiceTime")
    public Timestamp getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(Timestamp invoiceTime) {
        this.invoiceTime = invoiceTime;
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
        Invoice invoice = (Invoice) o;
        return idinvoice == invoice.idinvoice &&
                idcustomerFk == invoice.idcustomerFk &&
                Objects.equals(invoiceNo, invoice.invoiceNo) &&
                Objects.equals(invoiceDate, invoice.invoiceDate) &&
                Objects.equals(total, invoice.total) &&
                Objects.equals(discount, invoice.discount) &&
                Objects.equals(nettotal, invoice.nettotal) &&
                Objects.equals(paymentType, invoice.paymentType) &&
                Objects.equals(isActive, invoice.isActive) &&
                Objects.equals(createBy, invoice.createBy) &&
                Objects.equals(invoiceTime, invoice.invoiceTime) &&
                Objects.equals(department, invoice.department) &&
                Objects.equals(companyCode, invoice.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idinvoice, invoiceNo, invoiceDate, total, discount, nettotal, paymentType, isActive, createBy, idcustomerFk, invoiceTime, department, companyCode);
    }

    @OneToMany(mappedBy = "invoiceByIdinvoiceFk")
    public Collection<Customerpayments> getCustomerpaymentsByIdinvoice() {
        return customerpaymentsByIdinvoice;
    }

    public void setCustomerpaymentsByIdinvoice(Collection<Customerpayments> customerpaymentsByIdinvoice) {
        this.customerpaymentsByIdinvoice = customerpaymentsByIdinvoice;
    }

    @ManyToOne
    @JoinColumn(name = "idcustomerFK", referencedColumnName = "idcustomer", nullable = false)
    public Customers getCustomersByIdcustomerFk() {
        return customersByIdcustomerFk;
    }

    public void setCustomersByIdcustomerFk(Customers customersByIdcustomerFk) {
        this.customersByIdcustomerFk = customersByIdcustomerFk;
    }

    @OneToMany(mappedBy = "invoiceByIdinvoiceFk")
    public Collection<Invoiceitems> getInvoiceitemsByIdinvoice() {
        return invoiceitemsByIdinvoice;
    }

    public void setInvoiceitemsByIdinvoice(Collection<Invoiceitems> invoiceitemsByIdinvoice) {
        this.invoiceitemsByIdinvoice = invoiceitemsByIdinvoice;
    }
}
