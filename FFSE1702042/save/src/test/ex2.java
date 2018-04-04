package test;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author giasutinhoc.vn
 */
public class ex2 {
 public static void main(String[] args) {
  try {
   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
   FileInputStream fis = new FileInputStream("d:/file/mydata.bin");
   DataInputStream dis = new DataInputStream(fis);

   //Bước 2: Đọc dữ liệu
   int n = dis.readInt(); 
   double m = dis.readDouble();

   //Bước 3: Đóng luồng
   fis.close();
   dis.close();

   //Hiển thị nội dung đọc từ file
   System.out.println("Số nguyên: " + n);
   System.out.println("Số thực: " + m);
  } catch (IOException ex) {
    ex.printStackTrace();
  } 
 }
}

