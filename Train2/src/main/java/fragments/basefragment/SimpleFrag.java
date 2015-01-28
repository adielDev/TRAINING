package fragments.basefragment;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.training.R;

public class SimpleFrag extends ActionBarActivity implements CoordinatorFrag{

     int item ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_frag);

        item = savedInstanceState ==null ? 0 :
                savedInstanceState.getInt("item");
        changeFragOneText(item);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sinple, menu);
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
    public void itemListClicked(int item) {
        this.item = item;
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragOne fragOne = (FragOne) fragmentManager.findFragmentById(R.id.fragOne);

        fragOne.displayIndex(item);
    }
         // i split the funftion in order to be able perform the action without real "clicl"

    public void changeFragOneText(int index) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragOne fragOne = (FragOne) fragmentManager.findFragmentById(R.id.fragOne);

        fragOne.displayIndex(index);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("item",item);
    }
}
