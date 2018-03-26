package javadesktop;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;

public class ConfirmDialogDemo  extends JFrame implements ActionListener{
    private JLabel label;
    public void ConfirmDialogDemo() {
        setSize(300,200);
        setVisible(true);
        setResizable(true);
        setLocation(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         label =  new JLabel("Welcom");
         add(label);
        JButton button =  new JButton("Hit me");
        add(button, "South", 1);
        button.addActionListener(this);
       }
    public static void main(String args[]) {
        ConfirmDialogDemo confirm =  new ConfirmDialogDemo();
        confirm.ConfirmDialogDemo();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        label.setText("Myname Is Hung");
        String name = "Ducky";
        // thong bao hien thi tren giao dien: 
        int click =  JOptionPane.showConfirmDialog(null,"Is Ducky handsome ?");
        if(click ==  JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,"Click Yes");
        }
        else if(click ==  JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null,"Click No");
        }
        else if(click ==  JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Click cancel");
        }
        else if(click ==  JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null,"Click close");
            }
    }
}