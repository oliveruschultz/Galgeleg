package com.example.brint_aflevering2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity implements View.OnClickListener{

    Button knap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        knap = findViewById(R.id.button);
        knap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openMainActivity();
            }
        });
    }
    private void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public void onClick(View v){

    }
}
