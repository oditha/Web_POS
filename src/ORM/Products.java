package ORM;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Products {
    private int idproducts;
    private String productscode;
    private String productName;
    private Double unitPrice;
    private Double sellingPrice;
    private String isStock;
    private String isService;
    private String isActive;
    private String createBy;
    private Double reorderLevel;
    private int idcategoryFk;
    private int idunitsFk;
    private String barcode;
    private Double specialPrice;
    private String companyCode;
    private Collection<GrnItems> grnItemsByIdproducts;
    private Collection<Invoiceitems> invoiceitemsByIdproducts;
    private Collection<Poitems> poitemsByIdproducts;
    private Category categoryByIdcategoryFk;
    private Units unitsByIdunitsFk;
    private Collection<Stock> stocksByIdproducts;
    private Collection<Stockmaintain> stockmaintainsByIdproducts;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idproducts", unique = true)
    public int getIdproducts() {
        return idproducts;
    }

    public void setIdproducts(int idproducts) {
        this.idproducts = idproducts;
    }

    @Basic
    @Column(name = "productscode")
    public String getProductscode() {
        return productscode;
    }

    public void setProductscode(String productscode) {
        this.productscode = productscode;
    }

    @Basic
    @Column(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
    @Column(name = "sellingPrice")
    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Basic
    @Column(name = "isStock")
    public String getIsStock() {
        return isStock;
    }

    public void setIsStock(String isStock) {
        this.isStock = isStock;
    }

    @Basic
    @Column(name = "isService")
    public String getIsService() {
        return isService;
    }

    public void setIsService(String isService) {
        this.isService = isService;
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
    @Column(name = "reorderLevel")
    public Double getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Double reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    @Basic
    @Column(name = "idcategoryFK" ,insertable = false,  updatable = false)
    public int getIdcategoryFk() {
        return idcategoryFk;
    }

    public void setIdcategoryFk(int idcategoryFk) {
        this.idcategoryFk = idcategoryFk;
    }

    @Basic
    @Column(name = "idunitsFK" ,insertable = false,  updatable = false)
    public int getIdunitsFk() {
        return idunitsFk;
    }

    public void setIdunitsFk(int idunitsFk) {
        this.idunitsFk = idunitsFk;
    }

    @Basic
    @Column(name = "barcode")
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Basic
    @Column(name = "SpecialPrice")
    public Double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
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
        Products products = (Products) o;
        return idproducts == products.idproducts &&
                idcategoryFk == products.idcategoryFk &&
                idunitsFk == products.idunitsFk &&
                Objects.equals(productscode, products.productscode) &&
                Objects.equals(productName, products.productName) &&
                Objects.equals(unitPrice, products.unitPrice) &&
                Objects.equals(sellingPrice, products.sellingPrice) &&
                Objects.equals(isStock, products.isStock) &&
                Objects.equals(isService, products.isService) &&
                Objects.equals(isActive, products.isActive) &&
                Objects.equals(createBy, products.createBy) &&
                Objects.equals(reorderLevel, products.reorderLevel) &&
                Objects.equals(barcode, products.barcode) &&
                Objects.equals(specialPrice, products.specialPrice) &&
                Objects.equals(companyCode, products.companyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idproducts, productscode, productName, unitPrice, sellingPrice, isStock, isService, isActive, createBy, reorderLevel, idcategoryFk, idunitsFk, barcode, specialPrice, companyCode);
    }

    @OneToMany(mappedBy = "productsByIdproductsFk")
    public Collection<GrnItems> getGrnItemsByIdproducts() {
        return grnItemsByIdproducts;
    }

    public void setGrnItemsByIdproducts(Collection<GrnItems> grnItemsByIdproducts) {
        this.grnItemsByIdproducts = grnItemsByIdproducts;
    }

    @OneToMany(mappedBy = "productsByIdproductsFk")
    public Collection<Invoiceitems> getInvoiceitemsByIdproducts() {
        return invoiceitemsByIdproducts;
    }

    public void setInvoiceitemsByIdproducts(Collection<Invoiceitems> invoiceitemsByIdproducts) {
        this.invoiceitemsByIdproducts = invoiceitemsByIdproducts;
    }

    @OneToMany(mappedBy = "productsByIdproductsFk")
    public Collection<Poitems> getPoitemsByIdproducts() {
        return poitemsByIdproducts;
    }

    public void setPoitemsByIdproducts(Collection<Poitems> poitemsByIdproducts) {
        this.poitemsByIdproducts = poitemsByIdproducts;
    }

    @ManyToOne
    @JoinColumn(name = "idcategoryFK", referencedColumnName = "idcategory", nullable = false)
    public Category getCategoryByIdcategoryFk() {
        return categoryByIdcategoryFk;
    }

    public void setCategoryByIdcategoryFk(Category categoryByIdcategoryFk) {
        this.categoryByIdcategoryFk = categoryByIdcategoryFk;
    }

    @ManyToOne
    @JoinColumn(name = "idunitsFK", referencedColumnName = "idunits", nullable = false)
    public Units getUnitsByIdunitsFk() {
        return unitsByIdunitsFk;
    }

    public void setUnitsByIdunitsFk(Units unitsByIdunitsFk) {
        this.unitsByIdunitsFk = unitsByIdunitsFk;
    }

    @OneToMany(mappedBy = "productsByIdproductsFk")
    public Collection<Stock> getStocksByIdproducts() {
        return stocksByIdproducts;
    }

    public void setStocksByIdproducts(Collection<Stock> stocksByIdproducts) {
        this.stocksByIdproducts = stocksByIdproducts;
    }

    @OneToMany(mappedBy = "productsByIdproductsFk")
    public Collection<Stockmaintain> getStockmaintainsByIdproducts() {
        return stockmaintainsByIdproducts;
    }

    public void setStockmaintainsByIdproducts(Collection<Stockmaintain> stockmaintainsByIdproducts) {
        this.stockmaintainsByIdproducts = stockmaintainsByIdproducts;
    }
}
