package converter;

public class Data {

    private String digit;
    private int base;
    private int baseToConvert;

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

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public void setBaseToConvert(int baseToConvert) {
        this.baseToConvert = baseToConvert;
    }
}
