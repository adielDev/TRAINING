package com.example.user.training.actionbar.tabsNavsFromSample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.training.MainActivityTaining;
import com.example.user.training.R;


public class MainActivityForNav extends ActionBarActivity implements  ConstantsTabNav {

    SlidingTabsBasicFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
             fragment = new SlidingTabsBasicFragment();
            transaction.replace(R.id.sample_content_fragment,fragment);
            transaction.commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_nav_sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.action_add_tab :
                        fragment.addNewTab("aaa");
                break;
            case R.id.action_comback_to_index:
                Intent intent = new Intent(MainActivityForNav.this , MainActivityTaining.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }



}
