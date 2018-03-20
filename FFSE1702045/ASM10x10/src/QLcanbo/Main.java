package QLcanbo;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Main  {
 
    public static void main(String[] args)  throws IOException, ClassNotFoundException {
        ArrayList<canboinfo> arrcanbo = new ArrayList<>();
        FileOutputStream fos;
        ObjectOutputStream oos;
        FileInputStream fis;
        ObjectInputStream ois;
        
       
        int choose, soCanBo;
        long tongLuong = 0, luongThapNhat, luong;
        canboinfo canboinfo = null;
        Scanner scanner = new Scanner(System.in);
         
        System.out.print("Nhập số lượng cán bộ trong trường: ");
        soCanBo = scanner.nextInt();
    	scanner.nextLine();
        for (int i = 0; i < soCanBo; i++) {
            System.out.println("Nhập thông tin cán bộ thứ " + (i + 1) + ":");
            do {
              
                	 System.out.print("Chọn loại cán bộ (1 - giảng viên, 2 - nhân viên): ");
                	 choose = Integer.parseInt(scanner.nextLine());
                	 try {
         				canboinfoexception.chkSo(choose);
         				break;
                 	} catch (canboinfoexception e) {
         				System.out.println(e);
         			}

              
                switch (choose) {
                    case 1:
                    	canboinfo = new GiangVien();
                    	canboinfo.nhap();
                        arrcanbo.add(canboinfo);
                        break;
                    case 2:
                    	canboinfo = new NhanVien();
                    	canboinfo.nhap();
                        arrcanbo.add(canboinfo);
                        break;
                    default:
                        System.out.println("Chọn không hợp lệ.");
                        break;
                    }
            } while (choose > 3);
        }
         
        try {
        	fos = new FileOutputStream("nv.txt");
        	oos = new ObjectOutputStream(fos);
        	Object list = null;
			oos.writeObject(list);
			oos.close();
        }
        catch(FileNotFoundException e) {
        	System.out.println(e);
        }
        catch(IOException e){
        	System.out.println(e);
        }
        try {
        fis = new FileInputStream("nv.txt");
        		ois = new ObjectInputStream(fis);
        	ArrayList<canboinfo> List = (ArrayList<canboinfo>) ois.readObject();
     
        for (canboinfo cb : arrcanbo) {
            System.out.println(cb.toString());
        }
        ois.close();
        fis.close();
        }
        catch(EOFException e) {
        	System.out.println("Co loi" + e);
        }
    }
}

 
