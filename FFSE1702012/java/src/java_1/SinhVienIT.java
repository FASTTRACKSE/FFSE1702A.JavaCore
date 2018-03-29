package java_1;
    import java.util.Scanner;
public class SinhVienIT extends SinhVienFpt {
        double diemHtml;
        double diemJava;
        double diemCss;
    public SinhVienIT(String hoten, double diemJava, double diemHtml, double diemCss) {
        super(hoten, "IT");
        this.diemJava = diemJava;
        this.diemHtml = diemHtml;
        this.diemCss = diemCss;
    }
    @Override
     double getDiem() {
        // TODO Auto-generated method stub
        double diem = (diemJava*2 + diemHtml + diemCss)/4;
        return diem;
    }
    public static void main (String arg[]) {
     Scanner myinput = new Scanner(System.in);
     System.out.println("Nhap ho ten");
     String hoten = myinput.nextLine();
     System.out.println("Nhap diem Java");
     double diemJava = myinput.nextFloat();
     System.out.println("Nhap diem Html");
     double diemHtml = myinput.nextFloat();
     System.out.println("Nhap diem Css");
     double diemCss = myinput.nextFloat();
     SinhVienFpt sv = new SinhVienIT(hoten, diemHtml, diemJava, diemCss);
     sv.xuat();
    }

}
