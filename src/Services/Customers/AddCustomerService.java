package Services.Customers;

import Modals.CustomerModel;
import ORM.Customers;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import srcs.poolManager;

public class AddCustomerService {

    String username = ActionContext.getContext().getSession().get("USERNAME").toString();
    String idCompany = ActionContext.getContext().getSession().get("IDCOMPANY").toString();
    String companycode = ActionContext.getContext().getSession().get("COMPANYCODE").toString();
    String iduser = ActionContext.getContext().getSession().get("IDUSER").toString();


    public boolean saveCustomer(CustomerModel cm) {

        Session session = poolManager.getSession();
        try {

            Transaction transaction = session.beginTransaction();


            Customers cus = new Customers();
            cus.setCustomersName(cm.getCustomername());
            cus.setAddress1(cm.getAddress1());
            cus.setAddress2(cm.getAddress2());
            cus.setCity(cm.getCity());
            cus.setContactNo1(cm.getContact1());
            cus.setContactNo2(cm.getContact2());
            cus.setCreateBy(username);
            cus.setIsActive("Active");
            cus.setEmail(cm.getEmail());
            cus.setIsSpecial(cm.getAddspecialcustomerbenifits());
            cus.setDepartment("N/A");
            cus.setCompanyCode(companycode);

            session.save(cus);

            transaction.commit();



            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        } finally {
            session.close();
        }


//        return false;
    }

}
