package Services.Settings;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import srcs.MongoConfig;
import srcs.SendEmail;
import Modals.Settings.UserModel;
import ORM.Employees;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import srcs.poolManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserService {

    String username = ActionContext.getContext().getSession().get("USERNAME").toString();
    String idCompany = ActionContext.getContext().getSession().get("IDCOMPANY").toString();
    String companycode = ActionContext.getContext().getSession().get("COMPANYCODE").toString();

    public boolean saveUser(UserModel um) {

        Session session = poolManager.getSession();
        try {

            Transaction transaction = session.beginTransaction();

            Employees emp = new Employees();
            emp.setNic(um.getNic());
            emp.setFirstName(um.getFname());
            emp.setLastName(um.getLname());
            emp.setEmailAdress(um.getEmail());
            emp.setContactNo1(um.getContact1());
            emp.setContactNo2(um.getContact2());
            emp.setIsActive("Active");
            emp.setCreateBy(username);
            emp.setCompanyCode(companycode);

            session.save(emp);

            transaction.commit();

            String email = um.getEmail();
            String msg = "Welcome " + um.getFname() + " " + um.getLname() + " " +
                    "\n \n <a href=\"http://139.59.30.66:8080/POS/SignUp?id=" + emp.getIdemployees() + "&company=" + companycode + "&type=" + um.getRole() + "\">Click here to set user account</a>";

            SendEmail.sendEmail(email, msg);

            DBCollection collection = MongoConfig.database.getCollection("orderRecords");

            BasicDBObject user = new BasicDBObject();

            user.put("name", um.getFname() + " " + um.getLname());
            user.put("nic", um.getNic());
            user.put("sqlid", emp.getIdemployees());

            collection.insert(user);

            return true;

        } catch (Exception ex) {

            ex.printStackTrace();
            return false;

        } finally {
            session.close();
        }


    }


    public String loadUsers() {

        JSONArray jsonArray = new JSONArray();

        Session session = poolManager.getSession();
        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employees> builderQuery = criteriaBuilder.createQuery(Employees.class);
            builderQuery.from(Employees.class);
            Query<Employees> query = session.createQuery(builderQuery);
            List<Employees> resultList = query.getResultList();
            for (Employees e : resultList) {

                if (e.getIsActive().equals("Active") && e.getCompanyCode().equals(companycode)) {


                    JSONObject jo = new JSONObject();
                    jo.put("nic", e.getNic());
                    jo.put("name", e.getFirstName() + " " + e.getLastName());
                    jo.put("email", e.getEmailAdress());
                    jo.put("contact", e.getContactNo1());

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

}
