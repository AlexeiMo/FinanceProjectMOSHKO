package by.javatr.bank.dao.factory;

import by.javatr.bank.dao.AccountDAO;
import by.javatr.bank.dao.UserDAO;
import by.javatr.bank.dao.implementation.FileAccountDAO;
import by.javatr.bank.dao.implementation.FileUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO fileUserImpl = new FileUserDAO();
    private final AccountDAO fileAccountImpl = new FileAccountDAO();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return fileUserImpl;
    }

    public AccountDAO getAccountDAO() {
        return fileAccountImpl;
    }
}
