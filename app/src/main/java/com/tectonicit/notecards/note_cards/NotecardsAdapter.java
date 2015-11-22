package com.tectonicit.notecards.note_cards;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NotecardsAdapter extends ArrayAdapter<Notecards> {
    Context context;
    int layoutResourceId;
    Notecards data[] = null;

    public NotecardsAdapter(Context context, int layoutResourceId, Notecards[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View rowView = inflater.inflate(layoutResourceId, parent, false);

        ImageView icon = (ImageView)rowView.findViewById(R.id.icon);
        TextView title = (TextView)rowView.findViewById(R.id.title);
        TextView description = (TextView)rowView.findViewById(R.id.description);

        Notecards notecard = data[position];
        icon.setImageResource(notecard.icon);
        title.setText(notecard.title);
        description.setText(notecard.description);

        return rowView;
    }
}
