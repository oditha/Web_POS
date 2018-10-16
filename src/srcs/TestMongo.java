package srcs;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import singleton.FormatDates;

import java.util.ArrayList;

public class TestMongo {


    public static void main(String[] args) {

        try {

            DBCollection collection = MongoConfig.database.getCollection("orderRecords");

            BasicDBObject works = new BasicDBObject();
            works.append("month", FormatDates.getMonth());
            works.append("date" , FormatDates.getDate());
            works.append("orderId", "12345555ZZZZZ");
            works.append("account", "FIVERR");
            works.append("type", "NEW");
            works.append("updateNo", "01");

            ArrayList<BasicDBObject> arrayList = new ArrayList<>();

            arrayList.add(works);

            BasicDBObject object = new BasicDBObject();
            object.append("works", arrayList);

            BasicDBObject update = new BasicDBObject();
            update.append("$set", object);

            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.append("sqlid", 13);

            collection.update(searchQuery, update);

            System.out.println("OK");

        } catch (Exception e) {

            System.out.println("NOK");

            e.printStackTrace();


        }

    }

}
