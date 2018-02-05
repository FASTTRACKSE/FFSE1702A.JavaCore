package ffse037;
 
import java.util.Scanner;

public class assignment5 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	for(;;) {
    		System.out.println();
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int [] arr = new int [n];
        
        System.out.print("Nhập các phần tử của mảng: \n");
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = scanner.nextInt();
        }System.out.println("+-------------------------------------+");
    	System.out.println("+----Nhập 1 để sắp xếp tăng dần-------------------+");
    	System.out.println("+----Nhập 2 để sắp xếp giảm dần------------------------------+");
    	System.out.println("+----Nhập 3 để chạy lại------------------------+");
    	System.out.println("+----Nhập 4 để kết thúc------------------------+");
    	System.out.println("+-------------------------------------+");
    	try {
    		Scanner myInput = new Scanner(System.in);
    		int answer = myInput.nextInt();
    		
    		if(answer==1) {			
    			sortASC(arr);
    	        System.out.println("Dãy số được sắp xếp tăng dần: ");
    	        show(arr);
    		}
    		else if(answer==2) {			
    			sortDESC(arr);
    	        System.out.println("Dãy số được sắp xếp giảm dần: ");
    	        show(arr);
    		}else if(answer==3) {
    			continue;
    		}		
    		else if(answer==4) {
    			System.exit(0);
    		}		
    		else if(answer !=1&&answer !=2&&answer !=3 && answer!=4) {
    		System.out.println("vui lòng nhập số 1,2,3,4");
    	}
    	}catch(Exception ex) {
    		System.out.println("vui lòng nhập số ");
    	}
        
    }
}

    public static void sortASC(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public static void sortDESC(int [] arr) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public static void show(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
