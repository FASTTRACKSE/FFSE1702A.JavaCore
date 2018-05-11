package DATA;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ID, CLASS, NAME, AGE;
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getCLASS() {
		return CLASS;
	}
	public void setCLASS(String CLASS) {
		this.CLASS = CLASS;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	public String getAGE() {
		return AGE;
	}
	public void setAGE(String AGE) {
		this.AGE = AGE;
	}
	
	public Student(String ID, String NAME, String AGE) {
		this.ID = ID;
		this.NAME = NAME;
		this.AGE = AGE;
	}
	
	public Student(String ID,  String NAME, String AGE, String CLASS) {
		this.ID = ID;
		this.CLASS = CLASS;
		this.NAME = NAME;
		this.AGE = AGE;
	}
	
}