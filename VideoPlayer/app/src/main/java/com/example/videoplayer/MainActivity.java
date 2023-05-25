package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    String[] genres;
    public int val;
    public ListView listView;
    public ArrayList<Genre> gens = new ArrayList<Genre>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        genres = getResources().getStringArray(R.array.genres);
        gens.add(0, new Genre(genres[0], R.drawable.adventuree));
        gens.add(1, new Genre(genres[1], R.drawable.drama));
        gens.add(2, new Genre(genres[2], R.drawable.comedy));
        gens.add(3, new Genre(genres[3], R.drawable.scifi));
        TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("Genres");
        textView.setTextSize(27);
        textView.setGravity(Gravity.CENTER);
        listView = (ListView)findViewById(R.id.listview);
        listView.addHeaderView(textView);
        GenreAdapter genreAdapter = new GenreAdapter(this, gens);
        listView.setAdapter(genreAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Genre source = (Genre) parent.getItemAtPosition(position);
                for (int i = 0; i < 4; i++){
                    if (source.gen == genres[i]){
                       val = i;
                    }
                }
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("gen", val);
                startActivity(i);
            }
        });
    }
}