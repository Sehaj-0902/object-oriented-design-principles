import java.util.ArrayList;

class Book {
    // Class attributes
    private String title;
    private String author;

    // Parameterized Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method to get title
    public String getTitle() {
        return title;
    }

    // Method to get author
    public String getAuthor() {
        return author;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class Library {
    // Class attributes
    private ArrayList<Book> books;
    private String libraryName;

    // Parameterized Constructor
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    // Method to add book
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display books
    public void displayBooks() {
        System.out.println("Books in " + libraryName + ":");
        for (Book book : books) {
            book.displayBookDetails();
        }
    }
}

public class LibraryBookSystem {
    public static void main(String[] args) {
        // Create Book objects
        Book book1 = new Book("Gulliver's Travels", "Jonathan Swift");
        Book book2 = new Book("Pride and Prejudice", "Jane Austen");
        Book book3 = new Book("Alice In Wonderland", "Lewis Carroll");
        Book book4 = new Book("Charlie and the Chocolate Factory", "Roald Dahl");

        // Create Library objects
        Library centralLibrary = new Library("Central Library");
        Library universityLibrary = new Library("University Library");

        // Add books to libraries
        centralLibrary.addBook(book1);
        centralLibrary.addBook(book2);
        universityLibrary.addBook(book3);
        universityLibrary.addBook(book4);

        // Display books in libraries
        centralLibrary.displayBooks();
        universityLibrary.displayBooks();
    }
}
