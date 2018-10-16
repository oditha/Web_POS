package ORM;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Cashbooktypes {
    private int idcashbooktypes;
    private String typename;
    private String createBy;
    private String isActive;
    private String companyCode;
    private Collection<Cashbook> cashbooksByIdcashbooktypes;

    @Id
    @Column(name = "idcashbooktypes")
    public int getIdcashbooktypes() {
        return idcashbooktypes;
    }

    public void setIdcashbooktypes(int idcashbooktypes) {
        this.idcashbooktypes = idcashbooktypes;
    }

    @Basic
    @Column(name = "typename")
    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
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
    @Column(name = "isActive")
    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
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
        Cashbooktypes that = (Cashbooktypes) o;
        return idcashbooktypes == that.idcashbooktypes &&
                Objects.equals(typename, that.typename) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(companyCode, that.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idcashbooktypes, typename, createBy, isActive, companyCode);
    }

    @OneToMany(mappedBy = "cashbooktypesByIdcashbooktypesFk")
    public Collection<Cashbook> getCashbooksByIdcashbooktypes() {
        return cashbooksByIdcashbooktypes;
    }

    public void setCashbooksByIdcashbooktypes(Collection<Cashbook> cashbooksByIdcashbooktypes) {
        this.cashbooksByIdcashbooktypes = cashbooksByIdcashbooktypes;
    }
}
