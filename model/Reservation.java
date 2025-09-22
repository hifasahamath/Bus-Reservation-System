package model;

public class Reservation {
    private String reservationId;
    private String customerId;
    private String busId;
    private int seatNumber;
    private String reservationDate;

    public Reservation(String reservationId, String customerId, String busId, int seatNumber, String reservationDate) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.busId = busId;
        this.seatNumber = seatNumber;
        this.reservationDate = reservationDate;
    }

    public String getReservationId() { return reservationId; }
    public void setReservationId(String reservationId) { this.reservationId = reservationId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getBusId() { return busId; }
    public void setBusId(String busId) { this.busId = busId; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public String getReservationDate() { return reservationDate; }
    public void setReservationDate(String reservationDate) { this.reservationDate = reservationDate; }

    public String toString() {
        return "Reservation ID: " + reservationId + ", Customer ID: " + customerId +
               ", Bus ID: " + busId + ", Seat No: " + seatNumber + ", Date: " + reservationDate;
    }
}
