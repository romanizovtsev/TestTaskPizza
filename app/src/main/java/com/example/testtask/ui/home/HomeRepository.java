package com.example.testtask.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.testtask.ui.home.database.Data;
import com.example.testtask.ui.home.database.DataDbHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {
    DataDbHelper dh;
    SQLiteDatabase dB;
    Context newContext;
    private MutableLiveData<List<Post>> postList;

    public HomeRepository(Context context) {
        this.postList = new MutableLiveData();
        newContext = context;
    }

    public MutableLiveData<List<Post>> getDataFromNetwork() {

        final MutableLiveData<List<Post>> data = new MutableLiveData<>();
        NetworkService.getInstance()
                .getJSONApi()
                .getAllPosts()
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                        if (response.isSuccessful()) {
                            List<Post> temp = response.body();
                            Collections.sort(temp, new Comparator<Post>() {
                                public int compare(Post o1, Post o2) {
                                    if (o1.getCategory() > o2.getCategory())
                                        return 1;
                                    else if (o1.getCategory() < o2.getCategory())
                                        return -1;
                                    else
                                        return 0;
                                }
                            });
                            data.setValue(temp);
                            putToSql(temp);
                        } else
                            data.setValue(getFromDB());

                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                        Log.e("Берем из бд", "Интернет нет");
                        data.setValue(getFromDB());
                        t.printStackTrace();
                    }
                });


        return data;
    }

    public void putToSql(List<Post> list) {
        dh = new DataDbHelper(newContext);
        dB = dh.getWritableDatabase();
        String deleteQuery = "DELETE FROM " + Data.MenuData.TABLE_NAME;
        dB.execSQL(deleteQuery);//
        Iterator<Post> iter = list.iterator();
        while (iter.hasNext()) {
            putToSQL(iter.next());
        }
    }

    public void putToSQL(Post post) {

        String formatString = " VALUES ('%s','%s','%s','%s','%s')";
        String insertQuery1 = String.format(formatString, post.getTitle(),
                post.getDescription(), post.getCost(), post.getImage(), post.getCategory());
        String insertQuery = "INSERT INTO " +
                Data.MenuData.TABLE_NAME +
                " (" + Data.MenuData.COLUMN_TITLE + ","
                + Data.MenuData.COLUMN_DESCRIPTION + ","
                + Data.MenuData.COLUMN_COST + ","
                + Data.MenuData.COLUMN_IMAGE + ","
                + Data.MenuData.COLUMN_CATEGORY + ")" + insertQuery1;
        dB.execSQL(insertQuery);
    }

    public LiveData<List<Post>> getData() {
        getDataFromNetwork();
        return postList;
    }

    public List<Post> getFromDB() {
        ArrayList<Post> newList = new ArrayList<>();

        dh = new DataDbHelper(newContext);
        String query = "SELECT * FROM "
                + Data.MenuData.TABLE_NAME;
        dB = dh.getReadableDatabase();
        Cursor cursor = dB.rawQuery(query, null);

        while (cursor.moveToNext()) {
            Post post = new Post();
            @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(Data.MenuData.COLUMN_TITLE));
            @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex(Data.MenuData.COLUMN_DESCRIPTION));
            @SuppressLint("Range") Integer cost = cursor.getInt(cursor.getColumnIndex(Data.MenuData.COLUMN_COST));
            @SuppressLint("Range") String image = cursor.getString(cursor.getColumnIndex(Data.MenuData.COLUMN_IMAGE));
            @SuppressLint("Range") Integer category = cursor.getInt(cursor.getColumnIndex(Data.MenuData.COLUMN_CATEGORY));
            post.setTitle(title);
            post.setDescription(description);
            post.setCost(cost);
            post.setImage(image);
            post.setCategory(category);
            newList.add(post);
        }

        return newList;
    }
}

