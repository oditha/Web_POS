package srcs;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoConfig {

    public static MongoClient mongoClient = new MongoClient("localhost", 27017);
    public static DB database = mongoClient.getDB("web-pos-unique");

}
