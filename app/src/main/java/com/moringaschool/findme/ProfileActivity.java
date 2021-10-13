package com.moringaschool.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView mprofileTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mprofileTextView = (TextView) findViewById(R.id.textViewPersonName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        mprofileTextView.setText("These are all the missing persons with this name:" +name);
    }
}