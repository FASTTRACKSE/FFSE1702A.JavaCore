package test;

public class ex2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis	=	new FileInputStream("file1.dat");
		int c;
		while ((c	=	fis.read())!= -1) {
			System.out.println((char) c)
		}
	}
}
