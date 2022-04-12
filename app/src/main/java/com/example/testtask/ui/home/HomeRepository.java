package com.example.testtask.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.android.volley.NetworkResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {


    public HomeRepository() {
    }

    public MutableLiveData<NetworkResponse> getReceipesListData() {
        final MutableLiveData<NetworkResponse> getReceipesListDataResponseMutableLiveData = new MutableLiveData<>();

        return getReceipesListDataResponseMutableLiveData;
    }
}

