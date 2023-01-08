/**
 * Main Activity of the program
 * @author Israt
 * @since 1.0
 */


package ftmk.workshop2.Condominium_Management_Application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // =================== FORGOT PASSWORD Button
    private TextView txtForgotPassword;
    // =================== Text Fields for Email and Password
    private EditText emailField, passwordField;
    private String userEmail, userPassword;
    // =================== Database URL
    private String URL = "http:///10.0.2.2/login/login.php";

    /**
     * functions to do when the activity loads
     * @param savedInstanceState previous instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userEmail = userPassword = "";
        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);

        txtForgotPassword = findViewById(R.id.txt_main_resetpassword);
        txtForgotPassword.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PasswordResetActivity.class);
            startActivity(intent);
        });
    }

    /**
     * Login button onClickListener
     * @param view the view that generated the listener
     */
    public void login(View view) {
        userEmail = emailField.getText().toString().trim();
        userPassword = passwordField.getText().toString().trim();
        if(!userEmail.equals("") && !userPassword.equals("")){
            /**
             * @see https://javadoc.io/static/com.android.volley/volley/1.1.1/com/android/volley/toolbox/StringRequest.html
             */
            StringRequest currentRequests = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("res", response);
                    if (response.equals("success")) {
                        Intent successPage = new Intent(MainActivity.this, __Temp_Home.class);
                        startActivity(successPage);
                        finish();
                    } else if (response.equals("failure")) {
                        Toast.makeText(MainActivity.this, "Invalid Login Id/Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("email", userEmail);
                    data.put("password", userPassword);
                    return data;
                }
            };
            RequestQueue requestSessions = Volley.newRequestQueue(getApplicationContext());
            requestSessions.add(currentRequests);
        }else{
            Toast.makeText(this, "Fields can not be left empty!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Register button onClickListener
     * @param view View that generated listener
     */
    public void register(View view) {
        Intent registrationPage = new Intent(this, AccountRegisterActivity.class);
        startActivity(registrationPage);
        finish();
    }
}