package com.example.user.training.actionbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.training.R;

import fragments.basefragment.FragOne;

public class TabNavFromStack extends ActionBarActivity {

    ViewPager mViewPager;
    FragOne fragOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_nav_from_stack);
        mViewPager = (ViewPager) findViewById(R.id.vp);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab_nav_from_stack, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class TabsPagerAdapter extends FragmentPagerAdapter {

        String[] mTitles = {"Tab1", "Tab2", "Tab3"};

        public TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // Create the fragment here. Assuming you already have a fragment class
            // called "MyFragment", you just need to instantiate an
            // instance of MyFragment and return it

            fragOne = new FragOne();
            return fragOne;
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
