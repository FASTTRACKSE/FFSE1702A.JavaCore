package Process;



public class MainUI {

	public static LoginUI login = new LoginUI("Login");

	public static HomeUI home = new HomeUI();
	
	//public static KhachHang kh = new KhachHang(email);
	public static void main(String[] args) {
		login.addShow();
	}
}
