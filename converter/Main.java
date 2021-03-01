package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int digit = scanner.nextInt();
        DigitsPrinter printer = new DigitsPrinter(digit);
        printer.covertAndPrintLastDigit();
    }
}
