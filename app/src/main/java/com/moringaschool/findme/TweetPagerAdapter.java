package com.moringaschool.findme;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import java.util.ArrayList;
import java.util.List;

import com.moringaschool.findme.TwitterDetailFragment;
import com.moringaschool.findme.Datum;

public class TweetPagerAdapter extends FragmentPagerAdapter {
    private List<Datum> mTweets;

    public TweetPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Datum> tweets) {
        super(fm, behavior);
        mTweets = tweets;
    }

    @Override
    public Fragment getItem(int position) {
        return TwitterDetailFragment.newInstance(mTweets.get(position));
    }

    @Override
    public int getCount() {
        return mTweets.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return mTweets.get(position).getAuthorId(); //experiment
//    }
}
