package hcl_library.model;

public class Magazine extends LibraryItem {

    private static final double FEE_PER_DAY = 1.0;

    private int issueNumber;

    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public double lateFee(int daysLate) {
        return daysLate * FEE_PER_DAY;
    }

    @Override
    public String toString() {
        return "Magazine[" + super.toString() + ", issue " + issueNumber + "]";
    }
}