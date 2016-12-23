package com.phanimahesh.mynewcard.util;

import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A utility class with static methods used to generate
 * a credit card number
 */
public class CommonUtil {

    public static final String DEFAULT_CARD_TYPE = "Visa";
    public static final boolean DEFAULT_EXP = false;
    public static final boolean DEFAULT_CVV = false;
    public static final Long DEFAULT_QUANTITY = 1L;
    public static List<String> CCList;

    /**
     * A static utility method for validating Lunh Algorithm
     * @param number Credit card number to validate Luhn Algorithm
     * @return boolean true/false
     */
    public static boolean luhnCheck(final String number) {
        return (LuhnCheckDigit.LUHN_CHECK_DIGIT.isValid(number));
    }

    /**
     * A static utility method to generate a random expiry date
     * @return String expiry date Ex. 2018/12
     */
    public static String generateExpDate() {
        return Calendar.getInstance().get(Calendar.YEAR)+ ThreadLocalRandom.current().nextInt(2,6)
                + "/" + ThreadLocalRandom.current().nextInt(1,12);
    }

    /**
     * A static utility method to generate a random CVV
     * @return int CVV number
     */
    public static int generateCvv() {
        return ThreadLocalRandom.current().nextInt(101,998);
    }

    /**
     * A list of various types of Credit Cards
     */
    static {
        CCList = Collections.unmodifiableList(
                Arrays.asList(
                        "5404 36xx xxxx xxxx MasterCard - Lloyds Tsb Bank Plc., UK",
                        "5404 37xx xxxx xxxx MasterCard - Lloyds Tsb Bank Plc., UK",
                        "5177 43xx xxxx xxxx MasterCard - Credit Suisse, Switzerland",
                        "5218 41xx xxxx xxxx MasterCard - Ubs Ag, Switzerland",
                        "5288 77xx xxxx xxxx MasterCard - Banco Nacional De Mexico, S.A.",
                        "5289 00xx xxxx xxxx MasterCard - Bank Of America, USA",
                        "5314 50xx xxxx xxxx MasterCard - Bank Of America, USA",
                        "5315 7xxx xxxx xxxx MasterCard - First Usa Bank, USA.",
                        "5323 5xxx xxxx xxxx MasterCard - Chase Manhattan Bank USA, USA",
                        "5369 90xx xxxx xxxx MasterCard - Chase Manhattan Bank USA, USA",
                        "5405 10xx xxxx xxxx MasterCard - Wells Fargo Bank, USA",
                        "5121 64xx xxxx xxxx MasterCard - HSBC Bank Canada, Canada",
                        "5221 22xx xxxx xxxx MasterCard - Bank Of Montreal, Canada",
                        "5122 17xx xxxx xxxx MasterCard - Commonwealth Bank Of Australia, Australia",
                        "5324 20xx xxxx xxxx MasterCard - China Construction Bank, China",
                        "5592 09xx xxxx xxxx MasterCard - Banco Nacional De Mexico, S.A., Mexico",
                        "5137 4xxx xxxx xxxx MasterCard - Europay France Sas, France",
                        "5520 71xx xxxx xxxx MasterCard - Banco Bilbao Vizcaya Argentaria S.A., Spain",
                        "5522 00xx xxxx xxxx MasterCard - HSBC Bank Malta P.L.C., Malta",
                        "5127 17xx xxxx xxxx MasterCard - National Bank Of Dubai Ltd., United Arab Emirates",
                        "5xxx xxxx xxxx xxxx MasterCard",
                        "4003 91xx xxxx xxxx Visa - First United Bank, USA (Debit, Classic)",
                        "4003 93xx xxxx xxxx Visa - Capital One Bank, USA (Classic)",
                        "4223 99xx xxxx xxxx Visa - Chase Manhattan Bank USA, USA (Debit, Classic)",
                        "4030 73xx xxxx xxxx Visa - Chase Manhattan Bank USA, USA (Platinum)",
                        "4113 55xx xxxx xxxx Visa - Chase Manhattan Bank USA, USA (Platinum)",
                        "4343 51xx xxxx xxxx Visa - HSBC Bank Nevada, USA (Classic)",
                        "4343 85xx xxxx xxxx Visa - HSBC Bank Nevada, USA (Gold)",
                        "4000 52xx xxxx xxxx Visa - The Connecticut Bank And Trust Company, USA (Debit, Classic)",
                        "4265 10xx xxxx xxxx Visa - Barclays Bank Plc, UK (Classic)",
                        "4265 03xx xxxx xxxx Visa - Barclays Bank Plc, UK (Gold)",
                        "4265 04xx xxxx xxxx Visa - Barclays Bank Plc, UK (Platinum)",
                        "4112 98xx xxxx xxxx Visa - Lloyds Tsb Bank Plc, UK (Classic)",
                        "4479 65xx xxxx xxxx Visa - Citibank International Plc, UK (Business)",
                        "4067 42xx xxxx xxxx Visa - Bank Of Valletta Plc, Malta (Debit, Classic)",
                        "4233 85xx xxxx xxxx Visa - First International Bank Ltd., Malta (Gold)",
                        "4188 75xx xxxx xxxx Visa - Bank Of Valletta Plc, Malta (Platinum)",
                        "4137 73xx xxxx xxxx Visa - Topcard Service S.A., Switzerland (Classic)",
                        "4133 91xx xxxx xxxx Visa - Ubs Ag (Union Bank Of Switzerland), Switzerland (Gold)",
                        "4133 92xx xxxx xxxx Visa - Ubs Ag (Union Bank Of Switzerland), Switzerland (Business)",
                        "4001 31xx xxxx xxxx Visa - Barclays Bank Plc, Portugal (Debit, Electron)",
                        "4001 02xx xxxx xxxx Visa - Banco Do Brasil S.A., Brazil (Debit, Electron)",
                        "4001 36xx xxxx xxxx Visa - Banco Do Brasil S.A., Brazil (Debit, Electron)",
                        "4009 58xx xxxx xxxx Visa - Caixa Economica Federal, Brazil (Classic)",
                        "4009 59xx xxxx xxxx Visa - Caixa Economica Federal, Brazil (Gold)",
                        "4009 60xx xxxx xxxx Visa - Caixa Economica Federal, Brazil (Business)",
                        "4002 13xx xxxx xxxx Visa - The Hongkong And Shanghai Banking Corporation Ltd., Brunei (Classic)",
                        "4002 14xx xxxx xxxx Visa - The Hongkong And Shanghai Banking Corporation Ltd., Brunei (Gold)",
                        "4002 59xx xxxx xxxx Visa - Banco Sudameris Argentina S.A., Argentina (Classic)",
                        "4357 31xx xxxx xxxx Visa - HSBC Bank Argentina S.A., Argentina (Classic)",
                        "4357 52xx xxxx xxxx Visa - Banco Velox S.A., Argentina (Classic)",
                        "4357 53xx xxxx xxxx Visa - Banco Velox S.A., Argentina (Gold)",
                        "4002 62xx xxxx xxxx Visa - Coop Bank Ab, Sweden (Classic)",
                        "4003 31xx xxxx xxxx Visa - Sanpaolo Imi S.P.A., Italy (Debit, Electron)",
                        "4003 15xx xxxx xxxx Visa - Banca Monte Dei Paschi Di Siena S.P.A., Italy (Electron)",
                        "4003 29xx xxxx xxxx Visa - Banca Nazionale Del Lavoro, Italy (Classic)",
                        "4003 59xx xxxx xxxx Visa - Taiwan Shin Kong Commercial Bank, Taiwan (Infinite)",
                        "4003 61xx xxxx xxxx Visa - Chinatrust Commercial Bank, Taiwan (Infinite)",
                        "4003 63xx xxxx xxxx Visa - Banco Nacional Ultramarino, S.A., Macau (Platinum)",
                        "4017 80xx xxxx xxxx Visa - Banco Cooperativo Espanol S.A., Spain (Debit, Electron)",
                        "4020 40xx xxxx xxxx Visa - Caja De Ahorros Y Pensiones De Barcelona (La Caixa), Spain (Debit, Electron)",
                        "4035 69xx xxxx xxxx Visa - Banco Bilbao Vizcaya Argentaria S.A. (BBVA), Spain (Debit, Electron)",
                        "4035 67xx xxxx xxxx Visa - Banco Bilbao Vizcaya Argentaria S.A. (BBVA), Spain (Classic)",
                        "4035 68xx xxxx xxxx Visa - Banco Bilbao Vizcaya Argentaria S.A. (BBVA), Spain (Classic)",
                        "4036 42xx xxxx xxxx Visa - Banco Bilbao Vizcaya Argentaria S.A. (BBVA), Spain (Platinum)",
                        "4343 87xx xxxx xxxx Visa - Iberia Cards, Spain (Business)",
                        "4539 71xx xxxx xxxx Visa - Citibank, Philippines (Classic)",
                        "4539 72xx xxxx xxxx Visa - Citibank, Philippines (Gold)",
                        "4036 49xx xxxx xxxx Visa - Deutscher Sparkassen- Und Giroverband, Germany (Debit, Classic)",
                        "4036 50xx xxxx xxxx Visa - Deutscher Sparkassen- Und Giroverband, Germany (Debit, Gold)",
                        "4035 79xx xxxx xxxx Visa - HSBC France, France (Debit, Classic)",
                        "4561 22xx xxxx xxxx Visa - HSBC France, France (Gold)",
                        "4150 56xx xxxx xxxx Visa - Societe Generale, France (Classic)",
                        "4971 19xx xxxx xxxx Visa - BNP Paribas, France (Classic)",
                        "4561 23xx xxxx xxxx Visa - BNP Paribas, France (Gold)",
                        "4101 01xx xxxx xxxx Visa - Barclays Bank Egypt Sae, Egypt (Debit, Electron)",
                        "4214 02xx xxxx xxxx Visa - Citizens Bank Of Canada, Canada (Debit, Classic)",
                        "4257 02xx xxxx xxxx Visa - Banque Laurentienne Du Canada, Canada (Corporate)",
                        "4257 03xx xxxx xxxx Visa - Absa Group Ltd., South Africa (Corporate)",
                        "4101 00xx xxxx xxxx Visa - Wells Fargo Bank, USA (Classic)",
                        "4113 40xx xxxx xxxx Visa - Wells Fargo Bank, USA (Debit, Classic)",
                        "4023 80xx xxxx xxxx Visa - Barclays Bank Plc, Gibraltar (Debit, Electron)",
                        "4050 68xx xxxx xxxx Visa - Barclays Bank Plc, Switzerland (Classic)",
                        "4010 00xx xxxx xxxx Visa - Bayerische Landesbank Girozentrale, Germany (Gold)",
                        "4018 49xx xxxx xxxx Visa - Commerzbank Ag, Germany (Debit, Classic)",
                        "4667 04xx xxxx xxxx Visa - Icici Bank Ltd, India (Debit, Classic)",
                        "4259 83xx xxxx xxxx Visa - Ixe Banco, S.A., Mexico (Debit, Classic)",
                        "4259 84xx xxxx xxxx Visa - Ixe Banco, S.A., Mexico (Debit, Gold)",
                        "4265 14xx xxxx xxxx Visa - HSBC Mexico S.A., Mexico (Electron)",
                        "4265 13xx xxxx xxxx Visa - HSBC Mexico S.A., Mexico (Business)",
                        "6011 xxxx xxxx xxxx Discover Card - prefix(6011)",
                        "65xx xxxx xxxx xxxx Discover Card - prefix(65)",
                        "644x xxxx xxxx xxxx Discover Card - prefix(644)",
                        "645x xxxx xxxx xxxx Discover Card - prefix(645)",
                        "646x xxxx xxxx xxxx Discover Card - prefix(646)",
                        "647x xxxx xxxx xxxx Discover Card - prefix(647)",
                        "648x xxxx xxxx xxxx Discover Card - prefix(648)",
                        "649x xxxx xxxx xxxx Discover Card - prefix(649)",
                        "6221 26xx xxxx xxxx Discover Card - prefix(622126)",
                        "6229 25xx xxxx xxxx Discover Card - prefix(622925)",
                        "3710 xxxx xxxx xxxx American Express Company, USA (Green)",
                        "3712 xxxx xxxx xxxx American Express Company, USA (Green)",
                        "3728 xxxx xxxx xxxx American Express Company, USA (Gold)",
                        "3703 70xx xxxx xxxx American Express Company, USA (Platinum)",
                        "3703 71xx xxxx xxxx American Express Company, USA (Platinum)",
                        "3738 xxxx xxxx xxxx American Express Company, USA (Corporate Card)",
                        "3702 46xx xxxx xxxx American Express - Industrial And Commercial Bank Of China, China",
                        "3702 47xx xxxx xxxx American Express - Industrial And Commercial Bank Of China, China",
                        "50xx xxxx xxxx xxxx Maestro Prefix(50)",
                        "56xx xxxx xxxx xxxx Maestro Prefix(56)",
                        "57xx xxxx xxxx xxxx Maestro Prfix(57)",
                        "58xx xxxx xxxx xxxx Maestro Prfix(58)",
                        "61xx xxxx xxxx xxxx Maestro Prfix(61)",
                        "68xx xxxx xxxx xxxx Maestro Prfix(68)",
                        "69xx xxxx xxxx xxxx Maestro Prfix(69)"
                ));

    }

    /**
     * A static utility function used in the process of generating credit card number
     */
    public static String generateRandomNumber(String cardSequence, String placeHolder, String numberSequence) {
        String randomNumber = "";
        numberSequence += "";

        for(int i = 1; i <= cardSequence.length(); i++) {
            String cardSubString = cardSequence.substring(i-1, i);
            int tempIndex = placeHolder.indexOf(cardSubString);

            if( tempIndex == -1) {
                randomNumber += cardSubString;
            } else {
                randomNumber += midSubString(numberSequence, (int)Math.floor(Math.random() * (numberSequence.length() - 1)) + 1, 1);
            }
        }

        return randomNumber;
    }


    /**
     * A static utility function used in the process of generating credit card number
     */
    public static String midSubString(String numberSequence, int tempRandomNumber, int tempPlaceHolder) {
        String midSubString = "";
        numberSequence += "";

        if(tempPlaceHolder == 0) {
            tempPlaceHolder = numberSequence.length();
        }

        tempRandomNumber *= 1;
        tempPlaceHolder *= 1;

        if(tempRandomNumber < 0) {
            tempRandomNumber++;
        }
        midSubString = numberSequence.substring(tempRandomNumber - 1, tempRandomNumber - 1 + tempPlaceHolder);

        return midSubString;
    }

}
