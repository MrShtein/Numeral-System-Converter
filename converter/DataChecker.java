package converter;

import java.util.InputMismatchException;

public class DataChecker {

    public void checkBase(int digit) throws InputMismatchException {
        if (digit < 1 || digit > 36) {
            throw new InputMismatchException("error: Given base is wrong");
        }
    }

    public void checkDigit(String digit, int base) throws InputMismatchException {
        String[] digits = digit.split("");
        for (String item : digits) {
            if (".".equals(item)) {
                continue;
            }
            if (base == 1) {
                if (Integer.parseInt(item) != 1) {
                    throw new InputMismatchException("error");
                }
            } else {
                int decimalDigit = Integer.parseInt(item, base);
            }
        }


    }

}
