package part03;

public enum BookStatus {
	AVAILABLE("Book Available"),
	ON_LOAN("Book on Loan"),
	WITHDRAWN("Book Withdrawn");
	
	private String info;
	
	private BookStatus(String s) {
		info = s;
	}
	
	public String toString() {
		return info;
	}
}
