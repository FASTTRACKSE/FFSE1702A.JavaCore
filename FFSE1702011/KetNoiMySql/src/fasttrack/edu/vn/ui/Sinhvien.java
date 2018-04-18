package fasttrack.edu.vn.ui;

import java.sql.*;
import com.mysql.*;
import java.io.*;

import fasttrack.edu.vn.connection.ConnectSql;

import java.util.*;

public class Sinhvien implements Serializable {
	static Connection conn = ConnectSql.getConnect("localhost", "FFSE", "FFSE", "123456");
	
	private String id;
	private String name;
	private String age;
	private String cls;
	
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public Sinhvien(String id, String name, String age, String cls) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.cls = cls;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
