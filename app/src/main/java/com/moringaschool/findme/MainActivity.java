package com.moringaschool.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.editTextTextPersonName) EditText mEditTextName;
    @BindView(R.id.homeSearchButton) Button mHomeSearchButton;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mHomeSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
//                Toast.makeText(MainActivity.this, "Search occurring kindly be patient", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                String name = mEditTextName.getText().toString();
//                Log.d(TAG, name);
                intent.putExtra("name", name);
                startActivity(intent);
            }

        });
    }
}