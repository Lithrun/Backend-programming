package nl.hu.bep.spammer.helper;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MongoSaver {

    private MongoSaver() {}
    private static final Logger logger = LoggerFactory.getLogger(MongoSaver.class);

	public static final boolean saveEmail(String to, String from, String subject, String text, Boolean html) {

		MongoClientURI uri = new MongoClientURI(Configuration.DBURL);
		
		boolean success = true;
		try (MongoClient mongoClient = new MongoClient(uri)) {
			MongoDatabase db = mongoClient.getDatabase( Configuration.DBNAME );
			
			MongoCollection<Document> c = db.getCollection("email");

			Document doc = new Document ("to", to)
			        .append("from", from)
			        .append("subject", subject)
			        .append("text", text)
			        .append("asHtml", html);
			c.insertOne(doc);
		} catch (MongoException mongoException) {
		    logger.debug("XXXXXXXXXXXXXXXXXX ERROR WHILE SAVING TO MONGO XXXXXXXXXXXXXXXXXXXXXXXXXX");
			mongoException.printStackTrace();
			success = false;
		}
		
		return success;
 		
	}

}
