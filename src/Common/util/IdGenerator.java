package Common.util;

public class IdGenerator {
    private static long lastTimestamp = 0;
    // Counter for when multiple calls happen within the same millisecond
    private static int counter = 0;

    // Synchronized to avoid race conditions in a multithreaded environment
    public static synchronized String generateId() {
        long currentMillis = System.currentTimeMillis();
        // If we're still in the same millisecond, increment the counter
        if (currentMillis == lastTimestamp) {
            counter++;
        } else {
            // If we’re in a new millisecond, reset the counter and update the timestamp
            counter = 0;
            lastTimestamp = currentMillis;
        }

        // Combine current time (millis) + a formatted counter (up to 999)
        // Example result: "1678284143123001"
        return currentMillis + String.format("%03d", counter);
    }
}
