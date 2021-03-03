package converter;

public class Converter {

    private Data data;

    public Converter(Data data) {
        this.data = data;
    }

    public String convertData() {
        String[] splitDigit = splitDigitIntoTwoParts();
        if (splitDigit[1] == null) {
            return splitDigit[0];
        }
        String integerPart = convertIntegerPartToDecimal(splitDigit[0]);
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

    private String convertIntegerPartToDecimal(String digit) {
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

}
