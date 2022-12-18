package ftmk.workshop2.Condominium_Management_Application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

public class FacilityMaintenance extends AppCompatActivity {

    Spinner spinnerFacility, spinnerTime;
    ImageButton btnBack;

    ArrayList<String> facilityList = new ArrayList<>();
    ArrayAdapter<String> facilityAdapter;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_maintenance);



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
    }
}