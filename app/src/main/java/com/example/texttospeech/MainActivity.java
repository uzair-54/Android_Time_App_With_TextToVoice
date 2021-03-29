package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {


    TextView counter;
    int sec = LaunchActivity.secs;
    int min = LaunchActivity.mins;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new TextToSpeech(this,this);

        counter = (TextView) findViewById(R.id.counterScreen);
        counter.setText("0" + Integer.toString(min) +":0"+Integer.toString(sec));

        int totMilis = ((min * 60) + sec) * 1000;
        CountDownTimer cnt = new CountDownTimer(totMilis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sec--;
                if (sec <= 9){
                    counter.setText("0" + Integer.toString(min) +":0"+Integer.toString(sec));
                }
                else{
                    counter.setText("0" + Integer.toString(min) +":"+Integer.toString(sec));
                 }
                if (sec == 00){
                    min--;
                    sec = 60;
                    counter.setText("0" + Integer.toString(min) +":"+Integer.toString(sec));
                }
                if (sec % 5 == 0) {
                    String text = Integer.toString(min) + " minute" + Integer.toString(sec) + " second";
                    tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                }
            }

            @Override
            public void onFinish() {
                tts.speak("Timer Finished", TextToSpeech.QUEUE_FLUSH, null);
            }
        };
        cnt.start();
    }

    @Override
    public void onInit(int status) {
        int r = tts.setLanguage(Locale.ENGLISH);
    }
}