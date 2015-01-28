package com.example.user.training.actionbar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import com.example.user.training.R;

public class ActionBarEx extends ActionBarActivity implements View.OnClickListener {
    android.support.v7.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_ex);
        actionBar= getSupportActionBar();

        TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("tab1");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("Accoustic");
        tabHost.addTab(spec1);


        TabHost.TabSpec spec2 = tabHost.newTabSpec("tab2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("Bamba");
        tabHost.addTab(spec2);


        TabHost.TabSpec spec3 = tabHost.newTabSpec("tab3");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("Camel");
        tabHost.addTab(spec3);


        Button show =(Button)findViewById(R.id.showAB);
        Button hide=(Button)findViewById(R.id.hideAB);

        show.setOnClickListener(this);
        hide.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_action_bar_ex, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.option1 :
                       setLogo();
                break;

        case R.id.option2 :
                       changeTitle();
                break;



        }

        return  true;
    }

    public void setLogo (){

        Log.d("adiel","inside set logo") ;

        actionBar.setLogo(R.drawable.ic_action_good);

    }
    public void changeTitle (){

        Log.d("adiel","inside set logo") ;

        actionBar.setTitle("aaaa");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.showAB :
                       if(actionBar!=null){
                           actionBar.show();
                       }
                break;
            case R.id.hideAB :
                       if(actionBar!=null){
                           actionBar.hide();
                       }
                break;

        }
    }
}
