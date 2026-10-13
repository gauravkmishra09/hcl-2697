package hcl_library.model;

import java.time.LocalDate;

public abstract class LibraryItem implements Borrowable {

    private static int nextId = 1001;
    private static final int MIN_YEAR = 1900;

    private int id;
    private String title;
    private int year;
    private boolean available;

    public LibraryItem(String title, int year) {
        int currentYear = LocalDate.now().getYear();

        if (title == null || title.equals("")) {
            throw new IllegalArgumentException("Title cannot be blank");
        }
        if (year < MIN_YEAR || year > currentYear) {
            throw new IllegalArgumentException("Year is not valid");
        }

        this.id = nextId;
        nextId = nextId + 1;
        this.title = title;
        this.year = year;
        this.available = true;
    }

    public abstract double lateFee(int daysLate);

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void borrow() {
        available = false;
    }

    @Override
    public void giveBack() {
        available = true;
    }

    @Override
    public String toString() {
        return id + ", " + title + ", " + year;
    }
}