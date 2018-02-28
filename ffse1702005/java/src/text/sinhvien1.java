package text;
import java.util.Scanner;

public class sinhvien1 {
	private String id;
	private String name;
	private int age;
	private String address;
	private float avg;

	public sinhvien1() {
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

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public sinhvien1(String id, String name, int age, String address, float avg) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.avg = avg;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		sinhvien1[] dsSV = new sinhvien1[50];
		int index = 0;
		System.out.print("Số học sinh cần nhập: ");
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			//scanner.nextLine();
			sinhvien1 sv = new sinhvien1();
			System.out.print("Nhập ID của học sinh thứ " + (i + 1) + ": ");
			String id = scanner.nextLine();
			sv.setId(id);
			
			System.out.print("Nhập họ tên của học sinh thứ " + (i + 1) + ": ");
			String name = scanner.nextLine();

			System.out.print("Nhập số tuổi của học sinh thứ " + (i + 1) + ": ");
			int age = scanner.nextInt();

			System.out.print("Nhập địa chỉ của học sinh thứ " + (i + 1) + ": ");
			String address = scanner.nextLine();

			System.out.print("Nhập điểm TB của học sinh thứ " + (i + 1) + ": ");
			Float avg = scanner.nextFloat();

			System.out.println("ID: " + id);
			System.out.println("Họ tên: " + name);
			System.out.println("Tuổi: " + age);
			System.out.println("Địa chỉ: " + address);
			System.out.println("Điểm TB: " + avg);
		
			dsSV[index] = sv;
			index ++;
			
			
		}
	}
}
