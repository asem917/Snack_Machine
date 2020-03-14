package com.progressoft.induction;

import java.util.HashMap;
import java.util.Map;

public class SnackMachine {

    private Money moneyInside = Money.ZERO;
    private Money insertMoney = Money.ZERO;
    private Money moneyInTransaction = Money.ZERO;
    public static final int DEFAULT_QUANTITY = 10;

    private Snack chocolate;
    private Snack chewingGum;
    private Snack chips;
    private Map<SnackType, Integer> mapOfSnackType;

    public SnackMachine() {
        this.chocolate = new Snack(SnackType.CHOCOLATE);
        this.chewingGum = new Snack(SnackType.CHEWING_GUM);
        this.chips = new Snack(SnackType.CHIPS);
        this.mapOfSnackType = new HashMap<>();
        putTheSnackOnMap();


    }

    public Money moneyInside() {
        return this.moneyInside;
    }

    public void setMoneyInside(Money priceOfItem) {
        this.moneyInside = this.moneyInside.add(priceOfItem);
    }

    public void insertMoney(Money money) {
        this.insertMoney = money;
        if (Money.TEN_DINER.equals(this.insertMoney) || Money.QUARTER_DINAR.equals(this.insertMoney) ||
                Money.HALF_DINAR.equals(this.insertMoney) || Money.FIVE_DINER.equals(this.insertMoney) || Money.DINAR.equals(this.insertMoney)) {
            this.moneyInTransaction = this.moneyInTransaction.add(insertMoney);
        } else
            throw new IllegalArgumentException();
    }

    public Money moneyInTransaction() {

        return moneyInTransaction;
    }

    public void setMoneyInTransaction(Money priceOfItem) {
        this.moneyInTransaction = moneyInTransaction().subtract(priceOfItem);
    }

    public Money buySnack(SnackType snackType) {
        if (this.insertMoney.equals(Money.ZERO)) {
            throw new IllegalStateException();
        }
        return transactionProcessor(snackType);

    }

    private Money transactionProcessor(SnackType snackType) {
        switch (snackType) {
            case CHEWING_GUM:
                return processSnackType(Snack.PRICE_OF_CHEWING_GUM, SnackType.CHEWING_GUM);
            case CHIPS:
                return processSnackType(Snack.PRICE_OF_CHIPS, SnackType.CHIPS);
            case CHOCOLATE:
                return processSnackType(Snack.PRICE_OF_CHOCOLATE, SnackType.CHOCOLATE);
            default:
                throw new IllegalArgumentException();
        }
    }

    private Money processSnackType(Money priceOfSnackType, SnackType snackItem) {
        if (this.moneyInTransaction.isLessThan(priceOfSnackType)) {
            throw new IllegalStateException();
        }
        updateArrayOfSnack(snackItem);
        return getChange(priceOfSnackType);
    }


    public Map<SnackType, Integer> getMapOfSnackType() {
        return this.mapOfSnackType;


    }

    private void putTheSnackOnMap() {
        getMapOfSnackType().put(SnackType.CHOCOLATE, DEFAULT_QUANTITY);
        getMapOfSnackType().put(SnackType.CHIPS, DEFAULT_QUANTITY);
        getMapOfSnackType().put(SnackType.CHEWING_GUM, DEFAULT_QUANTITY);
    }


    public Integer chewingGums() {
        return getMapOfSnackType().get(SnackType.CHEWING_GUM);
    }

    public Integer chips() {
        return getMapOfSnackType().get(SnackType.CHIPS);
    }

    public Integer chocolates() {
        return getMapOfSnackType().get(SnackType.CHOCOLATE);
    }

    public void updateArrayOfSnack(SnackType snackType) {

        if (getMapOfSnackType().get(snackType) > 0) {
            getMapOfSnackType().put(snackType, getMapOfSnackType().get(snackType) - 1);
        } else {
            throw new IllegalStateException();
        }
    }

    private Money getChange(Money priceOfItem) {
        setMoneyInside(priceOfItem);
        setMoneyInTransaction(priceOfItem);
        return moneyInTransaction();

    }

    public Money getInsertMoney() {
        return insertMoney;
    }
}
