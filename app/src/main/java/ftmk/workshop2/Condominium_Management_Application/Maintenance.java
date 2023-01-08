package ftmk.workshop2.Condominium_Management_Application;

public class Maintenance {

    private String maintenanceID;
    private String facilityName;
    private String maintenanceTime;
    private String maintenanceDate;

    public Maintenance(String maintenanceID, String facilityName, String maintenanceTime, String maintenanceDate) {
        this.maintenanceID = maintenanceID;
        this.facilityName = facilityName;
        this.maintenanceTime = maintenanceTime;
        this.maintenanceDate = maintenanceDate;
    }

    public Maintenance(){

    }

    public String getMaintenanceID() {
        return maintenanceID;
    }

    public void setMaintenanceID(String maintenanceID) {
        this.maintenanceID = maintenanceID;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getMaintenanceTime() {
        return maintenanceTime;
    }

    public void setMaintenanceTime(String maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }
}
