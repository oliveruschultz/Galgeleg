package com.example.brint_aflevering2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class WinningActivity extends AppCompatActivity {

    private TextView winningWord, winningText, antalGæt;
    private Button restartButton;
    private String winningWordString,winningTextString;
    private int fejl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);
        Bundle b = getIntent().getExtras();
        winningWordString = "Ordet var: \n" + b.getString("ord");
        fejl = b.getInt("fejl");
        winningTextString = "Du har vundet!\nMed kun " + fejl + " fejl!";
        String winningWordString = b.getString("winningWord");

        winningText = findViewById(R.id.winningText);
        winningText.setText("Du har vundet \nOrdet var:");

        winningWord = findViewById(R.id.winningWord);
        winningWord.setText (winningWordString);


        restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener ((View.OnClickListener) this);

            }
}
