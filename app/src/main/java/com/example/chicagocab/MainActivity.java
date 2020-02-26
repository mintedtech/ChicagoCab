package com.example.chicagocab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private double perMile = 3.25;
    private double initialFee = 3.00;

    private EditText milesInput;
    private Button button;
    private View SB_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get a handle to the Activity_Main XML
        SB_View = findViewById(R.id.activity_main);

        // Get a handle to the EditText
        milesInput = findViewById(R.id.miles);

        // Get a handle to the button
        button = findViewById(R.id.button);

        // set the listener on the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the String of what the user had entered
                String milesDrivenString = milesInput.getText().toString();
                // Convert that String to a double
                double milesDriven = Double.parseDouble(milesDrivenString);

                // calculate the total fee including the initial charge
                double mileageCharge = milesDriven * perMile;
                double totalFee = initialFee + mileageCharge;

                // Put it all together in one message
                String msg = "Initial Fee: $" + initialFee + "; Miles Driven: " + milesDriven +
                        "; Per Mile: " + perMile + "; Mileage Charge: " + mileageCharge +
                        "; Total fee is: $" + totalFee;

                // Hide the keyboard, if it is shown
                InputMethodManager imm =
                        (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(SB_View.getWindowToken(),0);

                // output! - Snackbar is in Google's Material library (can add in Project Structure)
                Snackbar.make(SB_View, msg, Snackbar.LENGTH_INDEFINITE).show();
            }
        });


    }
}
