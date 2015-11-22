package com.tectonicit.notecards.note_cards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ViewScreen extends AppCompatActivity {
    private String name;
    private String description;
    private String cost;
    private String length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
        setContentView(R.layout.activity_view_screen);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Button backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity();
            }
        });
        Button editButton = (Button)findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEditScreen();
            }
        });
        TextView nameBox = (TextView)findViewById(R.id.nameBox);
        nameBox.setText("Test");
        TextView costBox = (TextView)findViewById(R.id.costBox);
        nameBox.setText(cost);
        TextView descriptionBox = (TextView)findViewById(R.id.descriptionBox);
        nameBox.setText(description);
        TextView lengthBox = (TextView)findViewById(R.id.lengthBox);
        nameBox.setText(length);
    }
    private void goToMainActivity(){
        Intent intent= new Intent(this,HomeScreen.class);
        startActivity(intent);
    }
    private void goToEditScreen(){
        Intent intent= new Intent(this,EditScreen.class);
        startActivity(intent);
    }
    private void loadData(){
        try {
            FileInputStream fstream = new FileInputStream("savedCards.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            name=br.readLine();
            description=br.readLine();
            cost=br.readLine();
            length=br.readLine();
        }catch(Exception err){
            err.printStackTrace();
        }
    }

}
