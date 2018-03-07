package lab3;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Collections;

public class Menu {
    ArrayList<QLSV> arrSV = new ArrayList();
    private Scanner scanner;

    public Menu() {
        super();
    }

    public void giaTriMacDinh() {
        arrSV.add(new QLSV("FFSE01", "Nguyễn Văn A", 20, "Quang trị", 9.6));
        arrSV.add(new QLSV("FFSE02", "Nguyễn Văn  B", 21, "Quang trị", 9.6));
        arrSV.add(new QLSV("FFSE03", "Nguyễn Văn  C", 25, "Quang trị", 10.0));
        arrSV.add(new QLSV("FFSE04", "Nguyễn Văn  D", 23, "33 Bạch Đằng", 8.6));
        arrSV.add(new QLSV("FFSE05", "Nguyễn Văn  E", 19, "Quang trị", 5.8));
        arrSV.add(new QLSV("FFSE06", "Nguyễn Văn  F", 19, "99 Nguyễn Văn Linh", 7.6));
    }

    public void themQLSV(QLSV sv) {
        int n;
        scanner = new Scanner(System.in);
        System.out.print("Nhập số sinh viên: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
            sv = new QLSV();
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
                QLSV temp = new QLSV();
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
        Collections.sort(arrSV, QLSV.sortByName);
        System.out.println("Sắp xếp thành công!\n");
    }

    public void sortByGPA() {
        Collections.sort(arrSV, QLSV.sortByGPA);
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