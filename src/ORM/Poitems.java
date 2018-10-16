package ORM;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Poitems {
    private int idpoItems;
    private Double itemQty;
    private Double unitPrice;
    private Double lineTotal;
    private String isActive;
    private String createBy;
    private int idproductsFk;
    private int idporderFk;
    private String companyCode;
    private Products productsByIdproductsFk;
    private Purchaseorder purchaseorderByIdporderFk;

    @Id
    @Column(name = "idpoItems")
    public int getIdpoItems() {
        return idpoItems;
    }

    public void setIdpoItems(int idpoItems) {
        this.idpoItems = idpoItems;
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
    @Column(name = "idproductsFK" ,insertable = false,  updatable = false)
    public int getIdproductsFk() {
        return idproductsFk;
    }

    public void setIdproductsFk(int idproductsFk) {
        this.idproductsFk = idproductsFk;
    }

    @Basic
    @Column(name = "idporderFK" ,insertable = false,  updatable = false)
    public int getIdporderFk() {
        return idporderFk;
    }

    public void setIdporderFk(int idporderFk) {
        this.idporderFk = idporderFk;
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
        Poitems poitems = (Poitems) o;
        return idpoItems == poitems.idpoItems &&
                idproductsFk == poitems.idproductsFk &&
                idporderFk == poitems.idporderFk &&
                Objects.equals(itemQty, poitems.itemQty) &&
                Objects.equals(unitPrice, poitems.unitPrice) &&
                Objects.equals(lineTotal, poitems.lineTotal) &&
                Objects.equals(isActive, poitems.isActive) &&
                Objects.equals(createBy, poitems.createBy) &&
                Objects.equals(companyCode, poitems.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idpoItems, itemQty, unitPrice, lineTotal, isActive, createBy, idproductsFk, idporderFk, companyCode);
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
    @JoinColumn(name = "idporderFK", referencedColumnName = "idporder", nullable = false)
    public Purchaseorder getPurchaseorderByIdporderFk() {
        return purchaseorderByIdporderFk;
    }

    public void setPurchaseorderByIdporderFk(Purchaseorder purchaseorderByIdporderFk) {
        this.purchaseorderByIdporderFk = purchaseorderByIdporderFk;
    }
}
