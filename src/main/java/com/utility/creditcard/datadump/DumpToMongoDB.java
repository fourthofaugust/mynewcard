package com.utility.creditcard.datadump;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.utility.creditcard.generator.CreditCardGenerator;
import com.utility.creditcard.generator.CreditCardGeneratorImpl;
import org.bson.Document;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by gkumaraswamy on 12/27/16.
 */
public class DumpToMongoDB {

    //TODO should be removed. only for testing
    public static void main(String... args) {

        long startTime = System.currentTimeMillis();
        CreditCardGenerator card = new CreditCardGeneratorImpl();
        List<String> result = card.generate("Visa", true, true, 1000);
        long endTime = System.currentTimeMillis();

        System.out.println("The output size is " + result.size());
        System.out.println("The total execution time is " + ((endTime - startTime) * 0.001));

        List<Document> ccdocument = result.parallelStream().filter(Objects::nonNull)
        .map(Document::parse).collect(Collectors.toList());
        startTime = System.currentTimeMillis();

        try (MongoClient mongo = new MongoClient()) {
            MongoDatabase db = mongo.getDatabase("banking");
            MongoCollection<Document> ccCollection = db.getCollection("creditcard");
            ccCollection.insertMany(ccdocument);
        }
        endTime = System.currentTimeMillis();

        System.out.println("The convert & dump time is " + ((endTime - startTime) * 0.001));
    }
}
