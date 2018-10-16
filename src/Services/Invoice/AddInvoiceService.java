package Services.Invoice;

import Holder.InvoiceJasperHolder;
import Modals.GRN.GrnModel;
import Modals.Invoice.InvoiceModel;
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
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddInvoiceService {


    public static List<InvoiceJasperHolder> holder = new ArrayList<>();

    String username = ActionContext.getContext().getSession().get("USERNAME").toString();
    String idCompany = ActionContext.getContext().getSession().get("IDCOMPANY").toString();
    String companycode = ActionContext.getContext().getSession().get("COMPANYCODE").toString();
    String iduser = ActionContext.getContext().getSession().get("IDUSER").toString();

    public String loadCustomers() {

        JSONArray jsonArray = new JSONArray();
        Session session = poolManager.getSession();
        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Customers> builderQuery = criteriaBuilder.createQuery(Customers.class);
            builderQuery.from(Customers.class);
            Query<Customers> query = session.createQuery(builderQuery);
            List<Customers> resultList = query.getResultList();
            Collections.sort(resultList, Comparator.comparing(Customers::getCustomersName));

            for (Customers s : resultList) {

                if (s.getCompanyCode().equals(companycode) && s.getIsActive().equals("Active")) {

                    JSONObject jo = new JSONObject();
                    jo.put("supname", s.getCustomersName());
                    jo.put("supid", s.getIdcustomer());

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


    public boolean saveInvoice(InvoiceModel gm) {

        holder.clear();

        Session session = poolManager.getSession();

        try {

            Transaction transaction = session.beginTransaction();

            Customers customers = new Customers();
            customers.setIdcustomer(Integer.parseInt(gm.getIdSupplier()));


            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Customers> builderQuery = criteriaBuilder.createQuery(Customers.class);
            Root<Customers> from = builderQuery.from(Customers.class);
            builderQuery.select(from).where(criteriaBuilder.equal(from.get("idcustomer"), Integer.parseInt(gm.getIdSupplier())));
            Query<Customers> query = session.createQuery(builderQuery);
            Customers result = query.uniqueResult();


            Invoice invoice = new Invoice();
            invoice.setInvoiceDate(FormatDates.parseDate(gm.getGrndate()));
            invoice.setTotal(Double.parseDouble(gm.getGrntotal()));
            invoice.setDiscount(0.00);
            invoice.setNettotal(Double.parseDouble(gm.getGrntotal()));
            invoice.setIsActive("Active");
            invoice.setCreateBy(username);
            invoice.setPaymentType(gm.getPaytype());
            invoice.setCustomersByIdcustomerFk(customers);
            invoice.setInvoiceNo(gm.getGrnno());
            invoice.setCompanyCode(companycode);
            invoice.setInvoiceTime(FormatDates.getTime());
            invoice.setDepartment("N/A");

            session.save(invoice);

            JSONArray grnitems = new JSONArray(gm.getTabledata());
            for (int i = 0; i < grnitems.length(); i++) {

                JSONObject jo = grnitems.getJSONObject(i);

                Products products = new Products();
                products.setIdproducts(Integer.parseInt(jo.get("idproduct").toString()));

                Invoiceitems items = new Invoiceitems();
                items.setQty(Double.parseDouble(jo.get("qty").toString()));
                items.setUnitPrice(Double.parseDouble(jo.get("unitprice").toString()));
                items.setLineTotal(Double.parseDouble(jo.get("total").toString()));
                items.setIsActive("Active");
                items.setInvoiceByIdinvoiceFk(invoice);
                items.setCreateBy(username);
                items.setProductsByIdproductsFk(products);
                items.setCompanyCode(companycode);
                session.save(items);


                InvoiceJasperHolder ijr = new InvoiceJasperHolder();
                ijr.setCashier(username);
                ijr.setCode("N/A");

//                if (result.getAddress1() == null || result.getAddress1().equals("") || result.getAddress1() == null || result.getAddress1().equals(""))

                ijr.setCustomeraddress("N/A");
                ijr.setCustomercity("N/A");
                ijr.setDiscount(gm.getDiscount());
                ijr.setCutomername(result.getCustomersName());
                ijr.setInvoicedate(gm.getGrndate());
                ijr.setInvoiceno(gm.getGrnno());
                ijr.setItem(jo.get("itemname").toString());
                ijr.setLinetotal(DecimalFo.setAmount(Double.parseDouble(jo.get("total").toString())));
                ijr.setNettotal(DecimalFo.setAmount(Double.parseDouble(gm.getNetttotal())));
                ijr.setQty(jo.get("qty").toString());
                ijr.setSubtotal(DecimalFo.setAmount(Double.parseDouble(gm.getGrntotal())));
                ijr.setUnitprice(DecimalFo.setAmount(Double.parseDouble(jo.get("unitprice").toString())));

                holder.add(ijr);

            }

            Customerpayments payments = new Customerpayments();
            payments.setPaymentDate(FormatDates.parseDate(gm.getGrndate()));
            payments.setPaymentType(gm.getPaytype());
            payments.setAmount(Double.parseDouble(gm.getGrntotal()));
            payments.setIsActive("Active");
            payments.setCreateBy(username);
            payments.setInvoiceByIdinvoiceFk(invoice);
            payments.setCustomersByIdcustomerFk(customers);
            payments.setCompanyCode(companycode);

            session.save(payments);

            transaction.commit();

            return true;


        } catch (Exception e) {

            e.printStackTrace();
            return false;

        } finally {

            session.close();

        }


    }


    public String genInvoiceNo() {

        Session session = poolManager.getSession();
        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Invoice> builderQuery = criteriaBuilder.createQuery(Invoice.class);
            Root<Invoice> root = builderQuery.from(Invoice.class);
            builderQuery.select(root);
            builderQuery.where(criteriaBuilder.equal(root.get("companyCode"), companycode));
            Query<Invoice> query = session.createQuery(builderQuery);
            List<Invoice> resultList = query.getResultList();

            int size = resultList.size() + 15;
            return DecimalFo.setInvNo(++size);

        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";

        } finally {

            session.close();
        }


    }

}
