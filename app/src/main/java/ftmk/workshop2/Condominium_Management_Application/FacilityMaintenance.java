package ftmk.workshop2.Condominium_Management_Application;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

public class FacilityMaintenance extends AppCompatActivity {

    Spinner spinnerFacility, spinnerTime;
    ImageButton btnBack;
    EditText edTxtDate;


    private DatePickerDialog datePicker;

    ArrayList<String> facilityList = new ArrayList<>();
    ArrayAdapter<String> facilityAdapter;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_maintenance);

        //Assign variable
        edTxtDate = (EditText) findViewById(R.id.editTxtDate);

        edTxtDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    //Initialize variable
                    final Calendar cldr = Calendar.getInstance();

                    //Get day, month, year
                    int day = cldr.get(Calendar.DAY_OF_MONTH);
                    int month = cldr.get(Calendar.MONTH);
                    int year = cldr.get(Calendar.YEAR);

                    // date picker dialog
                    datePicker = new DatePickerDialog(FacilityMaintenance.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                                      int dayOfMonth) {
                                    edTxtDate.setText(year  + "-" + (monthOfYear + 1)
                                            + "-" + dayOfMonth);
                                }
                            }, year,month, day);
                    datePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                    datePicker.show();

                }
                return false;
            }
        });

        //Get all Id's
        btnBack = (ImageButton) findViewById(R.id.btnBack);

        //Intent to Facilities Setting Menu
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(FacilityMaintenance.this,
                        FacilitiesSettingMenu.class);
                startActivity(intentBack);
            }
        });

        requestQueue = Volley.newRequestQueue(this);
        spinnerFacility = findViewById(R.id.spinnerFacility);
        String url = "http://192.168.1.9/populate_facility.php";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("facility");
                    for(int i=0; i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String facilityName = jsonObject.optString("FacilityName");
                        facilityList.add(facilityName);
                        facilityAdapter = new ArrayAdapter<>(FacilityMaintenance.this,
                                android.R.layout.simple_spinner_item, facilityList);
                        facilityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnerFacility.setAdapter(facilityAdapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);

       /* String facilitySpinner = spinnerFacility.getSelectedItem().toString();
        String timeSpinner = spinnerTime.getSelectedItem().toString();*/





    }


}