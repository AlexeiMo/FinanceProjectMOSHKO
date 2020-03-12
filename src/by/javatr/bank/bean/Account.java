package by.javatr.bank.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {

    private List<Operation> operations;
    
    public Account() {
        this.operations = new ArrayList<>();
    }
    
    public Account(List<Operation> operations) {
        this.operations = new ArrayList<>(operations);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations.clear();
        this.operations.addAll(operations);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Account other = (Account)obj;

        if(this.operations == null) {
            if(other.operations != null) {
                return false;
            }
        } else if(!this.operations.equals(other.operations)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int match = 31;
        int result = 1;

        result = result * match + ((this.operations == null) ? 0 : this.operations.hashCode());

        return result;
    }

    @Override
    public String toString() {
        String result = this.getClass().getName() + '@' + ": operations:\n";

        for (Operation elem: this.operations) {
            result = result + elem.toString() + '\n';
        }

        return result;
    }
}
