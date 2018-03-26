package luongbyte;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author giasutinhoc.vn
 */
public class Input {
 public static void main(String[] args) {
  try {
   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
      FileInputStream fis =  new FileInputStream("hung");
      ObjectInputStream dis = new ObjectInputStream(fis);
      
      // doc du lieu:
      String n = dis.readUTF(); 
      double m = dis.readDouble();
      //dong luong du lieu:
      dis.close();
      fis.close();
      // xuat ra du lieu:
      System.out.println("Chuoi" + n);
      System.out.println("so thuc" + m);
 }catch(IOException ex) {
     ex.printStackTrace();
     }
 }
}