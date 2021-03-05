package converter;

public class Data {

    private String digit;
    private int base;
    private int baseToConvert;

    public Data(int base, String digit, int baseToConvert) {
        this.digit = digit;
        this.base = base;
        this.baseToConvert = baseToConvert;
    }

    public String getDigit() {
        return digit;
    }

    public int getBase() {
        return base;
    }

    public int getBaseToConvert() {
        return baseToConvert;
    }

    public void setBase(int base) {
        this.base = base;
    }
}
