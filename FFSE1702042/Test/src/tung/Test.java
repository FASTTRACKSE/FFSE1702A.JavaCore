package tung;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int size, temp;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập vào độ dài của mảng: ");
		size = scanner.nextInt();

		int[] array = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.println("Nhập vào phần tử thứ " + i + ": ");
			array[i] = scanner.nextInt();
		}

		for (int i = 0; i < size; i++) {
			System.out.println("Phần tử thứ " + i + ": " + array[i]);
		}

		System.out.println("Mảng ban đầu: ");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + "\t");
		}
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (array[j] < array[i]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("\nMảng sau khi sắp xếp từ thấp đến cao: ");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + "\t");
		}
		for (int i = 0; i < size - 1; i++) {
			for (int k = i + 1; k < size; k++) {
				if (array[k] > array[i]) {
					temp = array[i];
					array[i] = array[k];
					array[k] = temp;
				}
			}
		}
		System.out.println("\nMảng sau khi sắp xếp từ cao đến thấp: ");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + "\t");
		}

	}
}
