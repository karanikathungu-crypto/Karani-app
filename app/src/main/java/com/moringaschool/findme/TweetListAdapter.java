package com.moringaschool.findme;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TweetListAdapter extends RecyclerView.Adapter<TweetListAdapter.TweetViewHolder> {

    private List<Datum> mTweets;
//    private List<Medium> mImageTweets;
    private Context mContext;

    public TweetListAdapter(Context context, List<Datum> tweets){
        mContext = context;
        mTweets = tweets;
//        mImageTweets = imageTweets;
    }
    @Override
    public TweetListAdapter.TweetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet_list_item, parent, false);
        TweetViewHolder viewHolder = new TweetViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TweetListAdapter.TweetViewHolder holder, int position) {
        holder.bindTweet(mTweets.get(position));
    }

    @Override
    public int getItemCount() {
        return mTweets.size();
    }

    public class TweetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        @BindView(R.id.tweetImageView) ImageView mTweetImageView;
        @BindView(R.id.tweetTextView) TextView mTweetTextView;


        private Context mContext;

        public TweetViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindTweet(Datum tweet) {
            mTweetTextView.setText(tweet.getText());

        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, TwitterDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("restaurants", Parcels.wrap(mTweets));
            mContext.startActivity(intent);
        }

        public void bindTweetImage(Medium imageTweets){
            Picasso.get().load(imageTweets.getType()).into(mTweetImageView);
        }
    }
}
