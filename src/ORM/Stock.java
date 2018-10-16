package ORM;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Stock {
    private int idstock;
    private Double qty;
    private String isActive;
    private String createBy;
    private int idproductsFk;
    private int idunits;
    private String companyCode;
    private Products productsByIdproductsFk;
    private Units unitsByIdunits;

    @Id
    @Column(name = "idstock")
    public int getIdstock() {
        return idstock;
    }

    public void setIdstock(int idstock) {
        this.idstock = idstock;
    }

    @Basic
    @Column(name = "qty")
    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
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
    @Column(name = "idproductsFK" ,insertable = false,  updatable = false)
    public int getIdproductsFk() {
        return idproductsFk;
    }

    public void setIdproductsFk(int idproductsFk) {
        this.idproductsFk = idproductsFk;
    }

    @Basic
    @Column(name = "idunits" ,insertable = false,  updatable = false)
    public int getIdunits() {
        return idunits;
    }

    public void setIdunits(int idunits) {
        this.idunits = idunits;
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
        Stock stock = (Stock) o;
        return idstock == stock.idstock &&
                idproductsFk == stock.idproductsFk &&
                idunits == stock.idunits &&
                Objects.equals(qty, stock.qty) &&
                Objects.equals(isActive, stock.isActive) &&
                Objects.equals(createBy, stock.createBy) &&
                Objects.equals(companyCode, stock.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idstock, qty, isActive, createBy, idproductsFk, idunits, companyCode);
    }

    @ManyToOne
    @JoinColumn(name = "idproductsFK", referencedColumnName = "idproducts", nullable = false)
    public Products getProductsByIdproductsFk() {
        return productsByIdproductsFk;
    }

    public void setProductsByIdproductsFk(Products productsByIdproductsFk) {
        this.productsByIdproductsFk = productsByIdproductsFk;
    }

    @ManyToOne
    @JoinColumn(name = "idunits", referencedColumnName = "idunits", nullable = false)
    public Units getUnitsByIdunits() {
        return unitsByIdunits;
    }

    public void setUnitsByIdunits(Units unitsByIdunits) {
        this.unitsByIdunits = unitsByIdunits;
    }
}
