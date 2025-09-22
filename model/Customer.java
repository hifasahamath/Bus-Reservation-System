package model;

public class Customer {
    private String customerId;
    private String name;
    private String nic;
    private String mobileNumber;
    private String homePhone;
    private String email;
    private String address;
    private String city;
    private int age;

    public Customer(String customerId, String name, 
    String nic, String mobileNumber, String homePhone, 
    String email, String address, String city, int age) {
        this.customerId = customerId;
        this.name = name;
        this.nic = nic;
        this.mobileNumber = mobileNumber;
        this.homePhone = homePhone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.age = age;
    }

    public Customer(String customerId, String name, String address, String mobileNumber) {
    this.customerId = customerId;
    this.name = name;
    this.address = address;
    this.mobileNumber = mobileNumber;
}


    // Getters and Setters

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNic() { return nic; }
    public void setNic(String nic) { this.nic = nic; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getHomePhone() { return homePhone; }
    public void setHomePhone(String homePhone) { this.homePhone = homePhone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", NIC: " + nic + 
        ", Mobile: " + mobileNumber + ", Home: " + homePhone + ", Email: " + email + 
        ", Address: " + address + ", City: " + city + ", Age: " + age;
    }

}