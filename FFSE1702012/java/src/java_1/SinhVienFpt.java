package java_1;
    import  java.util.Scanner;
public abstract class SinhVienFpt {
    String hoten;
    String nganh;
    String hocluc;
   public SinhVienFpt(String hoten, String nganh) {
       this.hoten = hoten;
       this.nganh = nganh;
   }
   abstract double getDiem();
   String getHocluc() {
       if(getDiem()<5) {
           this.hocluc = "Yeu";
       }
       else if(getDiem()>5 && getDiem()<=6.5){
           this.hocluc = "Trung Binh";
       }
       else if(getDiem()>6.5 && getDiem()<=7.5) {
           this.hocluc = "Kha";
       }
       else if(getDiem()>7.5 && getDiem()<=8.5) {
           this.hocluc = "gioi";
       }
       else if(getDiem()>8.5) {
           this.hocluc = "Xuat sac";
       }
       return this.hocluc;
   }
   void xuat() {
       System.out.println("Ho ten sinh vien" + this.hoten);
       System.out.println("Nganh hoc" + this.nganh);
       System.out.println("Diem hoc"  + this.getDiem());
       System.out.println("Xep loai hoc luc" + this.getHocluc());
       
   }
}
