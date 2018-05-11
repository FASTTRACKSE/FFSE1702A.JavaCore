package tiendien.MAIN;

import tiendien.MODEL.ExceptionMD;
import tiendien.UI.thongkebaocaoUI;

public class bctkMain {
	public static void main(String[] args) {
	thongkebaocaoUI myUI = new thongkebaocaoUI();
	try {
		myUI.hienthi_bc();
	} catch (ExceptionMD e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
