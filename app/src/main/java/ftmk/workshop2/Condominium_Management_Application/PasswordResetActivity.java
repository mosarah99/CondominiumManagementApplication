/**
 * Password reset activity
 * @author Israt
 * @since 1.0
 */
package ftmk.workshop2.Condominium_Management_Application;

import androidx.annotation.NonNull;
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

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

/**
 * Password reset activity
 */
public class PasswordResetActivity extends AppCompatActivity {


    /**
     * State class. Denotes the state of the view
     * @author Israt
     * @since 1.0
     */
    protected class State {
        protected String _name;
        protected State _instance;

        private State() {
            this._instance = null;
            _name = "";
        }

        public State getState() { return _instance; }
        public String getName() { return _name; }
    }
    /**
     * Fresh State
     * @author Israt
     * @since 1.0
     */
    protected class FreshState extends State {
        public FreshState() {
//            _instance = new FreshState();
            _name = "FreshState";
        }
    }
    /**
     * Enter Key State
     * @author Israt
     * @since 1.0
     */
    protected class EnterKeyState extends State {
        public EnterKeyState() {
//            _instance = new EnterKeyState();
            _name = "EnterKeyState";
        }
    }
    /**
     * Enter Password State
     * @author Israt
     * @since 1.0
     */
    protected class EnterPasswordState extends State {
        public EnterPasswordState() {
//            _instance = new EnterPasswordState();
            _name = "EnterPasswordState";
        }
    }

    // =================================== Text fields
    EditText txtEmail, txtKey, txtPassword, txtConfirmPassword;
    // =================================== Buttons
    Button btnBack, btnConfirm;
    // =================================== State of the class
    State stateOfActivity;
    //URL
    final String URL_GENKEY = "http:///10.0.2.2/login/generate_key.php";
    final String URL_ENTERKEY = "http:///10.0.2.2/login/resetpass_validate.php";
    final String URL_NEWPASSWORD = "http:///10.0.2.2/login/resetpass_updatepass.php";


    /**
     * Functions upon activity creation
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        txtEmail = findViewById(R.id.txt_resetpassword_enter_email);
        txtKey = findViewById(R.id.txt_resetpassword_key);
        txtPassword = findViewById(R.id.txt_resetpassword_password);
        txtConfirmPassword = findViewById(R.id.txt_resetpassword_confirm_password);

        btnBack = findViewById(R.id.btn_resetpassword_back);
        btnBack.setOnClickListener(view -> {
            switch (stateOfActivity.getName()) {
                case "EnterKeyState":
                    restoreFreshState();
                    break;
                case "EnterPasswordState":
                    restoreEnterKeyStatus();
                    break;
                default:
                    startActivity(new Intent(this, MainActivity.class));
            }
        });

        btnConfirm = findViewById(R.id.btn_resetpassword_sendkey);
//        btnConfirm.setOnClickListener(new ConfirmButtonActionListener());

        PreferenceManager.getDefaultSharedPreferences(this).edit().clear().commit();
        restoreFreshState();
    }

    /**
     * Functions when the app goes into background
     */
    @Override
    protected void onPause() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("passwordresetactivity_STATE", stateOfActivity.getName());
        editor.apply();
        super.onPause();
    }

    /**
     * Functions to perform when the app resumes
     */
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = prefs.edit();
        String state = prefs.getString("passwordresetactivity_STATE", "FreshState");
        switch(state) {
            case "EnterKeyState":
                restoreEnterKeyStatus();
                break;
            case "EnterPasswordState":
                restoreEnterPasswordState();
                break;
            default:
                restoreFreshState();
                break;
        }
    } //     protected void onResume() {

    /**
     * Set the screen for fresh state
     */
    private void restoreFreshState() {
        txtEmail.setVisibility(View.VISIBLE);
        txtEmail.requestFocus();
        txtEmail.setFocusable(true);

        txtKey.setVisibility(View.INVISIBLE);
        txtKey.setText("");
        txtKey.setFocusable(false);

        txtPassword.setVisibility(View.INVISIBLE);
        txtPassword.setText("");
        txtPassword.setFocusable(false);

        txtConfirmPassword.setVisibility(View.INVISIBLE);
        txtConfirmPassword.setText("");
        txtConfirmPassword.setFocusable(false);

        btnConfirm.setText("Get Key");

        stateOfActivity = new FreshState();
    } //     private void restoreFreshState() {

    /**
     * Set the screen for key entering stage
     */
    private void restoreEnterKeyStatus() {
        txtEmail.setVisibility(View.VISIBLE);
        txtEmail.setFocusable(true);

        txtKey.setVisibility(View.VISIBLE);
        txtKey.requestFocus();
        txtKey.setFocusable(true);

        txtPassword.setVisibility(View.INVISIBLE);
        txtPassword.setText("");
        txtPassword.setFocusable(false);

        txtConfirmPassword.setVisibility(View.INVISIBLE);
        txtConfirmPassword.setText("");
        txtConfirmPassword.setFocusable(false);

        btnConfirm.setText("Validate Key");

        stateOfActivity = new EnterKeyState();
    } //     private void restoreEnterKeyStatus() {

    /**
     * Password entering stage
     */
    private void restoreEnterPasswordState() {
        txtEmail.setVisibility(View.VISIBLE);
        txtEmail.setFocusable(false);

        txtKey.setVisibility(View.VISIBLE);
        txtKey.setFocusable(false);

        txtPassword.setVisibility(View.VISIBLE);
        txtPassword.setText("");
        txtPassword.setFocusable(true);

        txtConfirmPassword.setVisibility(View.VISIBLE);
        txtConfirmPassword.setText("");
        txtConfirmPassword.setFocusable(true);

        btnConfirm.setText("Save Password");

        stateOfActivity = new EnterPasswordState();
    } //     private void restoreEnterPasswordState() {

    /**
     * functions of get key button
     * @param view the view calling the function
     */
    public void getkey(View view) {
//        Toast.makeText(PasswordResetActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();

        if (txtEmail.getText().toString().equals("")) {
            txtEmail.setError("Please enter an email address");
            return;
        }

        if (stateOfActivity.getName().equals("FreshState")) {
            StringRequest stringRequest = generateKeyRequest();
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        } //         if (stateOfActivity.getName().equals("FreshState")) {
        else if (stateOfActivity.getName().equals("EnterKeyState")) {
            if (txtKey.getText().toString().equals("")) {
                txtKey.setError("Enter Key");
                return;
            }
            StringRequest stringRequest = validateKeyRequest();
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        } //         else if (stateOfActivity.getName().equals("EnterKeyState")) {
        else if (stateOfActivity.getName().equals("EnterPasswordState")) {
            if (!txtPassword.getText().toString().equals(
                    txtConfirmPassword.getText().toString()
            )) {
                Toast.makeText(
                        PasswordResetActivity.this,
                        "Password mismatch. Please check the passwords",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }
            StringRequest stringRequest = newPasswordRequest();
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        } //         else if (stateOfActivity.getName().equals("EnterPasswordState")) {
    }

    /**
        StringRequest object created for different states and different purposes
     */
    /**
     * StringRequest object when the key generation request is sent
     * @return StringRequest obj
     */
    private StringRequest generateKeyRequest() {
        return new StringRequest(Request.Method.POST, URL_GENKEY, response -> {
            if (response.equals("Message has been sent")) {
                restoreEnterKeyStatus();
                Toast.makeText(PasswordResetActivity.this, "Message sent", Toast.LENGTH_SHORT).show();
            } else {
                Log.e("PASSWORD_RESET_ACTIVITY", response);
            }
        }, (error) -> {
            error.printStackTrace();
            Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
        }){
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> data = new HashMap<>();
                data.put("email", txtEmail.getText().toString());
                return data;
            }
        };
    } //     private StringRequest generateKeyRequest() {

    /**
     * StringRequest object when the key is supposed to be validated
     * @return StringRequest object
     */
    private StringRequest validateKeyRequest () {
        return new StringRequest(Request.Method.POST, URL_ENTERKEY, response -> {
            if (response.equals("SUCCESS")) {
                restoreEnterPasswordState();
                Toast.makeText(PasswordResetActivity.this, "Key Validated", Toast.LENGTH_SHORT).show();
            } else {
                Log.e("PASSWORD_RESET_ACTIVITY", response);
                Toast.makeText(PasswordResetActivity.this, "Wrong Key", Toast.LENGTH_SHORT).show();
            }
        }, (error) -> {
            error.printStackTrace();
            Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
        }){
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> data = new HashMap<>();
                data.put("email", txtEmail.getText().toString());
                data.put("key", txtKey.getText().toString());
                return data;
            }
        };
    } //     private StringRequest validateKeyRequest () {

    /**
     * StringRequest object when new password is entered
     * @return StringRequest object
     */
    private StringRequest newPasswordRequest() {
        return new StringRequest(Request.Method.POST, URL_NEWPASSWORD, response -> {
            if (response.equals("SUCCESS")) {
                Toast.makeText(PasswordResetActivity.this, "Password Updated", Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // head over to the login screen
                startActivity(
                        new Intent(PasswordResetActivity.this, MainActivity.class)
                );
            } else {
                Log.e("PASSWORD_RESET_ACTIVITY", response);
                Toast.makeText(PasswordResetActivity.this, "Cannot update password. Please try again later.", Toast.LENGTH_SHORT).show();
            }
        }, (error) -> {
            error.printStackTrace();
            Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
        }){
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> data = new HashMap<>();
                data.put("email", txtEmail.getText().toString());
                data.put("password", txtPassword.getText().toString());
                return data;
            }
        };

    } //     private StringRequest newPasswordRequest() {
}