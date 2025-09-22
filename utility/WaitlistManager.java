package utility;
import model.Customer;

public class WaitlistManager {

    // custom linked list
    private static CustomerLinkedList waitlist = new CustomerLinkedList();

    // Add customer to waitlist (FIFO)
    public static void addToWaitlist(Customer customer) {
        waitlist.add(customer);
        System.out.println(customer.getName() + " added to waitlist.");
        NotificationService.sendSeatChangeRequestMessage(customer.getName());
    }

    // View waitlist customers
    public static void viewWaitlist() {
        if (waitlist.isEmpty()) {
            System.out.println("Waitlist is empty.");
            return;
        }
        System.out.println("Current Waitlist:");
        for (Customer c : waitlist.iterable()) {
            System.out.println("- " + c.getCustomerId() + ": " + c.getName());
        }
    }

    // Remove next customer from waitlist when seat is available
    public static Customer getNextCustomer() {
        if (!waitlist.isEmpty()) {
            Customer next = waitlist.poll();
            System.out.println("Next from waitlist: " + next.getName());
            return next;
        } else {
            System.out.println("No customer in waitlist.");
            return null;
        }
    }

    // Check if waitlist has anyone
    public static boolean hasWaitlist() {
        return !waitlist.isEmpty();
    }
}
