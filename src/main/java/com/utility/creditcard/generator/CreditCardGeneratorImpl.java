package com.utility.creditcard.generator;

import com.utility.creditcard.generator.util.CommonUtil;
import org.bson.Document;

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
    public List<Document> generate() {
        return generate(CommonUtil.DEFAULT_CARD_TYPE);
    }

    /**
     * This method generates only a credit card number of
     * the required type
     *
     * @param cardType Required card type. Ex. VISA
     * @return a list of JSON Strings containing the card info
     */
    public List<Document> generate(String cardType) {
        return generate(cardType, CommonUtil.DEFAULT_EXP, CommonUtil.DEFAULT_CVV);
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
    public List<Document> generate(String cardType, boolean expRequired, boolean cvvRequired) {
        return generate(cardType, expRequired, cvvRequired, CommonUtil.DEFAULT_QUANTITY);
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
    public List<Document> generate(String cardType, boolean expRequired, boolean cvvRequired, long quantity) {

        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity can't be zero or negative");
        }
        return generateCC(Optional.ofNullable(cardType), expRequired, cvvRequired, quantity);
    }

    /**
     * A private method used for generating Credit Card Numbers
     * @param cardType    cardType Required card type. EX. "VISA"
     * @param expRequired To generate an expiry date or vice-versa
     * @param cvvRequired To generate cvv or vice-versa
     * @param quantity    Require number results
     * @return a list of JSON Strings containing the card info
     */
    private List<Document> generateCC(final Optional<String> cardType, final boolean expRequired,
                            final boolean cvvRequired, final long quantity) {


        List<Document> creditCardList = new ArrayList<>();

        CommonUtil.CCList.stream().filter(
                ccType -> ccType.contains(!(cardType.isPresent() || cardType.get().equals(""))
                        ? CommonUtil.DEFAULT_CARD_TYPE : cardType.get()))
                .forEach(ccType -> {

                    for(int qty = 0; qty < quantity; qty++) {

                        String intermediateCardNumber = "";
                        //boolean isValidLuhn;
                        Document json = new Document();

                        json.append("usrnm",CommonUtil.generateUserName());

                        //TODO really required Luhn check here?
                        /*for(int trial = 1000; trial >= 1; trial--) {

                            intermediateCardNumber = CommonUtil.generateRandomNumber(ccType.substring(0,19),"x", "0123456789");
                            isValidLuhn = CommonUtil.luhnCheck(intermediateCardNumber.replaceAll(" ", ""));

                            if(isValidLuhn) {
                                break;
                            }
                        }*/
                        intermediateCardNumber = CommonUtil.generateRandomNumber(ccType.substring(0,19),"x", "0123456789");

                        json.append("ctyp",ccType.substring(20));
                        json.append("cnum",intermediateCardNumber);

                        if (expRequired) {
                            json.append("exp",CommonUtil.generateExpDate());
                        }
                        if (cvvRequired) {
                            //If Amex generate 4 digit CVV otherwise 3 digit cvv
                            if(ccType.contains("American Express")) {
                                json.append("cvv",CommonUtil.generateCvv(true));
                            }else {
                                json.append("cvv",CommonUtil.generateCvv(false));
                            }
                        }

                        creditCardList.add(json);

                    }
                }
                );
        return creditCardList;
    }
}

