import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagemenSystem {
    
    // Store all books in an ArrayList
    static ArrayList<String> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   LIBRARY MANAGEMENT SYSTEM");
        System.out.println("====================================");
        
        // Add some sample books for testing
        books.add("The Great Gatsby");
        books.add("To Kill a Mockingbird");
        books.add("1984 by George Orwell");
        
        // Show main menu
        showMainMenu();
    }
    // =================== MAIN MENU ===================
    public static void showMainMenu() {
        while (true) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Add a New Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Search for Books");
            System.out.println("4. View All Books");
            System.out.println("5. Exit Program");
            System.out.println("===============================");
            System.out.print("Enter your choice (1-5): ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    removeBook();
                    break;
                case "3":
                    searchBook();
                    break;
                case "4":
                    viewAllBooks();
                    break;
                case "5":
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1-5.");
            }
        }
    }
    
    // =================== ADD BOOK ===================
    public static void addBook() {
        System.out.println("\n----- ADD NEW BOOK -----");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        // Input validation: Check if empty
        if (title.trim().isEmpty()) {
            System.out.println("Error: Book title cannot be empty!");
            return;
        }
        
        // Check if book already exists
        for (String book : books) {
            if (book.equalsIgnoreCase(title.trim())) {
                System.out.println("This book already exists in the library!");
                return;
            }
        }
        
        // Add book to library
        books.add(title.trim());
        System.out.println("Book '" + title + "' added successfully!");
    }
    
    // =================== REMOVE BOOK ===================
    public static void removeBook() {
        System.out.println("\n----- REMOVE BOOK -----");
        
        // Check if library is empty
        if (books.isEmpty()) {
            System.out.println("The library is empty! No books to remove.");
            return;
        }
        
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();
        
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equalsIgnoreCase(title.trim())) {
                String removedBook = books.remove(i);
                System.out.println("Book '" + removedBook + "' removed successfully!");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Book not found in the library!");
        }
    }
    
    // =================== SEARCH BOOK ===================
    public static void searchBook() {
        System.out.println("\n----- SEARCH BOOKS -----");
        System.out.print("Enter book title to search: ");
        String searchTerm = scanner.nextLine();
        
        System.out.println("\nSearch Results:");
        System.out.println("------------------");
        
        boolean found = false;
        for (String book : books) {
            if (book.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("- " + book);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No books found matching '" + searchTerm + "'");
        }
    }
    
    // =================== VIEW ALL BOOKS ===================
    public static void viewAllBooks() {
        System.out.println("\n----- ALL BOOKS IN LIBRARY -----");
        
        if (books.isEmpty()) {
            System.out.println("The library is empty!");
            return;
        }
        
        System.out.println("Total books: " + books.size());
        System.out.println("---------------------------");
        
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }
    // =================== EXIT PROGRAM ===================
    public static void exitProgram() {
        System.out.println("\n====================================");
        System.out.println("    Thank you for using");
        System.out.println("  Library Management System");
        System.out.println("====================================");
        System.out.println("\nExiting program...");
        scanner.close();
        System.exit(0);
    }
}