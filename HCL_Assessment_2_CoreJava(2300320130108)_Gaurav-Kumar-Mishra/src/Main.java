package hcl_library;

import hcl_library.model.Book;
import hcl_library.model.Member;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Clean Code", 2008, "Robert Martin", "111");
        Member member = new Member("Ravi", "ravi@gmail.com");

        member.addBorrowedItem(book);
        System.out.println(member);
        System.out.println("Borrowed count: " + member.getBorrowedCount());

        Member another = new Member("Aman");
        System.out.println(another);

        try {
            new Member("Test", "wrongemail");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}