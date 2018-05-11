package tiendien.MAIN;

import tiendien.MODEL.ExceptionMD;
import tiendien.UI.quanlybienlaiUI;

public class qlblMain {
	public static void main(String[] args) {
	quanlybienlaiUI myqlbl = new quanlybienlaiUI();
	try {
		myqlbl.hienthi_qlbl();
	} catch (ExceptionMD e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
