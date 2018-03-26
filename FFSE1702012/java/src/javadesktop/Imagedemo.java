package javadesktop;

    import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
    import javax.swing.JFrame;
    import javax.swing.JLabel;

public class Imagedemo extends JFrame {
    public void Imagedemo() {
        this.setSize(300,150);
        setVisible(true);
        setLocation(500, 300);
        setResizable(true);
        JLabel label =  new JLabel();
        add(label);
      //  label.setSize(width, height);
        label.setSize(250, 100);
        System.out.println(" Kích thước cua label " + "  Chiều rộng  " + label.getSize().width + " Chiều cao " + label.getSize().height  );
        setpicture(label, "cn12.jpg" );
    }
    public void setpicture(JLabel label, String filename) {
        // thiet lap hinh nen
        try {
            BufferedImage image = ImageIO.read(new File(filename));
            int x = label.getSize().width;
            int y = label.getSize().height;
            int ix = image.getWidth();
            int iy = image.getHeight();
            int dx = 0;
            int dy = 0;
            if(x/y > ix/iy) {
                dy = y;
                dx = dy* ix/iy;
            }
            else {
                dx = x;
                dy = dx* iy/ix;
            }
            ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
            label.setIcon(icon);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        Imagedemo imagedemo =  new Imagedemo();
        imagedemo.Imagedemo();
    }
}
