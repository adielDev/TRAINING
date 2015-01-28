package com.example.user.training.actionbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import com.example.user.training.R;

import fragments.basefragment.FRagThree;
import fragments.basefragment.FragOne;
import fragments.basefragment.FragTwo;

public class TabNavNiceCode extends ActionBarActivity {

    ViewPager vp;
    TabHost tabHost;
    String [] pagesTitles;
    String [] tabNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_nav_nice_code);

        pagesTitles = new String []{"frag1","frag2","frag3"};
        tabNames =new String[] {"tab1","tab2","tab3"};
        vp = (ViewPager)findViewById(R.id.vp);
        tabHost = (TabHost)findViewById(R.id.niceTabHost);

        FragmentManager fm = getSupportFragmentManager();
        vp.setAdapter(new MyAdapter(fm));

//        for (int i = 0; i < pagesTitles.length; i++) {
//
//            TabHost.TabSpec spec = tabHost.newTabSpec(pagesTitles[i]);
//            int id = this.getResources().getIdentifier(pagesTitles[i],"id",this.getPackageName());
//            spec.setContent(id);
//            spec.setIndicator("Aba");
//            tabHost.addTab(spec);
//        }


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
            return  pagesTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {


          return pagesTitles[position];
        }
    }





     ////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab_nav_nice_code, menu);
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
}
