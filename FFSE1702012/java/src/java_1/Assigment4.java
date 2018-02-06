package java_1;
        import java.util.Scanner;
public class Assigment4 {
        public static  Scanner myinput = new Scanner(System.in);
           
        public static void main(String args[]) {
           
               System.out.println("Nhập số phần tử của mảng");
               int n = myinput.nextInt();
               // Khởi tạo mảng:
               int[] arr = new int[n];
               System.out.println("Nhập các phần tử của mảng");
               for( int i =0; i<n;i++) {
                    arr[i] = myinput.nextInt();
               }
               System.out.println("Các phần tử của mảng: ");
               show(arr);
               System.out.println();
               /*
                * can quay lai:
                */
               // thuc hien các chức năng:
              
               String  text  = "Yes";
               while(text == "Yes" ) {
                   int choise;
               System.out.println("CÁC CHỨC NĂNG LIÊN QUAN ");
               chucnang(); 
               /*
                * thuc hien chuc nang:
                */
               choise = myinput.nextInt();
               if(choise == 1) {
                   desc(arr);  show(arr);
               }
               else if(choise == 2) {
                   asc(arr);  show(arr);
               }
               else if(choise == 3) {
                   main(args);
               }
               else if(choise!=1 && choise !=2 && choise != 3) {
                   System.out.println("\n"+"Vui long chọn đúng chức năng");
                   
               }
               System.out.println("\n"+"Bạn có muốn thực hiện các chức năng khác không?");
               Scanner myinput1 = new Scanner(System.in);
               String text1 = myinput1.nextLine();
               for(int a = 0;a<text1.length();a++) {
                   if(text1.charAt(a) == 'Y') {
                       text = "Yes";
                   }
                   if(text1.charAt(a) == 'N') {
                       text = "No";
                   }
               }
          }  
        }

        
        /*
         * Show mang ra man hinh:
         */
        public static void show(int[] arr) {
            for(int j=0; j<arr.length; j++) {
                System.out.print(arr[j] + "  ");
            }
            }

        public static void chucnang() {
                System.out.println("1: Sắp xếp mảng từ cao đến thấp");
                System.out.println("2: Sắp xếp mảng từ thấp đến cao");
                System.out.println("3: Nhập lại mảng");
                System.out.println("4: Thoát khỏi chương trình");
        }
        public static void desc(int arr[]) {
                int temp = arr[0];
                for(int i =0; i<arr.length -1; i++) {
                    for(int j = i+1;j<arr.length;j++) {
                        if(arr[j] >arr[i]) {
                            temp = arr[j];
                            arr[j] = arr[i];
                            arr[i] = temp;
                        }
                    }
                }
        }
        public static void asc(int arr[]) {
            int temp1 = arr[0];
            for(int i =0; i<arr.length -1; i++) {
                for(int j = i+1;j<arr.length;j++) {
                    if(arr[j] <arr[i]) {
                        temp1 = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp1;
                    }
                }
            }
        }
}
