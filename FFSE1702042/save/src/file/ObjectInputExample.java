package file;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

/**
 *
 * @author giasutinhoc.vn
 */
public class ObjectInputExample {
 public static void main(String[] args) {  
  try {
    //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
    FileInputStream fis = new FileInputStream("D:/mydata2.bin");
    ObjectInputStream ois = new ObjectInputStream(fis);

    //Bước 2: Đọc dữ liệu
    Stock sArr[] = (Stock[]) ois.readObject();
    for(Stock s : sArr){
      System.out.println(s.toString());
    }

    //Bước 3: Đóng luồng
    fis.close();
    ois.close();
  } catch (Exception ex) {
    System.out.println("Loi doc file: "+ex);
 }
 }
}