package converter;

import java.util.Scanner;

public class DataGrabber {

    private Data data;

    public void grabDigitAndBase() {
        Scanner scanner = new Scanner(System.in);
        data = new Data(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    }

    public Data getData() {
        return data;
    }
}
