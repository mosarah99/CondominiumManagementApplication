package ftmk.workshop2.Condominium_Management_Application;

public class Booking {

    private String bookingID;
    private String facilityName;
    private String bookingTime;
    private String bookingDate;

    public Booking(){

    }

    public Booking(String bookingID, String facilityName, String bookingTime, String bookingDate) {
        this.bookingID = bookingID;
        this.facilityName = facilityName;
        this.bookingTime = bookingTime;
        this.bookingDate = bookingDate;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
}
