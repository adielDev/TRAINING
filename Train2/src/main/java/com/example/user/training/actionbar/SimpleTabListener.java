package com.example.user.training.actionbar;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;

/**
 * Created by user on 26/01/15.
 */
public class SimpleTabListener implements ActionBar.TabListener {

    Context context;
    String tabFragmentClassName;
    Fragment tabFragment;

    public SimpleTabListener( Context context,String tabFragmentClassName){
        this.context=context;
        this.tabFragmentClassName = tabFragmentClassName;
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        if(tabFragment==null){
            tabFragment = Fragment.instantiate(context,tabFragmentClassName);
            ft.add(android.R.id.content,tabFragment);
        }
        else {
            ft.attach(tabFragment);
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        ft.detach(tabFragment);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
