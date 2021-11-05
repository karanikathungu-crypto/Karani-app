
package com.moringaschool.findme;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
//@Generated("jsonschema2pojo")
public class Includes {

    @SerializedName("media")
    @Expose
    public List<Medium> media = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Includes() {
    }

    /**
     * 
     * @param media
     */
    public Includes(List<Medium> media) {
        super();
        this.media = media;
    }

    public List<Medium> getMedia() {
        return media;
    }

    public void setMedia(List<Medium> media) {
        this.media = media;
    }

}
