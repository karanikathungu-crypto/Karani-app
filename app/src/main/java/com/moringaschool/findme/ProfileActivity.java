package com.moringaschool.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.textViewPersonName) TextView mprofileTextView;
    @BindView(R.id.profileListView) ListView mprofileListView;
    private String [] details = new String [] {"Name", "Age", "DOB", "Gender", "Appearance", "LastSeen"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, details);
        mprofileListView.setAdapter(adapter);

        mprofileListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String detail = ((TextView)view).getText().toString();
                Toast.makeText(ProfileActivity.this, detail, Toast.LENGTH_LONG).show();
            }
        });


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        mprofileTextView.setText("These are all the missing persons with this name:" +name);
    }
}