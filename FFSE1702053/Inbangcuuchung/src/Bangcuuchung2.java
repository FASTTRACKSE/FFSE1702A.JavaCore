import java.util.Scanner; 

public class Bangcuuchung2 {

	public static void main(String[] args) {
		int number; 
		Scanner myInput = new Scanner(System.in);
		System.out.println("nhập 1 số : ");	
		number = myInput.nextInt();
		for ( int i = 1 ; i <= 10 ; i ++){
		
            for ( int j = 1; j<= number ; j ++) {
                System.out.printf("%5d x %2d =%2d" ,j,i,(j*i));
            }
            System.out.println(" ");
        }
    }
	

}
