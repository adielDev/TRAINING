package com.example.user.training.networking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.training.R;

public class Simplenetworking extends ActionBarActivity implements View.OnClickListener {

    TextView tvDetails;
    Button btnCheck;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplenetworking);

        context = getApplication();
        tvDetails = (TextView)findViewById(R.id.tvDisplayConnectivityDetails);
        btnCheck = (Button)findViewById(R.id.btnCheclConnectivity);

        btnCheck.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simplenetworking, menu);
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
    public void onClick(View v) {
        // HAVE TO ADD IN MANIFEST MANIFEST CHILD <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        displayNeteorkInfo(networkInfo);
    }

    public void displayNeteorkInfo (NetworkInfo networkInfo){

        String info = "";
        if(networkInfo!=null) {

            info +=""+ networkInfo.isConnected();
        }else {
            info="networkInfo is Null"  ;
        }
        tvDetails.setText(info);
    }

}
