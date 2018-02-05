

	import java.util.Scanner;
	import java.util.Arrays;

	public class Assignment_4 {

		static Scanner input = new Scanner(System.in);
		static boolean retry;

		public static void main(String[] args) {
			do {
				try {
					retry = false;
					System.out.print("Nhập kích thước mảng A: ");
					int n = input.nextInt();
					int[] A = new int[n];
					for (int i = 0; i < n; i++) {
						System.out.print("A[" + i + "] = ");
						A[i] = input.nextInt();
					}
					xuli(A);
					if (!retry) {
						System.out.print("\nTiếp tục chứ? (Y/N) ");
						String check = input.nextLine();
						if ("N".equals(check) || "n".equals(check)) {
							System.out.println("Exit!");
							break;
						}
						System.out.println("--------------------------------------------------------------");
					}
				} catch (Exception ex) {
					System.out.print("Vui lòng nhập số hợp lệ!");
					break;
				}
			} while (true);

		}

		public static void xuli(int array[]) {
			System.out.println(">>>     CHỌN PHƯƠNG ÁN XỬ LÍ     <<<");
			System.out.println("+----------------------------------+");
			System.out.println("| 1. Sắp xếp mảng từ cao đến thấp  |");
			System.out.println("| 2. Sắp xếp mảng từ thấp đến cao  |");
			System.out.println("| 3. Nhập lại mảng                 |");
			System.out.println("| 4. Thoát khỏi chương trình       |");
			System.out.println("+----------------------------------+");
			System.out.println(">>>           Nhập số?           <<<");
			int answer = input.nextInt();
			input.nextLine();
			if (answer == 1) {
				Arrays.sort(array);
				printArray_1(array);
			} else if (answer == 2) {
				Arrays.sort(array);
				printArray_2(array);
			} else if (answer == 3) {
				retry = true;
			} else if (answer == 4) {
				System.out.println("Kết thúc!");
				System.exit(0);
			} else {
				System.out.println("Chức năng không tồn tại. Vui lòng nhập đúng số!");
			}
		}

		public static void printArray_1(int array[]) {
			System.out.print("Mảng sắp xếp từ cao đến thấp là: ");
			for (int i = array.length - 1; i >= 0; i--) {
				if (i != array.length - 1) {
					System.out.print(", ");
				}
				System.out.print(array[i]);
			}
			System.out.println();
		}

		public static void printArray_2(int array[]) {
			System.out.print("Mảng sắp xếp từ thấp đến cao là: ");
			for (int i = 0; i < array.length; i++) {
				if (i != 0) {
					System.out.print(", ");
				}
				System.out.print(array[i]);
			}
			System.out.println();
		}

	}


