import java.util.HashMap;
import java.util.Map;

public class Library implements LibraryInterface{
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[34m";
    Map<Integer,Book> books = new HashMap<>();
    Validation validation = new Validation();


    @Override
    public void addBook() {
        System.out.println("Book Id : "+(Book.getNumber()+1));
        String title = validation.authorTitle("title");
        String author = validation.authorTitle("author");
        String publishingYear = validation.validYear();
        Book book = new Book(title,author,publishingYear,"Available");
        books.put(book.getId(), book);
        System.out.println(GREEN+"BOOK ADDED SUCCESSFULLY\n"+RESET);
        showBookDetails(book);
    }

    @Override
    public void showAllBooks() {
        if(books.size()==0){
            System.out.println(RED+"NO BOOKS AVAILABLE"+RESET);
            return;
        }
        System.out.printf(CYAN+"%-8s%-10s%-10s%-10s%-15s\n","BOOK ID","TITLE","AUTHOR","PUBLISHED","STATUS"+RESET);
        for(Book book:books.values())
            System.out.printf("%-8s%-10s%-10s%-10s%-15s\n",book.getId(),book.getTitle(),book.getAuthor(),
                    book.getPublishingYear(),book.getStatus());
    }

    public void showAvailableBooks(){
        if(books.size()==0){
            System.out.println(RED+"NO BOOKS AVAILABLE"+RESET);
            return;
        }
        System.out.printf(CYAN+"%-8s%-10s%-10s%-10s%-15s\n","BOOK ID","TITLE","AUTHOR","PUBLISHED","STATUS"+RESET);
        for(Book book:books.values()) {
            if(book.getStatus().equals("Available"))
                System.out.printf("%-8s%-10s%-10s%-10s%-15s\n", book.getId(), book.getTitle(), book.getAuthor(),
                        book.getPublishingYear(), book.getStatus());
        }
    }

    @Override
    public void barrow() {
        if(books.size()==0){
            System.out.println(RED+"NO BOOKS AVAILABLE"+RESET);
            return;
        }
        int id = validation.validId(books);
        if(!books.containsKey(id)) return;
        if(books.get(id).getStatus().equals("Not Available")){
            System.out.println(RED+"This Book is Currently Not Available"+RESET);
            return;
        }
        books.get(id).setStatus("Not Available");
        System.out.println(GREEN+"Barrowed Successfully\n"+RESET);
        showBookDetails(books.get(id));
    }

    @Override
    public void returnBook() {
        if(books.size()==0){
            System.out.println(RED+"NO BOOKS TO RETURN"+RESET);
            return;
        }
        int id = validation.validId(books);
        if(!books.containsKey(id)) return;
        if(books.get(id).getStatus().equals("Available")){
            System.out.println(RED+"We can not return this book"+RESET);
            return;
        }
        books.get(id).setStatus("Available");
        System.out.println(GREEN+"Return Successfully\n"+RESET);
        showBookDetails(books.get(id));
    }

    public void showBookDetails(Book book){
        System.out.println(CYAN+"    BOOK DETAILS"+RESET);
        System.out.printf("%-9s : %d\n%-9s : %s\n%-9s : %s\n%-9s : %s\n","BOOK ID",book.getId(),"TITLE",
                book.getTitle(),"AUTHOR",book.getAuthor(),"PUBLISHED",book.getPublishingYear());
    }
}
