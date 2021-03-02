package converter;

public class Data {

    private int digit;
    private int base;
    private int baseToConvert;

    public Data(int base, int digit, int baseToConvert) {
        this.digit = digit;
        this.base = base;
        this.baseToConvert = baseToConvert;
    }

    public int getDigit() {
        return digit;
    }

    public int getBase() {
        return base;
    }

    public int getBaseToConvert() {
        return baseToConvert;
    }
}
