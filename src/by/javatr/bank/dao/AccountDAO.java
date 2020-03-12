package by.javatr.bank.dao;

import by.javatr.bank.bean.FinanceType;
import by.javatr.bank.bean.Operation;
import by.javatr.bank.dao.exception.DAOException;

public interface AccountDAO {
    void addOperation(FinanceType type, double sum) throws DAOException;
    void readOperations() throws DAOException;
    void updateOperation(int id, Operation updOperation) throws DAOException;
    void deleteOperation(int id) throws DAOException;
}
