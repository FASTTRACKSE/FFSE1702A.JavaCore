import java.util.Scanner; 

public class Bangcuuchung {

	public static void main(String[] args) {
		int number; 
		Scanner myInput = new Scanner(System.in);
		System.out.println("nhập 1 số : ");	
		number = myInput.nextInt();
		  for ( int i = 1 ; i <= 10 ; i ++){
	          
	       System.out.println( number  + " x " + i + " = " + number * i + "\t");
	    
	           
	        }

	}

}
