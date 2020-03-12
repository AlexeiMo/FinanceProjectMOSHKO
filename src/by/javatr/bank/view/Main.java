package by.javatr.bank.view;

import by.javatr.bank.bean.Client;
import by.javatr.bank.bean.FinanceType;
import by.javatr.bank.controller.Controller;
import by.javatr.bank.controller.exception.ControllerException;

import by.javatr.bank.bean.Operation;
import by.javatr.bank.scanner.DataScanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        int solution;
        String request = null;

        String login = null;
        String password = null;

        boolean statement = true;
        while(statement) {
            try {
                System.out.println("Please, select option: ");
                System.out.println("1. Sign in");
                System.out.println("2. Sign up");
                System.out.println("3. Exit");

                solution = DataScanner.readIntFromConsole();

                switch (solution) {
                    case 1: {
                        System.out.println("Please, input your login: ");
                        login = DataScanner.readStringFromConsole();

                        System.out.println("Please, input your password: ");
                        password = DataScanner.readStringFromConsole();

                        request = "sign_in " + login + " " + password;

                        controller.executeTask(request);
                        statement = false;
                        break;
                    }
                    case 2: {
                        System.out.println("Please, input your login: ");
                        login = DataScanner.readStringFromConsole();

                        System.out.println("Please, input your password: ");
                        password = DataScanner.readStringFromConsole();

                        request = "sign_up " + login + " " + password;

                        controller.executeTask(request);
                        statement = false;
                        break;
                    }
                    case 3: {
                        return;
                    }

                    default: {
                        System.out.println("You input incorrect option number(");
                        continue;
                    }
                }
            } catch (ControllerException e) {
                System.out.println(e.getMessage());
            }
        }

        double sum = 0.0;
        String type = null;
        int id = 0;

        statement = true;
        while(statement) {
            try {
                System.out.println("Welcome, " + Client.getInstance().getUserData().getLogin());

                System.out.println("Please, select option: ");
                System.out.println("1. Show list of your account's operations");
                System.out.println("2. Add new operation");
                System.out.println("3. Update exist operation");
                System.out.println("4. Delete exist operation");
                System.out.println("5. Exit");

                solution = DataScanner.readIntFromConsole();

                switch (solution) {
                    case 1: {

                        request = "read_operations ";
                        controller.executeTask(request);

                        System.out.println("List of your account's operations is: ");
                        for (Operation elem : Client.getInstance().getAccount().getOperations()) {
                            System.out.println(elem);
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Please, input sum of money of that operation (positive (\"+\")):");
                        sum = DataScanner.readDoubleFromConsole();

                        while(true) {
                            System.out.println("Please, choose type of that operation: ");
                            System.out.println("1. Income");
                            System.out.println("2. Outcome");

                            solution = DataScanner.readIntFromConsole();

                            if (solution != 1 && solution != 2) {
                                System.out.println("Incorrect choice");
                                continue;
                            }

                            type = (solution == 1) ? "INCOME" : "OUTCOME";
                            break;

                        }

                        request = "add_operation " + sum + " " + type;
                        break;
                    }
                    case 3: {
                        System.out.println("Please, input id of operation you want to update: ");
                        id = DataScanner.readIntFromConsole();

                        System.out.println("Please, input new sum of money of that operation (positive (\"+\")):");
                        sum = DataScanner.readDoubleFromConsole();

                        while(true) {
                            System.out.println("Please, choose new type of that operation: ");
                            System.out.println("1. Income");
                            System.out.println("2. Outcome");

                            solution = DataScanner.readIntFromConsole();

                            if (solution != 1 && solution != 2) {
                                System.out.println("Incorrect choice");
                                continue;
                            }

                            type = (solution == 1) ? "INCOME" : "OUTCOME";
                            break;

                        }

                        request = "update_operation " + id + " " + sum + " " + type;

                        controller.executeTask(request);
                        break;

                    }
                    case 4: {
                        System.out.println("Please, input id of operation you want to delete:");
                        id = DataScanner.readIntFromConsole();

                        request = "delete_operation " + id;

                        controller.executeTask(request);
                        break;
                    }
                    case 5: {
                        return;
                    }
                    default: {
                        System.out.println("You input incorrect option number(");
                        continue;
                    }
                }

            } catch(ControllerException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
