package by.javatr.bank.bean;

public class Client {
    private static final Client instance;

    static {
        instance = new Client();
    }

    private int id;

    private User userData;

    private Account account;

    private Client() {}

    public static Client getInstance() {
        return instance;
    }

    public void setUserData(User userData) {
        this.userData = userData;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserData() {
        return userData;
}

    public Account getAccount() {
        return account;
    }

    public int getId() {
        return id;
    }
}
