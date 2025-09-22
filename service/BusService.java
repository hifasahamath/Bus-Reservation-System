package service;
import utility.DB;
import model.Bus;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.*;

public class BusService {
    static Scanner sc = new Scanner(System.in);

    //
    public static void addBus() {
    try {
        System.out.print("Enter Bus ID: ");
        String busId = sc.nextLine();
        System.out.print("Enter Bus Number: ");
        String number = sc.nextLine();
        System.out.print("Enter Route From: ");
        String from = sc.nextLine();
        System.out.print("Enter Route To: ");
        String to = sc.nextLine();
        System.out.print("Enter Journey Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        System.out.print("Enter Departure Time: ");
        String time = sc.nextLine();
        System.out.print("Enter Total Seats: ");
        int seats = sc.nextInt();
        System.out.print("Enter Fare: ");
        double fare = sc.nextDouble(); sc.nextLine();
        System.out.print("Enter Driver Name: ");
        String driver = sc.nextLine();
        System.out.print("Enter AC Type (AC/Non-AC): ");
        String acType = sc.nextLine();
        System.out.print("Enter Bus Type (Luxury/Semi-Luxury/Normal): ");
        String busType = sc.nextLine();

        Bus bus = new Bus(busId, number, from, to, date, time, seats, fare, driver, acType, busType);
        DB.busList.add(bus);
        System.out.println("Bus added successfully!");
    } catch (InputMismatchException e) {
        System.out.println("Invalid input format. Please check numbers and try again.");
        sc.nextLine(); 
    } catch (Exception e) {
        System.out.println("Something went wrong while adding the bus.");
    } finally {
        System.out.println("Returning to main menu...");
    }
}

    public static void viewBuses() {
        if (DB.busList.isEmpty()) {
            System.out.println("No buses found.");
            return;
        }
        for (Bus b : DB.busList) {
            System.out.println(b);
        }
    }

    public static void updateBus() {
    try {
        System.out.print("Enter Bus ID to update: ");
        String id = sc.nextLine();
        for (Bus b : DB.busList) {
            if (b.getBusId().equals(id)) {
                System.out.print("Enter New Bus Number: ");
                b.setBusNumber(sc.nextLine());
                System.out.print("Enter New Route From: ");
                b.setRouteFrom(sc.nextLine());
                System.out.print("Enter New Route To: ");
                b.setRouteTo(sc.nextLine());
                System.out.print("Enter New Journey Date (YYYY-MM-DD): ");
                b.setJourneyDate(sc.nextLine());
                System.out.print("Enter New Departure Time: ");
                b.setDepartureTime(sc.nextLine());
                System.out.print("Enter New Total Seats: ");
                b.setTotalSeats(sc.nextInt());
                System.out.print("Enter New Fare: ");
                b.setFare(sc.nextDouble()); sc.nextLine();
                System.out.print("Enter New Driver Name: ");
                b.setDriverName(sc.nextLine());
                System.out.print("Enter New AC Type: ");
                b.setAcType(sc.nextLine());
                System.out.print("Enter New Bus Type: ");
                b.setBusType(sc.nextLine());

                System.out.println("Bus updated successfully!");
                return;
            }
        }
        System.out.println("Bus not found.");
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Check numeric fields.");
        sc.nextLine();
    } catch (Exception e) {
        System.out.println("Unexpected error occurred.");
    } finally {
        System.out.println("Update operation completed.");
    }
}

    public static void deleteBus() {
        System.out.print("Enter Bus ID to delete: ");
        String id = sc.nextLine();
        for (Bus b : DB.busList) {
            if (b.getBusId().equals(id)) {
                DB.busList.remove(b);
                System.out.println("Bus deleted.");
                return;
            }
        }
        System.out.println("Bus not found.");
    }

    public static void searchBus() {
        System.out.print("Enter Bus ID to search: ");
        String id = sc.nextLine();
        for (Bus b : DB.busList) {
            if (b.getBusId().equals(id)) {
                System.out.println(b);
                return;
            }
        }
        System.out.println("Bus not found.");
    }

    public static void filterBuses() {
        System.out.print("Enter Route From: ");
        String from = sc.nextLine();
        System.out.print("Enter Route To: ");
        String to = sc.nextLine();
        System.out.print("Enter Journey Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        System.out.print("Enter AC Type (AC/Non-AC): ");
        String ac = sc.nextLine();

        boolean found = false;
        for (Bus b : DB.busList) {
            if (b.getRouteFrom().equalsIgnoreCase(from) &&
                b.getRouteTo().equalsIgnoreCase(to) &&
                b.getJourneyDate().equalsIgnoreCase(date) &&
                b.getAcType().equalsIgnoreCase(ac)) {
                System.out.println(b);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No buses match your criteria.");
        }
    }

    public static void sortBusesByFare() {
        List<Bus> sorted = new ArrayList<>(DB.busList);
        sorted.sort(Comparator.comparingDouble(Bus::getFare));
        System.out.println("\n--- Buses Sorted by Fare (Low to High) ---");
        for (Bus b : sorted) {
            System.out.println(b);
        }
    }

    public static void sortBusesByDepartureTime() {
        List<Bus> sorted = new ArrayList<>(DB.busList);
        sorted.sort(Comparator.comparing(Bus::getDepartureTime));
        System.out.println("\n--- Buses Sorted by Departure Time ---");
        for (Bus b : sorted) {
            System.out.println(b);
        }
    }


    public static void preloadSampleBus() {
        DB.busList.clear(); 
        DB.busList.add(new Bus("BUS01", "NB-2045", "Eravur", "Colombo", "2025-04-01", "06:00", 45, 1500.00, "R. Majeed", "AC", "Semi-Luxury"));
        DB.busList.add(new Bus("BUS02", "EP-4596", "Colombo", "Jaffna", "2025-04-01", "08:00", 50, 2000.00, "S. Fernando", "Non-AC", "Ordinary"));
        DB.busList.add(new Bus("BUS03", "EK-9821", "Kandy", "Trincomalee", "2025-04-01", "07:30", 40, 1800.00, "N. Silva", "AC", "Luxury"));
        DB.busList.add(new Bus("BUS04", "NC-3321", "Batticaloa", "Kandy", "2025-04-01", "05:00", 48, 1600.00, "A. Kumar", "Non-AC", "Semi-Luxury"));
        DB.busList.add(new Bus("BUS05", "KL-7732", "Galle", "Anuradhapura", "2025-04-01", "09:00", 46, 2200.00, "R. Perera", "AC", "Luxury"));
        DB.busList.add(new Bus("BUS06", "EP-2276", "Badulla", "Colombo", "2025-04-01", "04:30", 42, 1700.00, "K. Raman", "Non-AC", "Ordinary"));
        DB.busList.add(new Bus("BUS07", "NB-7845", "Matara", "Jaffna", "2025-04-01", "10:00", 44, 2500.00, "S. Rasheed", "AC", "Luxury"));
        DB.busList.add(new Bus("BUS08", "EK-3333", "Trincomalee", "Batticaloa", "2025-04-01", "12:00", 40, 1000.00, "V. Bandara", "Non-AC", "Ordinary"));
        DB.busList.add(new Bus("BUS09", "EP-1442", "Kurunegala", "Colombo", "2025-04-01", "11:00", 47, 1400.00, "M. Ilham", "AC", "Semi-Luxury"));
        DB.busList.add(new Bus("BUS10", "NC-5555", "Batticaloa", "Colombo", "2025-04-01", "07:00", 2, 1300.00, "S. Hifas", "AC", "Luxury"));
        System.out.println("Sample busses loaded successfully!");
    }



}
