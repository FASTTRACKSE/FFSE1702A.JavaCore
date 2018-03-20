package tienDien;

public class KhachHang {
	
		String hoten;
		String sonha;
		int msct;
		public KhachHang(String hoten, String sonha, int msct) {
			this.hoten	=	hoten;
			this.sonha	=	sonha;
			this.msct	= 	msct;
		}
		public String getHoten() {
			return hoten;
		}
		public void setHoten(String hoten) {
			this.hoten = hoten;
		}
		public String getSonha() {
			return sonha;
		}
		public void setSonha(String sonha) {
			this.sonha = sonha;
		}
		public int getMsct() {
			return msct;
		}
		public void setMsct(int msct) {
			this.msct = msct;
		}
		
	
}
