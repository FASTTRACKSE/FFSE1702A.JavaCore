import java.util.Scanner;
public class demo {

	public static void main(String[] args) {
		Scanner nc = new Scanner(System.in);
        System.out.print("Nhập vào 1 số : ");
        int so2 = nc.nextInt();
        
        int i=1;
        
        while(i<=so2) {int j=1;
        while(j<=10) {
        	
        	System.out.printf("\n%d"+"*"+j+"="+"%d",i,(i*j));
        	j++;
        }
        i++;
        }
	}

}