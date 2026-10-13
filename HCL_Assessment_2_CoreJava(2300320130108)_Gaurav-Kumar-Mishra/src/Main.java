package hcl_library;

import hcl_library.exception.LibraryException;
import hcl_library.service.LibraryService;

public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();

        service.addBook("Clean Code", 2008, "Robert Martin", "111");
        service.addMagazine("Wired", 2020, 5);
        service.addDVD("Inception", 2010, 148);
        service.addBook("Java Basics", 2015, "Ravi", "222");

        service.registerMember("Ravi", "ravi@gmail.com");
        service.registerMember("Aman", "aman@gmail.com");

        try {
            System.out.println("Issued: " + service.borrowItem(1, 1001));
        } catch (LibraryException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            service.borrowItem(2, 1001);
        } catch (LibraryException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            service.borrowItem(1, 9999);
        } catch (LibraryException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            service.borrowItem(1, 1002);
            service.borrowItem(1, 1003);
            service.borrowItem(1, 1004);
        } catch (LibraryException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            service.addBook("Another Book", 2019, "Someone", "111");
        } catch (LibraryException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}