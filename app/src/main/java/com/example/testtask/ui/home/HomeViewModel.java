package com.example.testtask.ui.home;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.NetworkResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends AndroidViewModel {

    MutableLiveData<List<Post>> postLiveData;
    List<Post> postList;;
    private HomeRepository repository;




    public HomeViewModel(@NonNull Application application) {
        super(application);
        postLiveData = new MutableLiveData<>();
        repository = new HomeRepository(getApplication());
        // call your Rest API in init method
        init();
    }


    public MutableLiveData<List<Post>> getUserMutableLiveData(){
        return postLiveData;
    }

    public void init(){
        //populateList();
        getData();

    }
    public void getData()
    {
        postLiveData=repository.getDataFromNetwork();

    }
    public void populateList(){
        NetworkService.getInstance()
                .getJSONApi()
                .getAllPosts()
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                        postList = response.body();
                        postLiveData.setValue(postList);


                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {


                        t.printStackTrace();
                    }
                });
    }
}