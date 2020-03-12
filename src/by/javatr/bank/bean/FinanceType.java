package by.javatr.bank.bean;

import java.io.Serializable;

public enum FinanceType implements Serializable {
    INCOME(true), OUTCOME(false);

    private boolean type;

    FinanceType(boolean type) {
        this.type = type;
    }

    public boolean isType() {
        return this.type;
    }
}
