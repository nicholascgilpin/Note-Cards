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
import java.util.Vector;

public class ViewScreen extends AppCompatActivity {
    private String name;
    private String description;
    private String cost;
    private String length;
    private String imageName="picture.jpg";//"ic_notifications_black_24dp.png";
    private String imageLoc;
    private Bitmap image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_screen);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //loadData();
        Bundle b=this.getIntent().getExtras();
        String[] data=b.getStringArray("key");
        name= data[0];
        description=data[1];
        cost=data[2];
        length= data[3];
        imageLoc= data[4];
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
        nameBox.setText(name);  //Load title from Notecard class
        TextView costBox = (TextView)findViewById(R.id.costBox);
        costBox.setText(cost);
        TextView descriptionBox = (TextView)findViewById(R.id.descriptionBox);
        descriptionBox.setText(description);
        TextView lengthBox = (TextView)findViewById(R.id.lengthBox);
        lengthBox.setText(length);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageBitmap(image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomIn();
            }
        });
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
    private void zoomIn(){
        Intent intent = new Intent(this,PictureScreen.class);
        intent.putExtra("BitmapImage",image);
        startActivity(intent);
    }

}
