package ftmk.workshop2.Condominium_Management_Application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailFacility extends AppCompatActivity {

    TextView tvid,tvName,tvLocation,tvCapacity;
    ImageButton btnBack;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_facility);

        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvName = findViewById(R.id.txtName);
        tvLocation = findViewById(R.id.txtLocation);
        tvCapacity = findViewById(R.id.txtCapacity);
        btnBack = (ImageButton)findViewById(R.id.btnBack);

        //Intent to Facilities List
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(DetailFacility.this,
                        FacilitiesList.class);
                startActivity(intentBack);
            }
        });

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: "+FacilitiesList.facilityArrayList.get(position).getFacilityID());
        tvName.setText("Facility Name: "+FacilitiesList.facilityArrayList.get(position).getFacilityName());
        tvLocation.setText("Location: "+FacilitiesList.facilityArrayList.get(position).getLocation());
        tvCapacity.setText("Capacity: "+FacilitiesList.facilityArrayList.get(position).getCapacity());

    }
}