package com.moringaschool.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mHomeSearchButton;
    private EditText mEditTextName;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextName = (EditText) findViewById(R.id.editTextTextPersonName);
        mHomeSearchButton= (Button)findViewById(R.id.homeSearchButton);
        mHomeSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
//                Toast.makeText(MainActivity.this, "Search occurring kindly be patient", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                String name = mEditTextName.getText().toString();
                Log.d(TAG, name);
                startActivity(intent);
            }

        });
    }
}