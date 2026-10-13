package hcl_library;

import hcl_library.exception.LibraryException;
import hcl_library.model.LibraryItem;
import hcl_library.service.LibraryService;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();

        service.addBook("Clean Code", 2008, "Robert Martin", "111");
        service.addMagazine("Wired", 2020, 5);
        service.addDVD("Inception", 2010, 148);
        service.addBook("Algorithms", 1999, "Ravi", "222");

        System.out.println("--- Sorted by title ---");
        for (LibraryItem item : service.getItemsSortedByTitle()) {
            System.out.println(item);
        }

        System.out.println("--- Sorted by year ---");
        for (LibraryItem item : service.getItemsSortedByYear()) {
            System.out.println(item);
        }

        Map<String, Integer> counts = service.countByType();
        System.out.println("Books: " + counts.getOrDefault("Book", 0));
        System.out.println("Magazines: " + counts.getOrDefault("Magazine", 0));
        System.out.println("DVDs: " + counts.getOrDefault("DVD", 0));

        System.out.println("Removed old items: " + service.removeOldItems(2005));
        System.out.println("Items left: " + service.getItemsSortedByTitle().size());

        service.exportReport("report.txt");
        System.out.println("Report saved");

        try {
            service.exportReport("nofolder/report.txt");
        } catch (LibraryException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}