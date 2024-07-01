package com.example.smartproperty;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;




public class add_property_activity extends AppCompatActivity {
    private final int GALLERY_REQ_CODE=1000;

    private ChipGroup homesTypeChipGroup;
    private ChipGroup plotsTypeChipGroup;
    private ChipGroup commercialTypeChipGroup;
    TextInputEditText cityEditText;
    bottomsheet_fragment bottomsheetFragment = new bottomsheet_fragment();
    MaterialSwitch installmentsSwitch;
    LinearLayout installmentsLayout,imageContainer;
    MaterialButton pickImage;
    ImageView imageGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_property);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar navButton = findViewById(R.id.toolbar);
        navButton.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {;
                finish();
            }
        });

        // Initialize ChipGroups
        ChipGroup purposeChipGroup = findViewById(R.id.purpose_chip_group);
        ChipGroup selectTypeChipGroup = findViewById(R.id.select_type_chip_group);
        homesTypeChipGroup = findViewById(R.id.homes_type_chip_group);
        plotsTypeChipGroup = findViewById(R.id.plots_type_chip_group);
        commercialTypeChipGroup = findViewById(R.id.commercial_type_chip_group);

        // Initialize Chips
        Chip buyChip = findViewById(R.id.rent_chip);
        Chip sellChip = findViewById(R.id.sell_chip);
        Chip homesChip = findViewById(R.id.homes_chip);
        Chip plotsChip = findViewById(R.id.plots_chip);
        Chip commercialChip = findViewById(R.id.commercial_chip);
        Chip houseChip = findViewById(R.id.house_chip);
        Chip roomChip = findViewById(R.id.room_chip);
        Chip upperPortionChip = findViewById(R.id.upperportion_chip);
        Chip lowerPortionChip = findViewById(R.id.lowerportion_chip);
        Chip flatChip = findViewById(R.id.flat_chip);
        Chip farmHouseChip = findViewById(R.id.farmhouse_chip);
        Chip residentialPlotChip = findViewById(R.id.residentialplot_chip);
        Chip commercialPlotChip = findViewById(R.id.commercialplot_chip);
        Chip plotFileChip = findViewById(R.id.plotfile_chip);
        Chip agriculturalLandChip = findViewById(R.id.agriculturalland_chip);
        Chip industrialLandChip = findViewById(R.id.industrialland_chip);
        Chip officeChip = findViewById(R.id.office_chip);
        Chip shopChip = findViewById(R.id.shop_chip);
        Chip warehouseChip = findViewById(R.id.warehouse_chip);
        Chip factoryChip = findViewById(R.id.factory_chip);
        Chip otherChip = findViewById(R.id.other_chip);

        cityEditText = findViewById(R.id.buttomsheet_button);
        installmentsSwitch=findViewById(R.id.installments_switch);
        installmentsLayout=findViewById(R.id.installments_layout);
        pickImage=findViewById(R.id.pick_images_button);
        imageContainer=findViewById(R.id.image_container);
        imageGallery=findViewById(R.id.image_gallery);



        purposeChipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                if (!checkedIds.isEmpty()) {
                    int checkedId = checkedIds.get(0);
                    if (checkedId == R.id.rent_chip) {
                        Toast.makeText(getApplicationContext(), "Rent Out Selected", Toast.LENGTH_SHORT).show();
                    } else if (checkedId == R.id.sell_chip) {
                        Toast.makeText(getApplicationContext(), "Sell Selected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        selectTypeChipGroup.setOnCheckedStateChangeListener(new ChipGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull ChipGroup group, @NonNull List<Integer> checkedIds) {
                if (!checkedIds.isEmpty()) {
                    int checkedId = checkedIds.get(0);
                    homesTypeChipGroup.setVisibility(View.GONE);
                    plotsTypeChipGroup.setVisibility(View.GONE);
                    commercialTypeChipGroup.setVisibility(View.GONE);
                    if (checkedId == R.id.homes_chip) {
                        homesTypeChipGroup.setVisibility(View.VISIBLE);
                    } else if (checkedId == R.id.plots_chip) {
                        plotsTypeChipGroup.setVisibility(View.VISIBLE);
                    } else if (checkedId == R.id.commercial_chip) {
                        commercialTypeChipGroup.setVisibility(View.VISIBLE);
                    }
                }
            }
        });


        cityEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomsheetFragment.show(getSupportFragmentManager(), bottomsheetFragment.getTag());
            }
        });



        bottomsheetFragment.setOnCitySelectedListener(new bottomsheet_fragment.OnCitySelectedListener() {
            @Override
            public void onCitySelected(String city) {
                cityEditText.setText(city);
            }
        });

        installmentsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    installmentsLayout.setVisibility(View.VISIBLE);
                }else{
                    installmentsLayout.setVisibility(View.GONE);
                }
            }
        });


        pickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent igallery=new Intent(Intent.ACTION_PICK);
                    igallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(igallery,GALLERY_REQ_CODE);

            }
        });
    }
    @Override
    protected void onActivityResult(int request_code, int result_code, Intent data) {
        super.onActivityResult(request_code, result_code, data);

        if (result_code==RESULT_OK){
            if (request_code==GALLERY_REQ_CODE){
                imageGallery.setImageURI(data.getData());
                imageContainer.setVisibility(View.VISIBLE);
        }
    }
}
}