package java_1;
        import java.util.Scanner;
public class ChuNhat {
    private int rong;
    private int dai;
    public ChuNhat(int dai, int rong) {
        this.dai = dai;
        this.rong = rong;
    }
    public int getRong() {
        return rong;
    }
    public int getDai() {
        return dai;
    }
    public void setDai(int dai) {
        this.dai = dai;
    }
    public void setRong(int rong) {
        this.rong = rong;
    }
    double getChuVi() {
        return 2*(rong + dai);
    }
    double getDienTich() {
        return (dai*rong);
    }
    void xuat() {
        System.out.println("Chiều dai " + this.dai);
        System.out.println("Chiều rộng " + this.rong);
        System.out.println("Chu Vi " + getChuVi());
        System.out.println("Dien tich" + getDienTich());
   }
   /* public static void main(String args[]) {
        Scanner myinput = new Scanner(System.in);
        System.out.println(" Nhap rong");
        
        int rong = myinput.nextInt();
        setRong(rong);
        
        
    }*/
}
