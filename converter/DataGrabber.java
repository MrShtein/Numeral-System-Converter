package converter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataGrabber {

    public Data grabDigitAndBase() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        try {
            DataChecker dataChecker = new DataChecker();
            Data data = new Data();

            int base = scanner.nextInt();
            dataChecker.checkBase(base);
            data.setBase(base);

            String digit = scanner.next();
            dataChecker.checkDigit(digit, base);
            data.setDigit(digit);

            int baseToConvert = scanner.nextInt();
            dataChecker.checkBase(baseToConvert);
            data.setBaseToConvert(baseToConvert);
            return data;

        } catch (InputMismatchException error) {
            throw new InputMismatchException("error: Given data is wrong");

        } catch (NumberFormatException error) {
            throw new NumberFormatException("error: Given data is wrong");
        }
    }
}
