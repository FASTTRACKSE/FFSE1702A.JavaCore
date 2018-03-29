import java.text.DecimalFormat;

public class PrintFloatingNumber {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.0");
        double[] tests = {2.50, 2f, 1.3751212, 2.1200};

        for(double d : tests) {
            System.out.println("--------------------");
            System.out.println("Normal print out value : " + d);
            System.out.printf("Format way: %.1f\n", d);
            System.out.println("DecimalFormat library way: " + df.format(d));
        }
	}
}