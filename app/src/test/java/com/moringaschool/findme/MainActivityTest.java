package com.moringaschool.findme;


import static org.junit.Assert.assertTrue;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void validateTextViewContent(){
        TextView textView = activity.findViewById(R.id.textView);
        assertTrue("Find Me".equals(textView.getText().toString()));
    }

    @Test
    public void validateButtonContent(){
        Button button = activity.findViewById(R.id.homeSearchButton);
        assertTrue("Search".equals(button.getText().toString()));
    }

    @Test
    public void validateAccountCreationTextViewContent(){
        TextView textView = activity.findViewById(R.id.textViewAccountCreation);
        assertTrue("You can create an account to receive updates on missing persons".equals(textView.getText().toString()));
    }
}
