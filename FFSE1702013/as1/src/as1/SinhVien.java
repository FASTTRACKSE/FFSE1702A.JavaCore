package as1;

import java.util.Scanner;

public class SinhVien {
	private String id;
	private String name;
	private int age;
	private String address;
	private float gpa;
	 public SinhVien () {}
	public SinhVien(String id, String name, int age, String address, float gpa) {
		super();
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
		if (age <= 150) this.age = age;
		else System.out.println("Tuổi không hợp lệ!");
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
		System.out.println(this.getId()+" | Tên: "+ this.getName()+ "| Tuổi: " + this.getAge()+" | Địa chỉ: "+ this.getAddress()+ " | Điểm trung bình: "+this.getGpa());
	}
	int control = 6;
	SinhVien[] listSv = new SinhVien[50];
	public static void main(String arg[]) {
		System.out.println("1. Thêm sinh viên.");
		System.out.println("2. Cập nhật thông tin sinh viên theo ID");
		System.out.println("3. Xóa sinh viên theo ID");
		System.out.println("4. Sắp sếp sinh viên theo tên");
		System.out.println("5. Hiển thị danh sách sinh viên");
		System.out.println("0. Kết thúc chương trình.");
	System.out.println("Chọn chức năng:");
	Scanner scanner = new Scanner(System.in);
	int soluong = 0;
	int control = Integer.parseInt(scanner.nextLine());
	if (control == 1) {
		System.out.println("Bạn muốn nhập bao nhiêu sinh viên:");
	soluong = Integer.parseInt(scanner.nextLine());
	for (int i = 0; i<soluong;i++) {
		int dem = i+1;
		System.out.println("Nhập sinh viên thứ: " + dem);
		SinhVien sv = new SinhVien();
		
		System.out.println("Nhập ID sinh viên: ");
		String id = scanner.nextLine();
		sv.setId(id);
		
		System.out.println("Nhập tên sinh viên: ");
		String name = scanner.nextLine();
		sv.setName(name);
		
		System.out.println("Nhập tuổi sinh viên: ");
		int age = Integer.parseInt(scanner.nextLine());
		sv.setAge(age);
		
		System.out.println("Nhập địa chỉ sinh viên: ");
		String address = scanner.nextLine();
		sv.setAddress(address);
		
		System.out.println("Nhập điểm trung bình sinh viên: ");
		float gpa = Integer.parseInt(scanner.nextLine());
		sv.setGpa(gpa);
      //listSv[i]= sv;
	}
	}
	
	else if (control == 5) {
		for (int i = 0; i < soluong; i++) {
			//listSv[i].display();
		}
	}
	
	while (control != 0);
	
	}}
