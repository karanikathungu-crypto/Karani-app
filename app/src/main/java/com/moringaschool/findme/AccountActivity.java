package com.moringaschool.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.textViewAccount) TextView mTextViewAccount;
    @BindView(R.id.editTextUserName) EditText mEditTextUserName;
    @BindView(R.id.editTextUserEmail) EditText mEditTextUserEmail;
    @BindView(R.id.editTextUserPassword) EditText mEditTextUserPassword;
    @BindView(R.id.createAccountButton) Button mCreateAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ButterKnife.bind(this);

        mCreateAccountButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == mCreateAccountButton) {
            Toast.makeText(AccountActivity.this, "Account is being created", Toast.LENGTH_LONG).show();
        }
    }
}