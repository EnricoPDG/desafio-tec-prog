package enricopdg.objects;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private String year;
    private String location;

    public Book() {
    }

    // Initialize all field for book
    public Book(
        String title,
        String author,
        String publisher,
        String year,
        String location
    ) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.location = location;
    }
    public void setTitle(String t) {
        this.title = t;
    }

    public void setAuthor(String a) {
        this.author = a;
    }
    public void setPublisher(String e) {
        this.publisher = e;
    }
    public void setYear(String ae) {
        this.year= ae;
    }
    public void setLocation(String l) {
        this.location = l;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }

    public String getYear() {
        return year;
    }
    public String getLocation() {
        return location;
    }

    public void printBook() {
        System.out.printf("%s", this.getAuthor());
    }


}
