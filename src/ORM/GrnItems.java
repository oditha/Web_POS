package ORM;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class GrnItems {
    private int idgrnItems;
    private Double itemQty;
    private Double unitPrice;
    private Double lineTotal;
    private String isActive;
    private String createBy;
    private int idGrnfk;
    private int idproductsFk;
    private String companyCode;
    private Grn grnByIdGrnfk;
    private Products productsByIdproductsFk;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idgrnItems", unique = true)
    public int getIdgrnItems() {
        return idgrnItems;
    }

    public void setIdgrnItems(int idgrnItems) {
        this.idgrnItems = idgrnItems;
    }

    @Basic
    @Column(name = "itemQty")
    public Double getItemQty() {
        return itemQty;
    }

    public void setItemQty(Double itemQty) {
        this.itemQty = itemQty;
    }

    @Basic
    @Column(name = "unitPrice")
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "lineTotal")
    public Double getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(Double lineTotal) {
        this.lineTotal = lineTotal;
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
    @Column(name = "idGRNFK" ,insertable = false,  updatable = false)
    public int getIdGrnfk() {
        return idGrnfk;
    }

    public void setIdGrnfk(int idGrnfk) {
        this.idGrnfk = idGrnfk;
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
        GrnItems grnItems = (GrnItems) o;
        return idgrnItems == grnItems.idgrnItems &&
                idGrnfk == grnItems.idGrnfk &&
                idproductsFk == grnItems.idproductsFk &&
                Objects.equals(itemQty, grnItems.itemQty) &&
                Objects.equals(unitPrice, grnItems.unitPrice) &&
                Objects.equals(lineTotal, grnItems.lineTotal) &&
                Objects.equals(isActive, grnItems.isActive) &&
                Objects.equals(createBy, grnItems.createBy) &&
                Objects.equals(companyCode, grnItems.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idgrnItems, itemQty, unitPrice, lineTotal, isActive, createBy, idGrnfk, idproductsFk, companyCode);
    }

    @ManyToOne
    @JoinColumn(name = "idGRNFK", referencedColumnName = "idGRN", nullable = false)
    public Grn getGrnByIdGrnfk() {
        return grnByIdGrnfk;
    }

    public void setGrnByIdGrnfk(Grn grnByIdGrnfk) {
        this.grnByIdGrnfk = grnByIdGrnfk;
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
