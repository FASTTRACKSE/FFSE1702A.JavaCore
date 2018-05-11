
public class HocSinh {
	String hoTen;
	String ngaySinh;
	float diemToan;
	float diemLy;
	float diemHoa;
	
	public String xepLoaiHs() {
		float diemTrungBinh = ((diemHoa + diemLy + diemToan) / 3);
		 String kq = "kem";
		 if (diemTrungBinh >= 8) {
			 kq = "gioi" ;
		 }else if(diemTrungBinh >=7) {
			 kq = "kha";
		 }else if (diemTrungBinh >=5) {
			 kq = "trung binh";
		 }
		return kq;
	}
	
}
