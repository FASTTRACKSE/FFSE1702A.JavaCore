
package tung;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Hello {
    public static  Scanner myinput = new Scanner(System.in);
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0");
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số sinh viên: ");
        int n = input.nextInt();
        ArrayList<SinhVien1> danhSach = new ArrayList();

        for (int i = 0; i < n; i++) {
            input.nextLine();
            SinhVien1 x = new SinhVien1();
            System.out.println("Thông tin sinh viên thứ " + (i + 1));
            System.out.print("Họ và Tên: ");
            x.Ten = input.nextLine();
            System.out.print("Ngày sinh: ");
            x.Ns = input.nextInt();
            System.out.print("Điểm Lp1: ");
            x.Lp1 = input.nextInt();
            System.out.print("Điểm Lp2: ");
            x.Lp2 = input.nextInt();
            x.Avg = (x.Lp1 + x.Lp2) / 2;
            danhSach.add(x);
        }
        
        String text = "Yes";
        while(text == "Yes") {
        menu();
        int answer = input.nextInt();
        if (answer == 1) {
            for (int i = 0; i < danhSach.size(); i++) {
                double avg1 = danhSach.get(i).Avg;
                char L = 'A';
                if (avg1 > 0 && avg1 <= 49) {
                    L = 'D';
                } else if (avg1 >= 50 && avg1 < 70) {
                    L = 'C';
                } else if (avg1 >= 70 && avg1 <= 84) {
                    L = 'B';
                } else if (avg1 >= 85 && avg1 <= 100) {
                    L = 'A';
                }
                System.out.println("Tên: " + danhSach.get(i).Ten
                        + " Ngaỳ Sinh: " + danhSach.get(i).Ns + " Điểm Lp1: "
                        + danhSach.get(i).Lp1 + " Điểm Lp2: "
                        + danhSach.get(i).Lp2 + " Điểm TB: "
                        + df.format(danhSach.get(i).Avg) + "Loại: " + L);
            }
        }
        if(answer == 2) {
            //Sắp xếp danh sách theo theo thứ tự a b c!
            Collections.sort(danhSach, new Comparator<SinhVien1>() {
                @Override
                public int compare(SinhVien1 sv1, SinhVien1 sv2) {
                    return (sv1.Ten.compareTo(sv2.Ten));
              }
            });

            System.out.println("Danh sách sắp xếp theo tên trong bảng chữ cái a - b - c: ");
            for (int i = 0; i < danhSach.size(); i++) {
                double avg1 = danhSach.get(i).Avg;
                char L = 'A';
                if (avg1 > 0 && avg1 <= 49) {
                    L = 'D';
                } else if (avg1 >= 50 && avg1 < 70) {
                    L = 'C';
                } else if (avg1 >= 70 && avg1 <= 84) {
                    L = 'B';
                } else if (avg1 >= 85 && avg1 <= 100) {
                    L = 'A';
                }
                System.out.println("Tên: " + danhSach.get(i).Ten
                        + " Ngaỳ Sinh: " + danhSach.get(i).Ns + " Điểm Lp1: "
                        + danhSach.get(i).Lp1 + " Điểm Lp2: "
                        + danhSach.get(i).Lp2 + " Điểm TB: "
                        + df.format(danhSach.get(i).Avg) + "Loại: " + L);
            }
        }
        if(answer == 3) {
            Collections.sort(danhSach, new Comparator<SinhVien1>() {
                @Override
                public int compare(SinhVien1 sv1, SinhVien1 sv2) {
                    if (sv1.Avg < sv2.Avg) {
                        return 1;
                    } else {
                        if (sv1.Avg == sv2.Avg) {
                            return 0;
                        } else {
                            return -1;
                        }
                    }
                }
            });

            System.out.println("Danh sách sắp xếp theo tên trong bảng chữ cái a - b - c: ");
            for (int i = 0; i < danhSach.size(); i++) {
                double avg1 = danhSach.get(i).Avg;
                char L = 'A';
                if (avg1 > 0 && avg1 <= 49) {
                    L = 'D';
                } else if (avg1 >= 50 && avg1 < 70) {
                    L = 'C';
                } else if (avg1 >= 70 && avg1 <= 84) {
                    L = 'B';
                } else if (avg1 >= 85 && avg1 <= 100) {
                    L = 'A';
                }
                System.out.println("Tên: " + danhSach.get(i).Ten
                        + " Ngaỳ Sinh: " + danhSach.get(i).Ns + " Điểm Lp1: "
                        + danhSach.get(i).Lp1 + " Điểm Lp2: "
                        + danhSach.get(i).Lp2 + " Điểm TB: "
                        + df.format(danhSach.get(i).Avg) + "Loại: " + L);
            }
        }
        if(answer == 4) {
            main(args);
        }
        System.out.println("\n"+"Bạn có muốn thực hiện các chức năng khác không?");
        Scanner myinput1 = new Scanner(System.in);
        String text1 = myinput1.nextLine();
        for(int a = 0;a<text1.length();a++) {
            if(text1.charAt(a) == 'Y') {
                text = "Yes";
            }
            if(text1.charAt(a) == 'N') {
                text = "No";
            }
        }
        }
        
    }

    // chuc nang cua menu:
    public static void menu() {
        System.out.println("CHỨC NĂNG");
        System.out.println(" 1:Hiển thị danh sách sinh viên ");
        System.out.println(" 2:Hiển thị tên sinh viên từ A - Z ");
        System.out.println(" 3:Hiển thị điểm trung bình sinh viên từ cao đến thấp ");
    }
}

class SinhVien1 {
    public String Ten;

    public int Ns;

    public int Lp1;

    public int Lp2;

    public double Avg;
}
