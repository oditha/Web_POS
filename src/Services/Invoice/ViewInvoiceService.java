package Services.Invoice;

import Modals.GRN.GrnFilterModel;
import Modals.GRN.GrnModel;
import Modals.Invoice.InvoiceModel;
import ORM.*;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import singleton.DecimalFo;
import singleton.FormatDates;
import srcs.poolManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Iterator;
import java.util.List;

public class ViewInvoiceService {

    String username = ActionContext.getContext().getSession().get("USERNAME").toString();
    String idCompany = ActionContext.getContext().getSession().get("IDCOMPANY").toString();
    String companycode = ActionContext.getContext().getSession().get("COMPANYCODE").toString();
    String iduser = ActionContext.getContext().getSession().get("IDUSER").toString();

    public String viewAllGrn() {

        JSONArray jsonArray = new JSONArray();
        Session session = poolManager.getSession();
        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Invoice> builderQuery = criteriaBuilder.createQuery(Invoice.class);
            builderQuery.from(Invoice.class);
            Query<Invoice> query = session.createQuery(builderQuery);
            List<Invoice> resultList = query.getResultList();

            for (Invoice g : resultList) {

                if (g.getCompanyCode().equals(companycode) && g.getIsActive().equals("Active")) {

                    JSONObject jo = new JSONObject();
                    jo.put("grnno", g.getInvoiceNo());
                    jo.put("grndate", g.getInvoiceDate());
                    jo.put("supplier", g.getCustomersByIdcustomerFk().getCustomersName());
                    jo.put("total", DecimalFo.setAmount(g.getNettotal()));
                    jo.put("button", "<a class=\"btn btn-success btn-sm waves-effect viewbtn\"  idGrn=\"" + g.getIdinvoice() + "\" id=\"btnGrn\" supplier=\"" + g.getCustomersByIdcustomerFk().getCustomersName() + "\" onclick=\"viewGrn(this.getAttribute('idGrn'), this.getAttribute('supplier'))\">View</a>");
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


    public String viewInvoiceData(InvoiceModel gm) {

        JSONArray items = new JSONArray();
        JSONArray payments = new JSONArray();
        JSONObject details = new JSONObject();

        Double totalPaid = 0.00;
        Double GRNTotal = 0.00;
        Double outstading = 0.00;

        Session session = poolManager.getSession();

        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Invoice> builderQuery = criteriaBuilder.createQuery(Invoice.class);
            builderQuery.from(Invoice.class);
            Query<Invoice> query = session.createQuery(builderQuery);
            List<Invoice> resultList = query.getResultList();
            for (Invoice invoice : resultList) {

                if (invoice.getIdinvoice() == Integer.parseInt(gm.getIdInvoice())) {

                    GRNTotal = invoice.getNettotal();

                    details.put("grnid", invoice.getInvoiceNo());
                    details.put("date", invoice.getInvoiceDate());
                    details.put("supplier", invoice.getCustomersByIdcustomerFk().getCustomersName() + " " + invoice.getCustomersByIdcustomerFk().getContactNo1());
                    details.put("total", DecimalFo.setAmount(invoice.getNettotal()));
                    details.put("createby", invoice.getCreateBy());

                    Iterator<Invoiceitems> iterator = invoice.getInvoiceitemsByIdinvoice().iterator();
                    while (iterator.hasNext()) {

                        Invoiceitems invoiceitems = iterator.next();

                        JSONObject jo = new JSONObject();
                        jo.put("item", invoiceitems.getProductsByIdproductsFk().getProductName());
                        jo.put("price", DecimalFo.setAmount(invoiceitems.getUnitPrice()));
                        jo.put("qty", invoiceitems.getQty());
                        jo.put("total", DecimalFo.setAmount(invoiceitems.getLineTotal()));

                        items.put(jo);

                    }

                    Iterator<Customerpayments> itt = invoice.getCustomerpaymentsByIdinvoice().iterator();
                    while (itt.hasNext()) {

                        Customerpayments next = itt.next();
                        totalPaid += next.getAmount();

                        JSONObject jo = new JSONObject();
                        jo.put("date", next.getPaymentDate());
                        jo.put("type", next.getPaymentType());
                        jo.put("amount", DecimalFo.setAmount(next.getAmount()));
                        jo.put("addBy", next.getCreateBy());

                        payments.put(jo);


                    }

                    outstading = GRNTotal - totalPaid;

                    details.put("totalpaid", DecimalFo.setAmount(totalPaid));
                    details.put("outstanding", DecimalFo.setAmount(outstading));


                }

            }

        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";

        } finally {

            session.close();

        }


        return details + "$$" + items + "$$" + payments;
    }


    public String grnFilter(GrnFilterModel gf) {

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXx "+gf.getDates()+ " "+ gf.getType()+" "+ gf.getIdSupplier());

        JSONArray jsonArray = new JSONArray();

        Session session = poolManager.getSession();

        String[] split = gf.getDates().split(" - ");
        String start = split[0];
        String end = split[1];


        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Grn> builderQuery = criteriaBuilder.createQuery(Grn.class);
            builderQuery.from(Grn.class);
            Query<Grn> query = session.createQuery(builderQuery);
            List<Grn> resultList = query.getResultList();
            for (Grn g : resultList) {

                if (g.getCompanyCode().equals(companycode) && g.getIsActive().equals("Active")) {

                    if (gf.getType().equals("ALL")) {

                        if (g.getGrnDate().after(FormatDates.parseDate(start)) && g.getGrnDate().before(FormatDates.parseDate(end))) {


                            JSONObject jo = new JSONObject();
                            jo.put("grnno", g.getGrnNo());
                            jo.put("grndate", g.getGrnDate());
                            jo.put("supplier", g.getSuppliersByIdsuppliersFk().getSupplierName());
                            jo.put("total", DecimalFo.setAmount(g.getGrnNettotal()));
                            jo.put("button", "<a class=\"btn btn-success btn-sm waves-effect viewbtn\"  idGrn=\"" + g.getIdGrn() + "\" id=\"btnGrn\" supplier=\"" + g.getSuppliersByIdsuppliersFk().getSupplierName() + "\" onclick=\"viewGrn(this.getAttribute('idGrn'), this.getAttribute('supplier'))\">View</a>");
                            jsonArray.put(jo);


                        }


                    } else {

                        if (g.getSuppliersByIdsuppliersFk().getIdsuppliers() == Integer.parseInt(gf.getIdSupplier())) {

                            if (g.getGrnDate().after(FormatDates.parseDate(start)) && g.getGrnDate().before(FormatDates.parseDate(end))) {


                                JSONObject jo = new JSONObject();
                                jo.put("grnno", g.getGrnNo());
                                jo.put("grndate", g.getGrnDate());
                                jo.put("supplier", g.getSuppliersByIdsuppliersFk().getSupplierName());
                                jo.put("total", DecimalFo.setAmount(g.getGrnNettotal()));
                                jo.put("button", "<a class=\"btn btn-success btn-sm waves-effect viewbtn\"  idGrn=\"" + g.getIdGrn() + "\" id=\"btnGrn\" supplier=\"" + g.getSuppliersByIdsuppliersFk().getSupplierName() + "\" onclick=\"viewGrn(this.getAttribute('idGrn'), this.getAttribute('supplier'))\">View</a>");
                                jsonArray.put(jo);


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

}
