package com.zoutexlexba.miage.tpandroid;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        this.enableButton(R.id.playChrono,false);
        this.enableButton(R.id.stopChrono,true);
    }

    public void stopChrono(View view) {
        timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
        chronometer.stop();

        this.enableButton(R.id.playChrono,true);
        this.enableButton(R.id.stopChrono,false);
    }

    public void resetChrono(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        timeWhenStopped = 0;

        this.enableButton(R.id.playChrono,true);
        this.enableButton(R.id.stopChrono,true);
    }

    public void displayWebViewActivity(View view) {
        Intent intent = new Intent(this,WebViewActivity.class);
        startActivity(intent);
    }

    private void enableButton(int id, boolean enable) {
        Button button = (Button) findViewById(id);
        button.setEnabled(enable);
    }
}
