package com.zoutexlexba.miage.tpandroid;

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
    public int nbCoups = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.resultat = randomGenerator.nextInt(100);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        this.nbCoups++;
        this.replaceTextView(R.id.nbCoups,Integer.toString(this.nbCoups));

        EditText userInput =  (EditText) findViewById(R.id.response);
        int userValue = Integer.parseInt(userInput.getText().toString());
        TextView resultatView = (TextView)findViewById(R.id.resultat);

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
        this.resultat = randomGenerator.nextInt(100);
        this.nbCoups = 0;

        this.replaceTextView(R.id.resultat, "");
        this.replaceTextView(R.id.nbCoups, Integer.toString(this.nbCoups));

        Button playButton = (Button) findViewById(R.id.playGame);
        playButton.setEnabled(true);
    }

    public void replaceTextView(int id, String text) {
        TextView textView = (TextView) findViewById(id);
        textView.setText(text);
    }
}
