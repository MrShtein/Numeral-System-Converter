package converter;

public class DigitsPrinter {

    private int digitToPrint;

    public DigitsPrinter(int digitToPrint) {
        this.digitToPrint = digitToPrint;
    }

    public DigitsPrinter() {

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

    private void printBinView(long digit) {
        System.out.printf("0b%s", Long.toBinaryString(digit));
    }

    private void printOctalView(long digit) {
        System.out.printf("0%s", Long.toOctalString(digit));
    }

    private void printHexView(long digit) {
        System.out.printf("0x%s", Long.toHexString(digit));
    }
}
