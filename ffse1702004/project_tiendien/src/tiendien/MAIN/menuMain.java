package tiendien.MAIN;

import tiendien.MODEL.ExceptionMD;
import tiendien.UI.menuUI;

public class menuMain {
	public static void main(String[] args) {
	menuUI myMenu = new menuUI();
	try {
		myMenu.hienthi();
	} catch (ExceptionMD e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
