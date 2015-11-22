package com.tectonicit.notecards.note_cards;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, EditScreen.class);
                startActivity(intent);
            }
        });

        final Notecards object_data[] = new Notecards[]{
                new Notecards(R.drawable.ic_info_black_24dp, "File 1", "The first file on the list"),
                new Notecards(R.drawable.ic_info_black_24dp, "File 2", "The second file on the list"),
                new Notecards(R.drawable.ic_info_black_24dp, "File 3", "The third file on the list"),
                new Notecards(R.drawable.ic_info_black_24dp, "File 4", "The fourth file on the list"),
                new Notecards(R.drawable.ic_info_black_24dp, "File 5", "The fifth file on the list"),
                new Notecards(R.drawable.ic_info_black_24dp, "File 6", "The sixth file on the list"),
                new Notecards(R.drawable.ic_info_black_24dp, "File 7", "The seventh file on the list"),
                new Notecards(R.drawable.ic_info_black_24dp, "File 8", "The eighth file on the list"),
                new Notecards(R.drawable.ic_info_black_24dp, "File 9", "The ninth file on the list"),
                new Notecards(R.drawable.ic_info_black_24dp, "File 10", "The tenth file on the list"),
                new Notecards(R.drawable.ic_info_black_24dp, "File 11", "The eleventh file on the list"),
        };

        NotecardsAdapter adapter = new NotecardsAdapter(this, R.layout.listview_notecard_row, object_data);

        listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeScreen.this, ViewScreen.class);
                startActivity(intent);
            }
        });
    }

}
