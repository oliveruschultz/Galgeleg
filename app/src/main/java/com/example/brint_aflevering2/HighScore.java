package com.example.brint_aflevering2;
//inspiration fra https://www.youtube.com/watch?v=WYWsVJTmWbY
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HighScore extends AppCompatActivity implements View.OnClickListener {

    private Button tilbage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        tilbage = findViewById(R.id.tilbage);
        tilbage.setOnClickListener (this);

        TextView score = (TextView) findViewById(R.id.score);
        TextView highScore = (TextView) findViewById(R.id.highScore);

        int newScore = getIntent().getIntExtra("Score",0);
        score.setText(newScore + "");

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int newHighScore = settings.getInt("HIGH_SCORE", 0);

        if (newScore > newHighScore){
            highScore.setText("High Score: "+ newScore);

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", newScore);
            editor.commit();

        } else{
            highScore.setText("High Score: " + newHighScore);
        }

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
