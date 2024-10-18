package part03;

import javax.swing.ImageIcon;

public class LibraryBook extends Book implements Lendable{
	private int id;
	private static int nextId;
	private BookStatus bookStatus;
	private ImageIcon imageIcon;
	private int loanCount;
	
	public LibraryBook(String title, String author, String isbn, BookType type, int edition, String summary, double price) {
		super(title, author, isbn, type, edition, summary, price);
		this.id = nextId;
		nextId++;
		
	} 
	
	@Override
	
	public String toString() { 
		return getTitle() + " by " + getAuthor() + "\n" + 
		"ISBN: " + getIsbn() + "\n" + 
		"Type: " + getType() + "\n" + 
		"Edition: " + getEdition() + "\n" + 
		"Summary: " + getSummary() + "\n" + 
		"Price: £" + String.format("%.2f", getPrice());
	} 
	
	public BookStatus getBookStatus() {
		return bookStatus;
	}
	
	public void setBookStatus(BookStatus bookStatus) {
	        this.bookStatus = bookStatus;
	}
	
	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getLoanCount() {
		return this.loanCount;
	}
	public boolean checkout() {
		this.loanCount+=1;
		return true;
	}
 
	public boolean checkin() {
		return true;
	}
	
	
}
	





