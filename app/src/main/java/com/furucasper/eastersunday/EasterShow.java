package com.furucasper.eastersunday;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EasterShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easter_show);

        TextView easterday = findViewById(R.id.easterday);
        easterday.setText(MainActivity.eggday);

        TextView myYear = findViewById(R.id.aYear);
        myYear.setText(MainActivity.aYear);

        Button back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
        }
        });
    }
}
