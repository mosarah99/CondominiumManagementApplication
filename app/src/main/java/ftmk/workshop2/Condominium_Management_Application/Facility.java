package ftmk.workshop2.Condominium_Management_Application;

public class Facility {

    private String facilityID;
    private String facilityName;
    private String location;
    private String capacity;

    public Facility(){

    }
    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        facilityID = facilityID;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        facilityName = facilityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        location = location;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        capacity = capacity;
    }

    public Facility(String facilityID, String facilityName, String location, String capacity) {
        this.facilityID = facilityID;
        this.facilityName = facilityName;
        this.location = location;
        this.capacity = capacity;
    }


}
