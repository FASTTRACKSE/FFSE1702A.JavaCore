package first_project;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment_6 {
	static String[] ten = { "Nguyễn Văn A", "Bành Thị B", "Trương Văn C", "Dương Thị D", "Trần Văn E" };
	static String[] ngay_sinh = { "20/07/1998", "12/01/1997", "03/03/1996", "27/01/1995", "11/01/1994" };
	static int[] diem1 = { 69, 88, 33, 99, 55 };
	static int[] diem2 = { 66, 55, 11, 77, 88 };
	static int left = 0;
	static int right = ten.length - 1;
	static int[] tuoi = new int[ten.length];
	static int[] index = new int[ten.length];
	static float[] diemTB = new float[ten.length];
	static String[] xeploai = new String[ten.length];
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		for (int i = 0; i < ten.length; i++) {
			index[i] = i;
			tuoi[i] = 2018 - Integer.parseInt(ngay_sinh[i].substring(6));
			diemTB[i] = (float) ((diem1[i] + diem2[i]) / 2.0);
			if (diemTB[i] >= 85) {
				xeploai[i] = "A";
			} else if (diemTB[i] >= 70) {
				xeploai[i] = "B";
			} else if (diemTB[i] >= 50) {
				xeploai[i] = "C";
			} else {
				xeploai[i] = "D";
			}
		}
		do {
			xuli();
		} while (true);
	}

	public static void quickSort(float[] arr, int left, int right) {
		float[] sort = new float[ten.length];
		sort = arr.clone();
		if (sort == null || sort.length == 0)
			return;
		if (left >= right)
			return;
		int middle = left + (right - left) / 2;
		float pivot = sort[middle];
		int i = left, j = right;
		while (i <= j) {
			while (sort[i] < pivot) {
				i++;
			}
			while (sort[j] > pivot) {
				j--;
			}
			if (i <= j) {
				float temp = sort[i];
				sort[i] = sort[j];
				sort[j] = temp;
				temp = index[i];
				index[i] = index[j];
				index[j] = (int) temp;
				i++;
				j--;
			}
		}
		if (left < j)
			quickSort(sort, left, j);
		if (right > i)
			quickSort(sort, i, right);
	}

	public static void sort_Name(String[] arr) {
		String[] sort = new String[ten.length];
		sort = arr.clone();
		for (int i = 0; i < sort.length - 1; i++) {
			for (int j = sort.length - 1; j >= 1; j--) {
				int result = sort[j].compareTo(sort[j - 1]);
				if (result < 0) {
					String temp = sort[j];
					sort[j] = sort[j - 1];
					sort[j - 1] = temp;
					int temp1 = index[j];
					index[j] = index[j - 1];
					index[j - 1] = temp1;
				}
			}
		}
	}

	public static void print_thap_cao() {
		System.out.println("+---------------+--------+--------+--------+---------+----------+");
		System.out.println("| Họ và tên\t|  Tuổi  | Điểm 1 | Điểm 2 | Điểm TB | Xếp loại |");
		System.out.println("|---------------|--------|--------|--------|---------|----------|");
		for (int i = 0; i < index.length; i++) {
			System.out.println("| " + ten[index[i]] + "\t|   " + tuoi[index[i]] + "   |   " + diem1[index[i]]
					+ "   |   " + diem2[index[i]] + "   |  " + diemTB[index[i]] + "   |     " + xeploai[index[i]]
					+ "    |");
		}
		System.out.println("+---------------+--------+--------+--------+---------+----------+");
	}

	public static void print_cao_thap() {
		System.out.println("+---------------+--------+--------+--------+---------+----------+");
		System.out.println("| Họ và tên\t|  Tuổi  | Điểm 1 | Điểm 2 | Điểm TB | Xếp loại |");
		System.out.println("|---------------|--------|--------|--------|---------|----------|");
		for (int i = index.length - 1; i >= 0; i--) {
			System.out.println("| " + ten[index[i]] + "\t|   " + tuoi[index[i]] + "   |   " + diem1[index[i]]
					+ "   |   " + diem2[index[i]] + "   |  " + diemTB[index[i]] + "   |     " + xeploai[index[i]]
					+ "    |");
		}
		System.out.println("+---------------+--------+--------+--------+---------+----------+");
	}

	public static void xuli() {
		System.out.println("               >>>      CHỌN PHƯƠNG ÁN XỬ LÍ       <<<");
		System.out.println("               +-------------------------------------+");
		System.out.println("               | 1. Sắp xếp mặc định                 |");
		System.out.println("               | 2. Sắp xếp điểm TB từ cao đến thấp  |");
		System.out.println("               | 3. Sắp xếp điểm TB thấp đến cao     |");
		System.out.println("               | 4. Sắp xếp theo họ và tên (A->Z)    |");
		System.out.println("               | 5. Sắp xếp theo họ và tên (Z->A)    |");
		System.out.println("               | 6. Thoát khỏi chương trình          |");
		System.out.println("               +-------------------------------------+");
		System.out.println("               >>>            Nhập số?             <<<");
		int answer = input.nextInt();
		input.nextLine();
		if (answer == 1) {
			Arrays.sort(index);
			print_thap_cao();
		} else if (answer == 2) {
			Arrays.sort(index);
			quickSort(diemTB, left, right);
			print_cao_thap();
		} else if (answer == 3) {
			Arrays.sort(index);
			quickSort(diemTB, left, right);
			print_thap_cao();
		} else if (answer == 4) {
			Arrays.sort(index);
			sort_Name(ten);
			print_thap_cao();
		} else if (answer == 5) {
			Arrays.sort(index);
			sort_Name(ten);
			print_cao_thap();
		} else if (answer == 6) {
			System.out.println("Kết thúc!");
			System.exit(0);
		} else {
			System.out.println("Chức năng không tồn tại. Vui lòng nhập đúng số!");
		}
	}
}
