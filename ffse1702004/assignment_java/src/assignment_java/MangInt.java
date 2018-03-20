package assignment_java;

import java.util.Scanner;

public class MangInt {
	public static void main(String arg[]) 
	{
		int [] mangInt = new int[50];
		Scanner sn = new Scanner(System.in);
		int chon = 1;
		int  key = 9;
		do 
		{
		
			//menu 
			Scanner sna = new Scanner(System.in);
			System.out.print("So phan tu muon nhap: ");
			int n = sna.nextInt();
		
			for (int i = 0; i < n; i++) 
			{
				System.out.print("Nhap gia tri phan tu: ");
				int k = sna.nextInt();
				mangInt[i] = k;	
			}
			do{
			//menu 
			System.out.print("\n**************************************\n");
			System.out.print("* nhập 1 để sắp xếp từ cao đến thấp  * \n");
			System.out.print("* nhập 2 để sắp xếp từ thấp đến cao  *\n");
			System.out.print("* nhập 3 để nhập lại mảng            *\n");
			System.out.print("* nhập 4 để kết thúc chương trình    *\n");
			System.out.print("**************************************\n");
			key = sna.nextInt();
			if(key == 1) 
			{
				for (int i = 0; i < n-1; i++) 
				{
					for (int j = i+1; j < n; j++) 
					{
						if (mangInt[i] > mangInt[j] ) 
						{
							int tam = mangInt[i];
							mangInt[i] = mangInt[j];
							mangInt[j] = tam;
						}
					}	
				}
				System.out.print("\n********************************************\n");
				System.out.print("Mang sau khi nhap: ");
				for (int i = 0; i < n; i++) 
				{
					System.out.print(mangInt[i]+" , ");	
				}
				System.out.print("\n********************************************\n");
				
			}
			if(key == 2) 
			{
				for (int i = 0; i < n-1; i++) 
				{
					for (int j = i+1; j < n; j++) 
					{
						if (mangInt[i] < mangInt[j] ) 
						{
							int tam = mangInt[i];
							mangInt[i] = mangInt[j];
							mangInt[j] = tam;
						}
					}	
				}
				System.out.print("\n********************************************\n");
				System.out.print("Mang sau khi nhap: ");
				for (int i = 0; i < n; i++) 
				{
					System.out.print(mangInt[i]+" , ");	
				}
				System.out.print("\n********************************************\n");
			}
			if(key == 4 ) 
			{
				System.exit(0);
			}
			
		}while (key != 3);
				
		}while (chon != 4);
	}
}
