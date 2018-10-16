package Services.LoginPage;

import ORM.Company;
import org.hibernate.Criteria;
import org.hibernate.Session;
import srcs.poolManager;

import java.util.List;

public class ValidateStartupService {

    public boolean idateCompany() throws Exception{

        boolean b;

        Session session = poolManager.getSession();
        Criteria criteria = session.createCriteria(Company.class);
        List<Company> list = criteria.list();
        int size = list.size();

        if (size == 0){

            b = false;

        }else {

            b = true;

        }

        session.close();
        return b;
    }

}
