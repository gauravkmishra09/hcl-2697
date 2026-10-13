package hcl_library;

import hcl_library.exception.LibraryException;
import hcl_library.service.LibraryService;

public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();

        service.addBook("Clean Code", 2008, "Robert Martin", "111");
        service.registerMember("Ravi", "ravi@gmail.com");
        service.registerMember("Aman", "aman@gmail.com");

        service.borrowItem(1, 1001);
        service.addToWaitlist(2, 1001);

        double fee = service.returnItem(1001, 3);
        System.out.println("Late fee: " + fee);
        service.notifyWaitlist(1001);

        try {
            service.returnItem(1001, 0);
        } catch (LibraryException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("Issued: " + service.borrowItem(2, 1001));
    }
}