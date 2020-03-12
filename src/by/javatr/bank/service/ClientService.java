package by.javatr.bank.service;

import by.javatr.bank.bean.User;
import by.javatr.bank.service.exception.ServiceException;

public interface ClientService {
    void signIn(String login, String password) throws ServiceException;
    void signUp(User user) throws ServiceException;
}
