package javadesktop;
     import javax.swing.*;
public class MyTable {
    JFrame f;
    public void MyTable() {
        f = new JFrame();
        String data[][] = {
                {"101","Vinh", "67000"},
                {"102", "Nhi","87000"},
                {"103", "Hung", "97000"}
        };
        String column[] = {"ID", "NAME", "SALARY"};
        JTable jt =  new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);// xet trục x, trục y. độ rộng và độ cao:
        
        // tao thanh cuon:
        JScrollPane sp =  new JScrollPane(jt);
        f.add(sp);
        f.setSize(300,400);  
    //  f.setLayout(null);  
        f.setVisible(true);  
    }  
    public static void main(String[] args) {  
        MyTable tb = new MyTable(); 
        tb.MyTable();
    }
}
