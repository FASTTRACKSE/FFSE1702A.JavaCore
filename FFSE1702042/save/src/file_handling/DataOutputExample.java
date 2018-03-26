package file_handling;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author giasutinhoc.vn
 */
public class DataOutputExample {
 public static void main(String[] args) { 
  try {
   //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
   FileOutputStream fos = new FileOutputStream("D:/file/mydata.bin");
   DataOutputStream dos = new DataOutputStream(fos);

   //Bước 2: Ghi dữ liệu
   dos.writeInt(100);
   dos.writeDouble(9.5);

   //Bước 3: Đóng luồng
   fos.close();
   dos.close();
   System.out.println("Done!");
  } catch (IOException ex) {
    ex.printStackTrace();
  } 
 }
} 
