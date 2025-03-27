package ZoomCar;

/**
 * An invoice for a particular reservation.
 * The invoice can be paid at creation time or at drop-off time.
 */
public class Invoice {
    private String invoiceId;
    private Reservation reservation;
    private double amount;
    private boolean isPaid;

    public Invoice(String invoiceId, Reservation reservation, double amount) {
        this.invoiceId = invoiceId;
        this.reservation = reservation;
        this.amount = amount;
        this.isPaid = false;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void markPaid() {
        this.isPaid = true;
    }
}