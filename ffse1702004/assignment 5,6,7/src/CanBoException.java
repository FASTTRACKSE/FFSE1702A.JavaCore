import java.util.ArrayList;

public class CanBoException extends Exception 
{
	String errHoten ;
	 
	public CanBoException(String errHoten) {
		super();
		this.errHoten = errHoten;
		
	}
	public 	String toString() {
	return this.errHoten;
	}
	//kiểm tra lỗi ở họ tên 
	static public void chkHoten(String Hoten) throws CanBoException 
	{
		if(Hoten.equals("")) {
			throw new CanBoException ("vui lòng không để rỗng \n");
		}
		if(Hoten.length()>40 ) 
		{throw new CanBoException("vui lòng không nhập quá 40 ký tự \n");}
	}  

	//kiểm tra lỗi ở số thực 
	static public void chkso(int n ) throws CanBoException
	{
		if (n < 0 )
		{
			throw new CanBoException("vui lòng nhập số dương \n "); 
		}
	}
	static public void chkMaCanBo(String MaCanBo , ArrayList<CanBo> arr ) throws CanBoException
	{
		for(int i = 0 ; i< arr.size();i++ ) {
			if(arr.get(i).getMaCanBo().equals(MaCanBo)) {
				throw new CanBoException("mã cán bộ đã tồn tại \n  ");
				}
		}
	}
	//bắt lỗi nhâp ký tự và nhập vào số khác 123 
	static public void chkso1 (String i ) throws CanBoException 
	{
		int n = 0;
		try {
			n = Integer.parseInt(i);
		}catch (Exception e ) 
		{
			throw new CanBoException("vui lòng nhập số \n ");
		}
		if(n !=1 && n!=2 && n!= 3 )
		{
			throw new CanBoException("vui lòng nhập đúng yêu cầu  \n");
			
		}
	}
	
}
