package Services.Products;

import Modals.Products.CategoryModel;
import ORM.Category;
import ORM.Department;
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

public class CategoryService {

    public boolean save(CategoryModel cm) {

        String username = ActionContext.getContext().getSession().get("USERNAME").toString();
        String idCompany = ActionContext.getContext().getSession().get("IDCOMPANY").toString();
        String companycode = ActionContext.getContext().getSession().get("COMPANYCODE").toString();

        Session session = poolManager.getSession();
        try {

            System.out.println("START SAVE");
            Transaction transaction = session.beginTransaction();

            Department department = new Department();
            department.setIdDepartment(Integer.parseInt(cm.getDepartment()));

            Category category = new Category();
            category.setCategoryCode(cm.getCategorycode().toUpperCase());
            category.setCategoryname(cm.getCategoryname().toUpperCase());
            category.setCategoryType(cm.getCategorytype());
            category.setIsActive("Active");
            category.setCreateBy(username);
            category.setDepartmentByIdDepartmentFk(department);
            category.setCompanyCode(companycode);

            session.save(category);
            transaction.commit();
            return true;

        } catch (Exception e) {


            e.printStackTrace();
            return false;

        } finally {
            session.close();
        }


    }

    public boolean validateCategory(CategoryModel cm) {

        Session session = poolManager.getSession();

        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Category> builderQuery = criteriaBuilder.createQuery(Category.class);
            builderQuery.from(Category.class);
            Query<Category> query = session.createQuery(builderQuery);
            List<Category> resultList = query.getResultList();
            for (Category c : resultList) {

                if (c.getCategoryCode().equals(cm.getCategorycode().toUpperCase()) && c.getIsActive().equals("Active")) {
                    System.out.println("TRUE");
                    return true;

                }

            }


        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            session.close();

        }
        System.out.println("FALSE");
        return false;

    }

    public String loadCategories() {

        Session session = poolManager.getSession();


        JSONArray jsonArray = new JSONArray();
        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Category> builderQuery = criteriaBuilder.createQuery(Category.class);
            builderQuery.from(Category.class);
            Query<Category> query = session.createQuery(builderQuery);
            List<Category> resultList = query.getResultList();


            Collections.sort(resultList, Comparator.comparing(Category::getCategoryname));
            int i = 0;
            for (Category c : resultList) {

                if (c.getIsActive().equals("Active")) {


                    JSONObject jo = new JSONObject();
                    jo.put("num", ++i);
                    jo.put("code", c.getCategoryCode());
                    jo.put("idcat", c.getIdcategory());
                    jo.put("name", c.getCategoryname());
                    jo.put("type", c.getCategoryType());
                    jo.put("department", c.getDepartmentByIdDepartmentFk().getDepartmentName());
                    jo.put("addby", c.getCreateBy());
                    jo.put("button", "<a class=\"btn btn-danger btn-sm waves-effect viewbtn\"  idCategory=\"" + c.getIdcategory() + "\" id=\"btnCategory\" idName=\"" + c.getCategoryname() + "\" onclick=\"deletec(this.getAttribute('idCategory'))\">Delete</a>");

                    jsonArray.put(jo);
                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            session.close();
        }

        return jsonArray.toString();
    }


    public boolean deleteCategories(CategoryModel cm){

        Session session = poolManager.getSession();

        try {

            Transaction transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Category.class);
            criteria.add(Restrictions.eq("idcategory", Integer.parseInt(cm.getIdcategory())));
            Category uniqueResult = (Category) criteria.uniqueResult();

            if (uniqueResult !=  null){

                uniqueResult.setIsActive("Delete");
                transaction.commit();
                return true;

            }


        }catch (Exception e){

            e.printStackTrace();

        }finally {

            session.close();
        }


        return false;
    }

}
