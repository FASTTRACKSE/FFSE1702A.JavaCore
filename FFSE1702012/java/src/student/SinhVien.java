package student;

import java.util.Scanner;
import java.util.Comparator;

public class SinhVien {
    public String id;
    public String name;
    public int age;
    public String address;
    public double gpa;
    public Scanner scanner;

    public SinhVien() {
        super();
    }

    public SinhVien(String id, String name, int age, String address, double gpa) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public static Comparator<SinhVien> sortByName = new Comparator<SinhVien>() {
        public int compare(SinhVien sv1, SinhVien sv2) {
            return sv1.name.compareTo(sv2.name);
        }
    };

    public static Comparator<SinhVien> sortByGPA = new Comparator<SinhVien>() {
        public int compare(SinhVien sv1, SinhVien sv2) {
            return Double.compare(sv2.gpa, sv1.gpa);
        }
    };

    public void nhap() {
        int age1;
        scanner = new Scanner(System.in);
        System.out.print("Nhập id sinh viên\t: ");
        id = scanner.nextLine();
        System.out.print("Nhập tên sinh viên\t: ");
        name = scanner.nextLine();
        //nhap tuoi sinh vien:
            System.out.print("Nhập tuổi sinh viên\t: ");
             age1 = Integer.parseInt(scanner.nextLine());
            if(age1 <=150 ) {
                age = age1;
            }
            else {
                System.out.println("Nhap lai tuổi cho sinh vien");
                age =   Integer.parseInt(scanner.nextLine());
            }
        System.out.print("Nhập địa chỉ sinh viên\t: ");
        address = scanner.nextLine();
        System.out.print("Nhập điểm trung bình\t: ");
        gpa = scanner.nextDouble();
        System.out.println("--------------------------------------------");
    }

    public void xuat() {
        System.out.printf("| %-6s | %-20s | %-3s | %-20s | %4s |\n", id, name, age, address, gpa);
    }
}