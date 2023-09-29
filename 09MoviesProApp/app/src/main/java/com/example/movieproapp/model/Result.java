package com.example.movieproapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Result implements Parcelable {
    /* PARCEL STEPS
    * 1. Create the object that Implements Parcelable (Movie.java,Result.java)
    * 2. Create Overridden Methods
    *     a. writeToParcel
    *     b. describeContents
    * 3. Create a Constructor with a Parcel object to read the data from.
    * 4. CREATOR field that implements Parcelable.Creator interface
     */
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<Movie> results;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;

    // (1) Parcelable.CREATOR
    public final static Parcelable.Creator CREATOR = new Parcelable.Creator<Result>(){

        @Override
        public Result createFromParcel(Parcel parcel) {
            return new Result(parcel);
        }

        @Override
        public Result[] newArray(int i) {
            return new Result[i];
        }
    };

    // (2) Constructors


    public Result() {
    }

    public Result(Parcel in) {
        this.page = (Integer) in.readValue(Integer.class.getClassLoader());
        in.readList(this.results,com.example.movieproapp.model.Movie.class.getClassLoader());
        this.totalPages = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalResults = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeValue(page);
        parcel.writeValue(totalPages);
        parcel.writeInt(totalResults);
        parcel.writeList(results);
    }
}