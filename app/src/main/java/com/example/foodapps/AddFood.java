package com.example.foodapps;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddFood extends AppCompatActivity {

    private ImageButton foodImage;
    private static final int GALLREQ=1;
    private EditText name,desc,price;
    private Uri uri = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        name = (EditText) findViewById(R.id.itemName);
        desc = (EditText) findViewById(R.id.itemDesc);
        price = (EditText) findViewById(R.id.itemPrice);
    }

    public void imageButtonClick(View view){
        Intent galeryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galeryIntent.setType("image/*");
        startActivityForResult(galeryIntent,GALLREQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLREQ && requestCode==RESULT_OK){
             uri=data.getData();
             foodImage=(ImageButton)findViewById(R.id.foodImageButton);
             foodImage.setImageURI(uri);
        }
    }
}
