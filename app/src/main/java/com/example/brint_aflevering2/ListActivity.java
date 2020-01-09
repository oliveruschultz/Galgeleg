package com.example.brint_aflevering2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String ordListe[] = new String[Galgelogik.muligeOrd.size()];
        for (int i = 0; i < ordListe.length; i++) {
            ordListe[i] = Galgelogik.muligeOrd.get(i);
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ordListe);

        ListView listView = new ListView(this);
        listView.setOnItemClickListener(this);
        listView.setAdapter(arrayAdapter);

        setContentView(listView);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

}
