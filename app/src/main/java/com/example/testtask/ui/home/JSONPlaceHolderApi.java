package com.example.testtask.ui.home;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {
    @GET("/food")
    public Call<List<Post>> getAllPosts();
}