package com.example.brint_aflevering2;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Galgelogik spil = new Galgelogik();
    private EditText gæt;
    private Button knap1, givOp, genstart, knapDR, listeKnap;
    private TextView ord, tvBrugteBogstaver,textViewW,textViewL;
    private ImageView imageView;
    int wincounter, losscounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        spil.nulstil();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gæt = findViewById(R.id.editText);
        ord = findViewById(R.id.textView2);
        tvBrugteBogstaver = findViewById(R.id.textView3);
        textViewW = findViewById(R.id.textViewW);
        textViewL = findViewById(R.id.textViewL);
        imageView = findViewById(R.id.imageView);

        knap1 = findViewById(R.id.button1);
        knap1.setOnClickListener(this);
        givOp = findViewById(R.id.button2);
        givOp.setOnClickListener(this);
        genstart = findViewById(R.id.button3);
        genstart.setOnClickListener(this);
        knapDR = findViewById(R.id.button4);
        knapDR.setOnClickListener(this);
        listeKnap = findViewById(R.id.button5);
        listeKnap.setOnClickListener(this);


        ord.setText(spil.getSynligtOrd());

    }

    @Override
    public void onClick(View v) {
        if (v == knap1) {

            spil.gætBogstav(gæt.getText().toString());
            ord.setText(spil.getSynligtOrd());
            String currentWord = "";
            imageViewChanger();
            for (int i = 0; i < spil.getBrugteBogstaver().size(); i++) {
                currentWord = currentWord + "  " + spil.getBrugteBogstaver().get(i);

            }
            if (!spil.erSidsteBogstavKorrekt() && spil.getAntalForkerteBogstaver() < 6){
                if (spil.getAntalForkerteBogstaver()==1){
                    Toast.makeText(this,"Du har gættet forkert " + (spil.getAntalForkerteBogstaver())+ " gang.",Toast.LENGTH_SHORT).show();
                }
                else if (spil.getAntalForkerteBogstaver() > 1){
                    Toast.makeText(this,"Du har gættet forkert " + (spil.getAntalForkerteBogstaver())+ " gange.",Toast.LENGTH_SHORT).show();
                }
            }
            else if (spil.erSidsteBogstavKorrekt() && !spil.erSpilletVundet()){
                Toast.makeText(this,"Du gættede rigtigt: '" + gæt.getText().toString().toUpperCase() + "' indgår i ordet",Toast.LENGTH_SHORT).show();
            }
            else if (spil.erSpilletVundet()) {
                Intent winIntent = new Intent(this, WinningActivity.class);
                winIntent.putExtra("winningWord",spil.getOrdet());
                winIntent.putExtra("antalGæt",spil.getBrugteBogstaver().size());
                startActivity(winIntent);
                 wincounter++;
                 genstart.setVisibility(View.VISIBLE);
                 textViewW.setText("W = " + wincounter);
             }
            else if (spil.erSpilletTabt()){
                Intent loseIntent = new Intent(this, LosingActivity.class);
                loseIntent.putExtra("losingWord",spil.getOrdet());
                startActivity(loseIntent);
                     losscounter++;
                     genstart.setVisibility(View.VISIBLE);
                     textViewL.setText("L = "+losscounter);
            }
            tvBrugteBogstaver.setText(currentWord);

        } else if (v == givOp) {
            Intent loseIntent = new Intent(this, LosingActivity.class);
            losscounter++;
            genstart.setVisibility(View.VISIBLE);
            textViewL.setText("L = "+losscounter);
            loseIntent.putExtra("losingWord",spil.getOrdet());
            startActivity(loseIntent);

        } else if (v == genstart) {
            spil.nulstil();
            imageViewChanger();
            genstart.setVisibility(View.INVISIBLE);
            ord.setText(spil.getSynligtOrd());
            tvBrugteBogstaver.setText("");
            Toast.makeText(this, "Du har genstartet spillet", Toast.LENGTH_SHORT).show();
        } else if (v == knapDR){
            new AsyncTask() {
                @Override
                protected Object doInBackground(Object... arg0) {
                    try {
                        spil.hentOrdFraDr();
                        return "Success";
                    } catch (Exception e) {
                        e.printStackTrace();
                        return "Fail: " + e;
                    }
                }

                @Override
                protected void onPostExecute(Object result) {
                    knapDR.setText(result.toString());
                    ord.setText(spil.getSynligtOrd());
                    tvBrugteBogstaver.setText("");
                    imageViewChanger();
                    final Handler handler = new Handler ();
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            knapDR.setText("nyt DR ord");
                        }
                    }, 5000);
                }
            }.execute();
            Toast.makeText(this, "DR ord hentet", Toast.LENGTH_SHORT).show();

        } else if (v == listeKnap) {
            Intent wordListIntet = new Intent(this, ListActivity.class);
            startActivity(wordListIntet);
        }

        gæt.setText("");
    }



    public int antalForkerteGæt () {
        return spil.getAntalForkerteBogstaver();
    }


    public void imageViewChanger(){
        if (spil.getAntalForkerteBogstaver() == 0){
            imageView.setImageResource(R.drawable.galge);
        }

        if(spil.getAntalForkerteBogstaver() == 1){
            imageView.setImageResource(R.drawable.forkert1);
        }
        if(spil.getAntalForkerteBogstaver() == 2){
            imageView.setImageResource(R.drawable.forkert2);
        }
        if(spil.getAntalForkerteBogstaver() == 3){
            imageView.setImageResource(R.drawable.forkert3);
        }
        if(spil.getAntalForkerteBogstaver() == 4){
            imageView.setImageResource(R.drawable.forkert4);
        }
        if(spil.getAntalForkerteBogstaver() == 5){
            imageView.setImageResource(R.drawable.forkert5);
        }
        if(spil.getAntalForkerteBogstaver() == 6){
            imageView.setImageResource(R.drawable.forkert6);
        }
    }

}

