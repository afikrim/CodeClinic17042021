import java.util.*;

public class Main {

    private static List<Visitor> visitors;
    private static List<Book> books;
    private static List<Admin> admins;

    private static boolean loggedIn = false;
    private static String currentUser;

    private static String role;

    private static final Scanner in = new Scanner(System.in);

    private static void initVisitors() {
        String uidA = "5632cfe1-14c6-4b24-9aaf-b9df8bd86afh";
        String uidB = "5632cfe1-14c6-4b24-9aaf-b9df8bd86afi";
        Visitor a = new Visitor(uidA, "Aziz", Collections.emptyList());
        Visitor b = new Visitor(uidB, "Fikri", Collections.emptyList());

        visitors = new ArrayList<>(Arrays.asList(a,b));
    }

    private static void initBooks() {
        Book a = new Book("Book A", 10, "Aziz", "Tech");
        Book b = new Book("Book B", 20, "Fikri", "Fiction");
        Book c = new Book("Book C", 5, "Mahmudi", "Tech");

        books = new ArrayList<>(Arrays.asList(a,b,c));
    }

    private static void initAdmins() {
        String uidA = "5632cfe1-14c6-4b24-9aaf-b9df8bd86aff";
        String uidB = "5632cfe1-14c6-4b24-9aaf-b9df8bd86afg";
        Admin a = new Admin(uidA, "Aziz", "President");
        Admin b = new Admin(uidB, "Fikri", "Vice President");

        admins = new ArrayList<>(Arrays.asList(a,b));
    }

    private static void menuAdmin() {
        System.out.println("1. Tambah buku");
        System.out.println("2. Lihat list pengunjung");
        System.out.println("3. Lihat list buku");
        System.out.println("0. Exit");
        System.out.print("Masukkan pilihan anda: ");
        int pil = in.nextInt();

        System.out.println("================================");
        in.nextLine();
        switch (pil) {
            case 0:
                loggedIn = false;
                System.out.println("See ya later!");
                break;
            case 1:
                // TODO: Tambah BUKU
                tambahBuku();
                break;
            case 2:
                // TODO: Lihat LIST Pengunjung
                cetakListPengunjung();
                break;
            case 3:
                cetakListBuku();
                break;
            default:
                // TODO: handle default
        }
        System.out.println("================================");
    }

    private static void menuUser() {
        System.out.println("1. Catat peminjaman buku");
        System.out.println("2. Cetak buku yang dipinjam");
        System.out.println("0. Exit");
        System.out.print("Masukkan pilihan anda: ");
        int pil = in.nextInt();

        System.out.println("================================");
        in.nextLine();
        switch (pil) {
            case 0:
                loggedIn = false;
                System.out.println("See ya later!");
                break;
            case 1:
                // TODO: Catat peminjaman
                catatPeminjamanBuku();
                break;
            case 2:
                cetakBukuYangDipinjam();
                break;
            default:
                // TODO: handle default
        }
        System.out.println("================================");
    }

    private static void cetakListBuku() {
        // TODO: Cetak list buku
        for (int i = 0; i < books.size(); i += 1) {
            Book book = books.get(i);

            System.out.println((i + 1) + ". " + book.getTitle() + " [" + book.getStock() + "]");
        }
    }

    private static void cetakDetailBuku(int bookIndex) {
        // TODO: Cetak detail buku
        books.get(bookIndex).display();
    }

    private static void tambahBuku() {
        // TODO: Masukkan judul, stok, penulis dan genre
        cetakListBuku();
        System.out.println("================================");
        System.out.print("Judul\t\t: ");
        String title = in.nextLine();
        System.out.print("Penulis\t: ");
        String author = in.nextLine();
        System.out.print("Genre\t\t: ");
        String genre = in.nextLine();
        System.out.print("Stok\t\t: ");
        int stock = in.nextInt();

        Book x = new Book(title, stock, author, genre);
        books.add(x);

        System.out.println("\nBerhasil menambahkan buku!\n");
        x.display();
    }

    private static void cetakListPengunjung() {
        // TODO: Print semua pengunjung yang datang
        for (int i = 0; i < visitors.size(); i += 1) {
            Visitor visitor = visitors.get(i);

            System.out.println((i + 1) + ". " + visitor.getName() + " [" + visitor.printBooks() + "]");
        }
    }

    private static void cetakDetailPengunjung() {
        // TODO: Cetak detail pengunjung
    }

    private static void catatPeminjamanBuku() {
        // TODO: Masukkan data peminjam dan buku yang dipinjam dan kurangi stok buku yang ada
        cetakListBuku();
        System.out.println("================================");
        System.out.print("Ingin melihat detail buku? [Y/n]");
        String pil = in.next();

        // array start with 0
        // book number start with 1
        if (pil.equalsIgnoreCase("Y")) {
            System.out.print("Masukkan nomor buku yang ingin dilihat");
            int indeksBuku = in.nextInt();
            cetakDetailBuku(indeksBuku - 1);
        }

        // 1,2,3,4
        System.out.print("Masukkan nomor buku yang ingin dipinjam [pisahkan dengan koma(,)]: ");
        String nomorBuku = in.next();

        // [1,2,3,4]
        String[] nomor2Buku = nomorBuku.split(",");

        Visitor currVisitor = null;
        for (Visitor visitor: visitors) {
            if (visitor.getUid().equals(currentUser)) {
                currVisitor = visitor;
            }
        }

        List<Book> tempBooks = new ArrayList<>(currVisitor.getBooks());
        for (String nomor3Buku: nomor2Buku) {
            int nomor4Buku = Integer.parseInt(nomor3Buku);

            Book tempBook = books.get(nomor4Buku - 1);
            tempBook.setStock(tempBook.getStock() - 1);
            tempBooks.add(tempBook);
        }

        currVisitor.setBooks(tempBooks);
    }

    private static void cetakBukuYangDipinjam() {
        Visitor currVisitor = null;
        for (Visitor visitor: visitors) {
            if (visitor.getUid().equals(currentUser)) {
                currVisitor = visitor;
            }
        }

        for (int i = 0; i < currVisitor.getBooks().size(); i += 1) {
            Book book = currVisitor.getBooks().get(i);

            System.out.println((i + 1) + ". " + book.getTitle());
        }
    }

    private static boolean login() {
        System.out.print("Masukkan uid: ");
        String uid = in.next();

        // foreach admin => cek id yang dimasukkan ada di admin atau tidak
        for (Admin admin: admins) {
            if (admin.getUid().equals(uid)) {
                role = "ADMIN";
                currentUser = uid;

                return true;
            }
        }

        // foreach visitor
        for (Visitor visitor: visitors) {
            if (visitor.getUid().equals(uid)) {
                role = "VISITOR";
                currentUser = uid;

                visitor.setLastVisit();
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        initVisitors();
        initBooks();
        initAdmins();

        boolean running = true;
        while (running) {
            if (loggedIn) {
                if (role.equals("ADMIN")) {
                    menuAdmin();
                } else {
                    menuUser();
                }
            } else {
                loggedIn = login();

                if (!loggedIn) {
                    System.out.println("Id yang dimasukkan tidak terdaftar.");
                }
            }
        }
    }

}
