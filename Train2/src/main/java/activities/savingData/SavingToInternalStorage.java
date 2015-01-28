package activities.savingData;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.training.R;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import general.ConstantsOfTraining;

public class SavingToInternalStorage extends ActionBarActivity implements View.OnClickListener
, ConstantsOfTraining {

    Button btnSave;
    Button btnShow;

    EditText etTextToSave;
    TextView tvSavedContent;
    private final String FILE_NAME = "groceries.txt";
    private final String FILESAVED = "FileSaved";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_to_internal_storage);

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
        getMenuInflater().inflate(R.menu.menu_saving_to_internal_storage, menu);
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

        switch (v.getId()){

            case R.id.btnSave :
                String text = etTextToSave.getText().toString();
                try {
                    FileOutputStream fileOutputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                    fileOutputStream.write(text.getBytes());
                    fileOutputStream.close();
                    Log.d(DEBUG_TAG, "SUCCEES WRITE TO STORAGE ");
                    Toast.makeText(SavingToInternalStorage.this, "SUCCEES WRITE TO STORAGE ", Toast.LENGTH_LONG);
                } catch (Exception e) {
                    Log.d(DEBUG_TAG,"CANT WRITE TO STORAGE ");
                    e.printStackTrace();
                }
                break;
            case R.id.btnShow :
                try {
                    FileInputStream fileInputStream = openFileInput(FILE_NAME);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DataInputStream(fileInputStream)));
                    String line ;
                    tvSavedContent.setText("");
                    while ((line=bufferedReader.readLine())!=null){
                        tvSavedContent.append(line);
                        tvSavedContent.append("\n");
                    }
                    fileInputStream.close();


                } catch (Exception e) {
                    Log.d(DEBUG_TAG,"CANT read file  ");
                    e.printStackTrace();
                }
                break;

        }


    }
}
