package com.codepro.java.Assignment1;
import java.util.Scanner;

public class Assignment4 {
	private static Scanner input;

	public static void main(String[] args) {
		int size;  
	    input = new Scanner(System.in);
	    System.out.print("Nhap vao do dai mang: ");
	    size= input.nextInt();
	    
	    int[] so = new int[size];
	    for (int i = 0; i < size; i++) {
	        System.out.print("Nhap vao phan tu thu " + (i+1) + ": ");
	        so[i] = input.nextInt(); 
	    }
	    
	    int x=0,a,j=0,i=0;
	    do {
	    	System.out.println("+-------------------------------+");
	    	System.out.println("1. Sap xep mang tu cao den thap.");
	    	System.out.println("2. Sap xep mang tu thap den cao.");
	    	System.out.println("3. Nhap lai mang.");
	    	System.out.println("4. Thoat khoi chuong trinh.");
	    	System.out.println("+-------------------------------+");
	    	System.out.print(">>Nhap yeu cau: ");
	    	x= input.nextInt();
	    	switch(x) {
			case 1 :
				 for (i = 0; i < size-1; i++) {
					 for (j = i+1; j < size; j++) {
						 if(so[i]<so[j]) {
							 a=so[i];
							 so[i]=so[j];
							 so[j]=a;
						 }
					 }
				 }
				 System.out.print("Mang:");
				 for (i = 0; i < size; i++) {
					 System.out.print("  "+so[i]);
				 }
				 System.out.println(".");
				 break;
			case 2 :
				 for (i = 0; i < size-1; i++) {
					 for (j = i+1; j < size; j++) {
						 if(so[i]>so[j]) {
							 a=so[i];
							 so[i]=so[j];
							 so[j]=a;
						 }
					 }
				 }
				 System.out.print("Mang:");
				 for (i = 0; i < size; i++) {
					 System.out.print("  "+so[i]);
				 }
				 System.out.println(".");
				 break;
			case 3 :
				System.out.print("Nhap vao do dai mang: ");
			    size= input.nextInt();
			    
			    so = new int[size];
			    for (i = 0; i < size; i++) {
			        System.out.print("Nhap vao phan tu thu " + (i+1) + ": ");
			        so[i] = input.nextInt(); 
			    }
			    break;
			case 4 :
				System.out.println("Da thoat khoi chuong trinh!");
				break;
	    	}
	    }while(x!=4);
	}
}
