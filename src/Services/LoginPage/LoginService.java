package Services.LoginPage;

import Modals.LoginPage.LoginModal;
import ORM.Company;
import ORM.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import srcs.poolManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginService {

    public static Map<String, Object> httpsesson = new HashMap<>();

    public boolean LoginCheck(LoginModal loginModal) {


        Session session = poolManager.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Users> builderQuery = builder.createQuery(Users.class);
        builderQuery.from(Users.class);
        Query<Users> query = session.createQuery(builderQuery);
        List<Users> list = query.getResultList();
        session.close();
        for (Users u : list) {

            if (u.getUsername().equals(loginModal.getUsername()) && u.getPassword().equals(loginModal.getPassword())) {

                httpsesson.put("USERNAME", u.getUsername());
                httpsesson.put("NAME", u.getEmployeesByIdemployeesFk().getFirstName() + " " + u.getEmployeesByIdemployeesFk().getLastName());
                httpsesson.put("IDUSER", u.getIdemployeesFk());
                httpsesson.put("COMPANYCODE", u.getCompanyCode());
                httpsesson.put("ROLE", u.getRole());
//                System.out.println("SESSON OBJECT"+httpsesson);

                Session session0 = poolManager.getSession();
                CriteriaBuilder builder0 = session0.getCriteriaBuilder();
                CriteriaQuery<Company> builderQuery0 = builder0.createQuery(Company.class);
                builderQuery0.from(Company.class);
                Query<Company> query0 = session0.createQuery(builderQuery0);
                List<Company> list0 = query0.getResultList();
                session0.close();
                for (Company c : list0) {

                    if (c.getCompanyCode().equals(u.getCompanyCode())) {

                        httpsesson.put("IDCOMPANY", c.getIdcompany());


                    }


                }

                return true;

            }

        }

        return false;
    }


}
