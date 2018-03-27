public abstract class SinhVienFPT 
{
	String hoTen;
	String nganh;

	public SinhVienFPT(String hoTen ,String nganh)
	{
		this.hoTen = hoTen;
		this.nganh = nganh;
	}
	abstract double getDiem();
	

	String getHocluc()
	{
		String hocluc = "";
		if(getDiem() < 5 ) hocluc = "yeu";
		else if (getDiem() < 6.5 ) hocluc = "tb";
		else hocluc = " gioi";
		//chú ý bổ sung đầy đủ việc xếp loại 
		return hocluc;
	}
	void xuat()
	{
		System.out.println("ho ten :" + this.hoTen);
		System.out.println("nganh:" + this.nganh);
		System.out.println("Diem :" + this.getDiem());
		System.out.println("hoc luc :" + this.getHocluc());
	}

}