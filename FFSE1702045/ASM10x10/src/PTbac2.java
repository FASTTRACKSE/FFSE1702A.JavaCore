import java.util.Scanner;
public class PTbac2 {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    	int stt=1;
    	while (stt ==1) {
    		try {
    			
    		  System.out.println("Chương trình giải phương trình bậc 2");
        System.out.print("Nhập số bậc 2");
        Scanner x = new Scanner(System.in);
		int a = x.nextInt();	
        System.out.print("Nhập số bậc 1");
        Scanner y = new Scanner(System.in);
		int b = y.nextInt();
        System.out.print("Nhập hằng số");
        Scanner z = new Scanner(System.in);
		int c = z.nextInt();
	
		
		System.out.print("Phương trình :");
	     System.out.print(a+"x^2" +"+"+b+"y"+"+"+c+" =0"+" ");
        if (a == 0) {
            if (b == 0) {
                System.out.println(" vô nghiệm!");
            } else {
                System.out.println(" có một nghiệm: "
                        + "x = " + (-c / b));
            }
            return;
        }
        float delta = b*b - 4*a*c;
        float x1;
        float x2;
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            System.out.println(" có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2);
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            System.out.println(" có nghiệm kép: "
                    + "x1 = x2 = " + x1);
        } else {
            System.out.println(" vô nghiệm!");
        }
        System.out.println("Nhập vào phím bất kì để tiếp tục hoặc 0 để dừng lại");
  	  Scanner k = new Scanner(System.in);
		int st = k.nextInt();		
		if(st==0) { 
			stt=0;
		}
		}
    	
        catch(ArithmeticException e){
        	  System.out.println(e);

        		}
    }
    	
  		
    
    
}
}