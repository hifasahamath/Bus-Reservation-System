package service;
import utility.DB;
import model.Customer;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class CustomerService {
    static Scanner sc = new Scanner(System.in);

    //
    public static void addCustomer() {
    try {
        System.out.print("Enter Customer ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter NIC: ");
        String nic = sc.nextLine();
        System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine();
        System.out.print("Enter Home Phone: ");
        String home = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt(); sc.nextLine();

        Customer c = new Customer(id, name, nic, mobile, home, email, address, city, age);
        DB.customerList.add(c);
        System.out.println("Customer added successfully!");
    } catch (Exception e) {
        System.out.println("Invalid input. Please try again.");
        sc.nextLine(); 
    } finally {
        System.out.println("Returning to customer menu...");
    }
}

    public static void viewCustomers() {
        if (DB.customerList.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer c : DB.customerList) {
            System.out.println(c);
        }
    }

    public static void updateCustomer() {
    try {
        System.out.print("Enter Customer ID to update: ");
        String id = sc.nextLine();
        for (Customer c : DB.customerList) {
            if (c.getCustomerId().equals(id)) {
                System.out.print("Enter New Name: ");
                c.setName(sc.nextLine());
                System.out.print("Enter New NIC: ");
                c.setNic(sc.nextLine());
                System.out.print("Enter New Mobile Number: ");
                c.setMobileNumber(sc.nextLine());
                System.out.print("Enter New Home Phone: ");
                c.setHomePhone(sc.nextLine());
                System.out.print("Enter New Email: ");
                c.setEmail(sc.nextLine());
                System.out.print("Enter New Address: ");
                c.setAddress(sc.nextLine());
                System.out.print("Enter New City: ");
                c.setCity(sc.nextLine());
                System.out.print("Enter New Age: ");
                c.setAge(sc.nextInt()); sc.nextLine();

                System.out.println("Customer updated successfully!");
                return;
            }
        }
        System.out.println("Customer not found.");
    } catch (Exception e) {
        System.out.println("Error while updating customer. Please check inputs.");
        sc.nextLine(); 
    } finally {
        System.out.println("Returning to customer menu...");
    }
}

    public static void deleteCustomer() {
        System.out.print("Enter Customer ID to delete: ");
        String id = sc.nextLine();
        for (Customer c : DB.customerList) {
            if (c.getCustomerId().equals(id)) {
                DB.customerList.remove(c);
                System.out.println("Customer deleted.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    public static void searchCustomer() {
        System.out.print("Enter Customer ID to search: ");
        String id = sc.nextLine();
        for (Customer c : DB.customerList) {
            if (c.getCustomerId().equals(id)) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Customer not found.");
    }



    public static void preloadSampleCustomers() {
        DB.customerList.clear();
        DB.customerList.add(new Customer("C001", "Nimal", "NIC001", "0711234567", "0651234567", "nimal@gmail.com", "Main St", "Colombo", 45));
        DB.customerList.add(new Customer("C002", "Sunil", "NIC002", "0771234567", "0651237890", "sunil@gmail.com", "Lake Rd", "Kandy", 32));
        DB.customerList.add(new Customer("C003", "Kamal", "NIC003", "0751234567", "0651234568", "kamal@gmail.com", "Temple St", "Jaffna", 29));
        DB.customerList.add(new Customer("C004", "Amara", "NIC004", "0721234567", "0651234599", "amara@gmail.com", "Hill Rd", "Matara", 40));
        DB.customerList.add(new Customer("C005", "Hifas", "NIC005", "0781234567", "0651234000", "hifas@gmail.com", "Main St", "Eravur", 22));
        System.out.println("Sample customers loaded successfully!");

    }







    // Bubble Sort to sort customers by age
    public static void sortCustomersByAge() {
    try {
        if (DB.customerList.isEmpty()) {
            System.out.println("No customers to sort.");
            return;
        }

        List<Customer> list = DB.customerList;
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getAge() > list.get(j + 1).getAge()) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }

        System.out.println("\nCustomer List After Sorting by Age:");
        for (Customer c : list) {
            System.out.println(c);
        }

        System.out.println("\nSorted using Bubble Sort.");
    } catch (Exception e) {
        System.out.println("Sorting failed due to unexpected error.");
    } finally {
        System.out.println("Returning to customer menu...");
    }
}




    // Insertion Sort to sort customers by age
    public static void sortCustomersByAgeUsingInsertionSort() {
    try {
        if (DB.customerList.size() <= 1) {
            System.out.println("Not enough customers to sort.");
            return;
        }

        // Insertion Sort logic
        for (int i = 1; i < DB.customerList.size(); i++) {
            Customer key = DB.customerList.get(i);
            int j = i - 1;

            while (j >= 0 && DB.customerList.get(j).getAge() > key.getAge()) {
                DB.customerList.set(j + 1, DB.customerList.get(j));
                j--;
            }
            DB.customerList.set(j + 1, key);
        }

        System.out.println("\nAfter Sorting (by Age - Insertion Sort):");
        for (Customer c : DB.customerList) {
            System.out.println(c);
        }
    } catch (Exception e) {
        System.out.println("An error occurred while sorting customers.");
    } finally {
        System.out.println("Returning to customer menu...");
    }
}




    /* 
    public static void reverseCustomerOrder() {
        if (DB.customerList.isEmpty()) {
            System.out.println("No customers to reverse.");
            return;
        }

        Stack<Customer> stack = new Stack<>();
        for (Customer c : DB.customerList) {
            stack.push(c);
        }

        System.out.println("\nReversed Customer List (Newest to Oldest):");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }*/


    public static void reverseCustomerOrder() {
    if (DB.customerList.isEmpty()) {
        System.out.println("No customers to reverse.");
        return;
    }

    Stack<Customer> stack = new Stack<>();
    for (Customer c : DB.customerList) {
        stack.push(c);
    }

    System.out.println("\nReversed Customer List (Newest to Oldest):");
    try {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    } catch (EmptyStackException e) {
        System.out.println("Error: Stack is empty. Cannot pop anymore.");
    }
}






}
