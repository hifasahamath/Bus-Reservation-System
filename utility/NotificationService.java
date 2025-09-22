package utility;
public class NotificationService {

    public static void sendReservationMessage(String customerName, String busNumber, int seatNumber) {
        System.out.println("\nNotification: Hi " + customerName + ", your seat " + seatNumber + " on Bus " + busNumber + " has been successfully reserved.");
    }

    public static void sendCancellationMessage(String customerName, String busNumber, int seatNumber) {
        System.out.println("\nNotification: Hi " + customerName + ", your reservation for seat " + seatNumber + " on Bus " + busNumber + " has been cancelled.");
    }

    public static void sendWaitlistMessage(String customerName, String busNumber, int seatNumber) {
        System.out.println("\nNotification: Hi " + customerName + ", seat " + seatNumber + " on Bus " + busNumber + " is now available. You have been moved from the waitlist.");
    }

    public static void sendSeatChangeRequestMessage(String customerName) {
        System.out.println("\nNotification: Hi " + customerName + ", your seat change request is received. Please wait in queue.");
    }

}
