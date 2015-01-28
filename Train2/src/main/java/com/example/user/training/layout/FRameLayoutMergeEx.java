package com.example.user.training.layout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.user.training.R;

public class FRameLayoutMergeEx extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_merge_ex);
        // THIS EXAMPLE SHOW US HOW TO USE MERGE ATTRIBUTE , THE ATTRIBUTE CAUSE TO USING THE PARENT LAYOUT AS A LAYOUT
        //FOR EXAMPLE IF OUR PARENT LAYOUT IS FRAME -LAYOUT BECAUSE THE DEFAULT LAYOUT THAT EVERY LAYOUT HAD IS FRAMELAYOUT
        // WE CAN GIVE UP THE EXPLICT LAYOIT AND USE THE FRAME-LAYOUT THAT ANDROID GIVE IN FREE
        // BUT IN ORDER TO CUSTOMIZE HIM WE NEED TO ACCESS LIKE THIS

        View parent = findViewById(android.R.id.content);
        parent.setBackgroundColor(Color.BLUE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_frame_layout_merge_ex, menu);
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
