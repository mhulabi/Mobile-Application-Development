package com.example.videoplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie> {
    private ArrayList<Movie> movies;
    private Activity context;

    public MovieAdapter(Activity context, ArrayList<Movie> mov) {
        super(context, R.layout.row_item, mov);
        this.context = context;
        this.movies = mov;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_item2, null, true);
        TextView textView = (TextView) row.findViewById(R.id.textViewItem2);
        TextView textView2 = (TextView) row.findViewById(R.id.textViewItem3);
        textView.setText(movie.name);
        textView2.setText(movie.time);
        return  row;
    }
}

