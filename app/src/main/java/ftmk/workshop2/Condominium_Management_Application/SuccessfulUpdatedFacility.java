package ftmk.workshop2.Condominium_Management_Application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessfulUpdatedFacility extends AppCompatActivity {

    ImageButton btnBack, btnHome;
    Button btnViewFList, btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfull_updated_facility);

        //Get all Id's
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnViewFList = (Button) findViewById(R.id.btnViewFacilitiesList);
        btnDone = (Button) findViewById(R.id.btnDone);

        //Intent to Edit Facility Info
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(SuccessfulUpdatedFacility.this,
                        Edit_facility_info.class);
                startActivity(intentBack);
            }
        });

        //Intent to Facility Menu
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(SuccessfulUpdatedFacility.this,
                        FacilitiesSettingMenu.class);
                startActivity(intentBack);
            }
        });

        //Intent to Home Page
        /*btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(SuccessfulUpdatedFacility.this,
                        FacilitiesSettingMenu.class);
                startActivity(intentBack);
            }
        });*/

        //Intent to Facilities List
        btnViewFList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(SuccessfulUpdatedFacility.this,
                        FacilitiesList.class);
                startActivity(intentBack);
            }
        });
    }
}