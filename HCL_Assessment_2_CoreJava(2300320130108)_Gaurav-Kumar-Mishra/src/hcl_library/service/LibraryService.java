package hcl_library.service;

import hcl_library.exception.BorrowLimitExceededException;
import hcl_library.exception.ItemNotAvailableException;
import hcl_library.exception.ItemNotFoundException;
import hcl_library.exception.LibraryException;
import hcl_library.model.Book;
import hcl_library.model.DVD;
import hcl_library.model.LibraryItem;
import hcl_library.model.Magazine;
import hcl_library.model.Member;
import hcl_library.repository.InMemoryRepository;
import hcl_library.repository.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class LibraryService {

    private static final int BORROW_LIMIT = 3;

    private Repository<LibraryItem, Integer> items = new InMemoryRepository<>(item -> item.getId());
    private Repository<Member, Integer> members = new InMemoryRepository<>(member -> member.getId());
    private Set<String> isbnSet = new HashSet<>();

    public Book addBook(String title, int year, String author, String isbn) {
        if (isbnSet.contains(isbn)) {
            throw new LibraryException("A book with this ISBN already exists");
        }
        Book book = new Book(title, year, author, isbn);
        isbnSet.add(isbn);
        items.save(book);
        return book;
    }

    public Magazine addMagazine(String title, int year, int issueNumber) {
        Magazine magazine = new Magazine(title, year, issueNumber);
        items.save(magazine);
        return magazine;
    }

    public DVD addDVD(String title, int year, int durationMinutes) {
        DVD dvd = new DVD(title, year, durationMinutes);
        items.save(dvd);
        return dvd;
    }

    public Member registerMember(String name, String email) {
        Member member = new Member(name, email);
        members.save(member);
        return member;
    }

    public LibraryItem findItem(int itemId) {
        Optional<LibraryItem> result = items.findById(itemId);
        if (!result.isPresent()) {
            throw new ItemNotFoundException("Item not found: " + itemId);
        }
        return result.get();
    }

    public Member findMember(int memberId) {
        Optional<Member> result = members.findById(memberId);
        if (!result.isPresent()) {
            throw new LibraryException("Member not found: " + memberId);
        }
        return result.get();
    }

    public LibraryItem borrowItem(int memberId, int itemId) {
        Member member = findMember(memberId);
        LibraryItem item = findItem(itemId);

        if (!item.isAvailable()) {
            throw new ItemNotAvailableException("Item " + itemId + " is not available");
        }
        if (member.getBorrowedCount() >= BORROW_LIMIT) {
            throw new BorrowLimitExceededException(member.getName() + " cannot borrow more than " + BORROW_LIMIT + " items");
        }

        item.borrow();
        member.addBorrowedItem(item);
        return item;
    }
}