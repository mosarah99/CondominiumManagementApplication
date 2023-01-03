package ftmk.workshop2.Condominium_Management_Application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FacilitiesSettingMenu extends AppCompatActivity {

    Button btnAddFacility, btnMaintenance, btnFacilitiesReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_setting_menu);

        //Get all Id's
        btnAddFacility = (Button) findViewById(R.id.btnFacility);
        btnMaintenance = (Button) findViewById(R.id.btnMaintenance);
        btnFacilitiesReport = (Button) findViewById(R.id.btnFacilitiesReport);

        //Intent to Add New Facility
        btnAddFacility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd = new Intent(FacilitiesSettingMenu.this,
                        AddNewFacility.class);
                startActivity(intentAdd);
            }
        });


        //Intent to Facilities Maintenance
        btnMaintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd = new Intent(FacilitiesSettingMenu.this,
                        AddNewMaintenance.class);
                startActivity(intentAdd);
            }
        });

        //Intent to Facilities Booking Report
        btnFacilitiesReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd = new Intent(FacilitiesSettingMenu.this,
                        Facilities_Report.class);
                startActivity(intentAdd);
            }
        });

    }
}