package com.zoutexlexba.miage.tpandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int resultat;
    public  Random randomGenerator = new Random();
    // This is to count the number of time the player tries a number
    public int nbCoups = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.resultat = randomGenerator.nextInt(100);
        setContentView(R.layout.activity_main);
    }
    
    //Listener function --> When player clicks on the screen and enters his result
    public void onClick(View view) {
        this.nbCoups++;
        // Update nbCoups and display it 
        this.replaceTextView(R.id.nbCoups,Integer.toString(this.nbCoups));
    
        EditText userInput =  (EditText) findViewById(R.id.response);
        int userValue = Integer.parseInt(userInput.getText().toString());
        TextView resultatView = (TextView)findViewById(R.id.resultat);
        
        // Victory condition
        if (userValue == resultat ) {
            resultatView.setText("Bravo vous avez gagné !\n"
            + "Le résultat était : " + resultat);

            Button playButton = (Button) findViewById(R.id.playGame);
            playButton.setEnabled(false);
        } else if (userValue < resultat) {
            resultatView.setText("Plus grand !");
        } else if (userValue > resultat) {
            resultatView.setText("Plus petit !");
        }
    }

    public void replayGame(View view) {
        //Reset all used variables
        this.resultat = randomGenerator.nextInt(100);
        this.nbCoups = 0;

        //Reset text fields
        this.replaceTextView(R.id.resultat, "");
        this.replaceTextView(R.id.nbCoups, Integer.toString(this.nbCoups));

        //Find the right playButton and enable it so players can replay
        Button playButton = (Button) findViewById(R.id.playGame);
        playButton.setEnabled(true);
    }

    public void replaceTextView(int id, String text) {
        //Update textView with text
        TextView textView = (TextView) findViewById(id);
        textView.setText(text);
    }

    public void nextGame(View view) {
        Intent intent = new Intent(this,ChronometerActivity.class);
        startActivity(intent);
    }
}
