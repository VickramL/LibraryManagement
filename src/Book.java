public class Book {
    private static int number = 0;
    private int id;
    private String title;
    private String author;
    private String publishingYear;
    private String status;

    public Book(String title, String author, String publishingYear,String status){
        this.id = ++number;
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public static int getNumber() {
        return number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
