package com.example.smartproperty;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class support_help_activity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText inputDetail;
    private MaterialButton submitButton;
    private ImageView screenShot;

    private final int GALLERY_REQ_CODE=1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_support_help);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.toolbar);
        inputDetail = findViewById(R.id.input_detail);
        submitButton = findViewById(R.id.submit_button);
        screenShot = findViewById(R.id.image_view_screenshot);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
            }
        });

        screenShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent igallery=new Intent(Intent.ACTION_PICK);
                igallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(igallery,GALLERY_REQ_CODE);            }
        });
    }


    protected  void onActivityResult(int request_code,int result_code, Intent data){
        super.onActivityResult(request_code, result_code, data);

        if (result_code==RESULT_OK){
            if (request_code==GALLERY_REQ_CODE){
                screenShot.setImageURI(data.getData());
            }
        }
    }
}