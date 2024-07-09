package com.example.smartproperty;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class your_property_activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private your_property_adapter adapter;
    private List<your_property_model> propertyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_your_property);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.yourPropertyMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        propertyList = generateRandomProperties(5);
        adapter = new your_property_adapter(this, propertyList);
        Toolbar toolbar=findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.property_recycler_view); // Initialize recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private List<your_property_model> generateRandomProperties(int count){
        List<your_property_model> propertyList =new ArrayList<>();
        Random random=new Random();

        String[] titles = {
                "Luxury Apartment in Downtown",
                "Spacious Villa with Garden",
                "Modern Townhouse with Garage",
                "Cozy Studio in Urban Setting",
                "Family Home near Schools",
        };

        String[] descriptions = {
                "Beautifully designed apartment with panoramic views of the city skyline.",
                "Large villa featuring multiple bedrooms, garden, and swimming pool, 6 bed rooms with attache bathroom.",
                "Newly built townhouse with modern amenities and private garage.",
                "Compact studio apartment perfect for young professionals.",
                "Ideal family home with spacious rooms and close proximity to schools.",
        };

        String[] demands = {
                "400,000 PKR",
                "650,000 PKR",
                "500,000 PKR",
                "300,000 PKR",
                "550,000 PKR",
        };

        String[] locations = {
                "Downtown, Islamabad",
                "Bahria Town, Lahore",
                "Clifton, Karachi",
                "F-10, Islamabad",
                "Gulberg, Lahore",
        };

        String[] type={
                "Rent",
                "Sell",
                "Rent",
                "Sell",
                "Rent",
        };

        int[] images = {
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
        };

        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(titles.length);
            your_property_model property = new your_property_model(
                    titles[randomIndex],
                    descriptions[randomIndex],
                    images[randomIndex % images.length],
                    demands[randomIndex],
                    locations[randomIndex],
                    type[randomIndex]
            );
            propertyList.add(property);
        }

        return propertyList;
    }
}