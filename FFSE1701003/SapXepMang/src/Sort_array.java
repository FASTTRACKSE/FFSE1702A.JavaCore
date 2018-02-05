import java.lang.reflect.Array;
import java.util.Scanner;

public class Sort_array {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] strs) {
		System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int [] arr = new int [n];
        pushArray(arr, n);
        lua_chon();
        int number = scanner.nextInt();
        
        if(number == 1) {
        	sortASC(arr, n);
        	show(arr);
        }else if(number == 2) {
        	sortDESC(arr, n);
        	show(arr);
        }else if(number == 3) {
        	pushArray(arr, n);
        }else if(number == 4) {
        	System.out.print("Thoát khỏi chương trình");
        	return;
        }
	}

	public static void pushArray(int [] arr, int length) {
		
        for(int i=0; i<length; i++) {
        	System.out.printf("array[%d] : ", i);
            arr[i] = scanner.nextInt();
        }
	}
	
	public static void lua_chon() {
		// Chọn phương án in ra màn hình
        System.out.println("1 : Sắp xếp mảng từ cao đến thấp");
        System.out.println("2 : Sắp xếp mảng từ thấp đến cao");
        System.out.println("3 : Nhập lại mảng");
        System.out.println("4 : Thoát khỏi chương trình");
	}
	
	public static void sortASC(int[] arr, int n) {
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
	
	public static void sortDESC(int[] arr, int n) {
        int temp = arr[0];
        for (int i = 0 ; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
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
