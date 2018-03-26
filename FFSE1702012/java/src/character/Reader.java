package character;
        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
public class Reader {
        public static void main(String args[]) {
            // tao doi tuong luong va lien ket du lieu:
            try {
            File f = new File("hung_nhi");
            FileReader fr = new FileReader(f);
            //doc du lieu:
            BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                  }
                // dong luong:
             fr.close();
             br.close();
        }catch(Exception ex) {
            System.out.println("Loi doc file: "+ex);
            }
        }
}
