package ftmk.workshop2.Condominium_Management_Application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailBooking extends AppCompatActivity {

    TextView tvid,tvName,tvTime,tvDate;
    ImageButton btnBack;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_booking);

        //Initializing Views
        tvid = findViewById(R.id.txtid);
        tvName = findViewById(R.id.txtName);
        tvTime = findViewById(R.id.txtTime);
        tvDate = findViewById(R.id.txtDate);
        btnBack = (ImageButton)findViewById(R.id.btnBack);

        //Intent to Booking List
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(DetailBooking.this,
                        BookingList.class);
                startActivity(intentBack);
            }
        });

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvid.setText("ID: "+BookingList.bookingArrayList.get(position).getBookingID());
        tvName.setText("Facility Name: "+BookingList.bookingArrayList.get(position).getFacilityName());
        tvTime.setText("Booking Time: "+BookingList.bookingArrayList.get(position).getBookingTime());
        tvDate.setText("Booking Date: "+BookingList.bookingArrayList.get(position).getBookingDate());
    }
}