package com.phanimahesh;

/**
 * Created by Phani Mahesh on 12/3/2016.
 */
public interface MyNewCard {

    String generateNewCard();
    String generateNewCard(String cardType);
    String generateNewCard(String cardType, boolean expRequired, boolean cvvRequired);
    String generateNewCard(String cardType, boolean expRequired, boolean cvvRequired, long quantity);

}
