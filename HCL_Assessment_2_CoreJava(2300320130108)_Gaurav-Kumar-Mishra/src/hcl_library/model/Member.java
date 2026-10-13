package hcl_library.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

    private static int nextId = 1;

    private int id;
    private String name;
    private String email;
    private List<LibraryItem> borrowedItems;

    public Member(String name, String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email must contain @");
        }
        this.id = nextId;
        nextId = nextId + 1;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>();
    }

    public Member(String name) {
        this(name, "noemail@library.com");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<LibraryItem> getBorrowedItems() {
        return Collections.unmodifiableList(borrowedItems);
    }

    public int getBorrowedCount() {
        return borrowedItems.size();
    }

    public void addBorrowedItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void removeBorrowedItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    @Override
    public String toString() {
        return "Member[" + id + ", " + name + ", " + email + "]";
    }
}