package Services.GRN;

import Modals.GRN.GrnModel;
import ORM.*;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
import java.util.List;

public class AddGrnService {
    String username = ActionContext.getContext().getSession().get("USERNAME").toString();
    String idCompany = ActionContext.getContext().getSession().get("IDCOMPANY").toString();
    String companycode = ActionContext.getContext().getSession().get("COMPANYCODE").toString();
    String iduser = ActionContext.getContext().getSession().get("IDUSER").toString();

    public String loadSuppliers() {

        JSONArray jsonArray = new JSONArray();
        Session session = poolManager.getSession();
        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Suppliers> builderQuery = criteriaBuilder.createQuery(Suppliers.class);
            builderQuery.from(Suppliers.class);
            Query<Suppliers> query = session.createQuery(builderQuery);
            List<Suppliers> resultList = query.getResultList();
            Collections.sort(resultList, Comparator.comparing(Suppliers::getSupplierName));

            for (Suppliers s : resultList) {

                if (s.getCompanyCode().equals(companycode) && s.getIsActive().equals("Active")) {

                    JSONObject jo = new JSONObject();
                    jo.put("supname", s.getSupplierName());
                    jo.put("supid", s.getIdsuppliers());

                    jsonArray.put(jo);


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

    public String loadProducts() {

        JSONArray jsonArray = new JSONArray();
        Session session = poolManager.getSession();
        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Products> builderQuery = criteriaBuilder.createQuery(Products.class);
            builderQuery.from(Products.class);
            Query<Products> query = session.createQuery(builderQuery);
            List<Products> resultList = query.getResultList();
            Collections.sort(resultList, Comparator.comparing(Products::getProductName));

            for (Products p : resultList) {

                if (p.getCompanyCode().equals(companycode) && p.getIsActive().equals("Active")) {

                    JSONObject jo = new JSONObject();
                    jo.put("productname", p.getProductName());
                    jo.put("productid", p.getIdproducts());
                    jo.put("unitpricee", DecimalFo.setAmount(p.getUnitPrice()));
                    jo.put("unitt", p.getUnitsByIdunitsFk().getUnitname());
                    jsonArray.put(jo);


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


    public boolean saveGrn(GrnModel gm) {

        Session session = poolManager.getSession();
        try {

            Transaction transaction = session.beginTransaction();

            Suppliers suppliers = new Suppliers();
            suppliers.setIdsuppliers(Integer.parseInt(gm.getIdSupplier()));

            Grn grn = new Grn();
            grn.setGrnDate(FormatDates.parseDate(gm.getGrndate()));
            grn.setGrnTotal(Double.parseDouble(gm.getGrntotal()));
            grn.setGrnDiscount(0.00);
            grn.setGrnNettotal(Double.parseDouble(gm.getGrntotal()));
            grn.setIsActive("Active");
            grn.setCreateBy(username);
            grn.setPaymentType(gm.getPaytype());
            grn.setSuppliersByIdsuppliersFk(suppliers);
            grn.setGrnNo(gm.getGrnno());
            grn.setCompanyCode(companycode);

            session.save(grn);

            JSONArray grnitems = new JSONArray(gm.getTabledata());
            for (int i = 0; i < grnitems.length(); i++){

                JSONObject jo = grnitems.getJSONObject(i);

                Products products = new Products();
                products.setIdproducts(Integer.parseInt(jo.get("idproduct").toString()));

                GrnItems items = new GrnItems();
                items.setItemQty(Double.parseDouble(jo.get("qty").toString()));
                items.setUnitPrice(Double.parseDouble(jo.get("unitprice").toString()));
                items.setLineTotal(Double.parseDouble(jo.get("total").toString()));
                items.setIsActive("Active");
                items.setGrnByIdGrnfk(grn);
                items.setCreateBy(username);
                items.setProductsByIdproductsFk(products);
                items.setCompanyCode(companycode);
                session.save(items);

                CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
                CriteriaQuery<Stock> builderQuery = criteriaBuilder.createQuery(Stock.class);
                builderQuery.from(Stock.class);
                Query<Stock> query = session.createQuery(builderQuery);
                List<Stock> resultList = query.getResultList();
                for (Stock stock : resultList){

                    if (stock.getIdproductsFk()==Integer.parseInt(jo.get("idproduct").toString())){


                        Double qty = stock.getQty();
                        stock.setQty(qty+Double.parseDouble(jo.get("qty").toString()));
                        session.update(stock);

                    }


                }
            }

            Supplierpayments sup = new Supplierpayments();
            sup.setPaymentDate(FormatDates.parseDate(gm.getGrndate()));
            sup.setPaymentType(gm.getPaytype());
            sup.setAmount(Double.parseDouble(gm.getGrntotal()));
            sup.setIsActive("Active");
            sup.setCreateBy(username);
            sup.setGrnByIdGrnfk(grn);
            sup.setSuppliersByIdsuppliersFk(suppliers);
            sup.setCompanyCode(companycode);

            session.save(sup);

            transaction.commit();

            return true;


        } catch (Exception e) {

            e.printStackTrace();
            return false;

        } finally {

            session.close();

        }


    }

}
