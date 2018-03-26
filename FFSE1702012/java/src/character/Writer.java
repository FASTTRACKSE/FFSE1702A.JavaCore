package character;
        import java.io.File;
        import java.io.FileWriter;
        import java.io.IOException;
public class Writer {
        public static void main(String args[]) {
            try {
            // tao doi tuong luong va lien ket du lieu:
            File f = new File("hung_nhi");
            FileWriter fw = new FileWriter(f);
            //ghi du lieu:
            fw.write("Ghi dữ liệu  bằng luồng Character");
            //dong luong:
            fw.close();
        }catch(IOException ex) {
            System.out.println("Loi ghi file: " + ex);
            }
        }
}
