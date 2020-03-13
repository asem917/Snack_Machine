package com.progressoft.induction;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    public static final Money ZERO =new Money(BigDecimal.valueOf(0.0)) ;
    public static final Money QUARTER_DINAR =new Money(BigDecimal.valueOf(0.25)) ;
    public static final Money HALF_DINAR =new Money(BigDecimal.valueOf(0.5)) ;
    public static final Money DINAR = new Money(BigDecimal.valueOf(1.0));
    public static final Money TEN_DINER=new Money(BigDecimal.valueOf(10.0));
    public static final Money FIVE_DINER=new Money(BigDecimal.valueOf(5.0));
    private BigDecimal value;

    public Money(BigDecimal value) {
        this.value=value;
        if (value.compareTo(BigDecimal.valueOf(0))==-1){
            throw new IllegalArgumentException();

        }

    }

    public boolean isLessThan(Money money) {
             if (null==money){
                 return false;
             }
             if (getValue().doubleValue()<money.getValue().doubleValue()){
                return true;
            }
            if (getValue().doubleValue()>money.getValue().doubleValue()){
                return false;
            }
            else
                return false;
    }




    public Money subtract(Money money) {
        double valueOfObject=getValue().doubleValue();
        double valueOfSubtractMoney=money.getValue().doubleValue();

        if (valueOfObject>=valueOfSubtractMoney){
            return new Money(BigDecimal.valueOf(valueOfObject-valueOfSubtractMoney));
        }
       else
           return new Money(BigDecimal.valueOf(-1));
    }

    public Money add(Money money) {
        double valueOfObject=getValue().doubleValue();
        double valueOfAddMoney=money.getValue().doubleValue();
        return new Money(BigDecimal.valueOf(valueOfAddMoney+valueOfObject));
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value.equals(money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
