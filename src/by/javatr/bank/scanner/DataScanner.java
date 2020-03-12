package by.javatr.bank.scanner;

import java.util.Scanner;

public class DataScanner {
    public static int readIntFromConsole() {
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextInt()) {
            scanner.next();
        }

        int result = scanner.nextInt();

        return result;
    }

    public static double readDoubleFromConsole() {
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextDouble()) {
            scanner.next();
        }

        double result = scanner.nextDouble();

        return result;
    }

    public static String readStringFromConsole() {
        Scanner scanner = new Scanner(System.in);

        String result = scanner.next();

        return result;
    }
}
