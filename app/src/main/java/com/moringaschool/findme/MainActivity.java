package com.moringaschool.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.editTextTextPersonName) EditText mEditTextName;
    @BindView(R.id.homeSearchButton) Button mHomeSearchButton;
    @BindView(R.id.textViewAccountCreation) TextView mTextViewAccountCreation;
    @BindView(R.id.createAccountHomeButton) Button mCreateAccountButton;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        mHomeSearchButton.setOnClickListener(new View.OnClickListener() {
        mHomeSearchButton.setOnClickListener(this);
        mCreateAccountButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mHomeSearchButton) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            String name = mEditTextName.getText().toString();
            intent.putExtra("name", name);
            startActivity(intent);
        }
        if (v == mCreateAccountButton) {
            Intent intent = new Intent(MainActivity.this, AccountActivity.class);
            startActivity(intent);
        }
    }
}