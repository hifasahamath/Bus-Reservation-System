package utility;

import model.Customer;
import model.Bus;
import model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DB {
    
    // Stores all customer records
    public static List<Customer> customerList = new ArrayList<>();
    
    // Stores all bus records
    public static List<Bus> busList = new ArrayList<>();
    
    // Stores all current reservations
    public static List<Reservation> reservationList = new ArrayList<>();
    
    // Stores reservation history using stack (LIFO order)
    public static Stack<Reservation> reservationHistory = new Stack<>();
    
    // Custom linked list used to manage the waitlist (FIFO order)
    public static CustomerLinkedList waitlistQueue = new CustomerLinkedList();
}
