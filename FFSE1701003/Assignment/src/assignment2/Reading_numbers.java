package assignment2;

import java.util.Scanner;

public class Reading_numbers {

	public Reading_numbers() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] strs) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
	}
	
	public static String Char_number( String a) 
	{
		String str = null;
		String ar_char[]= {"Khong", "Mot", "Hai", "Ba", "Bon", "Nam", "Sau", "Bay", "Tam", "Chin"};
		switch(a) {
			case "0":
				str = ar_char[0];
				break;
			case "1":
				str = ar_char[1];
				break;
			case "2":
				str = ar_char[2];
				break;
			case "3":
				str = ar_char[3];
				break;
			case "4":
				str = ar_char[4];
				break;
			case "5":
				str = ar_char[5];
				break;
			case "6":
				str = ar_char[6];
				break;
			case "7":
				str = ar_char[7];
				break;
			case "8":
				str = ar_char[8];
				break;
			case "9":
				str = ar_char[9];
				break;
		}
		return str;
	}
	
	public void add_number_array(int a) {
		String ss[];
		String str = Integer.toString(a);
		int[] j = Integer.toString(a).split();
		
//		int length = str.length();
		
//		for(int i = 0; i < length; i++) {
//			ss[i] = str[i];
//		}
		
//		String sampleString = "101,203,405";
//		
//		  String[] stringArray = sampleString.split(",");
//		  int[] intArray = new int[stringArray.length];
//		  for (int i = 0; i < stringArray.length; i++) {
//		     String numberAsString = stringArray[i];
//		     intArray[i] = Integer.parseInt(numberAsString);
//		  }
//		  System.out.println("Number of integers: " + intArray.length);
//		  System.out.println("The integers are:");
//		  for (int number : intArray) {
//		     System.out.println(number);
//		  }
	}
}
