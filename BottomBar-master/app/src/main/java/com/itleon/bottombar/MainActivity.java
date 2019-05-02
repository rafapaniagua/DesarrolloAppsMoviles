package com.itleon.bottombar;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomBar = findViewById(R.id.bottombar);


        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragmentSeleccionado = null;

                switch (menuItem.getItemId()){
                    case R.id.item_home:
                        fragmentSeleccionado = new Home();
                        break;
                    case R.id.item_search:
                        fragmentSeleccionado = new Search();

                        break;
                    case R.id.item_profile:
                        fragmentSeleccionado = new Profile();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentSeleccionado).commit();
                return true;
            }
        });
    }
}
