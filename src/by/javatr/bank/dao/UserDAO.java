package by.javatr.bank.dao;

import by.javatr.bank.bean.User;
import by.javatr.bank.dao.exception.DAOException;

public interface UserDAO {
    void signIn(String login, String password) throws DAOException;
    void signUp(User user) throws DAOException;
}
