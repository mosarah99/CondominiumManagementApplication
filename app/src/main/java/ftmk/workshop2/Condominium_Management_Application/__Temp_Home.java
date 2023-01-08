/**
 * Temporary home screen
 * @author Sadat
 * @since 1.0
 */


package ftmk.workshop2.Condominium_Management_Application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Temporary home screen. Placeholder.
 * @author Sadat
 * @since 1.0
 */
public class __Temp_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.__activity_temp_home);
    }

    /**
     * Go to Main Activity. Login Screen.
     * @param view
     */
    public void gotoLogin(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    /**
     * Go to Facilities settings
     * @param view
     */
    public void gotoFacilitiesSettings(View view) {
        startActivity(new Intent(this, FacilitiesSettingMenu.class));
    }
}