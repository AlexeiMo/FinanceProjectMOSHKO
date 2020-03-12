package by.javatr.bank.bean;

import java.io.Serializable;

public class Operation implements Serializable {
    private final int DEFAULT_ID = -1;
    private final double DEFAULT_MONEY_AMOUNT = 500;
    private final FinanceType DEFAULT_FIN_TYPE = FinanceType.INCOME;

    private int id;
    private double moneyAmount;
    private FinanceType type;

    public Operation() {
        this.id = DEFAULT_ID;
        this.moneyAmount = DEFAULT_MONEY_AMOUNT;
        this.type = DEFAULT_FIN_TYPE;
    }

    public Operation(double moneyAmount) {
        this.id = DEFAULT_ID;
        this.moneyAmount = moneyAmount;
        this.type = DEFAULT_FIN_TYPE;
    }

    public Operation(double moneyAmount, FinanceType type) {
        this.id = DEFAULT_ID;
        this.moneyAmount = moneyAmount;
        this.type = type;
    }

    public Operation(int id, double moneyAmount, FinanceType type) {
        this.id = id;
        this.moneyAmount = moneyAmount;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public FinanceType getType() {
        return type;
    }

    public void setType(FinanceType type) {
        this.type = type;
    }

    public int getDefaultId() {
        return DEFAULT_ID;
    }

    public double getDefaultMoneyAmount() {
        return DEFAULT_MONEY_AMOUNT;
    }

    public FinanceType getDefaultFinType() {
        return DEFAULT_FIN_TYPE;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() == obj.getClass()) {
            return false;
        }

        Operation other = (Operation)obj;

        if(this.type == null) {
            if(other.type != null) {
                return false;
            }
        } else if(!this.type.equals(other.type)) {
            return false;
        }

        return (this.id == other.id) || (this.moneyAmount == other.moneyAmount);
    }

    @Override
    public int hashCode() {
        int match = 31;
        int result = 1;

        result = result * match + this.id;
        result = result * match + (int)this.moneyAmount;
        result = result * match + ((this.type == null) ? 0 : this.type.hashCode());

        return result;
    }

    @Override
    public String toString() {
        String result = this.getClass().getName() + '@' +
                ": id = " + this.id +
                ", moneyAmount = " + this.moneyAmount +
                ", type = " + this.type + ".";
        return result;
    }
}
