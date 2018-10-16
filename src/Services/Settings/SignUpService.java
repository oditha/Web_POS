package Services.Settings;

import Modals.Settings.SignUpModel;
import ORM.Employees;
import ORM.Users;
import org.hibernate.Session;
import srcs.poolManager;

public class SignUpService {

    public boolean saveUser(SignUpModel sm) {

        Session session = poolManager.getSession();

        try {

            Employees employees = new Employees();
            employees.setIdemployees(Integer.parseInt(sm.getIduser()));

            Users u = new Users();
            u.setUsername(sm.getUsername());
            u.setPassword(sm.getPassword());
            u.setIsActive("Active");
            u.setCompanyCode(sm.getCompany());
            u.setLoginBlock("Block");
            u.setEmployeesByIdemployeesFk(employees);
            u.setRole(sm.getType());

            session.save(u);
            session.beginTransaction().commit();
            return true;

        } catch (Exception ex) {

            ex.printStackTrace();
            return false;

        } finally {

            session.close();

        }


    }

}
