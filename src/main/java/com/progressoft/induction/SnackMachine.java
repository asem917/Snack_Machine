package com.progressoft.induction;

import java.math.BigDecimal;
import java.util.Objects;

public class SnackMachine {
    private Money moneyInside=Money.ZERO;
    private Money insertMoney=Money.ZERO;
    private Money moneyInTransaction=Money.ZERO;
    public static final int DEFAULT_QUANTITY=10;
    private Snack chocolate;
    private Snack chewingGum;
    private Snack chips;


    public SnackMachine() {
        this.chocolate=new Snack(SnackType.CHOCOLATE);
        this.chewingGum=new Snack(SnackType.CHEWING_GUM);
        this.chips=new Snack(SnackType.CHIPS);
    }



    public Money moneyInside() {
        return this.moneyInside;
    }

    public void setMoneyInside(Money priceOfItem) {

        this.moneyInside= this.moneyInside.add(priceOfItem);
    }

    public void insertMoney(Money money) {
        this.insertMoney=money;
        if (Money.TEN_DINER.equals(money)||Money.QUARTER_DINAR.equals(money)||Money.HALF_DINAR.equals(money)||Money.FIVE_DINER.equals(money)||Money.DINAR.equals(money)){
            this. moneyInTransaction= this.moneyInTransaction.add(insertMoney);
        }
        else
            throw new IllegalArgumentException();
    }

    public Money moneyInTransaction() {
        return moneyInTransaction;
    }

    public void setMoneyInTransaction(Money priceOfItem) {
        this.moneyInTransaction= moneyInTransaction().subtract(priceOfItem);
    }

    public Money buySnack(SnackType snackType) {
        if (this.insertMoney.equals(Money.ZERO)){
            throw new IllegalStateException();
        }
        switch (snackType){
            case CHEWING_GUM:
                if (this.moneyInTransaction.isLessThan(Snack.PRICE_OF_CHEWING_GUM)){
                    throw new IllegalStateException();
                }
               updateArrayOfSnack(chewingGum);
               return getChange(Snack.PRICE_OF_CHEWING_GUM);
               case CHIPS:
                   if (this.moneyInTransaction.isLessThan(Snack.PRICE_OF_CHIPS)){
                       throw new IllegalStateException();
                   }
                   updateArrayOfSnack(chips);
               return getChange(Snack.PRICE_OF_CHIPS);
               case CHOCOLATE:
                   if (this.moneyInTransaction.isLessThan(Snack.PRICE_OF_CHOCOLATE)){
                       throw new IllegalStateException();
                   }
                   updateArrayOfSnack(chocolate);
               return getChange(Snack.PRICE_OF_CHOCOLATE);
            default:
                throw new IllegalArgumentException();
        }

    }


    public Snack chewingGums() {
        return this.chewingGum;
    }

    public Snack chips() {
        return this.chips;
    }

    public Snack chocolates() {
        return this.chocolate;
    }
    public void updateArrayOfSnack(Snack snack){
        if (snack.getArrayOfSnackType().size()>0){
        snack.getArrayOfSnackType().remove(0);
        }
        else {
            throw new IllegalStateException();
        }
    }



    private Money getChange(Money priceOfItem){
        setMoneyInside(priceOfItem);
        setMoneyInTransaction(priceOfItem);
        return moneyInTransaction();

    }
}
