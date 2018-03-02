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

	public void display() {
		System.out.println(id + " | " + name + " | " + address + " | " + avg + "  |  " + age);
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
			scanner.nextLine();
			sinhvien1 sv = new sinhvien1();
			System.out.print("Nhập ID của học sinh thứ " + (i + 1) + ": ");
			String id = scanner.nextLine();
			sv.setId(id);

			System.out.print("Nhập họ tên của học sinh thứ " + (i + 1) + ": ");
			String name = scanner.nextLine();
			sv.setName(name);

			System.out.print("Nhập số tuổi của học sinh thứ " + (i + 1) + ": ");
			int age = scanner.nextInt();
			sv.setAge(age);

			scanner.nextLine();
			System.out.print("Nhập địa chỉ của học sinh thứ " + (i + 1) + ": ");
			String address = scanner.nextLine();
			sv.setAddress(address);

			System.out.print("Nhập điểm TB của học sinh thứ " + (i + 1) + ": ");
			Float avg = scanner.nextFloat();
			sv.setAvg(avg);

			System.out.println("ID: " + id);
			System.out.println("Họ tên: " + name);
			System.out.println("Tuổi: " + age);
			System.out.println("Địa chỉ: " + address);
			System.out.println("Điểm TB: " + avg);

			dsSV[index] = sv;
			index++;

		}
		for (;;) {
			try {
				System.out.println("");
				System.out.println("+>>      Menu      <<+");
				System.out.println("+|    1. Thêm SV    |+");
				System.out.println("+|    2. Update SV  |+");
				System.out.println("+|    3. Xóa SV     |+");
				System.out.println("+|    4. Sắp xếp SV |+");
				System.out.println("+|    5. List SV    |+");
				System.out.println("+>> Chọn chức năng <<+");

				Scanner myInput = new Scanner(System.in);
				int answer = myInput.nextInt();

				if (answer == 1) {
					System.out.print("Số học sinh cần nhập: ");
					int m = scanner.nextInt();

					for (int i = 0; i < m; i++) {
						scanner.nextLine();
						sinhvien1 sv = new sinhvien1();
						System.out.print("Nhập ID của học sinh thứ " + (i + 1) + ": ");
						String id = scanner.nextLine();
						sv.setId(id);

						System.out.print("Nhập họ tên của học sinh thứ " + (i + 1) + ": ");
						String name = scanner.nextLine();
						sv.setName(name);

						System.out.print("Nhập số tuổi của học sinh thứ " + (i + 1) + ": ");
						int age = scanner.nextInt();
						sv.setAge(age);

						scanner.nextLine();
						System.out.print("Nhập địa chỉ của học sinh thứ " + (i + 1) + ": ");
						String address = scanner.nextLine();
						sv.setAddress(address);

						System.out.print("Nhập điểm TB của học sinh thứ " + (i + 1) + ": ");
						Float avg = scanner.nextFloat();
						sv.setAvg(avg);

						System.out.println("ID: " + id);
						System.out.println("Họ tên: " + name);
						System.out.println("Tuổi: " + age);
						System.out.println("Địa chỉ: " + address);
						System.out.println("Điểm TB: " + avg);

						dsSV[index] = sv;
						index++;

					}
				}

				else if (answer == 2) {
					System.out.print("Nhập ID của sinh viên cần thay đổi: ");
					Scanner update = new Scanner(System.in);
					String id = update.nextLine();

					for (int i = 0; i < index; i++) {
						if (dsSV[i].getId().equals(id)) {
							System.out.print("Nhập tên sinh viên: ");
							Scanner tenSV = new Scanner(System.in);
							String name = tenSV.nextLine();
							dsSV[i].setName(name);
						}
					}
				}

				else if (answer == 3) {
					System.out.print("Nhập ID của sinh viên cần xóa: ");
					Scanner update = new Scanner(System.in);
					String id = update.nextLine();

					for (int i = 0; i < index; i++) {
						if (dsSV[i].getId().equals(id)) {
							for (int j = i + 1; j < index; j++) {
								dsSV[i] = dsSV[j];
							}
						}
					}
					dsSV[index - 1] = null;
					index--;
				}

				else if (answer == 4) {
					for (int i = 0; i < index; i++) {
						for (int j = i + 1; j < index; j++) {
							int a = dsSV[i].getName().compareTo(dsSV[j].getName());
							if (a>0) {
							sinhvien1 bien = dsSV[i];
								dsSV[i] = dsSV[j];
								dsSV[j] = bien;
								
							}
						}
					}
				}

				else if (answer == 5) {
					for (int i = 0; i < index; i++) {
						dsSV[i].display();
					}
				}

				else {
					System.out
							.println("+>> Nhập sai chức năng vui lòng nhập lại chức năng trong khoảng từ 1 đến 4 <<+");
				}
			} catch (Exception e) {
				System.out.println("+>> Error! Vui lòng nhập lại <<+");
			}
		}
	}
}
