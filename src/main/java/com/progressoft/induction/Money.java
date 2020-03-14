package com.progressoft.induction;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    public static final Money ZERO = new Money(BigDecimal.valueOf(0.0));
    public static final Money QUARTER_DINAR = new Money(BigDecimal.valueOf(0.25));
    public static final Money HALF_DINAR = new Money(BigDecimal.valueOf(0.5));
    public static final Money DINAR = new Money(BigDecimal.valueOf(1.0));
    public static final Money TEN_DINER = new Money(BigDecimal.valueOf(10.0));
    public static final Money FIVE_DINER = new Money(BigDecimal.valueOf(5.0));

    private BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
        if (amount.compareTo(BigDecimal.valueOf(0)) == -1) {
            throw new IllegalArgumentException();

        }

    }

    public boolean isLessThan(Money money) {
        if (money==null) {
            return false;
        }
        if (getAmount().doubleValue() < money.getAmount().doubleValue()) {
            return true;
        }
        else
            return false;
    }


    public Money subtract(Money money) {
        double valueOfObject = getAmount().doubleValue();
        double valueOfSubtractMoney = money.getAmount().doubleValue();

        if (valueOfObject >= valueOfSubtractMoney) {
            return new Money(BigDecimal.valueOf(valueOfObject - valueOfSubtractMoney));
        } else
            return new Money(BigDecimal.valueOf(-1));
    }

    public Money add(Money money) {
        double valueOfObject = getAmount().doubleValue();
        double valueOfAddMoney = money.getAmount().doubleValue();
        return new Money(BigDecimal.valueOf(valueOfAddMoney + valueOfObject));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
