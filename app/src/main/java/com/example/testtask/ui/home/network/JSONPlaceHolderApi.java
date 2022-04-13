package com.example.testtask.ui.home.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderApi {
    @GET("/food")
    Call<List<Post>> getAllPosts();
}