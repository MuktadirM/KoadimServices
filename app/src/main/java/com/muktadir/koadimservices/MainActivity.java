package com.muktadir.koadimservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;
import com.muktadir.koadimservices.Modules.Adapters.ViewPagerAdapter;
import com.muktadir.koadimservices.Modules.Events.Events;
import com.muktadir.koadimservices.Modules.Home.Home;




public class MainActivity extends AppCompatActivity {
    private ViewPagerAdapter adapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar mytoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.ViewPagerContent);
        tabLayout = findViewById(R.id.TabLayoutContent);
        //Setting up toolbar
        mytoolbar = findViewById(R.id.customToolbar);
        setSupportActionBar(mytoolbar);

        //Setting up fragment in Tab Layout
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //You can add More than two
        //Adding fragment through Adapter
        adapter.AddFragment(new Home(),"Home");
        adapter.AddFragment(new Events(),"Events");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //Finish Tab Layout Set up


    }
}
