package Canbo;
    import java.util.Scanner;

import student.SinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Main {
    public static Scanner myinput = new Scanner(System.in);
    static ArrayList<Giangvien> gv = new ArrayList<>();
    static ArrayList<Nhanvien> nv = new ArrayList<>();
    private Object phongban;
    Giangvien giangvien;
    Nhanvien nhanvien;
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }
    static boolean checkexistHoten(String n) {
        for(Giangvien gv : gv ) {
            if (gv.getHoten().equals(n)) {
                return true;
            }
        }
        
        for( Nhanvien nv: nv) 
        {
            if(nv.getHoten().equals(n)) {
                return true;
            }
        }
        return false;
    }

    public void nhanviendefault() {
        //nhan vien:  hoten, phongban, songaycong, phucap, chucvu, hesoluong);
        nv.add(new Nhanvien("Nguyễn Văn A", "Phòng ql", 20 , 2000, "Trưởng phòng", 1.8, 3768));
        nv.add(new Nhanvien("Nguyễn Văn B", "Phòng ql", 25 , 1000, "Phó phòng", 1.5,2845 ));
        nv.add(new Nhanvien("Nguyễn Văn C", "Phòng nước", 27 , 500, "Nhân viên", 1.3, 2259));
        nv.add(new Nhanvien("Nguyễn Văn D", "Phòng nướcl", 28 , 500, "Nhân viên", 1.3 , 2289));
        nv.add(new Nhanvien("Nguyễn Văn E", "Phòng ql", 29 , 500, "Nhân viên", 1.3 , 2319));
    }
    public void giangviendefault() {
        // hoten, khoa, trinhdo, phucap, sotiet, hesoluong
        gv.add(new Giangvien("Lê Thị A","Môi trường","Cử nhân", 300, 50, 1.3, 3499));
        gv.add(new Giangvien("Lê Thị B","Môi trường","Thạc sĩ", 500, 50, 1.5 , 3845));
        gv.add(new Giangvien("Lê Thị C","IT","Tiến sĩ", 1000, 50, 1.8 , 4564));
        gv.add(new Giangvien("Lê Thị D","Môi trường","Cử nhân", 300, 40, 1.3 , 3049));
        gv.add(new Giangvien("Lê Thị E","IT","Tiến sĩ", 1000, 50, 1.6, 4418));
    }
    public void themnhanvien() {
        Nhanvien nv1 = new Nhanvien();
        int n;
        System.out.println("Nhập số nhân viên cần thêm");
        n = myinput.nextInt();
        for(int i =0; i<n;i++) {
            System.out.println("Nhập nhân viên thứ " + (i+1));
            nv1.nhap();
            nv.add(nv1);
        }
        System.out.println("Thêm thành công nhân viên");
    }
    public void themgiangvien() {
        Giangvien gv1 = new Giangvien();
        int n;
        System.out.println("Nhập số Giảng viên cần thêm");
        n = myinput.nextInt();
        for(int i =0; i<n;i++) {
            System.out.println("Nhập giảng viên thứ " + (i+1));
            gv1.nhap();
            gv.add(gv1);
        }
        System.out.println("Thêm thành công giảng viên");
    }
    public void hienThiNhanvien() {
        //nhan vien:  hoten, phongban, songaycong, phucap, chucvu, hesoluong);
        System.out.println("Danh sách Nhân viên");
        System.out.println("+--------------------------------------------------------------------");
        System.out.println("|   Họ tên   |         Phòng ban         | Số ngày công |       Phụ cấp     | Chức vụ  | Hệ số lương||");
        for (int i = 0; i < nv.size(); i++) {
            nv.get(i).xuat();
        }
        System.out.println("+--------------------------------------------------------------------");
    }
    public void hienThiGiangvien() {
        // hoten, khoa, trinhdo, phucap, sotiet, hesoluong
        System.out.println("Danh sách Nhân viên");
        System.out.println("+--------------------------------------------------------------------");
        System.out.println("|   Họ tên   |         Khoa         | Trình độ |       Phụ cấp        |  Số Tiết | Hệ số lương|");
        for (int i = 0; i < gv.size(); i++) {
            gv.get(i).xuat();
        }
        System.out.println("+--------------------------------------------------------------------");
    }
    public void tinhluongnhanvien() {
        double tongluong = 0;
        System.out.println("Tổng lương của Nhân viên");
        for(int i =0; i<nv.size();i++) {
                       tongluong += nv.get(i).getLuong(); 
        }
        System.out.println("" + tongluong);
    }
    public void tinhluonGiangvien() {
        double tongluong =0;
        System.out.println("Tổng lương của giảng viên");
        for(int i =0; i<gv.size();i++) {
                       tongluong += gv.get(i).getLuong(); 
        }

        System.out.println("" + tongluong);
    }
    
    public void getDsnv() {
        System.out.print("Nhập Phong ban cua nhân viên: ");
        String pb = myinput.nextLine();
        int index = -1;
        for (int i = 0; i < nv.size(); i++) {
            if (nv.get(i).getPhongban().equals(pb)) {
                index = 1;
                nv.get(i).xuat();
            }
        }
        if (index == -1) {
            System.out.println("Không tìm thấy nhân viên!\n");
        }
    }
    
    public void getDsgv() {
        System.out.print("Nhập khoa cua giảng viên: ");
        String khoa = myinput.nextLine();
        int index = -1;
        for (int i = 0; i < gv.size(); i++) {
            if (gv.get(i).getKhoa().equals(khoa)) {
                index = 1;
                gv.get(i).xuat();
            }
        }
        if (index == -1) {
            System.out.println("Không tìm thấy giảng viên!\n");
        }
    }
    
    public void sortGv() {
        Collections.sort(gv, Giangvien.sortByluong);
        System.out.println("Sắp xếp thành công!\n");
    }
    public void sortNv() {
        Collections.sort(nv, Nhanvien.sortByluong);
        System.out.println("Sắp xếp thành công!\n");
    }
}
