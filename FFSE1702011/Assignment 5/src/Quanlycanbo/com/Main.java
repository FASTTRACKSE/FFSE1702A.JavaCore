<<<<<<< HEAD:FFSE1702042/canBo/src/Quanlycanbo/Main.java
package Quanlycanbo;
import java.io.*;
=======
package Quanlycanbo.com;

>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing:FFSE1702011/Assignment 5/src/Quanlycanbo/com/Main.java
import java.util.ArrayList;
<<<<<<< HEAD
import java.io.*;

import java.util.Collection;
=======
>>>>>>> 45c6cc847d29ca7c683fcf8d24d00a1ee0c5e29f
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.*;
public class Main {
<<<<<<< HEAD
	static Scanner myInput = new Scanner(System.in);
	public static void main(String[] args) {
		Scanner chucNang = new Scanner(System.in);
=======
	
	public static void main(String[] args) throws IOException, ClassNotFoundException  {
>>>>>>> 45c6cc847d29ca7c683fcf8d24d00a1ee0c5e29f
		ArrayList<CanBo> list = new ArrayList<CanBo>();
		Scanner chucNang = new Scanner(System.in);
		try {
			FileInputStream fos = new FileInputStream("CanBo.doc");
			ObjectInputStream oos = new ObjectInputStream(fos);
			list = (ArrayList<CanBo>) oos.readObject();
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Co loi" + e);
		}
			for(;;) {
			System.out.println("1. Nhap thong tin danh sach");
			System.out.println("2. Hien thi danh sach");
			System.out.println("3. Tinh tong so luong");
			System.out.println("4. Sap xep theo luong, neu trung sap xep theo ten");
			System.out.println("5. Sap xep bang Collections.sort");
			System.out.println("0. Thoat chuong trinh");
			System.out.print("Chon chuc nang: ");
			int cn = Integer.parseInt(chucNang.nextLine());
			if(cn == 1) {
				System.out.println("");
				System.out.println("1. Nhap danh sach giang vien");
				System.out.println("2. Nhap danh sach nhan vien");
				System.out.print("Chon danh sach:");
				int ds = Integer.parseInt(chucNang.nextLine());
				if(ds == 1) {
					System.out.print("So luong nhap: ");
					int sl = Integer.parseInt(chucNang.nextLine());
					int dem = 1;
					for(int i = 0; i < sl; i++) {
						GiangVien gv = new GiangVien();
						gv.nhapTen();
						gv.nhapGiangVien();
						gv.nhapHeSoLuong();
						System.out.println("Giang vien " + dem);
<<<<<<< HEAD
						for(;;) {
							System.out.print("Nhap ma giang vien: ");
							try {
								String maCanBo = myInput.nextLine();
								CanBoException.chkMaCB(maCanBo, list);
								gv.setMaCanBo(maCanBo);
								break;
							} catch(CanBoException e) {
								System.out.print(e);
							}
						}
							gv.nhapTen();
							gv.nhapGiangVien();
							gv.nhapHeSoLuong();
							list.add(gv);
							dem++;
					}
					try {
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CanBo.txt"));
						oos.writeObject(list);
						oos.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
=======
<<<<<<< HEAD:FFSE1702042/canBo/src/Quanlycanbo/Main.java
						for(;;) {
							System.out.println("nhap ma can bo");
							String maCanBo	=	chucNang.next();
							try {
								CanBoException.chkMaCanBo(maCanBo, list);;
								gv.setMaCanBo(maCanBo);
								break;
							}catch(CanBoException e) {
								System.out.println(e);
							}
						
							
						}
						
=======
						gv.nhapTen();
						gv.nhapGiangVien();
						gv.nhapHeSoLuong();
>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing:FFSE1702011/Assignment 5/src/Quanlycanbo/com/Main.java
						list.add(gv);
						try {
							FileOutputStream fos = new FileOutputStream("CanBo.doc");
							ObjectOutputStream oos = new ObjectOutputStream(fos);

							oos.writeObject(list);

							oos.close();
							fos.close();

						} catch (IOException e) {
							System.out.println(e);
						}
						dem++;
>>>>>>> 45c6cc847d29ca7c683fcf8d24d00a1ee0c5e29f
					}
				} else if(ds == 2) {
<<<<<<< HEAD:FFSE1702042/canBo/src/Quanlycanbo/Main.java
				System.out.print("So luong nhap: ");
					int sl = Integer.parseInt(chucNang.next());
=======
					System.out.print("So luong nhap: ");
					int sl = Integer.parseInt(chucNang.nextLine());
>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing:FFSE1702011/Assignment 5/src/Quanlycanbo/com/Main.java
					int dem = 1;
					NhanVien nv = new NhanVien();
					nv.nhapTen();
					nv.nhapNhanVien();
					nv.nhapHeSoLuong();
					for(int i = 0; i < sl; i++) {
						
						System.out.println("Nhan vien " + dem);
<<<<<<< HEAD
						for(;;) {
							System.out.print("Nhap ma giang vien: ");
							try {
								String maCanBo = myInput.nextLine();
								CanBoException.chkMaCB(maCanBo, list);
								nv.setMaCanBo(maCanBo);
								break;
							} catch(CanBoException e) {
								System.out.print(e);
							}
						}
						nv.nhapTen();
						nv.nhapNhanVien();
						nv.nhapHeSoLuong();
						list.add(nv);
=======
					
						
						
						
					}
					list.add(nv);
					try {
						FileOutputStream fos = new FileOutputStream("CanBo.doc");
						ObjectOutputStream oos = new ObjectOutputStream(fos);

						oos.writeObject(list);

						oos.close();
						fos.close();

					} catch (IOException e) {
						System.out.println(e);
>>>>>>> 45c6cc847d29ca7c683fcf8d24d00a1ee0c5e29f
					}
					try {
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CanBo.txt"));
						oos.writeObject(list);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else if(cn == 2) {
				System.out.println("Danh sach giang vien");
				try {
					ObjectInputStream ios = new ObjectInputStream(new BufferedInputStream(new FileInputStream("CanBo.txt")));
					try {
						Object obj = ios.readObject();
						ArrayList<CanBo> dsCB = (ArrayList<CanBo>) obj;
						for(int i = 0; i < dsCB.size(); i++) {
							if(dsCB.get(i) instanceof GiangVien) {
								GiangVien gv = (GiangVien)dsCB.get(i);
								gv.xuatGiangVien();
							} 
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Danh sach nhan vien");
				try {
					ObjectInputStream ios = new ObjectInputStream(new BufferedInputStream(new FileInputStream("CanBo.txt")));
					try {
						Object obj = ios.readObject();
						ArrayList<CanBo> dsCB = (ArrayList<CanBo>) obj;
						for(int i = 0; i < dsCB.size(); i++) {
							if(dsCB.get(i) instanceof NhanVien) {
								NhanVien nv = (NhanVien)dsCB.get(i);
								nv.xuatNhanVien();
							}
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(cn == 3) {
				float tongLuong = 0;
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i) instanceof GiangVien) {
						GiangVien gv = (GiangVien)list.get(i);
						tongLuong += (gv.getHeSoLuong()*730) + gv.getPhuCap() + (gv.getSoTiet()*45);
					} else {
						NhanVien nv = (NhanVien)list.get(i);
						tongLuong += (nv.getHeSoLuong()*730) + nv.getPhuCap() + (nv.getNgayCong()*30);
					}
				}
				System.out.println("Tong so luong can bo: " + tongLuong);
			} else if(cn == 4) {
				CanBo tam;
				for(int i = 0; i < list.size() - 1; i++) {
					for(int j = i+1; j < list.size(); j++) {
						if(list.get(i).getHeSoLuong() > list.get(j).getHeSoLuong()) {
							tam = list.get(i);
							list.set(i, list.get(j));
							list.set(j, tam);
						} else if(list.get(i).getHeSoLuong() == list.get(j).getHeSoLuong()) {
							if(list.get(i).getHoTen().compareTo(list.get(j).getHoTen()) > 0) {
								tam = list.get(i);
								list.set(i, list.get(j));
								list.set(j, tam);
							}
						}
					}
				}
			} else if(cn == 0) {
				break;
			} else if(cn == 5) {
				Collections.sort(list, new Comparator<CanBo>() {

					@Override
					public int compare(CanBo o1, CanBo o2) {
						if(o1.getHeSoLuong() == o2.getHeSoLuong()) {
							return o2.getHoTen().compareTo(o1.getHoTen());
						} else {
						// TODO Auto-generated method stub
						return (o1.getHeSoLuong() > o2.getHeSoLuong())? -1 : 1;
						}
					}
					
				});
			}
			}
		}
			public void ghiFile() throws IOException {
				FileOutputStream fos	=	new FileOutputStream("CanBo.pdf",true);
				PrintWriter pw	=	new PrintWriter(fos);
				pw.println("Danh sach giang vien");
////				for(int i = 0; i < list.size(); i++) {
////					if(list.get(i) instanceof GiangVien) {
////						GiangVien gv = (GiangVien)list.get(i);
////						gv.xuatGiangVien();
////					} 
////				}
//				pw.println("Danh sach nhan vien");
////				for(int i = 0; i < list.size(); i++) {
////					if(list.get(i) instanceof NhanVien) {
////						NhanVien nv = (NhanVien)list.get(i);
////						nv.xuatNhanVien();
////					}
////				}
//				pw.close();
				fos.flush();
				fos.close();
	}
<<<<<<< HEAD:FFSE1702042/canBo/src/Quanlycanbo/Main.java
			public void docFile() throws IOException {
				FileReader fr	=	new FileReader("CanBo.pdf");
				BufferedReader br	=	new BufferedReader(fr);
				String line	=	" ";
				while((line=br.readLine())!=null) {
					System.out.println(line);
				}
				br.close();
				fr.close();
			}
	
}
=======
}

>>>>>>> parent of 7aeaedb... ASM 1 vs 2 JavaSwing:FFSE1702011/Assignment 5/src/Quanlycanbo/com/Main.java
