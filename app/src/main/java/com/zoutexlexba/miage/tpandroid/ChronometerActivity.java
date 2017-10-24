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
    //Start the chrono at timeWhenStopped
    public void playChrono(View view) {
        //Retrieve the chronometer by his ID.
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        //Setting the time base
        chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
        chronometer.start();

        //"Switch" the button
        this.enableButton(R.id.playChrono,false);
        this.enableButton(R.id.stopChrono,true);
    }
    //Stop the chrono at timeWhenStopped
    public void stopChrono(View view) {
        timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
        chronometer.stop();

        //"Switch" the button
        this.enableButton(R.id.playChrono,true);
        this.enableButton(R.id.stopChrono,false);
    }
    //Set chrono to 00:00:00
    public void resetChrono(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        timeWhenStopped = 0;

        //Display both buttons
        this.enableButton(R.id.playChrono,true);
        this.enableButton(R.id.stopChrono,true);
    }

    //Start the next activity: displaying a web page
    public void displayWebViewActivity(View view) {
        Intent intent = new Intent(this,WebViewActivity.class);
        startActivity(intent);
    }
    
    //Enable the given button
    private void enableButton(int id, boolean enable) {
        Button button = (Button) findViewById(id);
        button.setEnabled(enable);
    }
}
