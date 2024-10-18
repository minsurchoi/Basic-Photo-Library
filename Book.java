package part03;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private BookType type;
	private int edition;
	private String summary;
	private double price;
	
	public Book(String title, String author, String isbn, BookType type, int edition, String summary, double price) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.type = type;
		this.edition = edition;
		this.summary = summary;
		this.price = price;
	}
		public String getTitle() {
			return this.title;
		}
		
		public String getAuthor() {
			return this.author;
		}
		
		public String getIsbn() {
			return this.isbn;
		}
		
		public BookType getType() {
			return this.type;
		}
		
		public int getEdition() {
			return this.edition;
		}
		
		public String getSummary() {
			return this.summary;
		}
		
		public double getPrice() {
			return this.price;
		} 
		
		
		
		public String toString() { 
			return getTitle() + " by " + getAuthor() + "\n" + 
			"ISBN: " + getIsbn() + "\n" + 
			"Type: " + getType() + "\n" + 
			"Edition: " + getEdition() + "\n" + 
			"Summary: " + getSummary() + "\n" + 
			"Price: £" + String.format("%.2f", getPrice());
		} 
	 
}



