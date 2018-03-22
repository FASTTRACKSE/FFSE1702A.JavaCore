package assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SinhVien1  {
    private String id;
    private String name;
    private int age;
    private String address;
    private float gpa;

    public SinhVien1() {
    }

    public SinhVien1(String id, String name, int age, 
            String address, float gpa) {
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
        this.age = age;
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
    public static void main(String[] args) {
    	
    	ArrayList<SinhVien1> SV = new ArrayList<>();
		String kt = "yes";
		while(kt == "yes") {
			System.out.println("*******************************");
			System.out.println("1.Thêm sinh viên");
			System.out.println("2.Cập nhật thông tin sinh viên theo ID");
			System.out.println("3.Xóa sinh viên theo ID");
			System.out.println("4.Sắp sếp sinh viên theo tên");
			System.out.println("5.Hiển thị danh sách sinh viên");
			System.out.println("0.Kết thúc chương trình");
			System.out.println("*******************************");
			System.out.print("Chọn chức năng số: ");
			Scanner input1= new Scanner(System.in);
			int n = input1.nextInt();
			
		Scanner input2= new Scanner(System.in);
		
		if(n==1) {
			System.out.print("Nhập số sinh viên: ");
		
			int number = Integer.parseInt(input2.nextLine());
			for(int i=0; i < number; i++) {
				int dem =i+1;
			System.out.println("Sinh vien "+ dem);
			
			SinhVien1 sv = new SinhVien1();
			
			System.out.println("nhap id");
			String id = input2.nextLine();
			sv.setId(id);
			
			
			System.out.println("nhap ten");
			String name = input2.nextLine();
			sv.setName(name);
			
			System.out.println("nhap tuoi");
			int age = Integer.parseInt(input2.nextLine());
			sv.setAge(age);
			
			
			System.out.println("nhap dia chi");
			String address = input2.nextLine();
			sv.setAddress(address);
			
			System.out.print("nhap diem");
			float gpa = Float.parseFloat(input2.nextLine());
			sv.setGpa(gpa);
			
			
			SV.add(sv);
			}
			
			
		  }
		if(n==2) {
			System.out.print("nhap id muon sua");
			String id = input2.nextLine();
			for(int i = 0; i < SV.size(); i++) {
				if(SV.get(i).getId().equals(id)) {
					
					
					System.out.println("nhap ten moi");
					String name = input2.nextLine();
					SV.get(i).setName(name);
					System.out.println("sua thanh cong");
				}
			}
		}
		if (n == 3) {
			System.out.print("Nhap ID can xóa: ");
			String id = input2.nextLine();
			
			for (int i = 0; i < SV.size(); i++) {
				if(SV.get(i).getId().equals(id)) {
					SV.remove(i);
				}
			}
	    }
		if(n==4) {
			//Sắp xếp danh sách theo theo thứ tự a b c!
	        Collections.sort(SV, new Comparator<SinhVien1>() {
	            @Override
	            public int compare(SinhVien1 sv1, SinhVien1 sv2) {
	                return (sv1.name.compareTo(sv2.name));
	                // Muốn đảo danh sách các bạn đối thành
	                //return (sv2.hoTen.compareTo(sv1.hoTen));
	            }
	        });
	        System.out.println("Danh sách sắp xếp theo tên trong bảng chữ cái a - b - c: ");
	        for (int i = 0; i < SV.size(); i++) {
	            System.out.println("Tên: " + SV.get(i).name + " Điểm: " + SV.get(i).gpa);
	        }

		}
		if (n == 5) {
			for (int i = 0; i < SV.size(); i++) {
				System.out.println("id: " + SV.get(i).getId() + "|" + "name: " + SV.get(i).getName()
						+ "|" + "age: " + SV.get(i).getAge() + "|" + "address: "
						+ SV.get(i).getAddress() + "|" + "gpa: " + SV.get(i).getGpa());
			}
		}
		Scanner myInput2 = new Scanner(System.in);
		System.out.println("\n Muốn dừng nhấn N không muốn dừng thì tùy thích mà nhấn nhé  ");
		kt = myInput2.nextLine();
		if (kt.equalsIgnoreCase("N") || kt.equalsIgnoreCase("No")) {
			break;
		} else {
			kt = "yes";
		 }
		
	   }
	}
  }

