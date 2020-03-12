package by.javatr.bank.bean;

import java.io.Serializable;

public enum UserType implements Serializable {
    ADMIN("admin"), CLIENT("client");

    private String role;

    private UserType(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
