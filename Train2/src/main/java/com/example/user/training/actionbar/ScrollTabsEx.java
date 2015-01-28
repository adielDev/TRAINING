package com.example.user.training.actionbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.user.training.R;

import fragments.basefragment.FRagThree;
import fragments.basefragment.FragOne;
import fragments.basefragment.FragTwo;

public class ScrollTabsEx extends FragmentActivity {

    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tabs_ex);
        vp = (ViewPager)findViewById(R.id.vp);
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyAdapter adapter = new MyAdapter(fragmentManager);
         vp.setAdapter(adapter);
    }



    class MyAdapter extends FragmentPagerAdapter {    // NOTICE FOR SAVE INSTANCE USE    FragmentStatePagerAdapter

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // for some reason its essential to add false parametr in return statement of the frag
            // like this "return inflater.inflate(R.layout.fragment_frag_one, container,false);"
            Fragment fragment = null;
          switch (position){
              case 0:
                  fragment = new FragOne();
                  break;
              case 1:
                  fragment = new FragTwo();
                  break;
              case 2:
                  fragment = new FRagThree();
                  break;

          }

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "tab1";

                                                case 1:
                    return "tab2";
                case 2:
                    return "tab3";
            }
             return "";
        }
    }



}
