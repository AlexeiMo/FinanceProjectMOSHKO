package by.javatr.bank.bean;

import java.io.Serializable;

public class User implements Serializable {
    private final UserType DEFAULT_TYPE = UserType.CLIENT;

    private String login;
    private String password;
    private UserType type;

    public User() {
        this.login = null;
        this.password = null;
        this.type = DEFAULT_TYPE;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.type = DEFAULT_TYPE;
    }

    public User(String login, String password, UserType type) {
        this.login = login;
        this.password = password;
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public UserType getDefaultType() {
        return DEFAULT_TYPE;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        User other = (User)obj;

        if(this.login == null) {
            if(other.login != null) {
                return false;
            }
        } else if(!this.login.equals(other.login)) {
            return false;
        }

        if(this.password == null) {
            if(other.password != null) {
                return false;
            }
        }
        else if(!this.password.equals(other.password)) {
            return false;
        }

        if(this.type == null) {
            if(other.type != null) {
                return false;
            }
        } else if(!this.type.equals(other.type)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int match = 31;
        int result = 1;

        result = result * match + ((this.login == null) ? 0 : this.login.hashCode());
        result = result * match + ((this.password == null) ? 0 : this.password.hashCode());
        result = result * match + ((this.type == null) ? 0 : this.type.hashCode());

        return result;
    }

    @Override
    public String toString() {
        String result = this.getClass().getName() + '@' +
                ": login = " + this.login +
                ", password = " + this.password +
                ", type = " + this.type;
        return result;
    }
}
