import java.util.Scanner;
public class Longtlp {
public static void main(String[] args) {
	Scanner nc=new Scanner(System.in);
    System.out.println("nhập 1 số vào: ");
    int so1=nc.nextInt();
    
    int i=1;
       while(i<=10) {
    	for(int x=1;x<=so1;x++) {
    	System.out.printf(x+"*%d=%d",i,(x*i));
    	System.out.print("    ");
    	 };
    	i++;
    	System.out.println();
    }  
       
}
}
