package utility;
import model.Customer;

public class CustomerLinkedList {

    // Node class to hold customer data and reference to next node
    private static class Node {
        Customer data;
        Node next;

        Node(Customer data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // points to the first customer
    private Node tail; // points to the last customer

    // Add customer at the end (FIFO)
    public void add(Customer customer) {
        Node newNode = new Node(customer);

        if (head == null) {
            // List is empty
            head = newNode;
            tail = newNode;
        } else {
            // Attach new node at the end and update tail
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove and return the first customer (poll)
    public Customer poll() {
        if (head == null) {
            return null; // list empty
        }
        Customer firstCustomer = head.data;
        head = head.next; // move head to next node

        if (head == null) {
            tail = null; // list became empty after removal
        }
        return firstCustomer;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Return iterable to loop through customers
    public Iterable<Customer> iterable() {
        return () -> new java.util.Iterator<Customer>() {
            private Node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public Customer next() {
                Customer cust = current.data;
                current = current.next;
                return cust;
            }
        };
    }
}
