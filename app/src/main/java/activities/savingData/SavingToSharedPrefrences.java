package activities.savingData;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.training.R;

import general.ConstantsOfTraining;

public class SavingToSharedPrefrences extends ActionBarActivity implements View.OnClickListener
    , ConstantsOfTraining{

    Button btnSave;
    Button btnShow;

    EditText etTextToSave;
    TextView tvSavedContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_to_shared_prefrences);

        etTextToSave = (EditText)findViewById(R.id.editText);
        tvSavedContent = (TextView)findViewById(R.id.tvSavedContent);

        btnSave = (Button)findViewById(R.id.btnSave);
        btnShow = (Button)findViewById(R.id.btnShow);

        btnSave.setOnClickListener(this);
        btnShow.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_saving_to_shared_prefrences, menu);
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
        switch (v.getId()) {

            case R.id.btnSave:
                String text = etTextToSave.getText().toString();
                SharedPreferences preferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(SP_KEY_NAME,text);
                editor.commit();
                break;
            case R.id.btnShow :
                SharedPreferences preferences2 = getPreferences(MODE_PRIVATE);
                String name = preferences2.getString(SP_KEY_NAME,"DEF VALUE");
                tvSavedContent.setText(name);
                break;

        }

    }
}
