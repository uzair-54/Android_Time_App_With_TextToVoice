package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LaunchActivity extends AppCompatActivity {

    TextView min,sec;
    Button mainBtn;
    static int mins,secs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        min = (TextView) findViewById(R.id.min);
        sec = (TextView) findViewById(R.id.sec);
        mainBtn = (Button) findViewById(R.id.button);

        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String temp = min.getText().toString().replaceAll("\\s", "");
                mins = Integer.parseInt(temp);

                String temp2 = sec.getText().toString().replaceAll("\\s", "");
                secs = Integer.parseInt(temp2);

                Intent myInt = new Intent(LaunchActivity.this,MainActivity.class);
                LaunchActivity.this.startActivity(myInt);
            }
        });
    }
}