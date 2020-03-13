package com.progressoft.induction;

import java.util.ArrayList;

public class Snack {

    private ArrayList<SnackType> ArrayOfSnackType;

    public static final Money PRICE_OF_CHEWING_GUM=Money.HALF_DINAR;
    public static final Money PRICE_OF_CHIPS=Money.QUARTER_DINAR;
    public static final Money PRICE_OF_CHOCOLATE=Money.DINAR;


    public Snack(SnackType snackType) {
        this.ArrayOfSnackType=new ArrayList<>(SnackMachine.DEFAULT_QUANTITY);
        for (int i=0;i<SnackMachine.DEFAULT_QUANTITY;i++){
            ArrayOfSnackType.add(snackType);
        }

    }

    public ArrayList<SnackType> getArrayOfSnackType() {
        return ArrayOfSnackType;
    }
    public int quantity(){
        return getArrayOfSnackType().size();
    }
}
