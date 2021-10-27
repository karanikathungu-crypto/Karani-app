package com.moringaschool.findme;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TwitterApi {
        @GET("tweets/search/recent")
        Call<TwitterMissingPersonsSearchResponse> getMissingPersons(
                @Query("query") String name,
                @Query("user.fields") String description
        );
}
