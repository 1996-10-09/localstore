package lk.ac.kln.localstore;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalStorage extends AppCompatActivity {
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);
        editText=findViewById(R.id.editText);
    }
    public void save(View view) {
        if (isExternalStorageWritable()) {
            File file = new File(getExternalFilesDir("MyDir"), "textFile.txt");
            String input = editText.toString();

            try {
                FileOutputStream os = new FileOutputStream(file);
                os.write("Test".getBytes());
                os.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
        public void show (View view){

        }

        public boolean isExternalStorageWritable () {
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                return true;
            }
            return false;
        }

}
