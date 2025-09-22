package model;


public class Bus {
    private String busId;
    private String busNumber;
    private String routeFrom;
    private String routeTo;
    private String journeyDate;
    private String departureTime;
    private int totalSeats;
    private double fare;
    private String driverName;
    private String acType;
    private String busType;

    public Bus(String busId, String busNumber, String routeFrom, String routeTo,
               String journeyDate, String departureTime, int totalSeats, double fare,
               String driverName, String acType, String busType) {
        this.busId = busId;
        this.busNumber = busNumber;
        this.routeFrom = routeFrom;
        this.routeTo = routeTo;
        this.journeyDate = journeyDate;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.fare = fare;
        this.driverName = driverName;
        this.acType = acType;
        this.busType = busType;

    }

    // Get Set
    public String getBusId() { return busId; }
    public void setBusId(String busId) { this.busId = busId; }

    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }

    public String getRouteFrom() { return routeFrom; }
    public void setRouteFrom(String routeFrom) { this.routeFrom = routeFrom; }

    public String getRouteTo() { return routeTo; }
    public void setRouteTo(String routeTo) { this.routeTo = routeTo; }

    public String getJourneyDate() { return journeyDate; }
    public void setJourneyDate(String journeyDate) { this.journeyDate = journeyDate; }

    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }

    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }

    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }

    public String getAcType() { return acType; }
    public void setAcType(String acType) { this.acType = acType; }

    public String getBusType() { return busType; }
    public void setBusType(String busType) { this.busType = busType; }

    public String toString() {
        return "Bus ID: " + busId +
               ", Number: " + busNumber +
               ", From: " + routeFrom +
               ", To: " + routeTo +
               ", Date: " + journeyDate +
               ", Departure: " + departureTime +
               ", Seats: " + totalSeats +
               ", Fare: " + fare +
               ", Driver: " + driverName +
               ", AC Type: " + acType +
               ", Bus Type: " + busType;
    }
}
