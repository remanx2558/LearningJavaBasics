package ZoomCar;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BillingService {
    private Map<String, Invoice> invoiceMap;

    public BillingService() {
        invoiceMap = new HashMap<>();
    }

    /**
     * Generate invoice for a reservation.
     * The amount is pulled from the reservation's estimated cost for now.
     */
//    public Invoice generateInvoice(Reservation reservation) {
//        String invoiceId = UUID.randomUUID().toString();
//        // We could do more dynamic calculation here
//        Invoice invoice = new Invoice(invoiceId, reservation, reservation.getEstimatedCost());
//        invoiceMap.put(invoiceId, invoice);
//        return invoice;
//    }

    public Invoice getInvoice(String invoiceId) {
        return invoiceMap.get(invoiceId);
    }
}

