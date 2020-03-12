package by.javatr.bank.dao.implementation;

import by.javatr.bank.bean.Account;
import by.javatr.bank.bean.Client;
import by.javatr.bank.bean.FinanceType;
import by.javatr.bank.bean.Operation;
import by.javatr.bank.dao.AccountDAO;
import by.javatr.bank.dao.exception.DAOException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileAccountDAO implements AccountDAO {

    @Override
    public void addOperation(FinanceType type, double sum) throws DAOException {
        if(type == null) {
            throw new DAOException("Type of operation is null reference", new NullPointerException());
        }
        if(sum <= 0) {
            throw new DAOException("Incorrect sum was entered", new IllegalArgumentException());
        }
        if(Client.getInstance().getAccount() == null) {
            throw new DAOException("You'll need to read account (operations) firstly", new NullPointerException());
        }

        int id = Client.getInstance().getAccount().getOperations().size();
        Operation op = new Operation(id, sum, type);

        Client.getInstance().getAccount().getOperations().add(op);


        updateAccountFile();
    }

        @Override
        public void readOperations() throws DAOException{
            try{
                FileInputStream fis = new FileInputStream("./src/financial_data.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);

                Map<Integer, Account> accountMap = (HashMap<Integer, Account>)ois.readObject();

                int id = Client.getInstance().getId();
                boolean statement = false;


                for (Map.Entry<Integer, Account> elem: accountMap.entrySet()) {
                    if(elem.getKey() == id) {
                        statement = true;
                        Client.getInstance().setAccount(elem.getValue());
                    }
                }

                if(!statement) {
                    Account account = new Account();
                    Client.getInstance().setAccount(account);
                    id = accountMap.size();

                    accountMap.put(id, account);
                    updateAccountFile();
                    accountMap = null; //удаляем более ненужную ссылку
                }

            } catch(IOException | ClassNotFoundException e) {
                throw new DAOException("Error with file", e);
            }
        }

    @Override
    public void updateOperation(int id, Operation updOperation) throws DAOException{
        if(updOperation == null) {
            throw new DAOException("Updated operation is null reference", new NullPointerException());
        }

        if(Client.getInstance().getAccount() == null) {
            throw new DAOException("You'll need to read account (operations) firstly", new NullPointerException());
        }
        try {
            Client.getInstance().getAccount().getOperations().remove(id);
            Client.getInstance().getAccount().getOperations().add(id, updOperation);

            updateAccountFile();
        } catch (IndexOutOfBoundsException e) {
            throw new DAOException("Incorrect id was entered", e);
        }
    }

    @Override
    public void deleteOperation(int id) throws DAOException{

        if(Client.getInstance().getAccount() == null) {
            throw new DAOException("You'll need to read account (operations) firstly", new NullPointerException());
        }

        try{
            List<Operation> operations = Client.getInstance().getAccount().getOperations();

            operations.remove(id);
            for (int i = 0; i < operations.size(); i++) {
                operations.get(i).setId(i);
            }

            updateAccountFile();
        } catch (IndexOutOfBoundsException e) {
            throw new DAOException("Incorrect id was entered", e);
        }
    }

    public void updateAccountFile() {
        try {
            FileInputStream fis = new FileInputStream("./src/financial_data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Map<Integer, Account> accountMap = (HashMap<Integer, Account>)ois.readObject();

            int id = Client.getInstance().getId();
            Account account = Client.getInstance().getAccount();

            accountMap.put(id, account);

            FileOutputStream fos = new FileOutputStream("./src/financial_data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(accountMap);

            accountMap = null; //удаляем более ненужную ссылку

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
