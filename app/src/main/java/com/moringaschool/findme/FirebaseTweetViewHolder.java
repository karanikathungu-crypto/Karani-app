package com.moringaschool.findme;

//import android.content.Context;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseTweetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebaseTweetViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindTweet(Datum tweet) {
//        ImageView tweetImageView = (ImageView) mView.findViewById(R.id.tweetImageView);
        TextView nameTextView = (TextView) mView.findViewById(R.id.tweetNameTextView);
        TextView timeTextView = (TextView) mView.findViewById(R.id.tweetTimeTextView);
//        Picasso.get().load(tweet.getImageUrl()).into(restaurantImageView);
//        nameTextView.setText(tweet.getText());
//        timeTextView.setText(tweet.getCreatedAt());

    }

    @Override
    public void onClick(View view) {
        final ArrayList<Datum> tweets = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_NAMES);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    tweets.add(snapshot.getValue(Datum.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, TwitterDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("tweets", Parcels.wrap(tweets));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


}
