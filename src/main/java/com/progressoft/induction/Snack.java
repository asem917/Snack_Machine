package com.progressoft.induction;

public class Snack {

    public static final Money PRICE_OF_CHEWING_GUM = Money.HALF_DINAR;
    public static final Money PRICE_OF_CHIPS = Money.QUARTER_DINAR;
    public static final Money PRICE_OF_CHOCOLATE = Money.DINAR;
    private SnackType snackType;


    public Snack(SnackType snackType) {
        this.snackType = snackType;


    }

    public SnackType getSnackType() {
        return snackType;
    }

}