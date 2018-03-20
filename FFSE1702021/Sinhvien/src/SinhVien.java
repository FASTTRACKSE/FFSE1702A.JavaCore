

import java.util.ArrayList;

import java.util.Scanner;

public class SinhVien {

	 
	    private String hoten;
	    private int tuoi;
	    private int diem1;
	    private int diem2;
	    private float tb;
	    private String loai;

	    public SinhVien() {
	    }

	    public SinhVien(String hoten, int tuoi, 
	    		int diem1, int diem2,float tb,String loai) {
	        super();
	        this.hoten = hoten;
	        this.tuoi = tuoi;
	        this.diem1 = diem1;
	        this.diem2 = diem2;
	        this.tb = tb;
	        this.loai = loai;
	    }


		public String getHoten() {
			return hoten;
		}

		public void setHoten(String hoten) {
			this.hoten = hoten;
		}

		public int getTuoi() {
			return tuoi;
		}

		public void setTuoi(int tuoi) {
			this.tuoi = tuoi;
		}

		public int getDiem1() {
			return diem1;
		}

		public void setDiem1(int diem1) {
			this.diem1 = diem1;
		}

		public int getDiem2() {
			return diem2;
		}

		public void setDiem2(int diem2) {
			this.diem2 = diem2;
		}

		public float getTb() {
			return tb;
		}

		public void setTb(float tb) {
			this.tb = tb;
		}

		public String getLoai() {
			return loai;
		}

		public void setLoai(String loai) {
			this.loai=loai;
		}
		  public static void main(String[] args) {
		    	
		    	ArrayList<SinhVien> SV = new ArrayList<>();
				String kt = "yes";
				while(kt == "yes") {
					System.out.println("*******************************");
					System.out.println("1.Nhap sinh viên");
					System.out.println("2.Hiện danh sách sinh viên ");
					System.out.println("3.Hiện danh sách theo thứ tự Họ tên sinh viên từ A-Z");
					System.out.println("4.Hiện danh sách theo thứ tự điểm trung bình từ cao đến thấp");
					
					System.out.println("*******************************");
					System.out.print("Chọn chức năng số: ");
					Scanner Input1= new Scanner(System.in);
					int n = Input1.nextInt();
					
				Scanner input2= new Scanner(System.in);
				if(n==1) {
					System.out.print("Nhập số sinh viên: ");
				
					int number = Integer.parseInt(input2.nextLine());
					for(int i=0; i < number; i++) {
						int dem =i+1;
					System.out.println("Sinh vien "+ dem);
					
					SinhVien sv = new SinhVien();
					
					System.out.println("nhap ten");
					String hoten = input2.nextLine();
					sv.setHoten(hoten);
					
					System.out.println("tuoi");
					int tuoi = input2.nextInt();
					sv.setTuoi(tuoi);
					
					System.out.println("diem1");
					int diem1 = input2.nextInt();
					sv.setDiem1(diem1);
					
					System.out.println("diem2");
					int diem2 = input2.nextInt();
					sv.setDiem2(diem2);
					
					sv.setTb((float) ((sv.getDiem1() +sv.getDiem2()) / 2.0));
					if(sv.getTb() >= 8.5 ) {
						sv.setLoai("A");
					}else if(sv.getTb() >= 7.0 ) {
						sv.setLoai("B");
					}else if(sv.getTb() >= 5 ) {
						sv.setLoai("C");
					}else {
						sv.setLoai("D");
					}
					SV.add(sv);
					}
					
					
				  }
				if (n == 2) {
					for (int i = 0; i < SV.size(); i++) {
						System.out.println("Ten: " + SV.get(i).getHoten() + "|" + "Tuoi: " + SV.get(i).getTuoi()
								+ "|" + "Diem1: " + SV.get(i).getDiem1() + "|" + "Diem2 "
								+ SV.get(i).getDiem2() + "|" + "TB " + SV.get(i).getTb()+"Loại " + SV.get(i).getLoai());
					}
				}
				
				}
}
}