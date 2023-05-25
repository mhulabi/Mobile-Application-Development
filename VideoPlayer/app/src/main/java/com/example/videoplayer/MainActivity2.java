package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity{
    String[]name, url, time, genres;
    String s;
    private ArrayList<Movie> movs = new ArrayList<Movie>(4);
    public int val, val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        url = getResources().getStringArray(R.array.urls);
        name = getResources().getStringArray(R.array.names);
        time = getResources().getStringArray(R.array.time);
        genres = getResources().getStringArray(R.array.genres);
        Intent intent = getIntent();
        val = intent.getIntExtra("gen", 0);
        if (val == 0){
            movs.add(0, new Movie(name[0], url[0], time[0]));
            movs.add(1, new Movie(name[1], url[1], time[1]));
            movs.add(2, new Movie(name[2], url[2], time[2]));
            movs.add(3, new Movie(name[3], url[3], time[3]));
        }
        else if (val == 1){
            movs.add(0, new Movie(name[4], url[4], time[4]));
            movs.add(1, new Movie(name[5], url[5], time[5]));
            movs.add(2, new Movie(name[6], url[6], time[6]));

        }
        else if (val == 2){
            movs.add(0, new Movie(name[7], url[7], time[7]));
            movs.add(1, new Movie(name[8], url[8], time[8]));
            movs.add(2, new Movie(name[9], url[9], time[9]));

        }
        else{
            movs.add(0, new Movie(name[10], url[10], time[10]));
            movs.add(1, new Movie(name[11], url[11], time[11]));
            movs.add(2, new Movie(name[12], url[12], time[12]));
        }
        TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText(genres[val]);
        textView.setTextSize(27);
        textView.setGravity(Gravity.CENTER);
        ListView listView = (ListView)findViewById(R.id.listview2);
        listView.addHeaderView(textView);
        listView.setClickable(true);
        MovieAdapter movieAdapter = new MovieAdapter(this, movs);
        listView.setAdapter(movieAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie source = (Movie) parent.getItemAtPosition(position);
                Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                Bundle bundle = new Bundle();
                bundle.putString("ar", source.URL);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }

}