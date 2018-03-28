
import javax.swing.*;    
public class SinhVien {
	
    JFrame f;    
    SinhVien(){    
    f=new JFrame();    
    String data[][]={ {"101","Amit","12"},    
                          {"102","Jai","11"},    
                          {"101","Sachin","18"}};    
    String column[]={"MA","TEN","TUOI"};         
    JTable jt=new JTable(data,column);    
    jt.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(jt);    
    f.add(sp);          
    f.setSize(300,400);    
    f.setVisible(true);    
}     
public static void main(String[] args) {    
    new SinhVien();    
}    
}
