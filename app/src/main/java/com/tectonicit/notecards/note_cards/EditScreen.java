package com.tectonicit.notecards.note_cards;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Vector;

public class EditScreen extends AppCompatActivity {

    private String name;
    private String description;
    private String cost;
    private String length;
    private String imageLoc;
    private Bitmap image;
    private Bitmap imageDefault;
    EditText nameBox;
    EditText costBox;
    //private Vector<String> data=new Vector<String>(5);
    public static final int GET_FROM_GALLERY = 3;
    ImageView imageView;
    EditText descriptionBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);
        Button saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToViewScreen();
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
                length="Medium";
            }
        });
        final RadioButton radLong = (RadioButton)findViewById(R.id.radLong);
        radLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                length="Long";
            }
        });
        nameBox =  (EditText) findViewById(R.id.nameBox);
        descriptionBox =  (EditText) findViewById(R.id.descriptionBox);
        //description=descriptionBox.getText().toString();
        costBox =  (EditText) findViewById(R.id.costBox);
        //cost= costBox.getText().toString();
        /*ImageView */imageView=(ImageView) findViewById(R.id.imageView);
        image=((BitmapDrawable)imageView.getDrawable()).getBitmap();
        //imageView.setImageBitmap(image);
        Button galleryButton = (Button) findViewById(R.id.galleryButton);
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //Detects request codes
        if(requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            try {
                image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                imageView.setImageBitmap(image);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    private void goToViewScreen(){
        saveData();
        Intent intent= new Intent(this, ViewScreen.class);
        Bundle b=new Bundle();
        b.putStringArray("key", new String[]{name, description,cost,length,imageLoc});
        intent.putExtras(b);
        startActivity(intent);
    }
    private void saveData() {
        //change array values and write to file(clear 1st)
        name=nameBox.getText().toString();
        description=descriptionBox.getText().toString();
        cost= costBox.getText().toString();
        imageLoc=saveImage(image);


        //goToViewScreen();
    }
    private String saveImage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"picture.jpg");

        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream(mypath);

            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return directory.getAbsolutePath();
    }
    private void openGallery(){
        startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
    }
}
