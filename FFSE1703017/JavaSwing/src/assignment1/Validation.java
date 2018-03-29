package assignment1;

public class Validation {
	static boolean chkDouble(String s) {
		try {
			Double.parseDouble(s.trim());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
