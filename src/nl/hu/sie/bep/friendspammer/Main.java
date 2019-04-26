package nl.hu.sie.bep.friendspammer;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class Main {

    public static void main (String[] args) {

        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://Admin:test@ncluster-6ewif.mongodb.net/test?retryWrites=true");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("friendspammer");
        var something = database.getCollection("email");



    }

}
