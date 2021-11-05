
package com.moringaschool.findme;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

//@Generated("jsonschema2pojo")
@Parcel
public class Medium {

    @SerializedName("media_key")
    @Expose
    public String mediaKey;
    @SerializedName("type")
    @Expose
    public String type;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Medium() {
    }

    /**
     * 
     * @param mediaKey
     * @param type
     */
    public Medium(String mediaKey, String type) {
        super();
        this.mediaKey = mediaKey;
        this.type = type;
    }

    public String getMediaKey() {
        return mediaKey;
    }

    public void setMediaKey(String mediaKey) {
        this.mediaKey = mediaKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
