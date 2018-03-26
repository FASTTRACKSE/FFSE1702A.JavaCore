package javadesktopqlsv;

import java.util.ArrayList;
import java.util.List;
/*
 * 
 */
public class SinhVienBussiness {
    //khoi tao doi tuong  thuoc lớp sinhVienBussiness
    private static SinhVienBussiness _service = new SinhVienBussiness();
    /*
     * khởi tạo ham để truy xuất thông tin trong lớp:
     */
    public static SinhVienBussiness getIntance() {
        return _service;
    }
    //khai bao mot danh sach sinh vien
    private List<SinhVien> lstSinhVien = new ArrayList();
    public List<SinhVien> layDanhSachSinhVien()
    {
        return lstSinhVien;
    }
    /*
     * Ham tao danh sach sinh vien:
     */
    public void taoDuLieuSinhVien() 
    {
        //khai bao mot doi tuog sinh vien: .
//        SinhVien sv = new SinhVien();
        lstSinhVien.add(new SinhVien("sv1", "Le Quoc Hung", "20"));
        lstSinhVien.add(new SinhVien("sv2", "Nguyen Hoai", "25"));
        lstSinhVien.add(new SinhVien("sv3", "Huynh Cong Nam", "23"));
        lstSinhVien.add(new SinhVien("sv4", "Le Kim NHung", "16"));
    }
}
