package hcl_library;

import hcl_library.model.Book;
import hcl_library.model.LibraryItem;
import hcl_library.repository.InMemoryRepository;

public class Main {
    public static void main(String[] args) {
        InMemoryRepository<LibraryItem, Integer> repo =
                new InMemoryRepository<>(item -> item.getId());

        Book book1 = new Book("Clean Code", 2008, "Robert Martin", "111");
        Book book2 = new Book("Java Basics", 2015, "Ravi", "222");
        repo.save(book1);
        repo.save(book2);

        for (LibraryItem item : repo.findAll()) {
            System.out.println(item);
        }

        System.out.println("Found: " + repo.findById(1001).isPresent());
        System.out.println("Found: " + repo.findById(5000).isPresent());

        System.out.println("Deleted: " + repo.deleteById(1001));
        System.out.println("Deleted again: " + repo.deleteById(1001));
        System.out.println("Total items: " + repo.findAll().size());
    }
}