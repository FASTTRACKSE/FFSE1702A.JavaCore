package tiendien.MAIN;

import tiendien.MODEL.ExceptionMD;
import tiendien.UI.quanlykhachhangUI;

public class qlkhMain {
	public static void main(String[] args) {
	quanlykhachhangUI myMenu = new quanlykhachhangUI();
	try {
		myMenu.hienthi_kh();
	} catch (ExceptionMD e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
