package converter;

public class Converter {

    private Data data;

    public Converter(Data data) {
        this.data = data;
    }

    private String[] splitDigitIntoTwoParts() {
        return data.getDigit().split("\\.");
    }

}
