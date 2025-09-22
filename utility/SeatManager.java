package utility;
import java.util.ArrayList;
import java.util.HashMap;

public class SeatManager {

    // Map<BusNumber, ArrayList<Integer>> for each bus's reserved seats
    private static HashMap<String, ArrayList<Integer>> reservedSeats = new HashMap<>();

    // Reserve a seat
    public static boolean reserveSeat(String busNumber, int seatNumber) {
        reservedSeats.putIfAbsent(busNumber, new ArrayList<>());

        ArrayList<Integer> seats = reservedSeats.get(busNumber);
        if (seats.contains(seatNumber)) {
            System.out.println("Seat " + seatNumber + " on Bus " + busNumber + " is already reserved.");
            return false;
        } else {
            seats.add(seatNumber);
            System.out.println("Seat " + seatNumber + " reserved on Bus " + busNumber);
            return true;
        }
    }

    // Cancel a reserved seat
    public static boolean releaseSeat(String busNumber, int seatNumber) {
        ArrayList<Integer> seats = reservedSeats.get(busNumber);
        if (seats != null && seats.contains(seatNumber)) {
            seats.remove(Integer.valueOf(seatNumber));
            System.out.println("Seat " + seatNumber + " released from Bus " + busNumber);
            return true;
        }
        System.out.println("Seat " + seatNumber + " is not reserved on Bus " + busNumber);
        return false;
    }

    // Check if a seat is available
    public static boolean isSeatAvailable(String busNumber, int seatNumber) {
        ArrayList<Integer> seats = reservedSeats.get(busNumber);
        return seats == null || !seats.contains(seatNumber);
    }

    // View all reserved seats
    public static void viewReservedSeats(String busNumber) {
        ArrayList<Integer> seats = reservedSeats.get(busNumber);
        if (seats == null || seats.isEmpty()) {
            System.out.println("No seats reserved on Bus " + busNumber);
        } else {
            System.out.println("Reserved seats on Bus " + busNumber + ": " + seats);
        }
    }
}
