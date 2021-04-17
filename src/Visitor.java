import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Visitor {

    private String uid;
    private String name;
    private Date lastVisit;
    private List<Book> books;

    public Visitor() {
    }

    public Visitor(String uid, String name, List<Book> books) {
        this.uid = uid;
        this.name = name;
        this.books = books;
        this.lastVisit = new Date();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit() {
        this.lastVisit = new Date();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String printBooks() {
        String books = "";
        for (Book book: this.books) {
            books += book.getTitle() + ",";
        }

        return books;
    }

    public void detail() {
        System.out.println("Nama\t\t\t: " + name);
        System.out.println("Last Visit\t: " + new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(lastVisit));
        System.out.println("Buku yang dipinjam");
    }

}
