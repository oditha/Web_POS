package Services.Charts;

import Holder.ChartHolderForWorks;
import com.mongodb.*;
import org.json.JSONArray;
import org.json.JSONObject;
import singleton.FormatDates;
import srcs.MongoConfig;

import java.util.HashMap;
import java.util.Map;

public class ChartsService {

    public String loadWidgets() {


        JSONObject jo = new JSONObject();

        HashMap<String, Integer> map = new HashMap<>();


        try {


            DBCollection collection = MongoConfig.database.getCollection("orders");

            BasicDBObject search = new BasicDBObject();
            search.put("month", FormatDates.getMonth());

            DBCursor cursor = collection.find(search);

            System.out.println("CURR " + cursor);

            while (cursor.hasNext()) {

                DBObject next = cursor.next();

                String type = "";

                try {

                    type = next.get("type").toString();

                } catch (Exception ex) {


                }

                if (type.equals("New Order")) {

                    String account = next.get("account").toString();

                    Integer acc = map.get(account);

                    if (acc == null) {

                        map.put(account, 1);

                    } else {

                        map.put(account, ++acc);

                    }


                }


            }


        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";
        }


        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            String key = entry.getKey();
            Integer value = entry.getValue();

            jo.put(key, value);

        }

        return jo.toString();

    }

    public String loadAccVise() {

        JSONArray jsonArray = new JSONArray();


        HashMap<String, Integer> map = new HashMap<>();


        try {


            DBCollection collection = MongoConfig.database.getCollection("orders");

            BasicDBObject search = new BasicDBObject();
            search.put("month", FormatDates.getMonth());

            DBCursor cursor = collection.find(search);

            System.out.println("CURR " + cursor);

            while (cursor.hasNext()) {

                DBObject next = cursor.next();

                String type = "";

                try {

                    type = next.get("type").toString();

                } catch (Exception ex) {


                }

//                if (type.equals("New Order")) {
                if (true) {

                    String account = next.get("account").toString();

                    Integer acc = map.get(account);

                    if (acc == null) {

                        map.put(account, 1);

                    } else {

                        map.put(account, ++acc);

                    }


                }


            }


        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";
        }


        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            JSONObject jo = new JSONObject();

            String key = entry.getKey();
            Integer value = entry.getValue();

            jo.put("acc", key);
            jo.put("count", value);

            jsonArray.put(jo);

        }

        return jsonArray.toString();

    }


    public String loadUserVise() {

        JSONArray jsonArray = new JSONArray();


        HashMap<String, ChartHolderForWorks> map = new HashMap<>();


        try {


            DBCollection collection = MongoConfig.database.getCollection("orders");

            BasicDBObject search = new BasicDBObject();
            search.put("month", FormatDates.getMonth());

            DBCursor cursor = collection.find(search);


            while (cursor.hasNext()) {

                DBObject next = cursor.next();

                String type = next.get("type").toString();


                String user = next.get("user").toString();

                ChartHolderForWorks works = map.get(user);

                if (works == null) {

                    ChartHolderForWorks works1 = new ChartHolderForWorks();
                    if (type.equals("New Order")) {


                        works1.setNeworder(1);
                        map.put(user, works1);

                    } else {

                        works1.setUpdates(1);
                        map.put(user, works1);

                    }

                } else {

                    if (type.equals("New Order")) {

                        try {

                            Integer neworder = works.getNeworder();
                            works.setNeworder(++neworder);
                            map.put(user, works);

                        } catch (Exception e) {

                            works.setNeworder(1);
                            map.put(user, works);
                        }

                    } else {

                        try {

                            Integer updates = works.getUpdates();
                            works.setUpdates(++updates);
                            map.put(user, works);

                        } catch (Exception e) {

                            works.setUpdates(1);
                            map.put(user, works);

                        }

                    }


                }


            }


        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";
        }


        for (Map.Entry<String, ChartHolderForWorks> entry : map.entrySet()) {

            JSONObject jo = new JSONObject();

            String key = entry.getKey();
            ChartHolderForWorks value = entry.getValue();

            jo.put("user", key);
            jo.put("count", value.getNeworder());
            jo.put("update", value.getUpdates());

            jsonArray.put(jo);

        }

        return jsonArray.toString();

    }


    public String loadUserViseGsandaru() {

        JSONArray jsonArray = new JSONArray();


        HashMap<String, ChartHolderForWorks> map = new HashMap<>();


        DBCollection collection = MongoConfig.database.getCollection("orders");

        BasicDBObject search = new BasicDBObject();
        search.put("month", FormatDates.getMonth());
        search.put("account", "Fiverr_GSANDARU");

        DBCursor cursor = collection.find(search);

        try {

            while (cursor.hasNext()) {

                DBObject next = cursor.next();

                String type = next.get("type").toString();


                String user = next.get("user").toString();

                ChartHolderForWorks works = map.get(user);

                if (works == null) {

                    ChartHolderForWorks works1 = new ChartHolderForWorks();
                    if (type.equals("New Order")) {


                        works1.setNeworder(1);
                        map.put(user, works1);

                    } else {

                        works1.setUpdates(1);
                        map.put(user, works1);

                    }

                } else {

                    if (type.equals("New Order")) {

                        try {

                            Integer neworder = works.getNeworder();
                            works.setNeworder(++neworder);
                            map.put(user, works);

                        } catch (Exception e) {

                            works.setNeworder(1);
                            map.put(user, works);
                        }

                    } else {

                        try {

                            Integer updates = works.getUpdates();
                            works.setUpdates(++updates);
                            map.put(user, works);

                        } catch (Exception e) {

                            works.setUpdates(1);
                            map.put(user, works);

                        }

                    }


                }


            }


        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";
        } finally {

            cursor.close();
        }


        for (Map.Entry<String, ChartHolderForWorks> entry : map.entrySet()) {

            JSONObject jo = new JSONObject();

            String key = entry.getKey();
            ChartHolderForWorks value = entry.getValue();

            jo.put("user", key);
            jo.put("count", value.getNeworder());
            jo.put("update", value.getUpdates());

            jsonArray.put(jo);

        }

        return jsonArray.toString();

    }

    public String loadUserViseDILL() {

        JSONArray jsonArray = new JSONArray();


        HashMap<String, ChartHolderForWorks> map = new HashMap<>();


        DBCollection collection = MongoConfig.database.getCollection("orders");

        BasicDBObject search = new BasicDBObject();
        search.put("month", FormatDates.getMonth());
        search.put("account", "Fiverr_DILL");

        DBCursor cursor = collection.find(search);

        try {

            while (cursor.hasNext()) {

                DBObject next = cursor.next();

                String type = next.get("type").toString();


                String user = next.get("user").toString();

                ChartHolderForWorks works = map.get(user);

                if (works == null) {

                    ChartHolderForWorks works1 = new ChartHolderForWorks();
                    if (type.equals("New Order")) {


                        works1.setNeworder(1);
                        map.put(user, works1);

                    } else {

                        works1.setUpdates(1);
                        map.put(user, works1);

                    }

                } else {

                    if (type.equals("New Order")) {

                        try {

                            Integer neworder = works.getNeworder();
                            works.setNeworder(++neworder);
                            map.put(user, works);

                        } catch (Exception e) {

                            works.setNeworder(1);
                            map.put(user, works);
                        }

                    } else {

                        try {

                            Integer updates = works.getUpdates();
                            works.setUpdates(++updates);
                            map.put(user, works);

                        } catch (Exception e) {

                            works.setUpdates(1);
                            map.put(user, works);

                        }

                    }


                }


            }


        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";
        } finally {

            cursor.close();
        }


        for (Map.Entry<String, ChartHolderForWorks> entry : map.entrySet()) {

            JSONObject jo = new JSONObject();

            String key = entry.getKey();
            ChartHolderForWorks value = entry.getValue();

            jo.put("user", key);
            jo.put("count", value.getNeworder());
            jo.put("update", value.getUpdates());

            jsonArray.put(jo);

        }

        return jsonArray.toString();

    }

    public String loadUserViseODK() {

        JSONArray jsonArray = new JSONArray();


        HashMap<String, ChartHolderForWorks> map = new HashMap<>();


        DBCollection collection = MongoConfig.database.getCollection("orders");

        BasicDBObject search = new BasicDBObject();
        search.put("month", FormatDates.getMonth());
        search.put("account", "Fiverr_ODK");

        DBCursor cursor = collection.find(search);

        try {

            while (cursor.hasNext()) {

                DBObject next = cursor.next();

                String type = next.get("type").toString();


                String user = next.get("user").toString();

                ChartHolderForWorks works = map.get(user);

                if (works == null) {

                    ChartHolderForWorks works1 = new ChartHolderForWorks();
                    if (type.equals("New Order")) {


                        works1.setNeworder(1);
                        map.put(user, works1);

                    } else {

                        works1.setUpdates(1);
                        map.put(user, works1);

                    }

                } else {

                    if (type.equals("New Order")) {

                        try {

                            Integer neworder = works.getNeworder();
                            works.setNeworder(++neworder);
                            map.put(user, works);

                        } catch (Exception e) {

                            works.setNeworder(1);
                            map.put(user, works);
                        }

                    } else {

                        try {

                            Integer updates = works.getUpdates();
                            works.setUpdates(++updates);
                            map.put(user, works);

                        } catch (Exception e) {

                            works.setUpdates(1);
                            map.put(user, works);

                        }

                    }


                }


            }


        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";
        } finally {

            cursor.close();
        }


        for (Map.Entry<String, ChartHolderForWorks> entry : map.entrySet()) {

            JSONObject jo = new JSONObject();

            String key = entry.getKey();
            ChartHolderForWorks value = entry.getValue();

            jo.put("user", key);
            jo.put("count", value.getNeworder());
            jo.put("update", value.getUpdates());

            jsonArray.put(jo);

        }

        return jsonArray.toString();

    }

    public String loadUserViseSL() {

        JSONArray jsonArray = new JSONArray();


        HashMap<String, ChartHolderForWorks> map = new HashMap<>();


        DBCollection collection = MongoConfig.database.getCollection("orders");

        BasicDBObject case1 = new BasicDBObject();
        case1.put("month", FormatDates.getMonth());
        case1.put("account", "Upwork");

        BasicDBObject case2 = new BasicDBObject();
        case2.put("month", FormatDates.getMonth());
        case2.put("account", "Sri_Lanka");

        BasicDBList list = new BasicDBList();
        list.add(case1);
        list.add(case2);

        BasicDBObject query = new BasicDBObject();
        query.put("$or", list);

        DBCursor cursor = collection.find(query);

        try {

            while (cursor.hasNext()) {

                DBObject next = cursor.next();

                String type = next.get("type").toString();


                String user = next.get("user").toString();

                ChartHolderForWorks works = map.get(user);

                if (works == null) {

                    ChartHolderForWorks works1 = new ChartHolderForWorks();
                    if (type.equals("New Order")) {


                        works1.setNeworder(1);
                        map.put(user, works1);

                    } else {

                        works1.setUpdates(1);
                        map.put(user, works1);

                    }

                } else {

                    if (type.equals("New Order")) {

                        try {

                            Integer neworder = works.getNeworder();
                            works.setNeworder(++neworder);
                            map.put(user, works);

                        } catch (Exception e) {

                            works.setNeworder(1);
                            map.put(user, works);
                        }

                    } else {

                        try {

                            Integer updates = works.getUpdates();
                            works.setUpdates(++updates);
                            map.put(user, works);

                        } catch (Exception e) {

                            works.setUpdates(1);
                            map.put(user, works);

                        }

                    }


                }


            }


        } catch (Exception e) {

            e.printStackTrace();
            return "ERROR";
        } finally {

            cursor.close();
        }


        for (Map.Entry<String, ChartHolderForWorks> entry : map.entrySet()) {

            JSONObject jo = new JSONObject();

            String key = entry.getKey();
            ChartHolderForWorks value = entry.getValue();

            jo.put("user", key);
            jo.put("count", value.getNeworder());
            jo.put("update", value.getUpdates());

            jsonArray.put(jo);

        }

        return jsonArray.toString();

    }

    public static void main(String[] args) {

        ChartsService chartsService = new ChartsService();
        System.out.println(chartsService.loadUserVise());

    }

}

