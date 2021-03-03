package converter;


public class Main {
    public static void main(String[] args) {

        DataGrabber dataGrabber = new DataGrabber();
        dataGrabber.grabDigitAndBase();
        DigitsConverseAndPrinter digitsPrinter = new DigitsConverseAndPrinter(dataGrabber.getData());

        digitsPrinter.printData();


//        int test = 4242;
//
//        int out = Integer.parseInt(Integer.toString(test), 21);
//        String in = Integer.toString(out, 6);
//        System.out.println(in);
    }
}
