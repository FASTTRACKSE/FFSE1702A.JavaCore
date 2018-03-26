//package javadesktop;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//
//public class HelloWorld  extends JFrame{    
//   public void HelloWorld() {
//       //thiết lập kích thước cho Jframe;
//       setSize(200,150);
//       setVisible(true);
//       // thiết lập vị trí xuát hiện cua JFrame;
//       setLocation(100, 70);
//       // thiết lập kích cở:
//       setResizable(true);
//       JLabel label =  new JLabel("Hello World");
//       add(label);
//       
//   }
//   public static void main(String args[]) {
//       HelloWorld hello =  new HelloWorld();
//       hello.HelloWorld();
//   } 
// } 
//package javadesktopqlsv;
//
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//
//public class QuanLySV  extends JFrame implements ActionListener{
//JFrame f;
//private String masv, hoten, age;
//private JLabel lbtt, lbmasv, lbhoten, lbage, lbds;
//private JTextField tfmasv, tfhoten, tfage;
//private JButton btsave, btcreate, btdel, btexit; 
//private JTable tb;
//SinhVien sv;
//public void QuanLySV() {
//f=new JFrame("LOG IN FORM");
//this.setSize(700,500);
//this.setLocation(400,100);
//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//this.setLayout(null);
////tieu de:
//lbtt = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN");
//lbtt.setBounds(230, 30, 600, 40);
//lbtt.setForeground(Color.RED);
//this.add(lbtt);
////ma sinh vien
//lbmasv = new JLabel("Mã sinh viên");
//lbmasv.setBounds(150, 80, 200, 30);
//this.add(lbmasv);
////textfield
//tfmasv = new JTextField();
//tfmasv.setBounds(270, 80, 200, 30);
//this.add(tfmasv);
////ho ten:
//lbhoten =  new JLabel("Tên sinh viên");
//lbhoten.setBounds(150, 130, 200, 30);
//this.add(lbhoten);
////tesxt Field:
//tfhoten =  new JTextField();
//tfhoten.setBounds(270, 130, 200, 30);
//this.add(tfhoten);
////Tuổi
//lbage =  new JLabel("Tuổi");
//lbage.setBounds(150, 180, 200, 30);
//this.add(lbage);
////text field
//tfage =  new JTextField();
//tfage.setBounds(270, 180, 200, 30);
//this.add(tfage);
////button:
//btsave = new JButton("Lưu");
//btsave.setBounds(150, 230, 60, 30);
//this.add(btsave);
////create
////button:
//btcreate = new JButton("Mới");
//btcreate.setBounds(230, 230, 60, 30);
//this.add(btcreate);
////delete
//btdel = new JButton("Xóa");
//btdel.setBounds(310, 230, 60, 30);
//this.add(btdel);
////exit
//btexit = new JButton("Thoát");
//btexit.setBounds(390, 230,100, 30);
//this.add(btexit);
////tabel:
////(SinhVien) sv_arr[][]  = {
////        {"sv1","Lê Quốc A","17"},
////        {"sv2","Lê Quốc B","18"},
////        {"sv3","Lê Quốc C","17"},
////        {"sv4","Lê Quốc D","19"},
////        {"sv5","Lê Quốc E","16"},
////        {"sv6","Lê Quốc F","25"},
////        {"sv7","Lê Quốc G","19"}
////};
//String column[] = {"Mã Sinh Viên","Họ tên", "Tuổi"};
//JTable Jt = new JTable(Main.sv_arr,column);
////sau cung
//this.setVisible(true);
//}
//@Override
//public void actionPerformed(ActionEvent e) {
//// TODO Auto-generated method stub
//
//}
//public static void main(String args[]) {
//QuanLySV qlsv =  new QuanLySV();
//qlsv.QuanLySV();
//}
//
//}

