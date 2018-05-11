package Giaodien.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataBase {
	public DataBase() {
		super();
	}
	public DanhsachSV readSV(String part) throws Exception {
		DanhsachSV ds = new DanhsachSV();
		File f = new File(part);
		if (f.exists()) {
			Scanner s = new Scanner(f);
			while(s.hasNextLine())
			{
				String line = s.nextLine();
				String[] data = line.split(",");
				SinhVien sv = new SinhVien(Long.parseLong(data[0]),data[1],Integer.parseInt(data[2])); 
				ds.themSV(sv);
				
			}
			s.close();
		}
		else 
		{
			f.createNewFile();
		}
		return ds;	
	}
	public void writeSV(String part,DanhsachSV ds) throws Exception {
		try(PrintWriter out = new PrintWriter(new FileOutputStream(part),true)){
			for(SinhVien sv:ds.getDs()) {
				String data = sv.getMssv() + "," +sv.getHoten()+","+sv.getTuoi();
				out.println(data);
			}
			
		}
				
	}
}
