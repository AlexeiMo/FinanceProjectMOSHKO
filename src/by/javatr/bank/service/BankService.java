package by.javatr.bank.service;

import by.javatr.bank.bean.FinanceType;
import by.javatr.bank.bean.Operation;
import by.javatr.bank.service.exception.ServiceException;

public interface BankService {
    void addOperation(FinanceType type, double sum) throws ServiceException;
    void readOperations() throws ServiceException;
    void updateOperation(int id, Operation updOperation) throws ServiceException;
    void deleteOperation(int id) throws ServiceException;
}
