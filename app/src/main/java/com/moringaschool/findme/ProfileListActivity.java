package com.moringaschool.findme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileListActivity extends AppCompatActivity {
//    private SharedPreferences mSharedPreferences;
//    private String mRecentName;
//    private SharedPreferences.Editor mEditor;
//private static final String TAG = ProfileListActivity.class.getSimpleName();
//    @BindView(R.id.textViewPersonName) TextView mprofileTextView;
////    @BindView(R.id.profileListView) ListView mprofileListView;
//    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
//
//    @BindView(R.id.errorTextView) TextView mErrorTextView;
//    @BindView(R.id.progressBar) ProgressBar mProgressBar;
////    private String[] details = new String[]{"Name", "Age", "DOB", "Gender", "Appearance", "LastSeen"};
//    private TweetListAdapter mAdapter;
//
//    public List<Datum> tweets;
//    public List<Medium> imageTweets;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);
//        ButterKnife.bind(this);
//create adapter to display listview from backend
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, details);
//        mprofileListView.setAdapter(adapter);

//        mprofileListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                String detail = ((TextView) view).getText().toString();
//                Toast.makeText(ProfileActivity.this, detail, Toast.LENGTH_LONG).show();
//            }
//        });

//
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mRecentName = mSharedPreferences.getString(Constants.PREFERENCES_NAME_KEY, null);
//        Log.d("Shared Pref Name", mRecentName);
////        String name = mRecentName;
//
//        mprofileTextView.setText("These are all the missing persons with this name:" + name);
//
//        TwitterApi client = TwitterClient.getClient();
//
//        Call<TwitterMissingPersonsSearchResponse> call = client.getMissingPersons(name,"" );
//
//        call.enqueue(new Callback<TwitterMissingPersonsSearchResponse>() {
//
//            @Override
//            public void onResponse(Call<TwitterMissingPersonsSearchResponse> call, Response<TwitterMissingPersonsSearchResponse> response) {
//                hideProgressBar();

//            }
//
//            @Override
//            public void onFailure(Call<TwitterMissingPersonsSearchResponse> call, Throwable t) {
//                Log.e("Error Message", "onFailure: ", t);
//                hideProgressBar();
//                showFailureMessage();
//            }
//
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_search, menu);
//        ButterKnife.bind(this);
//
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();
//
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) menuItem.getActionView();
//
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }
//    private void addToSharedPreferences(String name) {
//        mEditor.putString(Constants.PREFERENCES_NAME_KEY, name).apply();
//    }
//
//    private void showFailureMessage() {
//        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void showUnsuccessfulMessage() {
//        mErrorTextView.setText("Something went wrong. Please try again later");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void showMissingPersons() {
//        mRecyclerView.setVisibility(View.VISIBLE);
////        mprofileListView.setVisibility(View.VISIBLE);
////        mLocationTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void hideProgressBar() {
//        mProgressBar.setVisibility(View.GONE);
//    }
//
//}

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentName;

    private static final String TAG = ProfileListActivity.class.getSimpleName();
    private TweetListAdapter mAdapter;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    public List<Datum> tweets;
//    public List<Medium> imageTweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentName = mSharedPreferences.getString(Constants.PREFERENCES_NAME_KEY, null);
        if(mRecentName != null){
            fetchTweets(mRecentName);
        }

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String name) {
                addToSharedPreferences(name);
                fetchTweets(name);
                return false;
            }


            @Override
            public boolean onQueryTextChange(String name) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showMissingPersons() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_NAME_KEY, location).apply();
    }

    private void fetchTweets(String name){
        TwitterApi client = TwitterClient.getClient();
        Call<TwitterMissingPersonsSearchResponse> call = client.getMissingPersons(name, "name");
        call.enqueue(new Callback<TwitterMissingPersonsSearchResponse>() {
            @Override
            public void onResponse(Call<TwitterMissingPersonsSearchResponse> call, Response<TwitterMissingPersonsSearchResponse> response) {

                hideProgressBar();
                if (response.isSuccessful()) {
                    tweets = response.body().getData();
                    mAdapter = new TweetListAdapter(ProfileListActivity.this, tweets);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ProfileListActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showMissingPersons();
                    List<Datum> dataList = response.body().getData();
//                    List<Medium> mediumList = response.body().getIncludes().getMedia();
                    String[] missingPersons = new String[dataList.size()];
//                    String [] personImages = new String[dataList.size()];

                    for (int i = 0; i < missingPersons.length; i++) {
                        missingPersons[i] = dataList.get(i).getText();
                    }

//                    for (int i = 0; i < personImages.length; i++) {
//                        personImages[i] = mediumList.get(i).getType();
//                    }

                    ArrayAdapter adapter = new MyMissingPersonsArrayAdapter(ProfileListActivity.this, android.R.layout.simple_list_item_1, missingPersons);
//                    mprofileListView.setAdapter(adapter);
                    showMissingPersons();


                } else {
                    showUnsuccessfulMessage();
                }
//                if (response.isSuccessful()) {
//                    restaurants = response.body().getBusinesses();
//                    mAdapter = new RestaurantListAdapter(RestaurantListActivity.this, restaurants);
//                    mRecyclerView.setAdapter(mAdapter);
//                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RestaurantListActivity.this);
//                    mRecyclerView.setLayoutManager(layoutManager);
//                    mRecyclerView.setHasFixedSize(true);
//
//                    showRestaurants();
//                } else {
//                    showUnsuccessfulMessage();
//                }
            }

            @Override
            public void onFailure(Call<TwitterMissingPersonsSearchResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t );
                hideProgressBar();
                showFailureMessage();
            }

        });
    }


    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();

            Collections.swap( tweets,fromPosition, toPosition);
            recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            int position = viewHolder.getAdapterPosition();
            switch(direction){
                case ItemTouchHelper.LEFT:
                    tweets.remove(position);
                    mAdapter.notifyItemRemoved(position);
                    break;
                case ItemTouchHelper.RIGHT:

                    break;
            }
        }
    };
}