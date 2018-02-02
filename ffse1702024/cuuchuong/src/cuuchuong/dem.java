package cuuchuong;

import java.util.Scanner;

public class dem {
	
		public static void main(String args[]) {
			String ln = "return";
			while (ln == "return") {
				String[]  doc = new String[10] ;
				doc[0] ="không";
				doc[1] ="một";
				doc[2] ="hai";
				doc[3] ="ba";
				doc[4] ="bốn";
				doc[5] ="năm";
				doc[6] ="sáu";
				doc[7] ="bảy";
				doc[8] ="tám";
				doc[9] ="chín"; 
				Scanner bien = new Scanner(System.in);
				System.out.println("Nhập 1 số từ 1-9999");
				int n = bien.nextInt();
				int x = n/1000;
				int y = (n-x*1000)/100;
				int z = (n-x*1000-y*100)/10;
				int k = (n-x*1000-y*100-z*10);
				if (n < 1 || n > 9999) {
					System.out.println("số cần nhập phải từ 1-9999");
				}
				else
				{
					System.out.println("số vừa nhập là:");
					if(n<10) {
						System.out.println( doc[k]);	
					}
					else {
						if(n<100) {
							if(z==1 && k==0) {
								System.out.println("mười" );	 
							}
							else if(z>1 && k==1) {
								System.out.println( doc[z] +" "+"mươi mốt" );	
							}
							else if(z==1) {
								System.out.println("mười" +" "+ doc[k]);
							}	
							else if(k==0) {
								System.out.println( doc[z] +" "+"mươi" );
							}
							else { 
								System.out.println( doc[z] +" "+"mươi" +" "+ doc[k]);
							}
						}
						else
						{
							if(n<1000)
							{

								if(z==0 && k==0) {
									System.out.println( doc[y] +" "+"trăm");
								}

								else if(z==1 && k==0) {
									System.out.println( doc[y] +" "+"trăm mười");
								}

								else if(z==1 && k==1) {
									System.out.println( doc[y] +" "+"trăm mười một");
								}
								else if(z==1 && k>0) {
									System.out.println( doc[y] +" "+"trăm" + " " + doc[z]+" "+"mười" +" "+ doc[k] );
								}

								else if(z>1 && k==0) {
									System.out.println( doc[y] +" "+"trăm" + " " + doc[z]+" "+"mươi");
								}
								else if(z==0) {
									System.out.println( doc[y] +" "+"trăm linh" + " " + doc[k] );
								}
								else if(z>0 && k==1) {
									System.out.println( doc[y] +" "+"trăm" + " " + doc[z]+" "+"mươi mốt" );
								}
								else 
								{
									System.out.println( doc[y] + " " + "trăm" + " " +  doc[z] + " " + "mươi" + " " +  doc[k] );
								}
							}
							else {
								if(y==0 && z==0 && k==0) {
									System.out.println( doc[x] +" "+"nghìn");
								}
								else if(z==1 && k==0) {
									System.out.println( doc[x] +" "+"nghìn" + " " +doc[y] +" "+"trăm mười");
								}
								else if(z==1 && k>0) {
									System.out.println( doc[x] +" "+"nghìn" + " " +doc[y] +" "+"trăm mười" +" "+ doc[k] );
								}
								else if(z==0)
								{
									System.out.println( doc[x] +" "+"nghìn" +" "+ doc[y] + " " + "trăm"
										+ " " +"linh" + " " +  doc[k] );	
								}
								else if(z>0 && k==1)
								{
									System.out.println( doc[x] +" "+"nghìn" +" "+ doc[y] + " " + "trăm"
										+" "	+  doc[z]	+ " " +"mươi mốt" );	
								}
								else if(k==0)
								{
									System.out.println( doc[x] +" "+"nghìn" +" "+ doc[y] + " " + "trăm"
										+ " " +  doc[z] + " " + "mươi" );
								}

								else {
									System.out.println( doc[x] +" "+"nghìn" +" "+ doc[y] + " " + "trăm"
										+ " " +  doc[z] + " " + "mươi" + " " +  doc[k] );
								}

							}

						}

					}

				}
				Scanner lap = new Scanner(System.in);
				System.out.println("		");
				System.out.println("Nhấn phím bất kì để lặp lại nhấn phím S để dừng chương trình  ");
				ln = lap.nextLine();
				if (ln.equalsIgnoreCase("S") || ln.equalsIgnoreCase("Stop")) {
					ln = "Stop";
				} else {
					ln = "return";
				}
			}
		}
	}