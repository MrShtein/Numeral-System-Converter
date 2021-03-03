package converter;

import java.util.Scanner;

public class DataGrabber {

    public Data grabDigitAndBase() {
        Scanner scanner = new Scanner(System.in);
        return new Data(scanner.nextInt(), scanner.next(), scanner.nextInt());
    }

}
