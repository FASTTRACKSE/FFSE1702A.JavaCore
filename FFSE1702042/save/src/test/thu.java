package test;
import java.io.FileOutputStream;
import java.io.IOException;
public class thu {
	public static void main(String[]args) throws IOException{
		FileOutputStream fos	=	new FileOutputStream("file1.dat");
		String text	= 	"abc abc";
		byte[] textAsByte	=	text.getBytes();
		fos.write(textAsByte);
	}
}
