
package com.moringaschool.findme;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

//@Generated("jsonschema2pojo")
@Parcel
public class TwitterMissingPersonsSearchResponse {

    @SerializedName("data")
    @Expose
    public List<Datum> data = null;
    @SerializedName("includes")
    @Expose
    public Includes includes;
    @SerializedName("meta")
    @Expose
    public Meta meta;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TwitterMissingPersonsSearchResponse() {
    }

    /**
     * 
     * @param data
     * @param meta
     * @param includes
     */
    public TwitterMissingPersonsSearchResponse(List<Datum> data, Includes includes, Meta meta) {
        super();
        this.data = data;
        this.includes = includes;
        this.meta = meta;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Includes getIncludes() {
        return includes;
    }

    public void setIncludes(Includes includes) {
        this.includes = includes;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
