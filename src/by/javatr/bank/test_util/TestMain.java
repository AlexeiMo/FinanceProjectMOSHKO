package by.javatr.bank.test_util;

import by.javatr.bank.bean.Account;
import by.javatr.bank.bean.User;
import by.javatr.bank.bean.UserType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestMain {

    public static void main(String[] args) {
        try {

            //1. Загрузить админа в файл
            /*TestService.initUsersFileWithAdmin();*/

            //2. Просмотреть файл
            /*Map<Integer, User> userMap = TestService.getUserMapFromUsersFile();

            for (Map.Entry<Integer, User> elem: userMap.entrySet()) {
                System.out.println("id: " + elem.getKey() + " || " + elem.getValue().toString());
            }*/

            //3. Загрузить 2 пользователей в файл
            /*Map<Integer, User> userMap = TestService.getUserMapFromUsersFile();

            User testUser = new User("login", "password", UserType.CLIENT);
            User defaultUser = new User("teacher", "1234567890", UserType.CLIENT);

            userMap.put(1, testUser);
            userMap.put(2, defaultUser);

            TestService.setUsersFileWithUpdatedUserMap(userMap);*/

            //1. Загрузить аккаунт админа в файл
            /*Map<Integer, Account> accountMap = new HashMap<>();
            TestService.addRandomAccountToAccountsFile(accountMap);*/

            //2. Просмотреть файл
            Map<Integer, Account> accountMap = TestService.getAccountMapFromAccountsFile();

            for (Map.Entry<Integer, Account> elem: accountMap.entrySet()) {
                System.out.println("id: " + elem.getKey() + " || " + elem.getValue().toString());
            }

            //3.Загрузка очередного аккаунта в файл
            /*Map<Integer, Account> accountMap = TestService.getAccountMapFromAccountsFile();
            TestService.addRandomAccountToAccountsFile(accountMap);*/

        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
    }
}
