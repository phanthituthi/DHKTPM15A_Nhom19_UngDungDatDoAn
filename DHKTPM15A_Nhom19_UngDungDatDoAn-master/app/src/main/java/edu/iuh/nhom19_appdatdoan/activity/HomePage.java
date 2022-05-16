package edu.iuh.nhom19_appdatdoan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import edu.iuh.nhom19_appdatdoan.R;
import edu.iuh.nhom19_appdatdoan.fragment.CartFragment;
import edu.iuh.nhom19_appdatdoan.fragment.HomeFragment;

public class HomePage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    CartFragment cartFragment = new CartFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bottomNavigationView = findViewById(R.id.bottom_gavaition);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.HomePageContainer, homeFragment)
                .commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.HomePageContainer, homeFragment)
                                .commit();
                        return true;
                    case R.id.cart:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.HomePageContainer, cartFragment)
                                .commit();
                        return true;
                }
                return false;
            }
        });
    }
}