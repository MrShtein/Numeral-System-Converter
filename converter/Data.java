package converter;

public class Data {

    private long digit;
    private int base;

    public Data(int digit, int base) {
        this.digit = digit;
        this.base = base;
    }

    public long getDigit() {
        return digit;
    }

    public int getBase() {
        return base;
    }
}
