package com.example.testtask.ui.home.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.testtask.ui.home.database.Data;

public class DataDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Data.db";
    private static final int DATABASE_VERSION = 1;
    public DataDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Строка для создания таблицы


        String SQL_CREATE_DATA_TABLE = "CREATE TABLE " + Data.MenuData.TABLE_NAME + " ("
                + Data.MenuData._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Data.MenuData.COLUMN_TITLE + " TEXT NOT NULL, "
                + Data.MenuData.COLUMN_DESCRIPTION + " TEXT NOT NULL ,"
                + Data.MenuData.COLUMN_COST + " INTEGER NOT NULL,"
                + Data.MenuData.COLUMN_IMAGE + " TEXT NOT NULL,"
                +Data.MenuData.COLUMN_CATEGORY+ " INTEGER NOT NULL)";


        // Запускаем создание таблицы
        db.execSQL(SQL_CREATE_DATA_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_NAME);
        //onCreate(db);
       /* if(newVersion>oldVersion) {
            db.execSQL("DROP TABLE " + DATABASE_NAME);
            onCreate(db);
        }*/

    }
}

