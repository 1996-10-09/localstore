package lk.ac.kln.localstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void externalStorage(View view){
        Intent intent= new Intent(this,ExternalStorage.class);
        startActivity(intent);
    }
    public void internalStorage(View view){
        Intent intent= new Intent(this,ExternalStorage.class);
        startActivity(intent);
    }
}
