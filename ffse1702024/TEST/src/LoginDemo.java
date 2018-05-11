import javax.swing.JOptionPane;

import login.Login;
import javax.swing.JFrame;
class LoginDemo extends JFrame
{
  public static void main(String arg[])
  {
  try
  {
  Login frame=new Login();

  
  }
  catch(Exception e)
  {JOptionPane.showMessageDialog(null, e.getMessage());
  }
  }
  }