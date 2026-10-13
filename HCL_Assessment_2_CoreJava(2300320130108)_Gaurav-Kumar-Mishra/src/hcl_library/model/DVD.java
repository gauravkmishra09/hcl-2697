package hcl_library.model;

public class DVD extends LibraryItem {

    private static final double FEE_PER_DAY = 5.0;

    private int durationMinutes;

    public DVD(String title, int year, int durationMinutes) {
        super(title, year);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public double lateFee(int daysLate) {
        return daysLate * FEE_PER_DAY;
    }

    @Override
    public String toString() {
        return "DVD[" + super.toString() + ", " + durationMinutes + " min]";
    }
}