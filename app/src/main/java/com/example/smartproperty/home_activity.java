package com.example.smartproperty;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class home_activity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;
    private final int PhoneNumber= 1234567890;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        toolbar.setNavigationOnClickListener(v -> drawerLayout.open());

        // Side Navigation Drawer
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);
            drawerLayout.close();

            Fragment fragment = null;
            int itemId = menuItem.getItemId();
            if (itemId == R.id.nav_home) {
                fragment = new home_fragment();
                bottomNavigationView.setSelectedItemId(R.id.bottom_nav_home);
            } else if (itemId == R.id.nav_projects) {
                fragment = new projects_fragment();
                bottomNavigationView.setSelectedItemId(R.id.bottom_nav_projects);
            } else if (itemId == R.id.nav_addproperty) {
                Intent intent = new Intent(home_activity.this, add_property_activity.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.nav_yourproperty) {
                Intent intent = new Intent(home_activity.this, your_property_activity.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.nav_agents) {
                Intent intent = new Intent(home_activity.this, findAgents_activity.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.nav_search) {
                fragment = new search_fragment();
                bottomNavigationView.setSelectedItemId(R.id.bottom_nav_search);
            } else if (itemId == R.id.nav_favourite) {
                fragment = new favourite_fragment();
                bottomNavigationView.setSelectedItemId(R.id.bottom_nav_favourite);
            } else if (itemId == R.id.nav_profile) {
                fragment = new profile_fragment();
                bottomNavigationView.setSelectedItemId(R.id.bottom_nav_profile);

            } else if (itemId == R.id.nav_draft) {
                Intent intent = new Intent(home_activity.this, drafts_activity.class);
                startActivity(intent);
            } else if (itemId == R.id.nav_settings) {
                Intent intent = new Intent(home_activity.this, settings_activity.class);
                startActivity(intent);
            } else if (itemId == R.id.nav_about_us) {
                Intent intent = new Intent(home_activity.this, about_us_activity.class);
                startActivity(intent);
            } else if (itemId==R.id.nav_contact_us) {
                DialPhoneNumber dialPhoneNumber=new DialPhoneNumber(this);
                dialPhoneNumber.dialNumber();
            } else if (itemId==R.id.nav_support) {
                Intent intent=  new Intent(home_activity.this, support_help_activity.class);
                startActivity(intent);
            } else if (itemId==R.id.nav_terms) {
                Intent intent = new Intent(home_activity.this, terms_privacy_activity.class);
                startActivity(intent);
            } else if (itemId==R.id.nav_logout) {
                Intent intent = new Intent(home_activity.this, intro_activity.class);
                startActivity(intent);
                finish();
            } else if (itemId==R.id.nav_feedback) {
                Intent intent=new Intent(home_activity.this,feedback_activity.class);
                startActivity(intent);
            }


            if (fragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, fragment);
                transaction.commit();
                return true;
            }
            return false;
        });

        // Bottom Navigation
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            int itemId = item.getItemId();
            if (itemId == R.id.bottom_nav_home) {
                fragment = new home_fragment();
                navigationView.setCheckedItem(R.id.nav_home);
            } else if (itemId == R.id.bottom_nav_projects) {
                fragment = new projects_fragment();
                navigationView.setCheckedItem(R.id.nav_projects);
            } else if (itemId == R.id.bottom_nav_search) {
                fragment = new search_fragment();
                navigationView.setCheckedItem(R.id.nav_search);
            } else if (itemId == R.id.bottom_nav_favourite) {
                fragment = new favourite_fragment();
                navigationView.setCheckedItem(R.id.nav_favourite);
            } else if (itemId == R.id.bottom_nav_profile) {
                fragment = new profile_fragment();
                navigationView.setCheckedItem(R.id.nav_profile);
            }

            if (fragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, fragment);
                transaction.commit();
                return true;
            }
            return false;
        });

        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.bottom_nav_home);
            navigationView.setCheckedItem(R.id.nav_home);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, new home_fragment());
            transaction.commit();
        }
    }
    

    @Override
    protected void onResume() {
        super.onResume();
        resetNavigationView();
    }

    private void resetNavigationView() {
        int selectedItemId = bottomNavigationView.getSelectedItemId();
        if (selectedItemId == R.id.bottom_nav_home) {
            navigationView.setCheckedItem(R.id.nav_home);
        } else if (selectedItemId == R.id.bottom_nav_projects) {
            navigationView.setCheckedItem(R.id.nav_projects);
        } else if (selectedItemId == R.id.bottom_nav_search) {
            navigationView.setCheckedItem(R.id.nav_search);
        } else if (selectedItemId == R.id.bottom_nav_favourite) {
            navigationView.setCheckedItem(R.id.nav_favourite);
        } else if (selectedItemId == R.id.bottom_nav_profile) {
            navigationView.setCheckedItem(R.id.nav_profile);

        } else {
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }
}
