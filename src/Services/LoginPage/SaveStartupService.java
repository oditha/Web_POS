package Services.LoginPage;

import Modals.LoginPage.CompanyStartupModel;
import ORM.Company;
import ORM.Employees;
import ORM.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import srcs.poolManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class SaveStartupService {

    public boolean save(CompanyStartupModel cms) throws Exception {
        boolean b = false;
        System.out.println("START SAVE");
        String companycode = "";
        String compnayname = cms.getCompanyName();
        String[] split = compnayname.split(" ");
        int length = split.length;
        for (String name : split) {

            String substring = name.substring(0);
            companycode += substring;

        }


        Session session = poolManager.getSession();
        Transaction beginTransaction = session.beginTransaction();

        Company company = new Company();
        company.setComapanyName(cms.getCompanyName());
        company.setAddress1(cms.getAddress1());
        company.setAddress2(cms.getAddress2());
        company.setCity(cms.getCity());
        company.setEmail(cms.getEmail());
        company.setContactNo1(cms.getContact1());
        company.setContactNo2(cms.getContact2());
        company.setIsActive("Active");
        company.setCreateBy("Admin");
        company.setCompanyCode(companycode);
        session.save(company);
//        beginTransaction.commit();

        Employees emp = new Employees();
        emp.setNic(cms.getNic());
        emp.setFirstName(cms.getFname());
        emp.setLastName(cms.getLname());
        emp.setEmailAdress(cms.getUemail());
        emp.setContactNo1(cms.getUcontact1());
        emp.setContactNo2(cms.getUcontact2());
        emp.setIsActive("Active");
        emp.setCreateBy("Admin");
        emp.setCompanyCode(companycode);

        session.save(emp);

        beginTransaction.commit();
        System.out.println("EMPCODE " + emp.getIdemployees());

        session.close();

        Session sessionuser = poolManager.getSession();
        Transaction beginTransactionuser = sessionuser.beginTransaction();
        Criteria criteria = sessionuser.createCriteria(Employees.class);
        criteria.add(Restrictions.eq("nic",cms.getNic()));
        Employees o = (Employees) criteria.uniqueResult();


//        CriteriaBuilder builder = sessionuser.getCriteriaBuilder();
//        CriteriaQuery<Employees> query = builder.createQuery(Employees.class);
//        Query<Employees> que = sessionuser.createQuery(query);
//        List<Employees> list = que.list();
//        Employees empa = new Employees();
//        for (Employees e : list) {
//
//            if (e.getNic().equals(cms.getNic())) {
//
//                empa.setIdemployees(e.getIdemployees());
//
//            }
//
//
//        }


        Users users = new Users();
        users.setUsername(cms.getUsername());
        users.setPassword(cms.getRepassword());
        users.setIsActive("Active");
        users.setLoginBlock("Unblock");
        users.setRole("Admin");
        users.setEmployeesByIdemployeesFk(o);
        users.setCompanyCode(companycode);
        sessionuser.save(users);
        beginTransactionuser.commit();


        sessionuser.close();

        b = true;

        return b;

    }


}
