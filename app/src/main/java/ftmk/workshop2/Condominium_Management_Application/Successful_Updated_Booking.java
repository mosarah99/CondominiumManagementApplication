package ftmk.workshop2.Condominium_Management_Application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Successful_Updated_Booking extends AppCompatActivity {

    ImageButton btnBack, btnHome;
    Button btnViewBList, btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_updated_booking);

        //Get all Id's
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnViewBList = (Button) findViewById(R.id.btnViewBookingList);
        btnDone = (Button) findViewById(R.id.btnDone);

        //Intent to Edit Booking Info
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(Successful_Updated_Booking.this,
                        Edit_booking_info.class);
                startActivity(intentBack);
            }
        });

        //Intent to Facility Menu
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(Successful_Updated_Booking.this,
                        FacilitiesSettingMenu.class);
                startActivity(intentBack);
            }
        });

        //Intent to Booking List
        btnViewBList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(Successful_Updated_Booking.this,
                        BookingList.class);
                startActivity(intentBack);
            }
        });
    }
}