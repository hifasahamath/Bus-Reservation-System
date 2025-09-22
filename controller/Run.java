package controller;

import model.Customer;
import service.CustomerService;
import service.BusService;
import service.ReservationService;
import utility.SeatManager;
import utility.WaitlistManager;
import utility.NotificationService;

import java.util.Scanner;

public class Run {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===========================");
            System.out.println("BUS RESERVATION SYSTEM");
            System.out.println("===========================");
            System.out.println("1. Customer");
            System.out.println("2. Bus");
            System.out.println("3. Reservation");
            System.out.println("4. Seat Manager");
            System.out.println("5. Notification Service");
            System.out.println("6. Waitlist Manager");
            System.out.println("7. Exit");
            System.out.println("---------------------------");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    busMenu();
                    break;
                case 3: 
                    reservationMenu();
                    break;
                case 4:
                    seatManagerMenu();
                    break;
                case 5:
                    notificationMenu();
                    break;
                case 6:
                    waitlistManagerMenu();
                    break;
                case 7:
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void customerMenu() {
        while (true) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Search Customer by ID");
            System.out.println("6. Preload Sample Customers");
            System.out.println("7. Sort Customers by Age");
            System.out.println("8. Reverse Customer Order (Newest to Oldest)");
            System.out.println("9. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    CustomerService.addCustomer();
                    break;
                case 2:
                    CustomerService.viewCustomers();
                    break;
                case 3:
                    CustomerService.updateCustomer();
                    break;
                case 4:
                    CustomerService.deleteCustomer();
                    break;
                case 5:
                    CustomerService.searchCustomer();
                    break;
                case 6:
                    CustomerService.preloadSampleCustomers();
                    break;
                case 7:
                    CustomerService.sortCustomersByAgeUsingInsertionSort();
                    break;
                case 8:
                    CustomerService.reverseCustomerOrder();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }



    public static void busMenu() {
        while (true) {
            System.out.println("\n--- Bus Menu ---");
            System.out.println("1. Add Bus");
            System.out.println("2. View All Buses");
            System.out.println("3. Update Bus");
            System.out.println("4. Delete Bus");
            System.out.println("5. Search Bus by ID");
            System.out.println("6. Filter Buses");
            System.out.println("7. Sort Buses by Fare");
            System.out.println("8. Sort Buses by Departure Time");
            System.out.println("9. Preload Sample Buses");
            System.out.println("10. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    BusService.addBus();
                    break;
                case 2:
                    BusService.viewBuses();
                    break;
                case 3:
                    BusService.updateBus();
                    break;
                case 4:
                    BusService.deleteBus();
                    break;
                case 5:
                    BusService.searchBus();
                    break;
                case 6:
                    BusService.filterBuses();
                    break;
                case 7:
                    BusService.sortBusesByFare();
                    break;
                case 8:
                    BusService.sortBusesByDepartureTime();
                    break;
                case 9:
                    BusService.preloadSampleBus();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void reservationMenu() {
        while (true) {
            System.out.println("\n--- Reservation Menu ---");
            System.out.println("1. Add Reservation");
            System.out.println("2. View All Reservations");
            System.out.println("3. Delete Reservation");
            System.out.println("4. Search Reservation by ID");
            System.out.println("5. View Reservation History");
            System.out.println("6. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    ReservationService.addReservation();
                    break;
                case 2:
                    ReservationService.viewReservations();
                    break;
                case 3:
                    ReservationService.deleteReservation();
                    break;
                case 4:
                    ReservationService.searchReservation();
                    break;
                case 5:
                    ReservationService.viewReservationHistory();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void seatManagerMenu() {
        System.out.print("Enter Bus Number: ");
        String busNo = sc.nextLine();

        while (true) {
            System.out.println("\n--- Seat Manager ---");
            System.out.println("1. Reserve a Seat");
            System.out.println("2. Release a Seat");
            System.out.println("3. Check Seat Availability");
            System.out.println("4. View Reserved Seats");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Seat Number to reserve: ");
                    int resSeat = sc.nextInt();
                    SeatManager.reserveSeat(busNo, resSeat);
                    break;
                case 2:
                    System.out.print("Enter Seat Number to release: ");
                    int relSeat = sc.nextInt();
                    SeatManager.releaseSeat(busNo, relSeat);
                    break;
                case 3:
                    System.out.print("Enter Seat Number to check: ");
                    int checkSeat = sc.nextInt();
                    boolean available = SeatManager.isSeatAvailable(busNo, checkSeat);
                    System.out.println(available ? "Seat is available." : "Seat is reserved.");
                    break;
                case 4:
                    SeatManager.viewReservedSeats(busNo);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void waitlistManagerMenu() {
        while (true) {
            System.out.println("\n--- Waitlist Manager ---");
            System.out.println("1. Add to Waitlist");
            System.out.println("2. View Waitlist");
            System.out.println("3. Get Next Customer");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter Contact Number: ");
                    String contact = sc.nextLine();
                    Customer c = new Customer(id, name, address, contact);
                    WaitlistManager.addToWaitlist(c);
                    System.out.println("Customer added to waitlist.");
                    break;
                case 2:
                    WaitlistManager.viewWaitlist();
                    break;
                case 3:
                    WaitlistManager.getNextCustomer();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void notificationMenu() {
        System.out.println("\n--- Notification Demo ---");
        NotificationService.sendReservationMessage("SampleUser", "BUS100", 3);
        NotificationService.sendCancellationMessage("SampleUser", "BUS100", 3);
        NotificationService.sendWaitlistMessage("SampleUser", "BUS100", 3);
        NotificationService.sendSeatChangeRequestMessage("SampleUser");
    }

}
