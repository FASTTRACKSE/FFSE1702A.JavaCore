package Nhom4;

public class Tamgiac {
	private int a;
	private int b;
	private int c;
	
	public Tamgiac(int a, int b, int c) throws Exception
	{
		if(a<=0 || b<=0 || c<=0) 
		{
			throw new Exception("Dữ liệu không hợp lệ");
		}
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public int KTTamgiac()
	{
		boolean latamgiac = false;
		if(a < b + c && b < a + c && c < b + a )
			latamgiac = true;
		if(latamgiac)
		{
			if(a == b && b==c)
				return 1;// la tam giac deu
			else if(a == b || b == c || a == c)
				return 2; // la tam giac can
			else if(a*a == b*b + c*c || b*b == a*a + c*c || c*c == b*b + a*a)
				return 3;// la tam giac vuông
			else
				return 0;
		}
		return -1; //neu k phai la tam giac
	}
}
