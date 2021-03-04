package converter;

import java.util.zip.DeflaterOutputStream;

public class Converter {

    private Data data;

    public Converter(Data data) {
        this.data = data;
    }

    public String convertData() {
        String[] splitDigit = splitDigitIntoTwoParts();
        if (splitDigit[1] == null) {
            return convertSimpleDigit(splitDigit[0]);
        }
        if (data.getBaseToConvert() == 10) {
            Double integerPart = convertSimpleDigit(splitDigit[0]);
            Double fractionalPart = convertFractionalPartToDecimal(splitDigit[1]);
            return String.format("%s.%s", integerPart, fractionalPart);
        } else {

        }

    }

    private String[] splitDigitIntoTwoParts() {
        String[] temp = new String[2];
        if (data.getDigit().contains(".")) {
            return data.getDigit().split("\\.");
        } else {
            temp[0] = data.getDigit();
            temp[1] = null;
        }
        return temp;
    }

    private String convertSimpleDigit(String digit) {
        if (data.getBase() == 1) {
            int length = digit.length();
            return Integer.toString(length, data.getBaseToConvert());
        } else if (data.getBaseToConvert() == 1) {
            StringBuilder sb = new StringBuilder();
            int value = Integer.parseInt(digit, 10);
            for (int i = 0; i < value; i++) {
                sb.append("1");
            }
            return sb.toString();
        } else {
            int value = Integer.parseInt(digit, data.getBase());
            return Integer.toString(value, data.getBaseToConvert());
        }
    }

    private String convertFractionalPartToDecimal(String digit) {
        char[] symbolsArray = digit.toCharArray();
        double sum = 0.0;
        for (char ch : symbolsArray) {
            if (Character.isLetter(ch)) {
                sum += (double) Integer.parseInt(String.valueOf(ch), data.getBase()) / 36;
            }
        }
        return Double.toString(sum);
    }

}
