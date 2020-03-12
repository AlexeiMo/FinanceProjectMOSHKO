package by.javatr.bank.service.implementation;

import by.javatr.bank.bean.User;
import by.javatr.bank.dao.UserDAO;
import by.javatr.bank.dao.exception.DAOException;
import by.javatr.bank.dao.factory.DAOFactory;
import by.javatr.bank.service.ClientService;
import by.javatr.bank.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {
    public void signIn(String login, String password) throws ServiceException {
        if(login == null || login.isEmpty()) {
            throw new ServiceException("Incorrect login was entered", new IllegalArgumentException());
        }
        if(password == null || password.isEmpty()) {
            throw new ServiceException("Incorrect password was entered", new IllegalArgumentException());
        }

        try{
            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoFactory.getUserDAO();

            userDAO.signIn(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e.getInnerException());
        }
    }

    public void signUp(User user) throws ServiceException {
        if(user == null) {
            throw new ServiceException("User data is null reference", new NullPointerException());
        }

        try{
            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoFactory.getUserDAO();

            userDAO.signUp(user);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e.getInnerException());
        }
    }
}
