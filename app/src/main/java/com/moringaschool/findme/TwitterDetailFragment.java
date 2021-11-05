package com.moringaschool.findme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TwitterDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwitterDetailFragment extends Fragment implements View.OnClickListener {

//    @BindView(R.id.tweetImageView) ImageView mImageLabel;
    @BindView(R.id.tweetNameTextView) TextView mNameLabel;
    @BindView(R.id.tweetTimeTextView) TextView mTimeLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.saveTweetButton) TextView mSaveTweetButton;

    private Datum mTweet;
//    private Medium mTweets;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public TwitterDetailFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TwitterDetailFragment newInstance(Datum tweet) {
        TwitterDetailFragment twitterDetailFragment = new TwitterDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("tweet", Parcels.wrap(tweet));
        twitterDetailFragment.setArguments(args);
        return twitterDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mTweet = Parcels.unwrap(getArguments().getParcelable("tweet"));
//        mTweets = Parcels.unwrap(getArguments().getParcelable("tweet"));//experiment
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_twitter_detail, container, false);
        ButterKnife.bind(this, view);

//        Picasso.get().load(mTweets.getType()).into(mImageLabel);

//        List<Medium> categories = new ArrayList<>();
//
//        for (Medium category: mTweet.getAuthorId()) {
//            categod, we first bind the views and then set the image and text views.

//Finally, in the onClick() method, we create a singleValueEventListener to grab out the current list of restaurants from Firebase which we pass along to the RestaurantDetailActivity in the form of an intent extra. We will need this ArrayList when constructing an instance of the RestaurantDetailFragment.
//ories.add(category.getTitle());
//        }

        mNameLabel.setText(mTweet.getText());
        mTimeLabel.setText(mTweet.getCreatedAt());

        mWebsiteLabel.setOnClickListener(this);
        mSaveTweetButton.setOnClickListener(this);

//        mCategoriesLabel.setText(android.text.TextUtils.join(", ", categories));
        return view;
//        return inflater.inflate(R.layout.fragment_twitter_detail, container, false);
    }
    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mTweet.getAuthorId()));
            startActivity(webIntent);
        }
        if (v == mSaveTweetButton) {
            DatabaseReference nameRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_NAMES);
            nameRef.push().setValue(mTweet);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}