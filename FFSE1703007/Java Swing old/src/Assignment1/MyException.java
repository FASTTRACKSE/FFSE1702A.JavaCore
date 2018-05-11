package Assignment1;

public class MyException {
	String err;

	public MyException(String err) {
		super();
		this.err = err;
	}

	@Override
	public String toString() {
		return this.err;
	}
	
}
