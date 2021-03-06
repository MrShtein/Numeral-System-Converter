package converter;

public class DigitsConverseAndPrinter {

    private int digitToPrint;
    private Data data;

    public DigitsConverseAndPrinter(int digitToPrint) {
        this.digitToPrint = digitToPrint;
    }

    public DigitsConverseAndPrinter(Data data) {
        this.data = data;
    }

    protected void printData() {

    }

    protected void printAnswer() {
        System.out.printf("%s = 0b%s", digitToPrint, Integer.toBinaryString(digitToPrint));
    }

    protected void covertAndPrintLastDigit() {
        String octal = Integer.toOctalString(digitToPrint);
        System.out.printf("%s", octal.charAt(octal.length() - 1));
    }

    public void printVariant(Data data) {
        switch (data.getBase()) {
            case 2:
                printBinView(data.getDigit());
                break;
            case 8:
                printOctalView(data.getDigit());
                break;
            case 16:
                printHexView(data.getDigit());
                break;
            default:
                throw new IllegalArgumentException("Something wrong with Data");
        }
    }

    private void printBinView(String digit) {
        System.out.printf("0b%s", digit);
    }

    private void printOctalView(String digit) {
        System.out.printf("0%s", digit);
    }

    private void printHexView(String digit) {
        System.out.printf("0x%s", digit);
    }
}
