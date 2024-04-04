package com.example.newone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fragments.Fragment1;
import com.example.fragments.Fragment2;
import com.example.fragments.Fragment3;
import com.example.fragments.Fragment4;
import com.example.fragments.Fragment5;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bmView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();

                if(id==R.id.home){
                    loadFrag(new Fragment1(),true);

                } else if (id==R.id.search) {
                    loadFrag(new Fragment2(),false);

                }else if (id==R.id.message) {
                    loadFrag(new Fragment3(),false);

                }else if (id==R.id.history){
                    loadFrag(new Fragment4(),false);

                }else {
                    loadFrag(new Fragment5(),false);
                }
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.home);

    }

    public void loadFrag(Fragment fragment , boolean flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();

        if(flag)
            ft.add(R.id.fmFrameLayout,fragment);
        else
            ft.replace(R.id.fmFrameLayout,fragment);
        ft.commit();

    }
    }
