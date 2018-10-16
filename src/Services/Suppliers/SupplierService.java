package Services.Suppliers;

import Modals.Suppliers.SuppliersModel;
import ORM.Suppliers;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import srcs.poolManager;

public class SupplierService {

    String username = ActionContext.getContext().getSession().get("USERNAME").toString();
    String idCompany = ActionContext.getContext().getSession().get("IDCOMPANY").toString();
    String companycode = ActionContext.getContext().getSession().get("COMPANYCODE").toString();
    String iduser = ActionContext.getContext().getSession().get("IDUSER").toString();

    public boolean saveSupplier(SuppliersModel sm) {

        Session session = poolManager.getSession();

        try {

            Transaction transaction = session.beginTransaction();

            Suppliers suppliers = new Suppliers();
            suppliers.setSupplierName(sm.getSuppliername());
            suppliers.setSupplierAddress1(sm.getAddress1());
            suppliers.setSupplierAddress2(sm.getAddress2());
            suppliers.setCity(sm.getCity());
            suppliers.setContactNo1(sm.getContact1());
            suppliers.setContactNo2(sm.getContact2());
            suppliers.setEmailAdress(sm.getEmail());
            suppliers.setContactPerson(sm.getContactperson());
            suppliers.setIsActive("Active");
            suppliers.setCreateBy(username);
            suppliers.setCompanyCode(companycode);

            session.save(suppliers);
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
