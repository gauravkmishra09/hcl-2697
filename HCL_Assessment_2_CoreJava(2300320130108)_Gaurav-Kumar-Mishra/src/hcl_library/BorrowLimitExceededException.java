package hcl_library;


public class BorrowLimitExceededException extends LibraryException {

    public BorrowLimitExceededException(String message) {
        super(message);
    }
}
