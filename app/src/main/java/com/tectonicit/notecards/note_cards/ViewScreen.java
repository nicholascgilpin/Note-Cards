package com.tectonicit.notecards.note_cards;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class ViewScreen extends AppCompatActivity {
    private String name;
    private String description;
    private String cost;
    private String length;
    private String imageName="ic_notifications_black_24dp.png";
    private String imageLoc;
    private Bitmap image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_screen);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //loadData();
        loadImage(imageLoc, imageName);
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
        nameBox.setText("Test Title");  //Load title from Notecard class
        TextView costBox = (TextView)findViewById(R.id.costBox);
        costBox.setText("404");
        TextView descriptionBox = (TextView)findViewById(R.id.descriptionBox);
        descriptionBox.setText("Test Description");
        TextView lengthBox = (TextView)findViewById(R.id.lengthBox);
        lengthBox.setText("Test Length");
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageBitmap(image);
    }
    private void goToMainActivity(){
        Intent intent= new Intent(this,EditScreen.class);   //change to main
        startActivity(intent);
    }
    private void goToEditScreen(){
        Intent intent= new Intent(this,EditScreen.class);
        startActivity(intent);
    }
    private void loadImage(String path, String imageName)
    {
        try {
            File f=new File(path, imageName);
            image = BitmapFactory.decodeStream(new FileInputStream(f));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

}
