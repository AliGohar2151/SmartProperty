package com.example.smartproperty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

public class selected_property_activity extends AppCompatActivity {

    private TextView txtTitle,txtDescription,txtDemand, txtLocation, txtType, propertySelectedType, propertyType, propertyArea, propertyAreaType, rooms, bathrooms, email, phone;
    private ImageCarousel imageCarousel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selected_property);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        txtDemand = findViewById(R.id.txt_demand);
        txtLocation = findViewById(R.id.txt_location);
        txtType = findViewById(R.id.txt_type);
        txtTitle=findViewById(R.id.txt_title);
        txtDescription=findViewById(R.id.txt_description);
        propertySelectedType = findViewById(R.id.property_selected_type);
        propertyType = findViewById(R.id.property_type);
        propertyArea = findViewById(R.id.property_area);
        propertyAreaType = findViewById(R.id.property_area_type);
        rooms = findViewById(R.id.rooms);
        bathrooms = findViewById(R.id.bathrooms);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);

        imageCarousel=findViewById(R.id.image_carousel);

        imageCarousel.addData(new CarouselItem(R.drawable.project_placeholder));
        imageCarousel.addData(new CarouselItem(R.drawable.project_placeholder));
        imageCarousel.addData(new CarouselItem(R.drawable.project_placeholder));

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String demand = intent.getStringExtra("demand");
        String location = intent.getStringExtra("location");
        String type = intent.getStringExtra("type");

        txtTitle.setText(title);
        txtDescription.setText(description);
        txtDemand.setText(demand);
        txtLocation.setText(location);
        txtType.setText(type);
        propertySelectedType.setText("Home");
        propertyType.setText("Upper Portion");
        propertyArea.setText("17.5");
        propertyAreaType.setText("Marla");
        rooms.setText("09");
        bathrooms.setText("02");
        email.setText("user123@gmail.com");
        phone.setText("+923128494878");


    }
}