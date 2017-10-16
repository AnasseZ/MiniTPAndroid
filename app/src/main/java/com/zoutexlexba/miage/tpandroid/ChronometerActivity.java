package com.zoutexlexba.miage.tpandroid;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class ChronometerActivity extends AppCompatActivity {

    public Chronometer chronometer;
    public long timeWhenStopped = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);
    }

    public void playChrono(View view) {
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        chronometer.start();
    }

    public void stopChrono(View view) {
        timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
        chronometer.stop();
    }

    public void resetChrono(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        timeWhenStopped = 0;
    }
}
