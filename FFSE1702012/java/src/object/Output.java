package object;

    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.ObjectOutputStream;
public class Output {
    public static void main(String[] args) {
        // tao doi tuong luon va lien ket  nguon du lieu:
        try {
        FileOutputStream fos = new FileOutputStream("Hung2");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // tao mag doi tuong:
        Stock[] st = {
          new Stock(1, "CD ROM", 100, 2),
          new Stock(2, "CPU", 500, 2),
          new Stock(3, "HP Scanner", 75, 1)
        };
        // ghi mang vao object:
        oos.writeObject(st);
        // dong luong 
        fos.close();
        oos.close();
        }catch(IOException ex) {
        System.out.println("Loi ghi file: "+ex);
        }
    }
}
