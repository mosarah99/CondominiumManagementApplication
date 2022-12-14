package ftmk.workshop2.Condominium_Management_Application;

import java.io.Serializable;

public class Facility {

    private String FacilityID;
    private String FacilityName;
    private String Location;
    private String Capacity;

    public Facility(){

    }
    public String getFacilityID() {
        return FacilityID;
    }

    public void setFacilityID(String facilityID) {
        FacilityID = facilityID;
    }

    public String getFacilityName() {
        return FacilityName;
    }

    public void setFacilityName(String facilityName) {
        FacilityName = facilityName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public Facility(String facilityID, String facilityName, String location, String capacity) {
        FacilityID = facilityID;
        FacilityName = facilityName;
        Location = location;
        Capacity = capacity;
    }


}
