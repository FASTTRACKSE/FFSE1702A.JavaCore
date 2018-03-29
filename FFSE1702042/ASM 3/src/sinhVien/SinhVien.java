package sinhVien;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class SinhVien {
	private String id;
	private String name;
	private 	int age;
	private String add;
	private float gpa;
    public SinhVien() {
    }
    public SinhVien(String id, String name, int age, String add, float gpa) {
          	super();
			this.id		=	id;
			this.name 	=	name;
			this.age 	=	age;
			this.add 	=	add;
			this.gpa	= 	gpa;
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
		this.age = age;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public static void main(String[] args) {
		ArrayList<SinhVien> sv	=	new ArrayList<>();
		String kt	=	"yes";
		while(kt== "yes") {
			System.out.println("*****************************");
			System.out.println("1.Thêm sinh viên");
			System.out.println("2.Cập nhật thông tin sinh viên theo ID");
			System.out.println("3.Xóa sinh viên theo ID");
			System.out.println("4.Sắp sếp sinh viên theo tên");
			System.out.println("5.Hiển thị danh sách sinh viên");
			System.out.println("0.Kết thúc chương trình");
			System.out.println("*****************************");
			System.out.print("Chọn chức năng số: ");
			Scanner input= new Scanner(System.in);
			int n	=	input.nextInt();
			Scanner input1= new Scanner(System.in);
			if(n==1) {
				System.out.println("Số sinh viên cần nhập: ");
				int num = Integer.parseInt(input1.nextLine());
				for(int i=0; i<num; i++) {
					int tt = i+1;
					System.out.println("Sinh viên thứ " + tt);
					SinhVien sv1	=	new SinhVien();
					System.out.println("Nhập id: ");
					String id	=	input1.nextLine();
					sv1.setId(id);
					System.out.println("Nhập tên sinh viên: ");
					String name	=	input1.nextLine();
					sv1.setName(name);
					System.out.println("Nhập tuổi");
					int age	=	Integer.parseInt(input1.nextLine());
					sv1.setAge(age);
					System.out.println("Nhập địa chỉ: ");
					String add	=	input1.nextLine();
					sv1.setAdd(add);
					System.out.println("Nhập điểm:");
					float gpa	=	input1.nextFloat();
					sv1.setGpa(gpa);
					sv.add(sv1);
				}
			}
			if(n==2) {
				System.out.println("Nhập id sinh viên muốn sửa: ");
				String id	=	input1.nextLine();
				for(int i=0; i<sv.size(); i++) {
					if(sv.get(i).getId().equals(id)) {
						System.out.println("Nhập tên mới: ");
						String name	=	input1.nextLine();
						sv.get(i).setName(name);
						System.out.println("Cập nhật thành công!");
					}
				}
			}
			if(n==3) {
				System.out.println("Nhập id sinh viên cần xóa!");
				String id	=	input1.nextLine();
				for(int i=0; i<sv.size(); i++) {
					if(sv.get(i).getId().equals(id)) {
						sv.remove(i);
					}
				}
			}
			if(n==4) {
				Collections.sort(sv, new Comparator<SinhVien>() {
					@Override
					public int compare(SinhVien sv2, SinhVien sv3) {
						return(sv2.name.compareTo(sv3.name));
					}
				});
				System.out.println("Hiển thị danh sách sinh viên theo tên: ");
				for(int i=0; i< sv.size(); i++) {
					System.out.println("Tên: " + sv.get(i).name +";	Điểm: "+ sv.get(i).gpa);
				}
			}
			if(n==5) {
				for(int i=0; i<sv.size(); i++) {
					System.out.println("id: " + sv.get(i).getId() + "|" + "name: " + sv.get(i).getName()
							+ "|" + "age: " + sv.get(i).getAge() + "|" + "address: "
							+ sv.get(i).getAdd() + "|" + "gpa: " + sv.get(i).getGpa());
				}
			}
			Scanner myInput2 = new Scanner(System.in);
			System.out.println("\n Nhấn phím bất kì để tiếp tục, nhấn N để dừng!");
			kt = myInput2.nextLine();
			if (kt.equalsIgnoreCase("N") || kt.equalsIgnoreCase("No")) {
				break;
			} else {
				kt = "yes";
			 }

		}
	}
	
}
