package com.example.sooheib.filestorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username= (EditText) findViewById(R.id.editText);
    }

    public void SaveUsername(View view) {

        String usernameValue = username.getText().toString();

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("file.txt", MODE_PRIVATE);
            fileOutputStream.write(usernameValue.getBytes());
            Toast.makeText(this, "Saved File "+ getFilesDir().toString() + "/file.txt", Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }

    public void goToNext(View view) {
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
