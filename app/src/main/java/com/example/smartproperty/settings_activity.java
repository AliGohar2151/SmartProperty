package com.example.smartproperty;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class settings_activity extends AppCompatActivity {
    private final int GALLERY_REQ_CODE=1000;

    private Toolbar toolbar;
    private CircleImageView profileView;
    private TextView txtSelectProfile;
    private TextInputEditText inputUsername, inputName, inputEmail, inputPassword, inputPhone, inputAddress1, inputAddress2, inputCity, inputPostalCode;
    private MaterialButton btnAccountDelete, btnUpdateProfile;
    private bottomsheet_fragment bottomsheetFragment = new bottomsheet_fragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        toolbar = findViewById(R.id.toolbar);
        profileView = findViewById(R.id.prifile_view);
        txtSelectProfile = findViewById(R.id.txt_select_profile);

        inputUsername = findViewById(R.id.input_username);
        inputName = findViewById(R.id.input_name);
        inputEmail = findViewById(R.id.input_email);
        inputPassword = findViewById(R.id.input_password);
        inputPhone = findViewById(R.id.input_phone);
        inputAddress1 = findViewById(R.id.input_address1);
        inputAddress2 = findViewById(R.id.input_address2);
        inputCity = findViewById(R.id.input_city);
        inputPostalCode = findViewById(R.id.input_postal_code);

        btnAccountDelete = findViewById(R.id.btn_account_delete);
        btnUpdateProfile = findViewById(R.id.btn_update_profile);




        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        txtSelectProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent igallery=new Intent(Intent.ACTION_PICK);
                igallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(igallery,GALLERY_REQ_CODE);
            }
        });


        inputCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomsheetFragment.show(getSupportFragmentManager(), bottomsheetFragment.getTag());
            }
        });

        bottomsheetFragment.setOnCitySelectedListener(new bottomsheet_fragment.OnCitySelectedListener() {
            @Override
            public void onCitySelected(String city) {
                inputCity.setText(city);
            }
        });




    }

    @Override
    protected  void onActivityResult(int request_code,int result_code, Intent data){
        super.onActivityResult(request_code, result_code, data);

        if (result_code==RESULT_OK){
            if (request_code==GALLERY_REQ_CODE){
                profileView.setImageURI(data.getData());
            }
        }
    }
}