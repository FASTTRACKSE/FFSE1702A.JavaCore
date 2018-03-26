package javadesktopqlsv;

public class SinhVien {
    private String masv;
    private String hoten;
    private String age;
    
    public SinhVien() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public SinhVien(String masv, String hoten, String age) {
        super();
        this.masv = masv;
        this.hoten = hoten;
        this.age = age;
    }

    public String getMasv() {
        return masv;
    }
    public void setMasv(String masv) {
        this.masv = masv;
    }
    public String getHoten() {
        return hoten;
    }
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    }
