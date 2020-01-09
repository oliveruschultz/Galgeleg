package com.example.brint_aflevering2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class WinningActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView winningWord, winningText, antalGæt;
    private Button restartButton;
    private int fejl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);
        Bundle b = getIntent().getExtras();

        winningText = findViewById(R.id.winningText);

        winningWord = findViewById(R.id.winningWord);
        winningWord.setText (b.getString("winningWord"));

        antalGæt = findViewById(R.id.antalGæt);
        antalGæt.setText("Ordet var " + b.getString("winningWord") + " , du brugte " + Integer.toString(b.getInt("antalGæt")) + " gæt");


        restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener (this);

            }

    @Override
    public void onClick(View v) {
        finish();

    }
}
