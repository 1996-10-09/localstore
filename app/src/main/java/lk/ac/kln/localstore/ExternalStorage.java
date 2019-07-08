package lk.ac.kln.localstore;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExternalStorage extends AppCompatActivity {
EditText editText;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);
        editText=findViewById(R.id.editText);
       textView=findViewById(R.id.textview);

    }
    public void save(View view) {
        String input = editText.toString();
        if(input!=null|| input.equals("")) {
            if (isExternalStorageWritable()) {
                File file = new File(getExternalFilesDir("MyDir"), "textFile.txt");


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
        }else{
            Toast.makeText(this,"no data to save",Toast.LENGTH_LONG).show();
        }
        }
        public void show (View view){
            String fileContent= "";
            File file= new File(getExternalFilesDir("MyDir"),"textFile.txt");

            try {

                FileInputStream fis= new FileInputStream(file);
                BufferedReader br= new BufferedReader(new InputStreamReader(fis));
                String strLine;
                while ((strLine= br.readLine()) != null) {
                    fileContent= fileContent+ strLine;

                }
                Toast.makeText(this,fileContent.toString(),Toast.LENGTH_LONG).show();
            } catch (IOException e) {e.printStackTrace();
            }
            textView.setText(fileContent);

        }

        public boolean isExternalStorageWritable () {
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                return true;
            }
            return false;
        }


}
