package quanlysinhvien; 

import java.util.Scanner; 

public class SinhVienTest 
{ 
    //Function print line 
    public static void printLine() 
    { 
        System.out.println(); 
         
        for(int i = 1; i <= 100; i++) 
        { 
            if(i == 1 || i == 100) 
            { 
                System.out.print("+"); 
            } 
            else 
            { 
                System.out.print("-"); 
            } 
        } 
    } 
     
    //Function print menu 
    public static void printMenu() 
    { 
        printLine(); 
        System.out.printf("\n| %-90s %7s", "Menu: ", "|"); 
        System.out.printf("\n| %-90s %7s", "1. Thêm sinh viên mới.", "|"); 
        System.out.printf("\n| %-90s %7s", "2. Cập nhật thông tin sinh viên theo ID.", "|"); 
        System.out.printf("\n| %-90s %7s", "3. Xóa sinh viên theo ID.", "|"); 
        System.out.printf("\n| %-90s %7s", "4. Sắp sếp sinh viên theo tên.", "|"); 
        System.out.printf("\n| %-90s %7s", "5. Hiển thị danh sách sinh viên.", "|");  
        System.out.printf("\n| %-90s %7s", "0. Kết thúc.", "|"); 
        printLine(); 
    } 
     
    //Function main 
    public static void main(String[] args) 
    { 
        try 
        { 
            final int max = 100; 
            SinhVien[] sinhVien = new SinhVien[max]; 
            Scanner input = new Scanner(System.in); 
            Count n = new Count(); 
            int selected; 

                        
            do 
            { 
                printMenu(); 
                System.out.print("\nBạn nhập vào chức năng: "); 
                selected = input.nextInt(); 
                System.out.flush();                 

                switch(selected) 
                { 
                    case 1: 
                    { 
                        System.out.print("\n1. Thêm sinh viên mới."); 
                        ThaoTac.selectInput(sinhVien, n); 
                        break; 
                    } 
                    case 2: 
                    { 
                    	if(n.getN() == 0 ) 
                        { 
                            System.out.println("Chưa có sinh viên nào trong danh sách bạn hãy chọn menu 1 để nhập các thông tin cho sinh viên."); 
                        } 
                        else 
                        { 
                            System.out.print("\n2. Sửa tên sinh viên có mã được nhập từ bàn phím."); 
                            ThaoTac.editSinhVien(sinhVien, n.getN()); 
                        } 

                        break;
                         
                    } 
                    case 3: 
                    { 
                    	if(n.getN() == 0 ) 
                        { 
                            System.out.println("Chưa có sinh viên nào trong danh sách bạn hãy chọn menu 1 để nhập các thông tin cho sinh viên."); 
                        } 
                        else 
                        { 
                            System.out.print("\n3. Xóa sinh viên có mã sinh viên được nhập từ bàn phím."); 
                            ThaoTac.removeAt(sinhVien, n); 
                        } 

                        break; 
                    } 
                    case 4: 
                    { 
                        if(n.getN() == 0 ) 
                        { 
                            System.out.println("Chưa có sinh viên nào trong danh sách bạn hãy chọn menu 1 để nhập các thông tin cho sinh viên."); 
                        } 
                        else 
                        { 
                            System.out.print("\n4. Sắp xếp sinh viên theo tên."); 
                            ThaoTac.sortSinhVien(sinhVien, n.getN()); 
                        } 

                        break; 
                    } 
                    case 5: 
                    { 
                         
                        if(n.getN() == 0 ) 
                        { 
                            System.out.println("Chưa có sinh viên nào trong danh sách bạn hãy chọn menu 1 để nhập các thông tin cho sinh viên."); 
                        } 
                        else 
                        { 
                            System.out.print("\n5. Hiển thị danh sách sinh viên."); 
                            ThaoTac.outputSinhVien(sinhVien, n.getN()); 
                        } 

                        break;
                    } 
                    case 0: 
                    { 
                    	System.out.println("Kết thúc."); 
                        break;
                    } 
                    
                    default: 
                    { 
                        System.out.println("Chương trình không có chức năng này."); 
                        break; 
                    } 
                } 
            } 
            while(selected != 0); 
        } 
        catch(Exception ex) 
        { 
            //ex.printStackTrace(); 
            System.err.print("Bạn nhập sai chương trình tự động kết thúc."); 
            System.exit(0); 
        } 
    } 
} 