package com.utility.creditcard.datadump;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.utility.creditcard.generator.CreditCardGenerator;
import com.utility.creditcard.generator.CreditCardGeneratorImpl;
import org.bson.Document;

import java.util.List;

/**
 * Created by gkumaraswamy on 12/27/16.
 */
public class DumpToMongoDB {

    public static void main(String... args) {

        long startTime = System.currentTimeMillis();
        CreditCardGenerator card = new CreditCardGeneratorImpl();
        List<Document> ccdocument = card.generate("Visa", true, true, 30000);
        long endTime = System.currentTimeMillis();

        System.out.println("The output size is " + ccdocument.size());
        System.out.println("The total execution time is " + ((endTime - startTime) * 0.001));

        startTime = System.currentTimeMillis();

        System.out.println("Starting bulk insert");
        try (MongoClient mongo = new MongoClient()) {
            MongoDatabase db = mongo.getDatabase("banking");
            MongoCollection<Document> ccCollection = db.getCollection("creditcard");
            ccCollection.insertMany(ccdocument);
        }
        endTime = System.currentTimeMillis();

        System.out.println("The dump time is " + ((endTime - startTime) * 0.001));
    }
}
