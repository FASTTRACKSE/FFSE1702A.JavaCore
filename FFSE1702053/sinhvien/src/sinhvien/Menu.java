package sinhvien;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Collections;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Collections;

public class Menu {
    ArrayList<SinhVien> arrSV = new ArrayList();
    private Scanner scanner;

    public Menu() {
        super();
    }

    public void giaTriMacDinh() {
        arrSV.add(new SinhVien("FFSE01", "Nguyễn Văn H", 20, "DAK lak", 9.6));
        
    }

    public void themSinhVien(SinhVien sv) {
        int n;
        scanner = new Scanner(System.in);
        System.out.print("Nhập số sinh viên: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
            sv = new SinhVien();
            sv.nhap();
            arrSV.add(sv);
        }
        System.out.println("Thêm thành công " + n + " sinh viên!\n");
    }

    public void updateByID() {
        scanner = new Scanner(System.in);
        System.out.print("Nhập ID sinh viên: ");
        String id = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < arrSV.size(); i++) {
            if (arrSV.get(i).id.equals(id)) {
                index = i;
                SinhVien temp = new SinhVien();
                temp.nhap();
                arrSV.set(index, temp);
                System.out.println("Update thành công!\n");
                break;
            }
        }
        if (index == -1) {
            System.out.println("Không tìm thấy ID sinh viên!\n");
        }
    }

    public void deleteByID() {
        scanner = new Scanner(System.in);
        System.out.print("Nhập ID sinh viên: ");
        String id = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < arrSV.size(); i++) {
            if (arrSV.get(i).id.equals(id)) {
                index = i;
                arrSV.remove(index);
                ;
                System.out.println("Xóa thành công!\n");
                break;
            }
        }
        if (index == -1) {
            System.out.println("Không tìm thấy ID sinh viên!\n");
        }
    }

    public void sortByName() {
        Collections.sort(arrSV, SinhVien.sortByName);
        System.out.println("Sắp xếp thành công!\n");
    }

    public void sortByGPA() {
        Collections.sort(arrSV, SinhVien.sortByGPA);
        System.out.println("Sắp xếp thành công!\n");
    }

    public void hienThiSV() {
        System.out.println("Danh sách sinh viên");
        System.out.println("+--------+----------------------+-----+----------------------+------+");
        System.out.println("|   ID   |         Name         | Age |       Address        |  GPA |");
        System.out.println("+--------+----------------------+-----+----------------------+------+");
        for (int i = 0; i < arrSV.size(); i++) {
            arrSV.get(i).xuat();
        }
        System.out.println("+--------+----------------------+-----+----------------------+------+");
    }

}