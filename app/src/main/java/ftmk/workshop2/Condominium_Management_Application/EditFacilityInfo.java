package ftmk.workshop2.Condominium_Management_Application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class EditFacilityInfo extends AppCompatActivity {

    ImageButton btnBack;
    Button btnUpdate;
    private EditText etName, etLocation, etCapacity;
    private String facilityName, location, capacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_facility_info);

        //Get all Id's
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        etName = (EditText) findViewById(R.id.editTxtFName);
        etLocation = (EditText) findViewById(R.id.editTxtFLocation);
        etCapacity = (EditText) findViewById(R.id.editTxtFCapacity);

        //Intent to Facilities Setting Menu
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(EditFacilityInfo.this,
                        FacilitiesSettingMenu.class);
                startActivity(intentBack);
            }
        });

        //Intent to Successful Added Facilities Screen
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateFacility();
            }
        });

    }

    public void UpdateFacility(){
        facilityName = etName.getText().toString().trim();
        location = etLocation.getText().toString().trim();
        capacity = etCapacity.getText().toString().trim();

        // Give a warning to user when the field is empty
        if(TextUtils.isEmpty(facilityName)){
            etName.setError("Please enter Facility Name");
        }else if (TextUtils.isEmpty(location)){
            etLocation.setError("Please enter Location");
        }else if (TextUtils.isEmpty(capacity)){
            etCapacity.setError("Please enter Capacity");
        }else {
            //UpdateData(facilityName, location, capacity);
            //Intent to Successful Added Facilities Screen
            Intent intentSuccess = new Intent(EditFacilityInfo.this,
                    SuccessfullUpdatedFacility.class);
            startActivity(intentSuccess);
        }
    }
}