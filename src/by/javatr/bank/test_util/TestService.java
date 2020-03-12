package by.javatr.bank.test_util;

import by.javatr.bank.bean.*;

import java.io.*;
import java.util.*;

public class TestService {
    public static void initUsersFileWithAdmin() throws IOException {
        Map<Integer, User> userMap = new HashMap<>();

        User admin = new User("admin", "admin", UserType.ADMIN);
        userMap.put(0, admin);

        setUsersFileWithUpdatedUserMap(userMap);
    }

    public static Map<Integer, User> getUserMapFromUsersFile() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("./src/users.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Map<Integer, User> userMap = (HashMap<Integer, User>)ois.readObject();

        return userMap;
    }

    public static void setUsersFileWithUpdatedUserMap(Map<Integer, User> userMap) throws IOException {
        FileOutputStream fos = new FileOutputStream("./src/users.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(userMap);
    }

    public static void addRandomAccountToAccountsFile(Map<Integer, Account> accountMap) throws IOException {
        Account account = new Account();
        List<Operation> operations = new ArrayList<>();
        Random random = new Random(System.currentTimeMillis());

        int amount = random.nextInt(5) + 1;

        for(int i = 0; i < amount; i++) {
            operations.add(new Operation(i, random.nextInt(500), FinanceType.values()[random.nextInt(2)]));
        }

        account.setOperations(operations);

        int id = accountMap.size();

        accountMap.put(id, account);

        setAccountsFileWithUpdatedAccountMap(accountMap);
    }

    public static Map<Integer, Account> getAccountMapFromAccountsFile() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("./src/financial_data.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Map<Integer, Account> accountMap = (HashMap<Integer, Account>)ois.readObject();

        return accountMap;
    }

    public static void setAccountsFileWithUpdatedAccountMap (Map<Integer, Account> accountMap) throws IOException {
        FileOutputStream fos = new FileOutputStream("./src/financial_data.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(accountMap);
    }
}
