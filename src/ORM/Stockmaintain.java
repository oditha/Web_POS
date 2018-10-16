package ORM;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Stockmaintain {
    private int idstockmaintain;
    private Date stockDate;
    private Double qty;
    private String isActive;
    private String createBy;
    private int idemployeesFk;
    private int idproductsFk;
    private Timestamp stockTime;
    private String companyCode;
    private Employees employeesByIdemployeesFk;
    private Products productsByIdproductsFk;

    @Id
    @Column(name = "idstockmaintain")
    public int getIdstockmaintain() {
        return idstockmaintain;
    }

    public void setIdstockmaintain(int idstockmaintain) {
        this.idstockmaintain = idstockmaintain;
    }

    @Basic
    @Column(name = "stockDate")
    public Date getStockDate() {
        return stockDate;
    }

    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
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
    @Column(name = "idemployeesFK" ,insertable = false,  updatable = false)
    public int getIdemployeesFk() {
        return idemployeesFk;
    }

    public void setIdemployeesFk(int idemployeesFk) {
        this.idemployeesFk = idemployeesFk;
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
    @Column(name = "StockTime")
    public Timestamp getStockTime() {
        return stockTime;
    }

    public void setStockTime(Timestamp stockTime) {
        this.stockTime = stockTime;
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
        Stockmaintain that = (Stockmaintain) o;
        return idstockmaintain == that.idstockmaintain &&
                idemployeesFk == that.idemployeesFk &&
                idproductsFk == that.idproductsFk &&
                Objects.equals(stockDate, that.stockDate) &&
                Objects.equals(qty, that.qty) &&
                Objects.equals(isActive, that.isActive) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(stockTime, that.stockTime) &&
                Objects.equals(companyCode, that.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idstockmaintain, stockDate, qty, isActive, createBy, idemployeesFk, idproductsFk, stockTime, companyCode);
    }

    @ManyToOne
    @JoinColumn(name = "idemployeesFK", referencedColumnName = "idemployees", nullable = false)
    public Employees getEmployeesByIdemployeesFk() {
        return employeesByIdemployeesFk;
    }

    public void setEmployeesByIdemployeesFk(Employees employeesByIdemployeesFk) {
        this.employeesByIdemployeesFk = employeesByIdemployeesFk;
    }

    @ManyToOne
    @JoinColumn(name = "idproductsFK", referencedColumnName = "idproducts", nullable = false)
    public Products getProductsByIdproductsFk() {
        return productsByIdproductsFk;
    }

    public void setProductsByIdproductsFk(Products productsByIdproductsFk) {
        this.productsByIdproductsFk = productsByIdproductsFk;
    }
}
