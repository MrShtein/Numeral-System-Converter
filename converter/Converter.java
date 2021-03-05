package converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter {

    private final Data data;

    public Converter(Data data) {
        this.data = data;
    }

    public String convertData() {
        String[] splitDigit = splitDigitIntoTwoParts();
        if (splitDigit[1] == null) {
           return convertSimpleDigit(splitDigit[0]);
        }
        if (data.getBaseToConvert() == 10) {
            return String.format("%.5f", convertToDecimal(splitDigit));
        } else {
            String[] decimalDigit;
            if (data.getBase() != 10) {
                decimalDigit = String.format("%s", convertToDecimal(splitDigit)).split("\\.");
                data.setBase(10);
            } else {
                decimalDigit = splitDigit;
            }
            String integerPart = convertSimpleDigit(decimalDigit[0]);
            String fractionalPart = convertFractionalPartFromDecimal(decimalDigit[1]);
            return String.format("%s.%s", integerPart, fractionalPart);
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

    private Double convertToDecimal(String[] splitDigit) {
        Double integerPart = (double) Integer.parseInt(splitDigit[0], data.getBase());
        Double fractionalPart = convertFractionalPartToDecimal(splitDigit[1]);
        return integerPart + fractionalPart;
    }

    private Double convertFractionalPartToDecimal(String digit) {
        char[] symbolsArray = digit.toCharArray();
        double sum = 0.0;
        int coefficient = 1;
        for (char ch : symbolsArray) {
            int decimalValue = Integer.parseInt(String.valueOf(ch), 36);
            sum += decimalValue / Math.pow(data.getBase(), coefficient);
            coefficient++;
        }
        return sum;
    }

    private String convertFractionalPartFromDecimal(String digit) {
        double temp = Double.parseDouble("0." + digit);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            double allSymbols = temp * data.getBaseToConvert();
            int fractionalSymbol = (int) allSymbols;
            temp = allSymbols - fractionalSymbol;
            sb.append(Integer.toString(fractionalSymbol, data.getBaseToConvert()));
        }
        return sb.substring(0, 5);
    }


}
