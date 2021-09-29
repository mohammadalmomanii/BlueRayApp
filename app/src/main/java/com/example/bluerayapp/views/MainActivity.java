package com.example.bluerayapp.views;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bluerayapp.Fragments.BlankFragment;
import com.example.bluerayapp.Fragments.ShoppingFragment;
import com.example.bluerayapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnItemSelectedListener(this::onNavigationItemSelected);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        navView.setSelectedItemId(R.id.navigation_home);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.nav_search)
            Toast.makeText(this, "searching", Toast.LENGTH_SHORT).show();
        if (id==R.id.nav_sort)
            Toast.makeText(this, "sorting", Toast.LENGTH_SHORT).show();
        if (id==R.id.nav_cart)
            Toast.makeText(this, "catr", Toast.LENGTH_SHORT).show();
        if (id==R.id.nav_filter)
            Toast.makeText(this, "filter", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if (id==R.id.navigation_home){
            ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_page, BlankFragment.newInstance("HomeFragment"));
            ft.commit();

        }if (id==R.id.navigation_category){
            ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_page,BlankFragment.newInstance("CategoryFragment"));
            ft.commit();
        }if (id==R.id.navigation_shopping){
            ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_page,new ShoppingFragment());
            ft.commit();
        }if (id==R.id.navigation_purchases){
            ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_page,BlankFragment.newInstance("MyPurchasesFragment"));
            ft.commit();
        }if (id==R.id.navigation_favourite){
            ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_page,BlankFragment.newInstance("favouriteFragment"));
            ft.commit();
        }
        return true;
    }
}