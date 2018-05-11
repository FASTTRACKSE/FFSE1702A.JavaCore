package javabuoi1;

import java.util.Scanner;

public class HelloWorld {

	//a + 20s + b + 20s + c 
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
  //      String a = "Nguyen      Van   Be    Ba";
    //    String b = a.replaceAll("\\s+", "_");
      //  String g = "nguyen";//
    //    g.charAt(0);
      //  System.out.println(g.charAt(0));
        
//        String email = "abc789@GMAIL.com";
//        String phone  = "09791234569";
//     	String regex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$"; // regular expression
		char s = '3';
		if(Character.isDigit(s)) { //isAlphabet
			
		}
		String a ;
        System.out.println("xin moi nhap chuoi  :");	
		Scanner sc = new Scanner(System.in);
		a= sc.nextLine(); 
		chuoiDaoNguoc(a);       
 	}
	// 0 1 2 3 4 5 6 7 8 9 10 11
	// N g u y e n _ V a n _ A
	private static String chuoiDaoNguoc (String a) {
		String kq = "";
		String [] b = a.split(" ");
		
		for (int i = b.length - 1; i >= 0; i-- ) {
			String temp = b[i];
			System.out.print(temp + " ");
			kq += temp;
		}
		return kq;
	}
	//ham chuan hoa chuoi
	// "nguyen      Van a     " -> "Nguyen Van A"
	private static void demKiTuTrongXau(String a) {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for(int i =0; i < a.length(); i++) {
			if (Character.isAlphabetic(a.charAt(i))) {
				count1++;
			}else if (Character.isDigit(a.charAt(i))) {
				count2++;
			}
		}
		String [] b = a.split(" "); 
		count3 = b.length;
		System.out.println("so ki tu chu cai trong chuoi la:" + count1);
		System.out.println("so ki tu so trong chuoi la:" + count2);
		System.out.println("so chu trong chuoi la:" + count3);

	}
	private static String hamChuanHoaChuoi(String a) {
		String kq = ""; 
		a = a.trim(); // -> "nguyen      Van a" (loai bo khoang trang dau cuoi
		a = a.replaceAll("\\s+", " "); //"nguyen       Van a" -> nguyen Van a (thay nhieu khoang trang bang mot khoang trang
		String [] b = a.split(" "); // -> mang {"nguyen", "Van", "a"}
		for(int i=0; i < b.length; i++) {
			String temp = b[i];
			String chuDauGhiHoa = String.valueOf(temp.charAt(0)).toUpperCase();// -> n -> N
			temp = chuDauGhiHoa + temp.substring(1);
			kq += temp + " ";
		}
		return kq.trim(); //loai khoang trang cuoi cung
	}
	private static boolean  kiemTraChuoiDoiXung(String a) {
		 char[] charArray = a.toCharArray(); 
		 boolean kq = true;
		 	
		 for( int i=0 ; i < charArray.length; i++) {
			 if(charArray[i] != charArray[charArray.length - 1 - i]) {
				kq = false;
			 }
			 }
		 return kq;
	}
	private static void tinhTong () {
		
		System.out.println("xin moi nhap so  :");	
		int sum = 0;
		int a;
		Scanner sc = new Scanner(System.in);
      do {
    	   a = sc.nextInt();
   			sum = sum + a;
       } while(a != 0);
       
	  System.out.println("tong cac gia tri la : " + sum);
	  
	}
	
	private static String kiemTraTamGiac(int a, int b, int c) {
		
		//xu ly Math.pow(a,2); // a*a
		String kq = "";
		if(a==b && b==c) {
			kq = "Tam Giac Deu";
		}else if (a==b || a == c || b == c) {
			kq = "Tam Giac Can";
		}else if ((Math.pow(a,2) == Math.pow(b,2) + Math.pow(c,2)) || 
				(Math.pow(b,2) == Math.pow(a,2) + Math.pow(c,2)) || 
				(Math.pow(c,2) == Math.pow(b,2) + Math.pow(a,2))){
			kq = "Tam Giac vuong";
		}
		
		return kq;
	}

	// 0	1	2	3	4
	// 88	70	199	11	1
	private static int timSoLonNhat (int[] a ) {
		int max = a[0];// -> max = 88 --> max = 199 (j==2)
		
		for (int j = 1; j < a.length; j++) {
			if(max < a[j]) {
				max = a[j];
			}
		}
		
		return max;
	}
	private static void hamDaoNguoc(int [] b) {
		for (int i = b.length-1; i >= 0; i-- ) {
			System.out.println(b[i]);
		}
	}
	private static int Dem(int[] c) {
		int count = 0;
		for (int i = 0; i < c.length;i++) {
			if (c[i] %2 == 0 ) {
				count++;
			}
				
		}
		
		return count;
	}
	private static void nhapSoKhacNhau(int[] d) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Vui long nhap mang du lieu gom " + d.length + " so");
		
		for(int i = 0; i < d.length; ) {
			System.out.println("Nhap so thu " + (i+1));
			int temp = sc.nextInt();
			if(chuaTonTai(d, temp) || temp == 0) {
				d[i] = temp;
				i++;
			} else {
				System.out.println(" Da ton tai");
			}
			
		}
	}
	
	private static boolean chuaTonTai(int[] a, int number ) {
		boolean kq = true;
		for(int i=0 ; i < a.length; i++) {
			if(number == a[i]) {
				kq = false;
				break;
			}
		}
		
		return kq;
	}
	private static int timViTriSo(int [] a, int b) {
		int kq = -1;
		for (int i =0 ; i < a.length; i++) {
			if (b == a[i]) {
				kq  = i;
			}
		}
		return kq;
	}
}



