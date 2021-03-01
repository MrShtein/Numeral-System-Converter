package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DataGrabber dataGrabber = new DataGrabber();
        DigitsPrinter digitsPrinter = new DigitsPrinter();
        dataGrabber.grabDigitAndBase();
        digitsPrinter.printVariant(dataGrabber.getData());

    }
}
