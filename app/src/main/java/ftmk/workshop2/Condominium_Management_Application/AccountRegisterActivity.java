/**
 * Account Register Activity of the program
 * @author Israt
 * @since 1.0
 */



package ftmk.workshop2.Condominium_Management_Application;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Account Registration and related functions
 */
public class AccountRegisterActivity extends AppCompatActivity {

    // ================================ Text fields in the xml
    private EditText nameField, emailField, phonenumberField, passwordField, field_retypePassword;
    private TextView successFailStatustxtView;
    private Button btnRegister;

    // ================================= Database URL
    private String URL = "http:///10.0.2.2/login/register.php";
    private String userName, userEmail, userPhoneNumber, userPassword, retypePassword;

    /**
     * Functions when activity loads
     * @param savedInstanceState previous saved instance
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_register);
        nameField = findViewById(R.id.nameField);
        emailField = findViewById(R.id.emailField);
        phonenumberField = findViewById(R.id.phonenumberField);
        passwordField = findViewById(R.id.passwordField);
        field_retypePassword = findViewById(R.id.field_retypePassword);
        successFailStatustxtView = findViewById(R.id.tvStatus);
        btnRegister = findViewById(R.id.btnRegister);
        userName = userEmail = userPhoneNumber = userPassword = retypePassword = "";
    }

    /**
     * Register button activity
     * @param view the view that created the event
     */
    public void save(View view) {
        userName = nameField.getText().toString().trim();
        userEmail = emailField.getText().toString().trim();
        userPhoneNumber = phonenumberField.getText().toString().trim();
        userPassword = passwordField.getText().toString().trim();
        retypePassword = field_retypePassword.getText().toString().trim();
        if(!userPassword.equals(retypePassword)){
            Toast.makeText(this, "Password Mismatch", Toast.LENGTH_SHORT).show();
        }
        else if(!userName.equals("") && !userEmail.equals("") && !userPassword.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, response -> {
                if (response.equals("success")) {
                    successFailStatustxtView.setText("Successfully registered.");

                    btnRegister.setClickable(false);
//                    Intent intent = new Intent( Register.this, AccountTypeSelection.class);
//                    startActivity(intent);

                } else if (response.equals("failure")) {
                    successFailStatustxtView.setText("Oops,Something went wrong!");                    }
            }, error -> Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show()){
                @Override
                public String getBodyContentType() {
                    // as we are passing data in the form of url encoded
                    // so we are passing the content type below
                    return "application/x-www-form-urlencoded; charset=UTF-8";
                }
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> data = new HashMap<>();
                    data.put("name", userName);
                    data.put("email", userEmail);
                    data.put("phonenumber", userPhoneNumber);
                    data.put("password", userPassword);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }

    /**
     * Login button activity. Goes to login screen
     * @param view the view that generated the event
     */
    public void login(View view) {
        Intent LoginPage = new Intent(this, MainActivity.class);
        startActivity(LoginPage);
        finish();
    }

}