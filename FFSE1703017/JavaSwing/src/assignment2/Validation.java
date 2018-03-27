package assignment2;

public class Validation {
	static boolean chkInt(String s) {
		try {
			Integer.parseInt(s.trim());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
