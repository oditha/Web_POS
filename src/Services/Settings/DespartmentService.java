package Services.Settings;

import Modals.Settings.DepartmentModel;
import ORM.Company;
import ORM.Department;
import ORM.Users;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import srcs.poolManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DespartmentService {

    public boolean SaveDepatment(DepartmentModel dm) {

        boolean b = false;

        try {


            String username = ActionContext.getContext().getSession().get("USERNAME").toString();
            String idCompany = ActionContext.getContext().getSession().get("IDCOMPANY").toString();
            String companycode = ActionContext.getContext().getSession().get("COMPANYCODE").toString();
            Session session = poolManager.getSession();
            Transaction transaction = session.beginTransaction();

            Department department = new Department();
            department.setDepartmentName(dm.getDepartmentname());
            department.setIsActive("Active");
            department.setCreateBy(username);

            Company company = new Company();
            company.setIdcompany(Integer.parseInt(idCompany));

            department.setCompanyByIdcompanyFk(company);

            department.setCompanyCode(companycode);

            session.save(department);

            transaction.commit();

            session.close();

            b = true;

        } catch (Exception e) {

            e.printStackTrace();


        }


        return b;
    }


    public String LoadDepartments() throws Exception {

        Session session = poolManager.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Department> builderQuery = builder.createQuery(Department.class);
        builderQuery.from(Department.class);
        Query<Department> query = session.createQuery(builderQuery);
        List<Department> list = query.getResultList();
        session.close();
        JSONArray jsonArray = new JSONArray();
        int i = 0;

        Collections.sort(list, Comparator.comparing(Department::getDepartmentName));

        for (Department d : list) {

            if (d.getIsActive().equals("Active")) {

                JSONObject jo = new JSONObject();
                jo.put("id", ++i);
                jo.put("company", d.getCompanyByIdcompanyFk().getComapanyName());
                jo.put("department", d.getDepartmentName());
                jo.put("iddepartment", d.getIdDepartment());
                jo.put("button", "<a class=\"btn btn-success btn-sm waves-effect viewbtn\"  idDepartment=\"" + d.getIdDepartment() + "\" id=\"btndepartment\" idName=\"" + d.getDepartmentName() + "\" onclick=\"loadmodel(this.getAttribute('idName'), this.getAttribute('idDepartment'))\">View</a>");
                jsonArray.put(jo);

            }
        }


        return jsonArray.toString();
    }


    public boolean update(DepartmentModel dm) throws Exception{

        boolean b = false;
        Session session = poolManager.getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Department.class);
        criteria.add(Restrictions.eq("idDepartment",Integer.parseInt(dm.getIdDepartment())));
        Department department = (Department) criteria.uniqueResult();
        if (department != null){

            department.setDepartmentName(dm.getDepartmentname());
            transaction.commit();
            session.update(department);
            b = true;
        }


        session.close();


        return b;
    }

    public boolean delete(DepartmentModel dm) throws Exception{

        boolean b = false;
        Session session = poolManager.getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Department.class);
        criteria.add(Restrictions.eq("idDepartment",Integer.parseInt(dm.getIdDepartment())));
        Department department = (Department) criteria.uniqueResult();
        if (department != null){

            department.setIsActive("Deactivate");
            transaction.commit();
            session.update(department);
            b = true;
        }


        session.close();


        return b;
    }

}
