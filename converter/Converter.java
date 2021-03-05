package converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.CountDownLatch;
import java.util.zip.DeflaterOutputStream;

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
            return convertToDecimal(splitDigit);
        } else {
            String[] decimalDigit = convertToDecimal(splitDigit).split("\\.");
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

    private String convertToDecimal(String[] splitDigit) {
        Double integerPart = (double) Integer.parseInt(splitDigit[0], data.getBase());
        Double fractionalPart = convertFractionalPartToDecimal(splitDigit[1]);
        Double sum = integerPart + fractionalPart;
        return String.format("%.5f",sum);
    }

    private Double convertFractionalPartToDecimal(String digit) {
        char[] symbolsArray = digit.toCharArray();
        double sum = 0.0;
        int coefficient = 1;
        for (char ch : symbolsArray) {
            int decimalValue = Integer.parseInt(String.valueOf(ch), data.getBase());
            sum += (double)  decimalValue / Math.pow(data.getBase(), coefficient);
            coefficient++;
        }
        return sum;
    }

    private String convertFractionalPartFromDecimal(String digit) {
        double temp = Double.parseDouble("0." + digit);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digit.length(); i++) {
            double allSymbols = new BigDecimal(temp * data.getBaseToConvert()).setScale(digit.length(), RoundingMode.DOWN).doubleValue();
            int fractionalSymbol = (int) Math.floor(allSymbols);
            temp = new BigDecimal(allSymbols - fractionalSymbol).setScale(digit.length(), RoundingMode.DOWN).doubleValue();
            sb.append(Integer.toString(fractionalSymbol, 36));
        }
        return sb.toString();
    }


}
