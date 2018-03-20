package dienluc;
import java.util.Scanner;
import java.util.ArrayList;
public class Bienlai {
 Khachhang kh = new Khachhang();
 ArrayList<Khachhang> arrkh = new ArrayList();
 public static Scanner myinput = new Scanner(System.in); 
public int chisocu;
 public int chisomoi;
 private Khachhang  Khachhang;
 private double sotienphaitra;
 public Bienlai() {
     super();
     // TODO Auto-generated constructor stub
 }
 public Bienlai(dienluc.Khachhang kh, int chisocu, int chisomoi,
         dienluc.Khachhang khachhang, double sotienphaitra) {
     super();
     this.kh = kh;
     this.chisocu = chisocu;
     this.chisomoi = chisomoi;
     Khachhang = khachhang;
     this.sotienphaitra = sotienphaitra;
 }
 public void nhap() {
         kh.nhap();
         System.out.println("NHap thong tin bien lai khach hang ");
         System.out.println("chi so cong to cu");
         int old = myinput.nextInt();
         if(old<=0) {System.out.println("Yêu cầu nhập lai");}
         else chisocu = old;
         System.out.println("chi so cong to mới");
         int new1 = myinput.nextInt();
         if(new1<=0) {System.out.println("Yêu cầu nhập lai");}
         else chisomoi = new1;
         if(chisomoi<chisocu) {
             System.out.println("Yêu cầu nhập lai");
         }
         else
             sotienphaitra = (chisomoi - chisocu)*750;
     }
 public void xuat() {
     kh.xuat();
     System.out.println("Chỉ số cũ: " + chisocu);
     System.out.println("Chỉ số mới: " + chisomoi);
     System.out.println("Số tiền phải trả: " + sotienphaitra);
 }
 }