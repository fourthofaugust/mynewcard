package com.phanimahesh;

/**
 * An implementation of MyNewCard
 * MyNewCard is an api to generate credit card numbers
 * and use them as "Test Data"
 *
 * @author Phani Mahesh | http://dev.phanimahesh.com
 */
public class MyNewCardImpl implements MyNewCard{

    private  final String DEFAULT_CARD_TYPE = "VISA";
    private final boolean DEFAULT_EXP = false;
    private final boolean DEFAULT_CVV = false;
    private final Long  DEFAULT_QUANTITY = 1L;

    /**
     * This method generate a random credit card number
     * with a cvv and exp date
     * @return a JSON String containing the card info
     */
    public String generateNewCard() {
        return generate(DEFAULT_CARD_TYPE, DEFAULT_EXP, DEFAULT_CVV, DEFAULT_QUANTITY );
    }

    /**
     * This method generates only a credit card number of
     * the required type
     * @param cardType Required card type. Ex. VISA
     * @return  a JSON String containing the card info
     */
    public String generateNewCard(String cardType) {
        return generate(cardType, DEFAULT_EXP, DEFAULT_CVV, DEFAULT_QUANTITY);
    }

    /**
     * This method generates a credit card number of
     * the required type. You also have an option to
     * generate cvv and exp date
     * @param cardType Required card type. EX. "VISA"
     * @param expRequired To generate an expiry date or vice-versa
     * @param cvvRequired To generate cvv or vice-versa
     * @return a JSON String containing the card info
     */
    public String generateNewCard(String cardType, boolean expRequired, boolean cvvRequired) {
        return generate(cardType, expRequired, cvvRequired, DEFAULT_QUANTITY);
    }

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
    public String generateNewCard(String cardType, boolean expRequired, boolean cvvRequired, long quantity) {
        return generate(cardType, expRequired, cvvRequired, quantity);
    }

    private String generate(final String cardType, final boolean expRequired,
                            final boolean cvvRequired, final long quantity) {
        String result = "";

        return result;
    }
}
