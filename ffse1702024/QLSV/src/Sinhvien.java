import java.util.Scanner;
public class Sinhvien {
private String id;
private String name;
private int age;
private String address;
private float gpa;
public Sinhvien() {
	super();
}
public Sinhvien(String id, String name, int age, String address, float gpa) {
	//super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.address = address;
	this.gpa = gpa;
}

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
	if(age<=150)
	this.age = age;
	else System.out.println("Tuổi không hợp lệ");
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public float getGpa() {
	return gpa;
}

public void setGpa(float gpa) {
	this.gpa = gpa;
} 
public void display() {
	System.out.println("id: "+this.getId()+ " | "+"name: "+this.getName()+ " | "+"tuổi: "+this.getAge()+ " | "+"địa chỉ: "+this.getAddress()+ " | "+"điểm trung bình: "+this.getGpa());
}
public static void main (String arg[]) {
	int control=6;
	Sinhvien[]  listSv = new Sinhvien[50];
	int soluong = 0;
	do {
		System.out.println("1.Them sinh vien");
		System.out.println("2.Cap nhat thong tin sinh vien");
		System.out.println("3.Xóa sinh vien theo ID");
		System.out.println("4.Sắp xếp sinh viên theo tên");
		System.out.println("5.Hiển thị danh sách sinh viên");
		System.out.println("0.kết thúc chương trình");

	System.out.print("chon chuc nang so : ");
	Scanner scanner = new Scanner(System.in);
		
	 control = Integer.parseInt(scanner.nextLine());
	
	
	if(control==1) {
		System.out.println("Ban muon nhap bao nhieu sinh vien: ");
		soluong = Integer.parseInt(scanner.nextLine()); 
		for (int i = 0 ;i<soluong;i++) {
				int dem = i+1;
				System.out.println("Nhap sinh vien thứ: "+dem);
				Sinhvien sv = new Sinhvien();
			
				System.out.print("Nhap id sinh vien: ");
				String id  = scanner.nextLine();
				sv.setId(id);
				
				System.out.print("Nhap tên sinh vien: ");
				String name  = scanner.nextLine();
				sv.setName(name);
			
				System.out.print("Nhap tuổi sinh vien: ");
				int age  = Integer.parseInt(scanner.nextLine());
				sv.setAge(age);
				
				System.out.print("Nhap dia chi sinh vien: ");
				String address  = scanner.nextLine();
				sv.setAddress(address);
				
				System.out.print("Nhap diem trung binh cua sinh vien: ");
				float gpa  = Float.parseFloat(scanner.nextLine());
				sv.setGpa(gpa);
				
				listSv[i]=sv;
		
			}
		}
	else if (control == 2) {
		System.out.println("nhap ID can thay doi thong tin: ");
		String id = scanner.nextLine();
		for(int i=0 ; i<soluong; i++) {
		if (listSv[i].getId().equals(id)) {
			System.out.print("nhap ten moi: ");
			String name = scanner.nextLine();
			listSv[i].setName(name);
			
			System.out.print("nhap dia chi moi: ");
			String address  = scanner.nextLine();
			listSv[i].setAddress(address);
			
			System.out.print("nhap tuoi moi: ");
			int age = Integer.parseInt(scanner.nextLine());
			listSv[i].setAge(age);
		}
		}
		
	}
	else if (control==4) {
		for (int i=0 ; i <= soluong-1 ; i++) { 
			for (int j = i+1 ; j < soluong ; j++ ) {
				if(listSv[i].getName().compareTo(listSv[j].getName())>0) {
					Sinhvien tam = listSv[i];
					listSv[i] = listSv[j];
					listSv[j] = tam ;
				}
				
			}
			
		}
	}
	else if (control==3) {
		System.out.print("Nhap id sinh vien can xoa: ");
		String id  = scanner.nextLine();
		for (int i=0;i<soluong;i++) {
			if(listSv[i].getId().equals(id)) {
				for(int j = i+1;j <soluong;j++) {
					listSv[i]=listSv[j];
					
				}
			}
		}
		listSv[soluong-1]=null;
	}
		else if (control == 5) {
				for (int i=0;i<soluong;i++) {
						listSv[i].display();
				}}}
				while(control!= 0);
		}
	}


