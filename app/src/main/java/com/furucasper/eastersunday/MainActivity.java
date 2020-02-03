package com.furucasper.eastersunday;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText year;
    private Button btnCheck;
    static String eggday;
    static String aYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        year = findViewById(R.id.inYear);
        btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aYear = year.getText().toString();
                if (aYear.length()<=4){
                    if (TextUtils.isEmpty(aYear)) {
                        Toast.makeText(getApplicationContext(), "Enter Year", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    int y = Integer.parseInt(aYear);

                    if (y==0){
                        Toast.makeText(getApplicationContext(), "Year is not correct, input again.", Toast.LENGTH_SHORT).show();
                        year.setText("");
                        return;
                    }

                    EasterSunday est = new EasterSunday(y);
                    eggday = est.check();
                    startActivity(new Intent(MainActivity.this, EasterShow.class));
                    year.setText("");

                }else {
                    Toast.makeText(getApplicationContext(), "Year is not correct, input again.", Toast.LENGTH_SHORT).show();
                    year.setText("");
                }
            }
        });

        year.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    //do what you want on the press of 'done'
                    btnCheck.performClick();
                }
                return false;
            }
        });
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
