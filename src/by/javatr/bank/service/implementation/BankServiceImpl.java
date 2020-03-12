package by.javatr.bank.service.implementation;

import by.javatr.bank.bean.FinanceType;
import by.javatr.bank.bean.Operation;
import by.javatr.bank.dao.AccountDAO;
import by.javatr.bank.dao.exception.DAOException;
import by.javatr.bank.dao.factory.DAOFactory;
import by.javatr.bank.service.BankService;
import by.javatr.bank.service.exception.ServiceException;

public class BankServiceImpl implements BankService {

    @Override
    public void addOperation(FinanceType type, double sum) throws ServiceException {
        if(type == null) {
            throw new ServiceException("Type of operation is null reference", new NullPointerException());
        }
        if(sum <= 0) {
            throw new ServiceException("Incorrect sum was entered", new IllegalArgumentException());
        }

        try{
            DAOFactory daoFactory = DAOFactory.getInstance();
            AccountDAO accountDAO = daoFactory.getAccountDAO();

            accountDAO.addOperation(type, sum);
        } catch(DAOException e) {
            throw new ServiceException(e.getMessage(), e.getInnerException());
        }

    }

    @Override
    public void readOperations() throws ServiceException {
        try{
            DAOFactory daoFactory = DAOFactory.getInstance();
            AccountDAO accountDAO = daoFactory.getAccountDAO();

            accountDAO.readOperations();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e.getInnerException());
        }
    }

    @Override
    public void updateOperation(int id, Operation updOperation) throws ServiceException {
        if(updOperation == null) {
            throw new ServiceException("Updated operation is null reference", new NullPointerException());
        }

        try{
            DAOFactory daoFactory = DAOFactory.getInstance();
            AccountDAO accountDAO = daoFactory.getAccountDAO();

            accountDAO.updateOperation(id, updOperation);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e.getInnerException());
        }
    }

    @Override
    public void deleteOperation(int id) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            AccountDAO accountDAO = daoFactory.getAccountDAO();

            accountDAO.deleteOperation(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e.getInnerException());
        }
    }
}
