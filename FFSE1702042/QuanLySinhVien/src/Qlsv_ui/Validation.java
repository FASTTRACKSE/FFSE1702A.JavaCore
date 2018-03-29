package Qlsv_ui;

public class Validation {
	static boolean chkInt(String s) {
		try {
			Integer.parseInt(s.trim());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	static boolean isEmpty(String s) {
		return s.trim().isEmpty();
	}

}
