package com.phanimahesh.mynewcard.util;

/**
 * A utility class with static methods used to generate
 * a credit card number
 */
public class CommonUtil {

    /**
     * A static utility method for validating Lunh Algorithm
     * @param number Credit card number to validate Luhn Algorithm
     * @return boolean true/false
     */
    public static boolean luhnCheck(final String number) {
        int sum = 0;
        int index = number.length() - 1;
        boolean hop = false;
        while (index >= 0)
        {
            int tempValue = Integer.parseInt(number.substring(index, index + 1));
            if (hop)
            {
                tempValue *= 2;
                tempValue = tempValue > 9 ? (tempValue % 10) + 1 : tempValue;
            }
            sum += tempValue;
            hop = !hop;
            index--;
        }
        return (sum % 10 == 0);
    }
}
