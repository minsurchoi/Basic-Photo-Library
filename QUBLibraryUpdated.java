package part03;

import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

import console.Console;


import part01.BookStatus;
import part01.BookType;
import part01.Library;
import part01.LibraryBook;
import part01.Menu;

public class QUBLibraryUpdated extends Library {
	
	static Scanner input = new Scanner(System.in);
	
	
		
	public static void main(String[] args) {
	    Console con = new Console(true);

	    con.setSize(800, 800);
	    con.setVisible(true);
	    con.setTitle("Main Menu");
	    con.setBgColour(Color.BLACK);
	    con.setColour(Color.WHITE);
	    con.setFont(new Font("Arial", Font.PLAIN, 14));

	    String options[] = {"List All Books", "List Books by Status", "Add a Book", "Remove a Book", 
	            "Borrow a Book", "Return a Book", 
	            "Display Ranked List", "Exit"};

	    int choice = 0;
	    do {
	        con.println("MENU");
	        for (int i = 0; i < options.length; i++) {
	            con.println((i + 1) + ". " + options[i]);
	        }

	        boolean checked = false;
	        do {
	            con.print("Enter choice: ");
	            String choicestr = con.readLn();
	            try {
	                choice = Integer.parseInt(choicestr);
	                checked = true;
	            } catch (Exception e) {
	                con.println("Invalid option");
	            }
	        } while (!checked);

	        switch (choice) {
	            case 1:
	                listAllBooks(con);
	                break;
	            case 2:
	                listByBookStatus(con);
	                break;
	            case 3:
	                addBook(con);
	                break;
	            case 4:
	                removeBook(con);
	                break;
	            case 5:
	                borrowBook(con);
	                break;
	            case 6:
	                returnBook(con);
	                break;
	            case 7:
	                rankedList(con);
	                break;
	            case 8:
	                con.println("Good bye!");
	                break;
	            default:
	                con.println("Invalid option: " + choice);
	                break;
	        }
	    } while (choice != 8);
	}

		
	public static void listAllBooks(Console con) {
		
		con.setSize(800, 800);
		con.setVisible(true);
		con.setTitle("List Books");
		con.setBgColour(Color.BLACK);
		con.setColour(Color.WHITE);
		con.setFont(new Font("Arial", Font.PLAIN, 14));
		
	    con.println("*** LIST ALL BOOKS ***");
		
		LibraryBook[] bookArray = list();
		
		if(bookArray.length==0) {
			con.println("No books in system");
			
		}else {
		
			for(int i =0; i< bookArray.length; i++) {
				con.println("\n "+(i+1)+". \nID: "+bookArray[i].getID()+"\nTitle: " + bookArray[i].getTitle() + 
	                    "\nAuthor: " + bookArray[i].getAuthor() + 
	                    "\nISBN: " + bookArray[i].getIsbn() + 
	                    "\nType: " + bookArray[i].getType() + 
	                    "\nEdition: " + bookArray[i].getEdition() + 
	                    "\nSummary: " + bookArray[i].getSummary() + 
	                    "\nPrice: " + bookArray[i].getPrice() + 
	                    "\nStatus: "+bookArray[i].getBookStatus()+"\n");
			}
		}
		
	}
	
	
	public static void listByBookStatus(Console con) {
		
		con.setSize(800, 800);
		con.setVisible(true);
		con.setTitle("List Book Status");
		con.setBgColour(Color.BLACK);
		con.setColour(Color.WHITE);
		con.setFont(new Font("Arial", Font.PLAIN, 14));
		
		con.println("*** LIST BY BOOK STATUS***");
		
		BookStatus status = chooseStatus(con);
		
		LibraryBook[] bookArray = listByStatus(status);
		
		if(bookArray.length==0) {
			con.println("No books by that status");
		}else {
		
			for(int i =0; i< bookArray.length; i++) {
				con.println("\n "+(i+1)+". \nID: "+bookArray[i].getID()+"\nTitle: " + bookArray[i].getTitle() + 
	                    "\nAuthor: " + bookArray[i].getAuthor() + 
	                    "\nISBN: " + bookArray[i].getIsbn() + 
	                    "\nType: " + bookArray[i].getType() + 
	                    "\nEdition: " + bookArray[i].getEdition() + 
	                    "\nSummary: " + bookArray[i].getSummary() + 
	                    "\nPrice: " + bookArray[i].getPrice() + 
	                    "\nStatus: "+bookArray[i].getBookStatus()+"\n");
			}
		}
		
		
	}
	
	public static void addBook(Console con) {
		
		con.setSize(800, 800);
		con.setVisible(true);
		con.setTitle("Add Book");
		con.setBgColour(Color.BLACK);
		con.setColour(Color.WHITE);
		con.setFont(new Font("Arial", Font.PLAIN, 14));
		
		con.println("*** ADD A BOOK ***");
		String title;
		String author;
		String isbn;
		int edition = 0;
		String summary;
		double price = 0;
		String imagePath;
		
		boolean checkTitle=false;
		do {
			con.print("Enter title:");
			title = con.readLn();
			
			if(title.length() < 10 || title.length() > 100) {
				con.println("Title must be between 10 and 100 characters");
				checkTitle= false;
			}else {
				checkTitle=true;
			}
		}while(!checkTitle);

		
		boolean checkAuthor=false;
		do {
			con.print("Enter author:");
			author = con.readLn();
			
			if(author.length() < 10 || author.length() > 100) {
				con.println("Author must be between 10 and 100 characters");
				checkAuthor= false;
			}else {
				checkAuthor= true;
			}
		}while(!checkAuthor);
		
		
		boolean checkISBN=false;
		do {
			con.print("Enter ISBN:");
			isbn = con.readLn();
			
			if(isbn.length() != 11) {
				con.println("ISBN must be 10 characters");
				checkISBN= false;
			}else {
				checkISBN= true;
			}
		}while (!checkISBN);

		
	//	System.out.print("Enter Book Type name:");
	//	BookType name = input.nextLine();
		
		boolean checkImage=false;
		do {
			con.print("Enter image file path:");
			imagePath = con.readLn();
			
			if(imagePath == "") {
				con.println("Needs an image file path");
				checkImage= false;
			}else {
				checkImage= true;	
			}
		}while (!checkImage);
		

	    boolean checkEdition=false;
	    do {
			con.print("Enter edition: ");
			String input = con.readLn();
			try {
				edition = Integer.parseInt(input);
				if(edition>=1) {
					checkEdition = true;
				}else {
					checkEdition = true;
				}
			} catch (Exception ex) {
				con.println("Not correct input");
			}
		} while (!checkEdition);
		
		boolean checkSummary=false;
		do {
			con.print("Enter summary:");
			summary = con.readLn();
			
			if(summary.length() < 20 || summary.length() > 150) {
				con.println("Summary needs to be between 20 and 150 charactrs");
				checkSummary= false;
			}else {
				checkSummary= true;
			}
		}while (!checkSummary);

		
		boolean checkPrice=false;
	    do {
			con.print("Enter price: ");
			String input = con.readLn();
			try {
				price = Integer.parseInt(input);
				if(edition>=0.00) {
					checkPrice = true;
				}else {
					checkPrice = true;
				}
			} catch (Exception ex) {
				con.println("Not correct input");
			}
		} while (!checkPrice);

		
		BookType type = chooseType(con);
		
		LibraryBook newBook = new LibraryBook(title, author, isbn, type, edition, summary, price);
		//newBook.setImageIcon(image);
		newBook.setBookStatus(BookStatus.AVAILABLE);
	    add(newBook);
	    
	    
	    con.println("BOOK ADDED SUCCESSFULLY");

		
	}
	
	public static BookType chooseType(Console con) {
	    con.setSize(800, 800);
	    con.setVisible(true);
	    con.setTitle("Choose type");
	    con.setBgColour(Color.BLACK);
	    con.setColour(Color.WHITE);
	    con.setFont(new Font("Arial", Font.PLAIN, 14));
	    
	    con.println("");
	    String options[] = { "Fiction", "Non-Fiction", "Reference"};
	    
	    int choice = 0;
	    boolean checked = false;
	    
	    for (int i = 0; i < options.length; i++) {
	        con.println((i + 1) + ". " + options[i]);
	    }
	    
	    do {
	        con.println("Enter type:");
	        String choicestr = con.readLn();

	        try {
	            choice = Integer.parseInt(choicestr);
	            checked = true;
	        } catch (Exception e) {
	            con.println("Invalid option");
	            checked = false; // reset checked to false
	        }
	    } while (!checked);

	    switch (choice) {
	        case 1:
	            return BookType.FICTION;
	        case 2:
	            return BookType.NON_FICTION;
	        case 3:
	            return BookType.REFERENCE;
	        default:
	            return null;
	    }
	}

	
	public static BookStatus chooseStatus(Console con) {

	    con.setSize(800, 800);
	    con.setVisible(true);
	    con.setTitle("Choose status");
	    con.setBgColour(Color.BLACK);
	    con.setColour(Color.WHITE);
	    con.setFont(new Font("Arial", Font.PLAIN, 14));

	    String options[] = { "Available", "On Loan", "Withdrawn" };

	    int choice = 0;
	    boolean checked = false;
	    
	    do {
	        for (int i = 0; i < options.length; i++) {
	            con.println((i + 1) + ". " + options[i]);
	        }

	        con.println("Enter status:");
	        String choicestr = con.readLn();

	        try {
	            choice = Integer.parseInt(choicestr);
	            checked = true;

	        } catch (Exception e) {
	            con.println("Invalid option");
	        }
	    } while (!checked);

	    switch (choice) {
	        case 1:
	            return BookStatus.AVAILABLE;
	        case 2:
	            return BookStatus.ON_LOAN;
	        case 3:
	            return BookStatus.WITHDRAWN;
	        default:
	            return null;
	    }
	}

	
	public static void removeBook(Console con) {
	    con.setSize(800, 800);
	    con.setVisible(true);
	    con.setTitle("Remove Book");
	    con.setBgColour(Color.BLACK);
	    con.setColour(Color.WHITE);
	    con.setFont(new Font("Arial", Font.PLAIN, 14));

	    int remove = 0;

	    con.println("*** REMOVE A BOOK ***");

	    if (books.size() == 0) {
	        con.println("No Books in system");
	    } else {
	        for (int i = 0; i < books.size(); i++) {
	            if (books.get(i).getBookStatus() != BookStatus.ON_LOAN) {
	                con.println((i + 1) + ". " + books.get(i).getTitle());
	            }
	        }
	        boolean validated = false;
	        do {
	        	con.print("Choose book:");
                String input = con.readLn();
	            try {
	                
	            	remove = Integer.parseInt(input);
	                if (remove <= books.size() && remove >= 1) {
	                    validated = true;
	                } else {
	                    con.println("Invalid input. Please enter a valid number.");
	                }
	            } catch (Exception e) {
	                con.println("Invalid input. Please enter a valid number.");
	            }
	        } while (validated == false);

	        removeBook(remove - 1);
	    }
	}

	
	public static void borrowBook(Console con) {
	    con.setSize(800, 800);
	    con.setVisible(true);
	    con.setTitle("Remove Book");
	    con.setBgColour(Color.BLACK);
	    con.setColour(Color.WHITE);
	    con.setFont(new Font("Arial", Font.PLAIN, 14));

	    int borrow = 0;

	    con.println("*** REMOVE A BOOK ***");

	    if (books.size() == 0) {
	        con.println("No Books in system");
	    } else {
	        for (int i = 0; i < books.size(); i++) {
	            if (books.get(i).getBookStatus() != BookStatus.AVAILABLE) {
	                con.println((i + 1) + ". " + books.get(i).getTitle());
	            }
	        }boolean checkPrice=false;
		 
	        boolean validated = false;
	        do {
	        	con.print("Choose book:");
                String input = con.readLn();
	            try {
	                
	                borrow = Integer.parseInt(input);
	                if (borrow <= books.size() && borrow >= 1) {
	                    validated = true;
	                } else {
	                    con.println("Invalid input. Please enter a valid number.");
	                }
	            } catch (Exception e) {
	                con.println("Invalid input. Please enter a valid number.");
	            }
	        } while (validated == false);

	        removeBook(borrow - 1);
	    }
	}
	
	public static void returnBook(Console con) {
	    con.setSize(800, 800);
	    con.setVisible(true);
	    con.setTitle("Remove Book");
	    con.setBgColour(Color.BLACK);
	    con.setColour(Color.WHITE);
	    con.setFont(new Font("Arial", Font.PLAIN, 14));

	    int bookReturn = 0;

	    con.println("*** REMOVE A BOOK ***");

	    if (books.size() == 0) {
	        con.println("No Books in system");
	    } else {
	        for (int i = 0; i < books.size(); i++) {
	            if (books.get(i).getBookStatus() != BookStatus.ON_LOAN) {
	                con.println((i + 1) + ". " + books.get(i).getTitle());
	            }
	        }
	        boolean validated = false;
	        do {
	        	con.print("Choose book:");
                String input = con.readLn();
	            try {
	                
	                bookReturn = Integer.parseInt(input);
	                if (bookReturn <= books.size() && bookReturn >= 1) {
	                    validated = true;
	                } else {
	                    con.println("Invalid input. Please enter a valid number.");
	                }
	            } catch (Exception e) {
	                con.println("Invalid input. Please enter a valid number.");
	            }
	        } while (validated == false);

	        removeBook(bookReturn - 1);
	    }
	}
	
	public static void rankedList(Console con) {
		
		con.setSize(800, 800);
		con.setVisible(true);
		con.setTitle("Most Popular");
		con.setBgColour(Color.BLACK);
		con.setColour(Color.WHITE);
		con.setFont(new Font("Arial", Font.PLAIN, 14));
		
		con.println("*** MOST POPULAR BOOKS***");
		
		LibraryBook[] bookArray = mostPopular();
		
		if(bookArray.length==0) {
			con.println("No books in system");
		}else {
		
			for(int i =0; i< bookArray.length; i++) {
				con.println("\n "+(i+1)+". \nTitle: " + bookArray[i].getTitle() + 
	                    "\nAuthor: " + bookArray[i].getAuthor()+"\nLoan Count: "+bookArray[i].getLoanCount()+"\n");
			}
		}
		
	}
		
}
		
		
		

	



