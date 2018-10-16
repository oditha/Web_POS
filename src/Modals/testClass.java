package Modals;

import ORM.Company;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.mongodb.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class testClass {

    public static void main(String[] args) {

        try {

            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB database = mongoClient.getDB("SIMPLE");
//        boolean auth = database.authenticate("username", "pwd".toCharArray());


            database.getCollectionNames().forEach(System.out::println);

            DBCollection collection = database.getCollection("PPPPP");
//            BasicDBObject document = new BasicDBObject();
//            document.put("name", "ODK");
//            document.put("company", "WANASINGHE");
//            collection.insert(document);

            BasicDBObject document = new BasicDBObject();
            document.put("database", "mkyongDBSSSPP");
            document.put("table", "hosting");

            BasicDBObject documentDetail = new BasicDBObject();
            documentDetail.put("records", 990);
            documentDetail.put("index", "vps_index1");
            documentDetail.put("active", "true");

            ArrayList<String> strings = new ArrayList<>();
            strings.add("01");
            strings.add("0BB");
            strings.add("01vdgs");
            strings.add("0sfsfs1");

            documentDetail.put("test", strings);

            document.put("detail", documentDetail);

            collection.insert(document);

            BasicDBObject searchQuery = new BasicDBObject();
//            searchQuery.put("name", "John");
            DBCursor cursor = collection.find(searchQuery);

            while (cursor.hasNext()) {

                DBObject next = cursor.next();
                System.out.println(next);

                String index = (String) next.get("detail");
                System.out.println(index);

//                ArrayList test = (ArrayList) next.get("test");
//                System.out.println("array "+ test);

            }


        } catch (Exception e) {

            e.printStackTrace();

        }

    }


}
