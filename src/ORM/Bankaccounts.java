package ORM;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Bankaccounts {
    private int idbankaccounts;
    private String bankName;
    private String branch;
    private String accountNo;
    private String accType;
    private String isActive;
    private String createBy;
    private int idcompanyFk;
    private String companyCode;
    private Company companyByIdcompanyFk;
    private Collection<Supplierpaymentcheque> supplierpaymentchequesByIdbankaccounts;

    @Id
    @Column(name = "idbankaccounts")
    public int getIdbankaccounts() {
        return idbankaccounts;
    }

    public void setIdbankaccounts(int idbankaccounts) {
        this.idbankaccounts = idbankaccounts;
    }

    @Basic
    @Column(name = "bankName")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "branch")
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Basic
    @Column(name = "accountNo")
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Basic
    @Column(name = "accType")
    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
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
    @Column(name = "idcompanyFK", insertable = false,  updatable = false)
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
        Bankaccounts that = (Bankaccounts) o;
        return idbankaccounts == that.idbankaccounts &&
                idcompanyFk == that.idcompanyFk &&
                Objects.equals(bankName, that.bankName) &&
                Objects.equals(branch, that.branch) &&
                Objects.equals(accountNo, that.accountNo) &&
                Objects.equals(accType, that.accType) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(companyCode, that.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idbankaccounts, bankName, branch, accountNo, accType, isActive, createBy, idcompanyFk, companyCode);
    }

    @ManyToOne
    @JoinColumn(name = "idcompanyFK", referencedColumnName = "idcompany", nullable = false)
    public Company getCompanyByIdcompanyFk() {
        return companyByIdcompanyFk;
    }

    public void setCompanyByIdcompanyFk(Company companyByIdcompanyFk) {
        this.companyByIdcompanyFk = companyByIdcompanyFk;
    }

    @OneToMany(mappedBy = "bankaccountsByIdbankaccountsFk")
    public Collection<Supplierpaymentcheque> getSupplierpaymentchequesByIdbankaccounts() {
        return supplierpaymentchequesByIdbankaccounts;
    }

    public void setSupplierpaymentchequesByIdbankaccounts(Collection<Supplierpaymentcheque> supplierpaymentchequesByIdbankaccounts) {
        this.supplierpaymentchequesByIdbankaccounts = supplierpaymentchequesByIdbankaccounts;
    }
}
