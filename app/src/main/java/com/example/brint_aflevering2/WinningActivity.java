package com.example.brint_aflevering2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;


public class WinningActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView antalGæt, winAnimation;
    private Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);
        Bundle b = getIntent().getExtras();

        winAnimation = findViewById(R.id.textViewGz);

        antalGæt = findViewById(R.id.antalGæt);
        antalGæt.setText("Ordet var " + b.getString("winningWord") + "\nDu brugte " + Integer.toString(b.getInt("antalGæt")) + " gæt");

        restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener (this);
        turnOnTextBlink();
        playWinSound();
    }


    public void playWinSound() {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.winsound);
        mp.start();
    }

    @Override
    public void onClick(View v) {
        finish();

    }

    // @author: Lånt fra Clockradio-projekt.
    public void turnOnTextBlink() {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        winAnimation.startAnimation(anim);
    }
}
