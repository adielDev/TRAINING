     package com.example.user.training.layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.training.R;

public class IndexLayout extends ActionBarActivity {

    private final Class[] sActivities = new Class[] {BasicAttributes.class,LinearLayoutEx.class, RElativeLayoutEx.class,FrameLayoutEx.class,                                FRameLayoutMergeEx.class};

    private ListView mListViewSamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_layout);

        String[] titles =  new String[]{"BasicAttributes","LinearLayoutEx","RelativeLayout","FrameLayoutEx","FRameLayoutMergeEx"};
        mListViewSamples = (ListView) findViewById(R.id.listView);
        mListViewSamples.setAdapter(
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles));
        mListViewSamples.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int i, long arg3) {
                Intent intent = new Intent(getBaseContext(), sActivities[i]);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_saving_data_index, menu);
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
