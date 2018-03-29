package Canbo;

import java.util.Scanner;
public class Menu {
<<<<<<< HEAD
    public static void showMenu() {
        System.out.print("+------------------------------------------+\n");
        System.out.print("|                   MENU                   ");
        System.out.printf("\n| %-40s ", "1. Thêm Giảng viên.");
        System.out.printf("\n| %-40s ", "2. Thêm nhân viên.");
        
        
        System.out.printf("\n| %-40s ", "3. Xuất danh sách giảng viên theo khoa");
        System.out.printf("\n| %-40s ", "4. Xuất danh sách nhân viên theo phòng ban");
        System.out.printf("\n| %-40s ", "5. Tổng lương các nhân viên.");
        System.out.printf("\n| %-40s ", "6.Tổng lương các giáo viên");
        System.out.printf("\n| %-40s ", "7.Hiển thị giảng viên");
        System.out.printf("\n| %-40s ", "8.Hiển thị nhân viên");
        System.out.printf("\n| %-40s ", "9.Sắp xếp giáng viên ");
        System.out.printf("\n| %-40s \n", "10 Sắp xếp Nhận viên", "");
        System.out.printf("\n| %-40s \n", "0 Thoát", "");
        System.out.println("+------------------------------------------+");
    }

    public static void main(String[] args) {
        Scanner myinput = new Scanner(System.in);
        Main main = new Main();
        main.nhanviendefault();
        main.giangviendefault();
        showMenu();
        do {
            System.out.print("Chọn chức năng (nhấn 11 để hiện lại menu): ");
            int choose = myinput.nextInt();
            System.out.println("--------------------------------------------");
            switch (choose) {
            case 1:
                main.themgiangvien();
                break;
            case 2:
                main.themnhanvien();
                 break;
            case 3:
                main.getDsgv();
                break;
            case 4:
                main.getDsnv();
                break;
            case 5:
                main.tinhluongnhanvien();
                break;
            case 6:
               main.tinhluonGiangvien();
                break;
            case 7:
                main.hienThiGiangvien();
                break;
            case 8:
                main.hienThiNhanvien();
                break;
            case 9:
               main.sortGv();
               main.hienThiGiangvien();
                break;
            case 10:
                main.sortNv();
                main.hienThiNhanvien();
                break;
            case 11:
              showMenu();
                break;
            case 0:
                System.out.println("Kết thúc chương trình");
                System.exit(0);
                break;
            default:
                System.out.println("Vui lòng nhập số từ 0-7\n");
                break;
            }
        } while (true);
=======
    static ArrayList<CanBo> arrCanBo = new ArrayList<>();
    private Scanner scanner;
    CanBo canBo;

    public Menu() {
        super();
    }

    public void dataWrite() throws IOException {
        FileOutputStream fos = new FileOutputStream("CanBo.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(arrCanBo);
        oos.close();
    }

    public void dataRead() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("CanBo.txt");
            ois = new ObjectInputStream(fis);
            arrCanBo = (ArrayList<CanBo>) ois.readObject();
            // for (CanBo cb : arrCanBo) {
            // System.out.print(cb);
            // }
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("Có lỗi: " + e);
        }
    }

    public void giaTriMacDinh() throws IOException {
<<<<<<< HEAD
        arrCanBo.add(new NhanVien("Nguyễn Văn A", "Phòng Đào tạo", "Trưởng phòng", 5, 3.3));
        arrCanBo.add(new NhanVien("Bành Thị B", "Phòng Đào tạo", "Phó phòng", 10, 2.2));
        arrCanBo.add(new NhanVien("Trương Văn C", "Phòng Đào tạo", "Nhân viên", 15, 1.1));
        arrCanBo.add(new GiangVien("Dương Thị D", "IT", "Cử nhân", 5, 1.1));
        arrCanBo.add(new GiangVien("Trần Văn E", "IT", "Thạc sĩ", 10, 2.2));
        arrCanBo.add(new GiangVien("Cao Văn F", "IT", "Tiến sĩ", 15, 3.3));
        arrCanBo.add(new GiangVien("Huỳnh Thị G", "IT", "Tiến sĩ", 15, 3.3));
        arrCanBo.add(new GiangVien("Phạm Văn H", "IT", "Tiến sĩ", 15, 3.3));
        // dataRead();
        // dataWrite();
    }

    public void themCanBo() {
        int soCanBo, choose;
        scanner = new Scanner(System.in);
        System.out.print("Nhập số cán bộ: ");
        soCanBo = Main.myFunction.loopCheckInt();
        for (int i = 0; i < soCanBo; i++) {
            System.out.println("Nhập thông tin cán bộ thứ " + (i + 1));
            System.out.print("Chọn loại cán bộ (1 - Giảng viên, 2 - Nhân viên): ");
            do {
                choose = Main.myFunction.loopCheckInt();
                switch (choose) {
                case 1:
                    canBo = new GiangVien();
                    canBo.nhap();
                    arrCanBo.add(canBo);
                    break;
                case 2:
                    canBo = new NhanVien();
                    canBo.nhap();
                    arrCanBo.add(canBo);
                    break;
                default:
                    System.err.print(" * Vui lòng nhập số từ 1-2!\n Nhập lại: ");
                    break;
                }
            } while (choose > 2);
        }
        System.out.print("\nThêm thành công " + soCanBo + " cán bộ!\n");
    }

=======
        arrCanBo.add(new NhanVien("Nguyễn Văn A", "Phòng Đào tạo", "Trưởng phòng", 5, 3.3,"abc"));
        arrCanBo.add(new NhanVien("Bành Thị B", "Phòng Đào tạo", "Phó phòng", 10, 2.2,"abc"));
        arrCanBo.add(new NhanVien("Trương Văn C", "Phòng Đào tạo", "Nhân viên", 15, 1.1,"abc"));
        arrCanBo.add(new GiangVien("Dương Thị D", "IT", "Cử nhân", 5, 1.1,"bc"));
        arrCanBo.add(new GiangVien("Trần Văn E", "IT", "Thạc sĩ", 10, 2.2,"bcw"));
        arrCanBo.add(new GiangVien("Cao Văn F", "IT", "Tiến sĩ", 15, 3.3,"bcd"));
        arrCanBo.add(new GiangVien("Huỳnh Thị G", "IT", "Tiến sĩ", 15, 3.3,"bcs"));
        arrCanBo.add(new GiangVien("Phạm Văn H", "IT", "Tiến sĩ", 15, 3.3,"bca"));
        // dataRead();
        // dataWrite();
    }

    public void themCanBo() {
        int soCanBo, choose;
        scanner = new Scanner(System.in);
        System.out.print("Nhập số cán bộ: ");
        soCanBo = Main.myFunction.loopCheckInt();
        for (int i = 0; i < soCanBo; i++) {
            System.out.println("Nhập thông tin cán bộ thứ " + (i + 1));
            System.out.print("Chọn loại cán bộ (1 - Giảng viên, 2 - Nhân viên): ");
            do {
                choose = Main.myFunction.loopCheckInt();
                switch (choose) {
                case 1:
                    canBo = new GiangVien();
                    canBo.nhap();
                    for (;;) {
                        System.out.print("Nhập mã cán bộ: ");
                        String maCanBo = scanner.nextLine();
                        try {
                            
                            MyException.checkExist(maCanBo, arrCanBo);
                            canBo.setMaCanBo(maCanBo);
                            break;
                        } catch (MyException e) {
                            System.err.print(e);
                        }

                    }
                    arrCanBo.add(canBo);
                    break;
                case 2:
                    canBo = new NhanVien();
                    canBo.nhap();
                    for (;;) {
                        System.out.print("Nhập mã cán bộ: ");

                        try {
                            String maCanBo = scanner.nextLine();
                            MyException.checkExist(maCanBo, arrCanBo);
                            canBo.setMaCanBo(maCanBo);
                            break;
                        } catch (MyException e) {
                            System.err.print(e);
                        }

                    }
                    arrCanBo.add(canBo);
                    break;
                default:
                    System.err.print(" * Vui lòng nhập số từ 1-2!\n Nhập lại: ");
                    break;
                }
            } while (choose > 2);
        }
        System.out.print("\nThêm thành công " + soCanBo + " cán bộ!\n");
    }

>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
    public void xuatCanBo() {
        int i = 0;
        scanner = new Scanner(System.in);
        System.out.print("Nhập tên khoa hoặc phòng ban: ");
        String ten = scanner.nextLine();
        for (CanBo cb : arrCanBo) {
            if (cb instanceof GiangVien) {
                GiangVien gv = (GiangVien) cb;
                if (gv.getKhoa().equals(ten)) {
                    i += 1;
                    if (i == 1) {
                        System.out.println("\nDanh sách giảng viên thuộc khoa " + ten);
                        System.out.println(
                                "+----------------------+----------------------------+-----------------------+------------------+------------------+---------------+-----------------+");
                    }
<<<<<<< HEAD
                    System.out.print(cb);
                }
            }
            if (cb instanceof NhanVien) {
                NhanVien nv = (NhanVien) cb;
                if (nv.getPhongBan().equals(ten)) {
                    i += 1;
                    if (i == 1) {
                        System.out.println("\nDanh sách giảng viên thuộc " + ten);
                        System.out.println(
                                "+----------------------+----------------------------+-----------------------+------------------+------------------+---------------+-----------------+");
                    }
                    System.out.print(cb);
                }
            }
=======
                    System.out.print(gv);
                }
            }
            if (cb instanceof NhanVien) {
                NhanVien nv = (NhanVien) cb;
                if (nv.getPhongBan().equals(ten)) {
                    i += 1;
                    if (i == 1) {
                        System.out.println("\nDanh sách giảng viên thuộc " + ten);
                        System.out.println(
                                "+----------------------+----------------------------+-----------------------+------------------+------------------+---------------+-----------------+");
                    }
                    System.out.print(cb);
                }
            }
>>>>>>> 86f8770633e2f4f086edb7cfd8c7be3439e672b5
        }
        if (i == 0) {
            System.out.println("Không tồn tại cán bộ!");
        } else {
            System.out.println(
                    "+----------------------+----------------------------+-----------------------+------------------+------------------+---------------+-----------------+");
        }
    }

    public void tongLuong() {
        double tong = 0;
        for (CanBo cb : arrCanBo) {
            tong += cb.getLuong();
        }
        System.out.println("Tổng số lương trường trả cho cán bộ là: " + tong);
    }

    public void sortByLuong() {
        Collections.sort(arrCanBo, CanBo.sortByLuong);
        System.out.println("Sắp xếp thành công!\n");
>>>>>>> f519ccdc26c546bd3f966d16137622b9d9099d44
    }

}
