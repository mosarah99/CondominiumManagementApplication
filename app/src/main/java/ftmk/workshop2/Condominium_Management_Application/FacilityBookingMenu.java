package ftmk.workshop2.Condominium_Management_Application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FacilityBookingMenu extends AppCompatActivity {

    Button btnBooking, btnEditBooking, btnCancelBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_booking_menu);

        //Get all Id's
        btnBooking = (Button) findViewById(R.id.btnBooking);
        btnEditBooking = (Button) findViewById(R.id.btnEditBooking);
        btnCancelBooking = (Button) findViewById(R.id.btnCancelBooking);

        //Intent to Add New Facility
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd = new Intent(FacilityBookingMenu.this,
                        NewBooking.class);
                startActivity(intentAdd);
            }
        });

    }
}