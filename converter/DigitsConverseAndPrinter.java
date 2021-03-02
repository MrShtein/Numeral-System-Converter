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
        if (data.getBase() == 1) {
            int length = String.valueOf(data.getDigit()).length();
            System.out.printf("%s", Integer.toString(length, data.getBaseToConvert()));
        } else if (data.getBaseToConvert() == 1) {
            StringBuilder sb = new StringBuilder();
            int value = Integer.parseInt(Integer.toString(data.getDigit()), 10);
            for (int i = 0; i < value; i++) {
                sb.append("1");
            }
            System.out.printf("%s", sb.toString());
        } else {
            System.out.println(data.getDigit());
            System.out.println(data.getBase());
            System.out.println(data.getBaseToConvert());
            System.out.println("---");
            int value = Integer.parseInt(Integer.toString(data.getDigit(), data.getBase()));
            System.out.printf("%s", Integer.toString(value, data.getBaseToConvert()));
        }
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

    private void printBinView(int digit) {
        System.out.printf("0b%s", Long.toBinaryString(digit));
    }

    private void printOctalView(int digit) {
        System.out.printf("0%s", Long.toOctalString(digit));
    }

    private void printHexView(int digit) {
        System.out.printf("0x%s", Long.toHexString(digit));
    }
}
