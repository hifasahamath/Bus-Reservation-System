package service;

import utility.DB;
import model.Reservation;
import model.Customer;
import model.Bus;
import utility.WaitlistManager;

import java.util.Scanner;
import java.util.Stack;

import java.util.InputMismatchException;

public class ReservationService {
    static Scanner sc = new Scanner(System.in);

    //
    public static void addReservation() {
    try {
        System.out.print("\nEnter Reservation ID: ");
        String resId = sc.nextLine();
        System.out.print("Enter Customer ID: ");
        String customerId = sc.nextLine();
        System.out.print("Enter Bus ID: ");
        String busId = sc.nextLine();
        System.out.print("Enter Seat Number: ");
        int seatNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Reservation Date (yyyy-mm-dd): ");
        String date = sc.nextLine();

        // Get bus
        Bus selectedBus = null;
        for (Bus b : DB.busList) {
            if (b.getBusId().equals(busId)) {
                selectedBus = b;
                break;
            }
        }

        if (selectedBus == null) {
            System.out.println("Bus not found.");
            return;
        }

        // Count reservations for this bus
        int reservedCount = 0;
        for (Reservation r : DB.reservationList) {
            if (r.getBusId().equals(busId)) {
                reservedCount++;
                if (r.getSeatNumber() == seatNo) {
                    System.out.println("Seat number already reserved.");
                    return;
                }
            }
        }

        if (reservedCount >= selectedBus.getTotalSeats()) {
            System.out.println("\nBus is full. Adding to waitlist.");
            // Find customer and add to waitlist
            for (Customer c : DB.customerList) {
                if (c.getCustomerId().equals(customerId)) {
                    WaitlistManager.addToWaitlist(c);
                    return;
                }
            }
            System.out.println("\nCustomer not found. Cannot waitlist.");
            return;
        }

        // Reserve seat
        Reservation r = new Reservation(resId, customerId, busId, seatNo, date);
        DB.reservationList.add(r);
        DB.reservationHistory.push(r);
        System.out.println("Reservation added successfully!");

    } catch (InputMismatchException e) {
        System.out.println("\nInvalid input type. Seat number must be a number.");
        sc.nextLine();
    } catch (Exception e) {
        System.out.println("Something went wrong while adding the reservation.");
    } finally {
        System.out.println("Returning to main menu...");
    }
}

    public static void viewReservations() {
        if (DB.reservationList.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        for (Reservation r : DB.reservationList) {
            System.out.println(r);
        }
    }

    public static void deleteReservation() {
        System.out.print("Enter Reservation ID to delete: ");
        String id = sc.nextLine();
        for (Reservation r : DB.reservationList) {
            if (r.getReservationId().equals(id)) {
                DB.reservationList.remove(r);

                for (Bus b : DB.busList) {
                    if (b.getBusId().equals(r.getBusId())) {
                        b.setTotalSeats(b.getTotalSeats() + 1);
                        break;
                    }
                }

                System.out.println("Reservation deleted.");

                // Assign seat to waitlisted customer
                if (WaitlistManager.hasWaitlist()) {
                    Customer next = WaitlistManager.getNextCustomer();
                    if (next != null) {
                        String newResId = id + "W";
                        Reservation newR = new Reservation(newResId, next.getCustomerId(), r.getBusId(), r.getSeatNumber(), r.getReservationDate());
                        DB.reservationList.add(newR);
                        DB.reservationHistory.push(newR);
                        System.out.println("Seat assigned to waitlisted customer: " + next.getName());
                    }
                }
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    public static void searchReservation() {
        System.out.print("Enter Reservation ID to search: ");
        String id = sc.nextLine();
        for (Reservation r : DB.reservationList) {
            if (r.getReservationId().equals(id)) {
                System.out.println(r);
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    //
    public static void viewReservationHistory() {
        if (DB.reservationHistory.isEmpty()) {
            System.out.println("No reservation history found.");
            return;
        }

        System.out.println("\n--- Reservation History (LIFO) ---");
        Stack<Reservation> temp = new Stack<>();

        while (!DB.reservationHistory.isEmpty()) {
            Reservation r = DB.reservationHistory.pop();
            System.out.println(r);
            temp.push(r);
        }

        while (!temp.isEmpty()) {
            DB.reservationHistory.push(temp.pop());
        }
    }
}
