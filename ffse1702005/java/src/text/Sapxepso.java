package text;
import java.util.Scanner;

public class Sapxepso {

	public static Scanner scanner = new Scanner(System.in);
    
    /**
     * main
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        // khởi tạo arr
        int [] arr = new int [n];
        System.out.print("Nhập các phần tử của mảng: \n");
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = scanner.nextInt();
        }
        
    
     
	for(int i=1; i>=i++; i++) {
		System.out.println("");
		System.out.println(">> MÁY TÍNH CÁ NHÂN <<");
		System.out.println("+--------------------+");
		System.out.println("+|    1. Tăng dần   |+");
		System.out.println("+|    2. Giảm dần   |+");
		System.out.println("+|    3. Kết thúc   |+");
		System.out.println("+--------------------+");
		System.out.println("+>> Chọn chức năng <<+");
	
	Scanner myInput = new Scanner(System.in);
	int answer = myInput.nextInt();
	try {
	if(answer == 1) {      
	     // sắp xếp dãy số theo thứ tự tăng dần
	        sortASC(arr);
	        System.out.println("Dãy số được sắp xếp tăng dần: ");
	        show(arr);
	}
	
	else if(answer == 2) {
		// sắp xếp dãy số theo thứ tự giảm dần
        sortDSC(arr);
        System.out.println("Dãy số được sắp xếp giảm dần: ");
        show(arr);
	}
	
	else if(answer == 3) {
		System.exit(0);
	}
	
	else {
		System.out.println("+>> Nhập sai chức năng vui lòng nhập lại <<+");
	}
	}
	catch (Exception e) {
        System.out.println("+>> Error! Vui lòng nhập lại <<+");
    }
	}
    }
    
    /**
     * sắp xếp mảng số nguyên theo thứ tự tăng dần
     * 
     * @param arr: mảng các số nguyên
     * @param n: số phần tử của mảng
     */ 
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
    
    public static void sortDSC(int [] arr) {
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
     
    /**
     * in các phần tử của mảng ra màn hình
     * 
     * @param arr: mảng các số nguyên
     * @param n: số phần tử của mảng
     */
    public static void show(int [] arr) {
    	 for (int i = 0; i < arr.length; i++) {
	            System.out.print(arr[i] + " ");
	        }
    }
    
}
