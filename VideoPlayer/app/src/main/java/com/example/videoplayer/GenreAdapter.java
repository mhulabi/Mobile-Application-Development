package com.example.videoplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GenreAdapter extends ArrayAdapter<Genre> {
        private ArrayList<Genre> genres;
        private Activity context;

        public GenreAdapter(Activity context, ArrayList<Genre> gens) {
            super(context, R.layout.row_item, gens);
            this.context = context;
            this.genres = gens;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Genre genre = getItem(position);
            View row = convertView;
            LayoutInflater inflater = context.getLayoutInflater();
            if(convertView==null)
                row = inflater.inflate(R.layout.row_item, null, true);
            TextView textView = (TextView) row.findViewById(R.id.textViewItem);
            ImageView imageTh = (ImageView) row.findViewById(R.id.imageView);
            textView.setText(genre.gen);
            imageTh.setImageResource(genre.image);
            return  row;
        }
    }

