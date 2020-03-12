package by.javatr.bank.dao.implementation;

import by.javatr.bank.bean.Client;
import by.javatr.bank.bean.User;
import by.javatr.bank.dao.UserDAO;
import by.javatr.bank.dao.exception.DAOException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileUserDAO implements UserDAO {
    public void signIn(String login, String password) throws DAOException {
        if(login == null || login.isEmpty()) {
            throw new DAOException("Incorrect login", new IllegalArgumentException());
        }
        if(password == null || password.isEmpty()) {
            throw new DAOException("Incorrect password", new IllegalArgumentException());
        }

        try {
            FileInputStream fis = new FileInputStream("./src/users.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Map<Integer,User> userMap = (HashMap<Integer, User>)ois.readObject();

            boolean statement = false;

            for (Map.Entry<Integer, User> elem: userMap.entrySet()) {
                if(elem.getValue().getLogin().equals(login) && elem.getValue().getPassword().equals(password)) { // проверка на совпадение логина и пароля
                    statement = true;
                    Client.getInstance().setUserData(elem.getValue());
                    Client.getInstance().setId(elem.getKey());
                    break;
                }
            }

            if(!statement) {
                throw new DAOException("User with these login and password doesn't exist in system", new IllegalArgumentException());
            }

        } catch(IOException | ClassNotFoundException e) {
            throw new DAOException("Error with file", e);
        }
    }
    public void signUp(User user) throws DAOException {
        if(user == null) {
            throw new DAOException("This user is null reference", new NullPointerException());
        }
        try {
            FileInputStream fis = new FileInputStream("./src/users.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Map<Integer,User> userMap = (HashMap<Integer, User>)ois.readObject();

            for (User elem: userMap.values()) {
                if(elem.getLogin().equals(user.getLogin()) && elem.getPassword().equals(user.getPassword())) {
                    throw new DAOException("User with such login and password already exists", new IllegalArgumentException());
                }
            }

            int id = userMap.size(); // получение следующего по порядку id

            userMap.put(id, user);

            FileOutputStream fos = new FileOutputStream("./src/users.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(userMap);

            Client.getInstance().setUserData(user);
            Client.getInstance().setId(id);

        } catch(IOException | ClassNotFoundException e) {
            throw new DAOException("Error with file", e);
        }
    }
}
