package converter;



public class Main {
    public static void main(String[] args) {
        DataGrabber dataGrabber = new DataGrabber();
        try {
            Converter converter = new Converter(dataGrabber.grabDigitAndBase());
            System.out.println(converter.convertData());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
