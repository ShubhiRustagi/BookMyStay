/**
 * Book My Stay Application - Use Case 5
 *
 * Demonstrates booking request handling using Queue (FIFO).
 * No inventory updates happen here.
 *
 * @author Shubhi
 * @version 1.0
 */

import java.util.*;

// ----------- Reservation (Request Object) -----------
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void display() {
        System.out.println("Guest: " + guestName + " | Requested: " + roomType);
    }
}

// ----------- Booking Queue (FIFO Structure) -----------
class BookingQueue {
    private Queue<Reservation> queue;

    public BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request (enqueue)
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added for " + reservation.getGuestName());
    }

    // View all requests (without removing)
    public void displayQueue() {
        System.out.println("\n===== Booking Requests Queue =====");

        if (queue.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        for (Reservation r : queue) {
            r.display();
        }

        System.out.println("==================================");
    }

    // Peek next request (FIFO)
    public Reservation peekNext() {
        return queue.peek();
    }
}

// ----------- Main Class -----------
public class TestCases {

    public static void main(String[] args) {

        // Initialize booking queue
        BookingQueue bookingQueue = new BookingQueue();

        // Simulate incoming booking requests
        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Double Room"));

        // Display queue (order preserved)
        bookingQueue.displayQueue();

        // Show next request (without removing)
        System.out.println("\nNext request to process:");
        Reservation next = bookingQueue.peekNext();

        if (next != null) {
            next.display();
        }
    }
}