package com.moringaschool.findme;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class MyMissingPersonsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] missingPersons;
//    private String[] personImages;


    public MyMissingPersonsArrayAdapter(@NonNull Context mContext, int resource, String[] missingPersons){
        super(mContext, resource);
        this.mContext = mContext;
        this.missingPersons = missingPersons;
//        this.personImages = personImages;
    }

    @Override
    public Object getItem(int position) {
        String missingPerson = missingPersons[position];
//        String personImage = personImages[position];
        return String.format("%s", missingPerson);
    }
    @Override
    public int getCount(){
        return missingPersons.length;
    }
}
