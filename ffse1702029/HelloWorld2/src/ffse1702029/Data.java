package ffse1702029;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Data {
	public Data() {
		super();
	}
	public static DanhSach readSV(String part) throws Exception {
		DanhSach ds = new DanhSach();
		File f = new File(part); 
		if(f.exists()) {
			Scanner s = new Scanner(f);
			while(s.hasNextLine()) {
				String line = s.nextLine();
				String[] Data= line.split(",");
				SinhVien sv = new SinhVien(Data[0], Data[1], Integer.parseInt(Data[2]), Data[3]);
				ds.them(sv);
			}
			s.close();
		}else {
			f.createNewFile();
		}
		return ds;
	}
	public void write(String part, DanhSach ds) throws Exception{
		try(PrintWriter out = new PrintWriter(new FileOutputStream(part),true)){
			for(SinhVien sv:ds.getDs()) {
				String data = sv.getMs()+","+sv.getHt()+","+sv.getTuoi()+","+sv.getEmail();
				out.println(data);
			}
		}
	}


}
