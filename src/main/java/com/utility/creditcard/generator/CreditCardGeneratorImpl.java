package com.utility.creditcard.generator;

import com.utility.creditcard.generator.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * An implementation of CreditCardGenerator
 * CreditCardGenerator is an api to generate credit card numbers
 * and use them as "Test Data"
 *
 * @author Phani Mahesh | http://dev.phanimahesh.com
 */
public class CreditCardGeneratorImpl implements CreditCardGenerator {



    /**
     * This method generate a random credit card number
     * with a cvv and exp date
     *
     * @return a list of JSON Strings containing the card info
     */
    public List<String> generate() {
        return generate(Optional.ofNullable(CommonUtil.DEFAULT_CARD_TYPE), CommonUtil.DEFAULT_EXP,
                CommonUtil.DEFAULT_CVV, CommonUtil.DEFAULT_QUANTITY);
    }

    /**
     * This method generates only a credit card number of
     * the required type
     *
     * @param cardType Required card type. Ex. VISA
     * @return a list of JSON Strings containing the card info
     */
    public List<String> generate(String cardType) {
        return generate(Optional.ofNullable(cardType), CommonUtil.DEFAULT_EXP, CommonUtil.DEFAULT_CVV,
                CommonUtil.DEFAULT_QUANTITY);
    }

    /**
     * This method generates a credit card number of
     * the required type. You also have an option to
     * generate cvv and exp date
     *
     * @param cardType    Required card type. EX. "VISA"
     * @param expRequired To generate an expiry date or vice-versa
     * @param cvvRequired To generate cvv or vice-versa
     * @return a list of JSON Strings containing the card info
     */
    public List<String> generate(String cardType, boolean expRequired, boolean cvvRequired) {
        return generate(Optional.ofNullable(cardType), expRequired, cvvRequired, CommonUtil.DEFAULT_QUANTITY);
    }

    /**
     * This method generates a credit card number of
     * the required type. You also have an option to
     * generate cvv and exp date. Additionally you also
     * have an option too choose the number of results.
     *
     * @param cardType    cardType Required card type. EX. "VISA"
     * @param expRequired To generate an expiry date or vice-versa
     * @param cvvRequired To generate cvv or vice-versa
     * @param quantity    Require number results
     * @return a list of JSON Strings containing the card info
     */
    public List<String> generate(String cardType, boolean expRequired, boolean cvvRequired, long quantity) {
        return generate(Optional.ofNullable(cardType), expRequired, cvvRequired,
                quantity <= 0 ? CommonUtil.DEFAULT_QUANTITY : quantity);
    }

    /**
     * A private method used for generating Credit Card Numbers
     * @param cardType    cardType Required card type. EX. "VISA"
     * @param expRequired To generate an expiry date or vice-versa
     * @param cvvRequired To generate cvv or vice-versa
     * @param quantity    Require number results
     * @return a list of JSON Strings containing the card info
     */
    private List<String> generate(final Optional<String> cardType, final boolean expRequired,
                            final boolean cvvRequired, final long quantity) {


        List<String> creditCardList = new ArrayList<>();

        CommonUtil.CCList.parallelStream().filter(
                ccType -> ccType.contains(!(cardType.isPresent()) || cardType.get().equals("")
                        ? CommonUtil.DEFAULT_CARD_TYPE : cardType.get()))

                .forEach(ccType -> {

                    for(int qty = 1; qty <= quantity; qty++) {

                        String intermediateCardNumber = "";
                        boolean isValidLuhn;
                        StringBuilder creditCardJSON = new StringBuilder();
                        creditCardJSON.append("{");

                        for(int trial = 1000; trial >= 1; trial--) {

                            intermediateCardNumber = CommonUtil.generateRandomNumber(ccType.substring(0,19),"x", "0123456789");
                            isValidLuhn = CommonUtil.luhnCheck(intermediateCardNumber.replaceAll(" ", ""));

                            if(isValidLuhn) {
                                break;
                            }
                        }

                        creditCardJSON.append("\"CardType\":\""+ ccType.substring(20) +"\",");
                        creditCardJSON.append("\"CardNumber\":\""+ intermediateCardNumber +"\"");


                        if (cvvRequired) {
                            creditCardJSON.append(",\"Exp\":\""+ CommonUtil.generateExpDate() +"\",");
                        }
                        if (expRequired) {
                            creditCardJSON.append("\"CVV\":\""+ CommonUtil.generateCvv() +"\"");
                        }

                        creditCardJSON.append("}");
                        creditCardList.add(creditCardJSON.toString());

                    }
                }
                );


        if(creditCardList.size() == 0) {
            creditCardList.add("{\"error\":\"Please enter a valid card type\"}");
        }
        return creditCardList;
    }

    //TODO should be removed. only for testing
    public static void main(String... args) {

        long startTime = System.currentTimeMillis();
        CreditCardGenerator card = new CreditCardGeneratorImpl();
        List<String> result = card.generate("Visa", true, true, 100000);
        long endTime = System.currentTimeMillis();

        System.out.println("The output size is " + result.size());
        System.out.println("The total execution time is " + ((endTime - startTime) * 0.001));

    }
}

