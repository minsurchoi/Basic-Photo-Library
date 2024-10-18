package part03;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;

public class Library {
	protected static ArrayList<LibraryBook> books = new ArrayList<LibraryBook>();

	public Library() {
		
	}
	
	public static boolean borrowBook(int id) {
		
		books.get(id).setBookStatus(BookStatus.ON_LOAN);
		books.get(id).checkout();
		return true; 
	}
	
	public static boolean returnBook(int id) {
		books.get(id).setBookStatus(BookStatus.AVAILABLE);
		return true;
	}
	
	public static boolean removeBook(int id) {
		books.get(id).setBookStatus(BookStatus.WITHDRAWN);
		return true;
	}
	
	public static LibraryBook[] list() {


		LibraryBook[] BookArray = new LibraryBook[books.size()];
		int index = 0;

		for (int i = 0; i < books.size(); i++) {
		        BookArray[index] = books.get(i);
		        index++;
		    
		}

		return BookArray;
	}
	
	public static LibraryBook[] listByStatus(BookStatus bookStatus) {
		int count = 0;
		for (int i = 0; i < books.size(); i++) {
		    if (books.get(i).getBookStatus() == bookStatus) {
		        count++;
		    }
		}

		LibraryBook[] matchedBookArray = new LibraryBook[count];
		int index = 0;

		for (int i = 0; i < books.size(); i++) {
		    if (books.get(i).getBookStatus() == bookStatus) {
		        matchedBookArray[index] = books.get(i);
		        index++;
		    }
		}

		return matchedBookArray;
	}
	
	public static LibraryBook[] mostPopular() {
	    // Create a new array to hold the sorted books
	    LibraryBook[] BookArray = new LibraryBook[books.size()];

	    // Copy the books to the new array
	    for (int i = 0; i < books.size(); i++) {
	        BookArray[i] = books.get(i);
	    }

	    // Sort the array using insertion sort
	    for (int i = 1; i < BookArray.length; i++) {
	        LibraryBook key = BookArray[i];
	        int j = i - 1;
	        while (j >= 0 && BookArray[j].getLoanCount() > key.getLoanCount()) {
	            BookArray[j + 1] = BookArray[j];
	            j--;
	        }
	        BookArray[j + 1] = key;
	    }

	    // Reverse the order of the sorted array
	    for (int i = 0; i < BookArray.length / 2; i++) {
	        LibraryBook temp = BookArray[i];
	        BookArray[i] = BookArray[BookArray.length - 1 - i];
	        BookArray[BookArray.length - 1 - i] = temp;
	    }

	    return BookArray;
	}



	
	
	public static LibraryBook search(int id) {
	    for (int i = 0; i < books.size(); i++) {
	        if (books.get(i).getID() == id) {
	            return books.get(i);
	        }
	    }
	    return null;
	}

	
	
	public static boolean add(LibraryBook bk) {

		books.add(bk);
		return true;
	}
		
		
		
		
	
	
}









