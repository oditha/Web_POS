package Services.Works;

import Holder.OrdersHolder;
import Modals.Works.WorksFilterModel;
import ORM.Employees;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.opensymphony.xwork2.ActionContext;
import freemarker.template.utility.DateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import singleton.FormatDates;
import srcs.MongoConfig;
import srcs.poolManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ViewWorksService {

    String username = ActionContext.getContext().getSession().get("USERNAME").toString();
    String idCompany = ActionContext.getContext().getSession().get("IDCOMPANY").toString();
    String companycode = ActionContext.getContext().getSession().get("COMPANYCODE").toString();
    String iduser = ActionContext.getContext().getSession().get("IDUSER").toString();

    public String loadEmployees() {

        JSONArray jsonArray = new JSONArray();
        Session session = poolManager.getSession();

        try {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employees> builderQuery = criteriaBuilder.createQuery(Employees.class);
            builderQuery.from(Employees.class);
            Query<Employees> query = session.createQuery(builderQuery);
            List<Employees> resultList = query.getResultList();
            for (Employees emp : resultList) {

                JSONObject jo = new JSONObject();
                jo.put("username", emp.getFirstName() + " " + emp.getLastName());
                jo.put("iduser", emp.getIdemployees());
                jsonArray.put(jo);


            }


        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";

        } finally {

            session.close();

        }


        return jsonArray.toString();
    }


    public String loadWorks() {

        JSONArray jsonArray = new JSONArray();


        try {


            DBCollection collection = MongoConfig.database.getCollection("orders");

            BasicDBObject search = new BasicDBObject();
            search.put("month", FormatDates.getMonth());

            DBCursor cursor = collection.find(search);

            System.out.println("CURR " + cursor);

            while (cursor.hasNext()) {

                DBObject next = cursor.next();

                JSONObject jo = new JSONObject();

                jo.put("user", next.get("user").toString());
                jo.put("date", next.get("date").toString());
                jo.put("orderId", next.get("orderId").toString());
                jo.put("account", next.get("account").toString());
                try {

                    jo.put("type", next.get("type").toString());

                } catch (Exception e) {


                }

                try {


                    jo.put("updateNo", next.get("updateNo").toString());

                } catch (Exception e) {


                }

                jsonArray.put(jo);

            }


        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";
        }

        return jsonArray.toString();

    }


    public String filterWorks(WorksFilterModel wm) throws ParseException {

        JSONArray jsonArray = new JSONArray();
        ArrayList<OrdersHolder> list = new ArrayList<>();
        list.clear();


        String[] split = wm.getDatestart().split(" - ");
        Date start = FormatDates.parseMongoDate(split[0]);
        Date end = FormatDates.parseMongoDate(split[1]);

        try {


            DBCollection collection = MongoConfig.database.getCollection("orders");

            BasicDBObject search = new BasicDBObject();
            search.put("month", FormatDates.getMonth());

            DBCursor cursor = collection.find(search);

            while (cursor.hasNext()) {

                DBObject next = cursor.next();

                OrdersHolder holder = new OrdersHolder();
                holder.setAccount(next.get("account").toString());
                holder.setOrderDate(FormatDates.parseMongoDate(next.get("date").toString()));
                holder.setOrderId(next.get("orderId").toString());
                holder.setSqlID(Integer.parseInt(next.get("sqlId").toString()));
                holder.setType(next.get("type").toString());

                try {

                    holder.setUpdateNo(next.get("updateNo").toString());

                } catch (Exception e) {

                    holder.setUpdateNo("0");
                }

                holder.setUser(next.get("user").toString());

                list.add(holder);

            }


        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";
        }

        try {


            Iterator<OrdersHolder> iterator = list.iterator();
            while (iterator.hasNext()) {

                OrdersHolder next = iterator.next();

                if (wm.getUser().equals("All Users")) {


                    if (next.getOrderDate().after(start) && next.getOrderDate().before(end) && next.getType().equals(wm.getOrderType())) {

                        JSONObject jo = new JSONObject();
                        jo.put("user", next.getUser());
                        jo.put("date", FormatDates.dateToString(next.getOrderDate()));
                        jo.put("orderId", next.getOrderId());
                        jo.put("account", next.getAccount());
                        jo.put("type", next.getType());
                        jo.put("updateNo", next.getUpdateNo());

                        jsonArray.put(jo);

                    }

                } else {


                    if (next.getSqlID() == Integer.parseInt(wm.getUser()) && next.getOrderDate().after(start)
                            && next.getOrderDate().before(end) && next.getType().equals(wm.getOrderType())) {

                        JSONObject jo = new JSONObject();
                        jo.put("user", next.getUser());
                        jo.put("date", FormatDates.dateToString(next.getOrderDate()));
                        jo.put("orderId", next.getOrderId());
                        jo.put("account", next.getAccount());
                        jo.put("type", next.getType());
                        jo.put("updateNo", next.getUpdateNo());

                        jsonArray.put(jo);

                    }

                }


            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return jsonArray.toString();

    }


}
