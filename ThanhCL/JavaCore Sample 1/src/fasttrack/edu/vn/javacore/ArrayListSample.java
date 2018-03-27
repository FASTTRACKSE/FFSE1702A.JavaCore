package fasttrack.edu.vn.javacore;

import java.util.ArrayList;

public class ArrayListSample {

	public static void main(String[] args) {
		ArrayList ds1 = new ArrayList();
		ds1.add("Danh sách collection");
		ds1.add("By Cao Lê Thành");
		ds1.add("======================");
		ds1.add("======================");
		
		for (int i = 1; i <= 10; i++) {
			ds1.add(ds1.size()-1, i + ". Hàng thứ " + i);
		}
		
		for (Object x: ds1) {
			System.out.println(x);
		}

	}

}
