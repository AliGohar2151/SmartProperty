package com.example.smartproperty;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class home_activity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

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
        } else {
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }
}
