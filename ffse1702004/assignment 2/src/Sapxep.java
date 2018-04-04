

import java.util.Arrays;
import java.util.Scanner;
public class Sapxep 
{
    public static int nhap()
    {
    		Scanner input= new Scanner(System.in);
    		boolean check= false;
    		int n=0;
    		while(!check)
    		{
    			System.out.print(" ");
    			try
    			{
    				n= input.nextInt();
    				check= true;
    			}catch(Exception e)
    			{
    				System.out.println("Ban phai nhap so! hay nhap lai...");
    				input.nextLine();
    			}
    		}
    		return (n);
    }
    public static int viTriMaxInt(int a[], int n)
    {
    		int max= a[0];
    		int key= 0;
    		for(int j=0 ; j<n ; j++)
    		{
    			if(max<a[j])
    			{
    				max= a[j];
    				key= j;
    			}
    		}
    		return (key);
    }
    public static void inArray(int[] a, int begin , int end)
    {
    		System.out.println();
    		int i;
    		for(i=begin ; i<end ; i++)
    		{
    			System.out.print(" "+a[i]);
    		}
    		System.out.println();
    }
    public static int viTriMax2(int[] a,int n)
    {
    		int i,key=0,Max2=0;
    		for(i=0 ; i<n ; i++)
    		{
    			if(a[i]>Max2 && a[i]!= a[viTriMaxInt(a, n)])
    			{
    					Max2= a[i];key= i;
    			}
    		}
    		return (key);
    }
    public static void themPhanTu(int[] a,int n,int pt)
    {
    		a[0]= pt;
    		Arrays.sort(a);
    }
    public static void main(String[] args) 
    {
    	int key = 9;
    	do 
    	{
        System.out.print("bạn muốn nhập bao nhiêu số :  ");
        	int n= nhap();
        	int[] a= new int[n+1];
        	int i;
        	for(i=0 ; i<n ; i++)
        	{
        		System.out.print("\n Nhap phan tu thu "+i+" = ");
        		a[i]= nhap();
        	}
        	Arrays.sort(a);
        	inArray(a,1,n+1);
    	}while(key !=0 );
    }
 
}

