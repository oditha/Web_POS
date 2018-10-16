package Services.Stock;

import ORM.Stock;
import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import singleton.DecimalFo;
import srcs.poolManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class StockRefillService {

    String username = ActionContext.getContext().getSession().get("USERNAME").toString();
    String idCompany = ActionContext.getContext().getSession().get("IDCOMPANY").toString();
    String companycode = ActionContext.getContext().getSession().get("COMPANYCODE").toString();
    String iduser = ActionContext.getContext().getSession().get("IDUSER").toString();

    public String viewStock(){

        JSONArray jsonArray = new JSONArray();
        Session session = poolManager.getSession();

        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Stock> builderQuery = criteriaBuilder.createQuery(Stock.class);
            builderQuery.from(Stock.class);
            Query<Stock> query = session.createQuery(builderQuery);
            List<Stock> resultList = query.getResultList();
            for (Stock s: resultList){

                if (s.getCompanyCode().equals(companycode)){

                    if (s.getProductsByIdproductsFk().getReorderLevel() >= s.getQty()){


                    JSONObject jo = new JSONObject();
                    jo.put("item",s.getProductsByIdproductsFk().getProductName());
                    jo.put("category",s.getProductsByIdproductsFk().getCategoryByIdcategoryFk().getCategoryname());
                    jo.put("department",s.getProductsByIdproductsFk().getCategoryByIdcategoryFk().getDepartmentByIdDepartmentFk().getDepartmentName());
                    jo.put("qty",s.getQty());
                    jo.put("price", DecimalFo.setAmount(s.getProductsByIdproductsFk().getSellingPrice()));

                    jsonArray.put(jo);

                    }

                }

            }


        }catch (Exception e){

            e.printStackTrace();
            return "ERROR";
        }finally {

            session.close();

        }


        return jsonArray.toString();
    }

}
