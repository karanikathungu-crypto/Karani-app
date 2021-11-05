
package com.moringaschool.findme;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

//@Generated("jsonschema2pojo")
@Parcel
public class Attachments {

    @SerializedName("media_keys")
    @Expose
    public List<String> mediaKeys = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attachments() {
    }

    /**
     * 
     * @param mediaKeys
     */
    public Attachments(List<String> mediaKeys) {
        super();
        this.mediaKeys = mediaKeys;
    }

    public List<String> getMediaKeys() {
        return mediaKeys;
    }

    public void setMediaKeys(List<String> mediaKeys) {
        this.mediaKeys = mediaKeys;
    }

}
