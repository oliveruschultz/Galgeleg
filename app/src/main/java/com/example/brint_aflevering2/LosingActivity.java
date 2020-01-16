package com.example.brint_aflevering2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LosingActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView losingWord, losingText, numberOfTries;
    private Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losing);
        Bundle b = getIntent().getExtras();
        String losingWordString = b.getString("losingWord");
        
        numberOfTries =findViewById(R.id.numberOfTries);
        numberOfTries.setText("");

        losingText = findViewById(R.id.losingText);
        losingText.setText("Du har tabt, ordet var:");

        losingWord = findViewById(R.id.losingWord);
        losingWord.setText (losingWordString);

        restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(this);

        playLossSound();

    }

    public void playLossSound() {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.loosesound);
        mp.start();
    }

    @Override
    public void onClick(View v) {
    finish();
    }

}
