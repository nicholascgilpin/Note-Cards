package com.tectonicit.notecards.note_cards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.PrintWriter;

public class EditScreen extends AppCompatActivity {

    private String name;
    private String description;
    private String cost;
    private String length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);
        Button saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        final RadioButton radShort = (RadioButton)findViewById(R.id.radShort);
        radShort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                length="Short";
            }
        });
        final RadioButton radMed = (RadioButton)findViewById(R.id.radMed);
        radMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                length="Long";
            }
        });
        final RadioButton radLong = (RadioButton)findViewById(R.id.radLong);
        radLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                length="Long";
            }
        });
        final EditText nameBox =  (EditText) findViewById(R.id.nameBox);
        name=nameBox.getText().toString();
        final EditText descriptionBox =  (EditText) findViewById(R.id.descriptionBox);
        description=descriptionBox.getText().toString();
        final EditText costBox =  (EditText) findViewById(R.id.costBox);
        cost= costBox.getText().toString();
    }
    private void goToViewScreen(){
        Intent intent= new Intent(this, ViewScreen.class);
        startActivity(intent);
    }
    private void saveData() {
        try{
            PrintWriter out = new PrintWriter("savedCards.txt");
            out.write(name+"\r\n");
            out.write(description+"\r\n");
            out.write(cost+"\r\n");
            out.write(length+"\r\n");
            out.close();
        }catch(Exception err){
            err.printStackTrace();
        }
        goToViewScreen();
    }
}
