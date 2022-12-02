import java.util.Scanner;

public class BookDetails{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int noPage;
		double price;
		String title;
		String author;
		int noBooks;
		System.out.println("Enter the number of books");
		noBooks = scanner.nextInt();

		Book book[] = new Book[noBooks]; 
		
		for(int i = 0; i<noBooks; i++){
			System.out.println("Enter the book title");
			title = scanner.next();

			System.out.println("Enter the book author");
			author = scanner.next();

			System.out.println("Enter the book price");
			price = scanner.nextDouble();

			System.out.println("Enter the number of pages in the book");
			noPage = scanner.nextInt();
			
			book[i] = new Book();
			book[i].setTitle(title);
			book[i].setAuthor(author);
			book[i].setPrice(price);
			book[i].setPage(noPage);
		}

		for(int i = 0; i<noBooks; i++){
			System.out.println(book[i]);
		}
	}
}

class Book{
	String title;
	String author;
	double price;
	int noPage;
	
	Book(){
		title = "Default";
		author = "Default";
		price = 0.0;
		noPage = 0;
	}

	//setters
	public void setTitle(String title){
		this.title = title;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public void setPage(int noPage){
		this.noPage = noPage;
	}
	
	//getters
	public String toString(){
		return title+"\t"+author+"\t"+price+"\t"+noPage;
	}
	
}