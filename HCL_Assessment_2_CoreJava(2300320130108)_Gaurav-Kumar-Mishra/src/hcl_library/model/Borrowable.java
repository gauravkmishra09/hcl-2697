package hcl_library.model;

public interface Borrowable {

    boolean isAvailable();

    void borrow();

    void giveBack();
}