package object;

       import java.io.FileNotFoundException;
       import java.io.FileInputStream;
       import java.io.IOException;
       import java.io.ObjectInputStream;
public class Input {
    public static void main(String args[]) {
        try {
        // tao doi tuong luong vaf lien ket du lieu:
   FileInputStream fos = new FileInputStream("Hung2");
   ObjectInputStream oos = new ObjectInputStream(fos);
       //doc du lieu ra:
   Stock sArr[] = (Stock[]) oos.readObject();
   for(Stock s:sArr) {
       System.out.println(s.toString());
   }
   // dong luong
   fos.close();
   oos.close();
      }catch(Exception ex) {
        System.out.println("Loi doc file: "+ex);
    }
}
}
