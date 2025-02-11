package CricBuzz.util;

import java.util.Scanner;

public final class Input {
    private static final Scanner SCANNER = ScannerSingleton.INSTANCE.getScanner();

    private Input() {}

    public static String next() {
        return SCANNER.next();
    }

    public static int nextInt() {
        return SCANNER.nextInt();
    }
}
