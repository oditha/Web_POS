package Services.Works;

import Modals.Works.WorksModel;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.opensymphony.xwork2.ActionContext;
import singleton.FormatDates;
import srcs.MongoConfig;

public class WorksService {

    String username = ActionContext.getContext().getSession().get("USERNAME").toString();
    String idCompany = ActionContext.getContext().getSession().get("IDCOMPANY").toString();
    String companycode = ActionContext.getContext().getSession().get("COMPANYCODE").toString();
    String iduser = ActionContext.getContext().getSession().get("IDUSER").toString();

    public boolean saveWorks(WorksModel wm) {


        try {

            DBCollection collection = MongoConfig.database.getCollection("orders");

            BasicDBObject works = new BasicDBObject();
            works.put("month", FormatDates.getMonth());
            works.put("date", FormatDates.getDate());
            works.put("orderId", wm.getOrderno());
            works.put("account", wm.getAccount());
            works.put("type", wm.getType());

            if (wm.getType().equals("New Order")) {

                works.put("updateNo", 0);

            } else {
                works.put("updateNo", wm.getUpdateno());

            }

            works.put("user", username);
            works.put("sqlId", iduser);


            collection.insert(works);

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }


    }


    public String genOrderno() {

        String orderno = "";

        orderno = "UC/BD/" + FormatDates.getcompanycode() + iduser;

        return orderno;
    }

}
