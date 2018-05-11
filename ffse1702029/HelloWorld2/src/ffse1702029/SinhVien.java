package ffse1702029;

public class SinhVien {
	private String ms;
	private String ht;
	private int tuoi;
	private String email;
	
	public SinhVien(String ms, String ht, int tuoi, String email) {
		super();
		this.ms = ms;
		this.ht = ht;
		this.tuoi = tuoi;
		this.email = email;
	}
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	public String getHt() {
		return ht;
	}
	public void setHt(String ht) {
		this.ht = ht;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SinhVien() {
		super();	
	}
	public String toString() {
		return "Sinhvien [mssv="+ ms +", hoten="+ ht +", namsinh="+tuoi+", email"+email+"]";
	}
}
