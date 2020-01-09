package com.example.brint_aflevering2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class WinningActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView antalGæt;
    private Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);
        Bundle b = getIntent().getExtras();

        antalGæt = findViewById(R.id.antalGæt);
        antalGæt.setText("Ordet var " + b.getString("winningWord") + "\nDu brugte " + Integer.toString(b.getInt("antalGæt")) + " gæt");

        restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener (this);

            }

    @Override
    public void onClick(View v) {
        finish();

    }
}
