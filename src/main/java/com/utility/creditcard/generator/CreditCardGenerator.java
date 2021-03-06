package com.utility.creditcard.generator;

import org.bson.Document;

import java.util.List;

/**
 * CreditCardGenerator is an api to generate credit card numbers
 * and use them as "Test Data"
 */
public interface CreditCardGenerator {

    /**
     * This method generate a random credit card number
     * with a cvv and exp date
     * @return a JSON String containing the card info
     */
    List<Document> generate();
    /**
     * This method generates only a credit card number of
     * the required type
     * @param cardType Required card type. Ex. VISA
     * @return  a JSON String containing the card info
     */
    List<Document> generate(String cardType);
    /**
     * This method generates a credit card number of
     * the required type. You also have an option to
     * generate cvv and exp date
     * @param cardType Required card type. EX. "VISA"
     * @param expRequired To generate an expiry date or vice-versa
     * @param cvvRequired To generate cvv or vice-versa
     * @return a JSON String containing the card info
     */
    List<Document> generate(String cardType, boolean expRequired, boolean cvvRequired);
    /**
     * This method generates a credit card number of
     * the required type. You also have an option to
     * generate cvv and exp date. Additionally you also
     * have an option too choose the number of results.
     * @param cardType cardType Required card type. EX. "VISA"
     * @param expRequired To generate an expiry date or vice-versa
     * @param cvvRequired To generate cvv or vice-versa
     * @param quantity Require number results
     * @return a JSON String containing the card info
     */
    List<Document> generate(String cardType, boolean expRequired, boolean cvvRequired, long quantity);

}
