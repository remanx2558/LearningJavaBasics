package CricBuzz.util;

import java.util.Scanner;

public enum ScannerSingleton {
    INSTANCE;
    private final Scanner scanner;

    ScannerSingleton() {
        System.out.println("Creating a new Scanner instance...");
        scanner=new Scanner(System.in);
    }

    public Scanner getScanner() {
       return scanner;
    }
}
