package hcl_library.model;

public class Book extends LibraryItem {

    private static final double FEE_PER_DAY = 2.0;

    private String author;
    private String isbn;

    public Book(String title, int year, String author, String isbn) {
        super(title, year);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public double lateFee(int daysLate) {
        return daysLate * FEE_PER_DAY;
    }

    @Override
    public String toString() {
        return "Book[" + super.toString() + ", " + author + "]";
    }
}