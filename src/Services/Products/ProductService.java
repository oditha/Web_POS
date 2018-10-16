package Services.Products;

import Modals.Products.ProductsFilterModel;
import Modals.Products.ProductsModel;
import Modals.Products.UnitModal;
import Modals.Settings.DepartmentModel;
import ORM.Category;
import ORM.Products;
import ORM.Stock;
import ORM.Units;
import com.mysql.cj.x.json.JsonArray;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import singleton.DecimalFo;
import singleton.FormatDates;
import srcs.poolManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ProductService {

    String username = ActionContext.getContext().getSession().get("USERNAME").toString();
    String idCompany = ActionContext.getContext().getSession().get("IDCOMPANY").toString();
    String companycode = ActionContext.getContext().getSession().get("COMPANYCODE").toString();
    String iduser = ActionContext.getContext().getSession().get("IDUSER").toString();

    public String generateBarcode() {

        return idCompany + FormatDates.getcompanycode() + iduser;

    }

    public String loadCategories(DepartmentModel departmentModel) {

        Session session = poolManager.getSession();
        JSONArray jsonArray = new JSONArray();

        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Category> builderQuery = criteriaBuilder.createQuery(Category.class);
            builderQuery.from(Category.class);
            Query<Category> query = session.createQuery(builderQuery);
            List<Category> resultList = query.getResultList();
            Collections.sort(resultList, Comparator.comparing(Category::getCategoryname));
            for (Category c : resultList) {

                if (c.getIdDepartmentFk() == Integer.parseInt(departmentModel.getIdDepartment())) {

                    JSONObject jo = new JSONObject();
                    jo.put("id", c.getIdcategory());
                    jo.put("name", c.getCategoryname());
                    jsonArray.put(jo);

                }

            }

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            session.close();
        }

        return jsonArray.toString();
    }


    public boolean saveUnit(UnitModal um) {

        Session session = poolManager.getSession();

        try {

            Transaction transaction = session.beginTransaction();
            Units units = new Units();
            units.setCompanyCode(companycode);
            units.setCreateBy(username);
            units.setIsActive("Active");
            units.setUnitname(um.getUnitName());

            session.save(units);
            transaction.commit();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        } finally {

            session.close();

        }


    }


    public String loadUnits() {

        JSONArray jsonArray = new JSONArray();
        Session session = poolManager.getSession();

        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Units> builderQuery = criteriaBuilder.createQuery(Units.class);
            builderQuery.from(Units.class);
            Query<Units> query = session.createQuery(builderQuery);
            List<Units> resultList = query.getResultList();
            Collections.sort(resultList, Comparator.comparing(Units::getUnitname));

            for (Units u : resultList) {


                if (u.getIsActive().equals("Active") && u.getCompanyCode().equals(companycode)) {

                    JSONObject jo = new JSONObject();
                    jo.put("unitid", u.getIdunits());
                    jo.put("unitname", u.getUnitname());
                    jsonArray.put(jo);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        } finally {

            session.close();
        }

        System.out.println(jsonArray.toString());
        return jsonArray.toString();


    }

    public boolean saveProduct(ProductsModel pm) {

        Session session = poolManager.getSession();

        try {

            Transaction transaction = session.beginTransaction();

            Category category = new Category();
            category.setIdcategory(Integer.parseInt(pm.getCategory()));

            Units units = new Units();
            units.setIdunits(Integer.parseInt(pm.getMessuringunit()));

            Products products = new Products();
            products.setProductscode(pm.getProductcode());
            products.setProductName(pm.getProductName().toUpperCase());
            products.setUnitPrice(Double.parseDouble(pm.getUnitprice()));
            products.setSellingPrice(Double.parseDouble(pm.getSellingprice()));
            products.setIsActive("Active");

            if (pm.getStcokcheck().equals("stock")) {

                products.setIsStock("TRUE");
                products.setIsService("FALSE");

            } else if (pm.getStcokcheck().equals("service")) {

                products.setIsStock("FALSE");
                products.setIsService("TRUE");

            }

            products.setCreateBy(username);
            products.setReorderLevel(Double.parseDouble(pm.getReorderlevel()));
            products.setCategoryByIdcategoryFk(category);
            products.setUnitsByIdunitsFk(units);
            products.setBarcode(pm.getBarcode());
            products.setSpecialPrice(Double.parseDouble(pm.getSpecialprice()));
            products.setCompanyCode(companycode);

            System.out.println("PKEY "+ products.getIdproducts());

            session.save(products);



            if (pm.getStcokcheck().equals("stock")) {


                Stock stock = new Stock();
                stock.setQty(Double.parseDouble(pm.getCurrentstock()));
                stock.setIsActive("Active");
                stock.setCreateBy(username);
                stock.setProductsByIdproductsFk(products);
                stock.setUnitsByIdunits(units);
                stock.setCompanyCode(companycode);
                session.save(stock);


            }

            transaction.commit();
            System.out.println("PKEY COO1 "+ products.getIdproducts());

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        } finally {

            session.close();
        }

    }


    public boolean updateProduct(ProductsModel pm){

        Session session = poolManager.getSession();

        try {

            Criteria criteria = session.createCriteria(Products.class);
            criteria.add(Restrictions.eq("idproducts", Integer.parseInt(pm.getIdproduts())));
            Products products = (Products) criteria.uniqueResult();
            if (products != null) {

                Transaction transaction = session.beginTransaction();


                Category category = new Category();
                category.setIdcategory(Integer.parseInt(pm.getCategory()));

                Units units = new Units();
                units.setIdunits(Integer.parseInt(pm.getMessuringunit()));

                products.setProductscode(pm.getProductcode());
                products.setProductName(pm.getProductName());
                products.setUnitPrice(Double.parseDouble(pm.getUnitprice()));
                products.setSellingPrice(Double.parseDouble(pm.getSellingprice()));
                products.setIsActive("Active");

                products.setCreateBy(username);
                products.setReorderLevel(Double.parseDouble(pm.getReorderlevel()));
                products.setCategoryByIdcategoryFk(category);
                products.setUnitsByIdunitsFk(units);
                products.setBarcode(pm.getBarcode());
                products.setSpecialPrice(Double.parseDouble(pm.getSpecialprice()));
                products.setCompanyCode(companycode);

                session.update(products);

                transaction.commit();

                return true;
            }
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        } finally {

            session.close();
        }

      return false;
    }

    public boolean deleteProduct(ProductsModel pm){

        Session session = poolManager.getSession();

        try {

            Criteria criteria = session.createCriteria(Products.class);
            criteria.add(Restrictions.eq("idproducts", Integer.parseInt(pm.getIdproduts())));
            Products products = (Products) criteria.uniqueResult();
            if (products != null) {

                Transaction transaction = session.beginTransaction();


                products.setIsActive("Deactive");

                session.update(products);

                transaction.commit();

                return true;
            }
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        } finally {

            session.close();
        }

        return false;
    }

    public String loadAllProducts() {

        JSONArray jsonArray = new JSONArray();

        Session session = poolManager.getSession();

        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Products> builderQuery = criteriaBuilder.createQuery(Products.class);
            builderQuery.from(Products.class);
            Query<Products> query = session.createQuery(builderQuery);
            List<Products> resultList = query.getResultList();
            Collections.sort(resultList, Comparator.comparing(Products::getProductName));
            int i = 0;
            for (Products p : resultList) {


                if (p.getIsActive().equals("Active") && p.getCompanyCode().equals(companycode)) {


                    json(jsonArray, p, i);


                }

            }


        } catch (Exception ex) {

            ex.printStackTrace();
            return "ERROR";

        } finally {

            session.close();

        }

        return jsonArray.toString();

    }

    public String productsFilter(ProductsFilterModel pf) {

        JSONArray jsonArray = new JSONArray();
        Session session = poolManager.getSession();

        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Products> builderQuery = criteriaBuilder.createQuery(Products.class);
            builderQuery.from(Products.class);
            Query<Products> query = session.createQuery(builderQuery);
            List<Products> resultList = query.getResultList();
            Collections.sort(resultList, Comparator.comparing(Products::getProductName));
            int i = 0;
            for (Products p : resultList) {

                if (p.getIsActive().equals("Active") && p.getCompanyCode().equals(companycode)) {

                    if (pf.getType().equals("department")) {

//                        System.out.println("IDDE"+p.getCategoryByIdcategoryFk().getDepartmentByIdDepartmentFk().getIdDepartment());

                        if (p.getCategoryByIdcategoryFk().getDepartmentByIdDepartmentFk().getIdDepartment() == Integer.parseInt(pf.getTerm())) {

                            json(jsonArray, p, i);


                        }

                    } else if (pf.getType().equals("category")) {


                        if (p.getCategoryByIdcategoryFk().getIdcategory() == Integer.parseInt(pf.getTerm())) {

                            json(jsonArray, p, i);


                        }

                    } else if (pf.getType().equals("type")) {

                        String term = pf.getTerm();

                        if (term.equals("Products")) {

                            if (p.getIsService().equals("FALSE")) {

                                json(jsonArray, p, i);
                            }

                        } else if (term.equals("Services")) {

                            if (p.getIsService().equals("TRUE")) {

                                json(jsonArray, p, i);

                            }

                        }

                    }


                }

            }


        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";

        } finally {
            session.close();
        }

        return jsonArray.toString();
    }

    public String viewProduct(ProductsModel pm) {

        JSONObject jo = new JSONObject();

        Session session = poolManager.getSession();

        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Products> builderQuery = criteriaBuilder.createQuery(Products.class);
            builderQuery.from(Products.class);
            Query<Products> query = session.createQuery(builderQuery);
            List<Products> resultList = query.getResultList();

            for (Products p : resultList) {

                if (p.getIdproducts() == Integer.parseInt(pm.getIdproduts())) {

                    double stock = 0;

                    Iterator<Stock> iterator = p.getStocksByIdproducts().iterator();
                    while (iterator.hasNext()) {

                        Stock next = iterator.next();
                        stock = next.getQty();

                    }

                    jo.put("pcode", p.getProductscode());
                    jo.put("pname", p.getProductName());
                    jo.put("barcode", p.getBarcode());
                    jo.put("department", p.getCategoryByIdcategoryFk().getDepartmentByIdDepartmentFk().getIdDepartment());
                    jo.put("category", p.getCategoryByIdcategoryFk().getIdcategory());
                    jo.put("unitprice", DecimalFo.setAmount(p.getUnitPrice()));
                    jo.put("spcprice", DecimalFo.setAmount(p.getSpecialPrice()));
                    jo.put("sellprice", DecimalFo.setAmount(p.getSellingPrice()));
                    jo.put("stock", stock);
                    jo.put("units", p.getUnitsByIdunitsFk().getIdunits());
                    jo.put("reorder", p.getReorderLevel());
                    jo.put("ststus", p.getIsActive());
                    jo.put("addby", p.getCreateBy());
                    jo.put("idproduct", p.getIdproducts());

                    if (p.getIsService().equals("TRUE")) {

                        jo.put("typee", "SERVICE");

                    } else {

                        jo.put("typee", "PRODUCT");


                    }


                }

            }

        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";

        } finally {

            session.close();

        }


        return jo.toString();

    }

    public void json(JSONArray jsonArray, Products p, int i) {

        JSONObject jo = new JSONObject();
        jo.put("num", ++i);
        jo.put("pname", p.getProductName());
        jo.put("category", p.getCategoryByIdcategoryFk().getCategoryname());
        jo.put("department", p.getCategoryByIdcategoryFk().getDepartmentByIdDepartmentFk().getDepartmentName());
        jo.put("sellingprice", DecimalFo.setAmount(p.getSellingPrice()));
        jo.put("button", "<a class=\"btn btn-success btn-sm waves-effect viewbtn\"  idProduct=\"" + p.getIdproducts() + "\" id=\"btnProducts\" idName=\"" + p.getProductName() + "\" onclick=\"viewProducts(this.getAttribute('idProduct'), this.getAttribute('idName'))\">View</a>");
        jsonArray.put(jo);

    }
}

