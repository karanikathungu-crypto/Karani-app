package com.moringaschool.findme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mSearchedNameReference;
    private ValueEventListener mSearchedNameReferenceListener;
//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;

//    @BindView(R.id.editTextTextPersonName) EditText mEditTextName;
    @BindView(R.id.homeSearchButton) Button mHomeSearchButton;
    @BindView(R.id.textViewAccountCreation) TextView mTextViewAccountCreation;
//    @BindView(R.id.createAccountHomeButton) Button mCreateAccountButton;
    @BindView(R.id.savedTweetsButton) Button mSavedTweetsButton;

//    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSearchedNameReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_NAME);
        mSearchedNameReference.addValueEventListener(new ValueEventListener() { //attach listener

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) { //something changed!
                for (DataSnapshot nameSnapshot : dataSnapshot.getChildren()) {
                    String name = nameSnapshot.getValue().toString();
                    Log.d("Names updated", "name: " + name);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { //update UI here if error occurred.

            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();
//        mHomeSearchButton.setOnClickListener(new View.OnClickListener() {
        mHomeSearchButton.setOnClickListener(this);
//        mCreateAccountButton.setOnClickListener(this);
        mSavedTweetsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mHomeSearchButton) {
//            String name = mEditTextName.getText().toString();
            Intent intent = new Intent(MainActivity.this, ProfileListActivity.class);
            startActivity(intent);
//            saveNameToFirebase(name);
//            if(!(name).equals("")) {
//                addToSharedPreferences(name);
//            }
//            Intent intent = new Intent(MainActivity.this, ProfileListActivity.class);
//            intent.putExtra("name", name);
//            startActivity(intent);
        }
//        if (v == mCreateAccountButton) {
//            Intent intent = new Intent(MainActivity.this, AccountActivity.class);
//            startActivity(intent);
//        }
        if (v == mSavedTweetsButton) {
            Intent intent = new Intent(MainActivity.this, SavedTweetsListActivity.class);
            startActivity(intent);
        }
    }
//    public void saveNameToFirebase(String name) {
//        mSearchedNameReference.push().setValue(name);
//    }
//    private void addToSharedPreferences(String name) {
//        mEditor.putString(Constants.PREFERENCES_NAME_KEY, name).apply();
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mSearchedNameReference.removeEventListener(mSearchedNameReferenceListener);
//   }
}