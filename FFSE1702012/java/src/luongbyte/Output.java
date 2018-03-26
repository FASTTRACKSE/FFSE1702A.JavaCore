
package luongbyte;

    import java.io.ObjectOutputStream;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
    /*
     */
    public class Output {
     public static void main(String[] args) { 
         try {
         FileOutputStream fos = new FileOutputStream("hung");
         ObjectOutputStream dos = new ObjectOutputStream(fos);
         
         // ghi du lieu:
         dos.writeUTF("lequochung");
         dos.writeDouble(9.55);
         // dong luong
         fos.close();
         dos.close();
         }catch(IOException ex) {
             ex.printStackTrace();
    } 
    }
    }