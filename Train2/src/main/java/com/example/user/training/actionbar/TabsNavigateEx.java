package com.example.user.training.actionbar;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;

import com.example.user.training.R;

import fragments.basefragment.FRagThree;
import fragments.basefragment.FragOne;
import fragments.basefragment.FragTwo;

public class TabsNavigateEx extends FragmentActivity implements ActionBar.TabListener ,View.OnClickListener {

    ViewPager vp;

    ActionBar actionBar;
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tabs_ex_2);

        vp = (ViewPager)findViewById(R.id.vp);
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyAdapter adapter = new MyAdapter(fragmentManager);
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

              tabHost.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                    switch (state){
                        case ViewPager.SCROLL_STATE_IDLE :

                            break;
                        case ViewPager.SCROLL_STATE_DRAGGING:

                            break;
                        case ViewPager.SCROLL_STATE_SETTLING :

                            break;

                    }
            }
        });

        tabHost = (TabHost)findViewById(R.id.tabHost2);
        tabHost.setup();


        TabHost.TabSpec spec1 = tabHost.newTabSpec("tab1");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("Aba");
        tabHost.addTab(spec1);


        TabHost.TabSpec spec2 = tabHost.newTabSpec("tab2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("Bamba");
        tabHost.addTab(spec2);


        TabHost.TabSpec spec3 = tabHost.newTabSpec("tab3");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("Camel");
        tabHost.addTab(spec3);



        tabHost.setOnClickListener(this);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.d("adiel","onTabChanged "+tabId)   ;
                switch (tabId){
                    case "tab1" :
                        vp.setCurrentItem(0);
                        break;
                    case "tab2" :
                        vp.setCurrentItem(1);
                        break;
                    case "tab3" :
                        vp.setCurrentItem(2);
                        break;
                }
            }
        });






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabs_navigate_ex, menu);
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


    @Override
    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

        Log.d("adiel","onTabSelected")   ;
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {

        Log.d("adiel","onTabUnselected")   ;
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction ft) {
        Log.d("adiel","onTabReselected")   ;
    }

    @Override
    public void onClick(View v) {

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
