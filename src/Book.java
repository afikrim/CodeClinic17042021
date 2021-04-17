public class Book {

    private String title;
    private int stock;
    private String author;
    private String genre;

    public Book() {
    }

    public Book(String title, int stock, String author, String genre) {
        this.title = title;
        this.stock = stock;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void display() {
        System.out.println("Judul\t\t: " + title);
        System.out.println("Penulis\t: " + author);
        System.out.println("Genre\t\t: " + genre);
    }

}
