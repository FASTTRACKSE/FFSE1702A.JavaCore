package first_project;

import java.text.DecimalFormat;

public class Test {
	static String[] ten = { "Nguyễn Văn A", "Trần Thị B", "Trương Văn C", "Dương Thị D", "Trần Văn E" };

	public static void main(String[] args) {
		// float rate = (float) 10.3546645;
		// System.out.println(rate);
		// System.out.println((float) Math.floor(rate * 100) / 100);
		float rate1 = (float) (13456 * 1.0 / 1000);
		System.out.println(rate1);
		// System.out.println(Math.floor(13456 / 1000));
		DecimalFormat df = new DecimalFormat("#.0");
		System.out.println(df.format(rate1));
	}

}
