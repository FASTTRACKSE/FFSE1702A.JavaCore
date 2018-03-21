package SinhVien;
import java.util.*;
public class Sinhvien {
	String id;
	String name;
	int age;
	String provice;
	int diem;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getProvice() {
		return provice;
	}
	
	public void setProvice(String provice) {
		this.provice = provice;
	}
	
	public int getDiem() {
		return diem;
	}
	
	public void setDiem(int diem) {
		this.diem = diem;
	}
	
	public void display() {
		System.out.println("ID sv: " + this.getId() + "  ||Ten sv: " + this.getName() + "  || Tuoi: " + this.getAge() + "  || Que quan: " + this.getProvice() + "  || Diem: " + this.getDiem());
	}
	public static void main(String args[]) {
		Scanner myInput = new Scanner(System.in);
		int control = 0;
		int soluong = 0;
		Sinhvien[] listsv = new Sinhvien[50];
		for(;;) {
		System.out.println("1. Them sinh vien");
		System.out.println("2. Cap nhat thong tin sinh vien theo ID");
		System.out.println("3. Xoa sinh vien theo ID");
		System.out.println("4. Sap xep sinh vien theo ten");
		System.out.println("5. Hien thi danh sach sinh vien");
		System.out.println("0. Ket thuc chuong trinh");
		System.out.print(">>Chon chuc nang so: ");
		control = Integer.parseInt(myInput.nextLine());
		
		//Chuc nang 1
		if(control == 1) {
			System.out.print("Ban muon nhap bao nhieu sinh vien: ");
			int number = Integer.parseInt(myInput.nextLine());
			for(int i = 0; i < number; i++) {
				Sinhvien sv = new Sinhvien();
				int dem = i + 1;
				
				System.out.println("Nhap sinh vien " + dem);
				System.out.print("Id sinh vien: ");
				String id = myInput.nextLine();
				sv.setId(id);
				
				System.out.print("Ten sinh vien: ");
				String name = myInput.nextLine();
				sv.setName(name);
				
				boolean check = true;
				while(check) {
					System.out.print("Tuoi: ");
					try {
					int age = Integer.parseInt(myInput.nextLine());
					sv.setAge(age);
					check = false;
					} catch(Exception e) {
						System.out.println("Nhap sai du lieu");
					}
				}
				
				System.out.print("Que quan: ");
				String provice = myInput.nextLine();
				sv.setProvice(provice);
				
				boolean chk = true;
				while(chk) {
					System.out.print("Diem: ");
					try {
					int diem = Integer.parseInt(myInput.nextLine());
					sv.setDiem(diem);
					chk = false;
					} catch(Exception e) {
						System.out.println("Nhap sai du lieu");
					}
				}
				
				listsv[soluong+i] = sv;
				soluong++;
			}
		}
		
		//Chuc nang 2
		if(control == 2) {
			System.out.print("ID sinh vien: ");
			String id = myInput.nextLine();
			for(int i = 0; i < soluong; i++) {
				if(listsv[i].getId().equals(id) ) {
					System.out.print("Nhap ten sv: ");
					String newName = myInput.nextLine();
					listsv[i].setName(newName);
				}
			}
		}
		
		//Chuc nang 3
		if(control == 3) {
			System.out.print("ID sinh vien: ");
			String id = myInput.nextLine();
			for(int i = 0; i < soluong; i++) {
				if(listsv[i].getId().equals(id)) {
					for(int j = i + 1; j < soluong; j++) {
						listsv[i] = listsv[j];
					}
				}
			}
			listsv[soluong-1] = null;
			soluong--;
		}
		
		//Chuc nang 4
		if(control == 4) {
			Sinhvien tam;
			for(int i = 0; i < soluong - 1; i++) {
				for(int j = i + 1; j < soluong; j ++) {
					if(listsv[i].getName().compareTo(listsv[j].getName()) > 0) {
						tam = listsv[i];
						listsv[i] = listsv[j];
						listsv[j] = tam;
					}
				}
			}
		}
		
		//Chuc nang 5
		if(control == 5) {
			for(int i = 0; i < soluong; i++) {
				listsv[i].display();
			}
		}
		
		//Chuc nang 0
		if(control == 0) {
			break;
		}
	}
	}
}

