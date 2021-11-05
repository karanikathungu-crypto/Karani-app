
package com.moringaschool.findme;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

//@Generated("jsonschema2pojo")
@Parcel
public class User {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("username")
    @Expose
    public String username;

    /**
     * No args constructor for use in serialization
     * 
     */
    public User() {
    }

    /**
     * 
     * @param name
     * @param description
     * @param id
     * @param username
     */
    public User(String id, String description, String name, String username) {
        super();
        this.id = id;
        this.description = description;
        this.name = name;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
