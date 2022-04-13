package com.example.testtask.ui.home.mvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.testtask.ui.home.network.Post;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    MutableLiveData<List<Post>> postLiveData;
    private HomeRepository repository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        postLiveData = new MutableLiveData<>();
        repository = new HomeRepository(getApplication());
        init();
    }


    public MutableLiveData<List<Post>> getUserMutableLiveData() {
        return postLiveData;
    }

    public void init() {
        getData();

    }

    public void getData() {
        postLiveData = repository.getDataFromNetwork();

    }
}