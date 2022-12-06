package ftmk.workshop2.Condominium_Management_Application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FacilitiesList extends AppCompatActivity {

    //Declare Button
    ImageButton btnBack;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_list);

        //Get all Id's
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnEdit = (Button) findViewById(R.id.btnEditFacility);

        //Intent to Facilities Setting Menu
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(FacilitiesList.this,
                        FacilitiesSettingMenu.class);
                startActivity(intentBack);
            }
        });

        //Intent to Edit Facility Information
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(FacilitiesList.this,
                        EditFacilityInfo.class);
                startActivity(intentBack);
            }
        });

        //Intent to Edit Facility Page
        /*btnEdit = (Button) findViewById(R.id.btnEditFacility);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(FacilitiesList.this,
                        FacilitiesSettingMenu.class);
                startActivity(intentBack);
            }
        });*/
    }
}