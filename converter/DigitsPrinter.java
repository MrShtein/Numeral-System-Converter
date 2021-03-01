package converter;

public class DigitsPrinter {

    private int digitToPrint;

    public DigitsPrinter(int digitToPrint) {
        this.digitToPrint = digitToPrint;
    }

    protected void printAnswer() {
        System.out.printf("%s = 0b%s", digitToPrint, Integer.toBinaryString(digitToPrint));
    }
}