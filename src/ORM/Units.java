package ORM;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Units {
    private int idunits;
    private String unitname;
    private String isActive;
    private String createBy;
    private String companyCode;
    private Collection<Products> productsByIdunits;
    private Collection<Stock> stocksByIdunits;

    @Id
    @Column(name = "idunits")
    public int getIdunits() {
        return idunits;
    }

    public void setIdunits(int idunits) {
        this.idunits = idunits;
    }

    @Basic
    @Column(name = "unitname")
    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
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
        Units units = (Units) o;
        return idunits == units.idunits &&
                Objects.equals(unitname, units.unitname) &&
                Objects.equals(isActive, units.isActive) &&
                Objects.equals(createBy, units.createBy) &&
                Objects.equals(companyCode, units.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idunits, unitname, isActive, createBy, companyCode);
    }

    @OneToMany(mappedBy = "unitsByIdunitsFk")
    public Collection<Products> getProductsByIdunits() {
        return productsByIdunits;
    }

    public void setProductsByIdunits(Collection<Products> productsByIdunits) {
        this.productsByIdunits = productsByIdunits;
    }

    @OneToMany(mappedBy = "unitsByIdunits")
    public Collection<Stock> getStocksByIdunits() {
        return stocksByIdunits;
    }

    public void setStocksByIdunits(Collection<Stock> stocksByIdunits) {
        this.stocksByIdunits = stocksByIdunits;
    }
}
