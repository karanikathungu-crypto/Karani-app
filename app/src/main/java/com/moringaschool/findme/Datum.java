
package com.moringaschool.findme;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

//@Generated("jsonschema2pojo")
@Parcel
public class Datum {

    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("author_id")
    @Expose
    public String authorId;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("id")
    @Expose
    public String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param createdAt
     * @param text
     * @param id
     * @param authorId
     */
    public Datum(String text, String authorId, String createdAt, String id) {
        super();
        this.text = text;
        this.authorId = authorId;
        this.createdAt = createdAt;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
