package com.example.testtask.ui.home.database;

import android.provider.BaseColumns;

public class Data {
    public static final class MenuData implements BaseColumns {
        public final static String TABLE_NAME = "Menu";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_TITLE = "Title";
        public final static String COLUMN_DESCRIPTION = "Parts";
        public final static String COLUMN_COST = "Cost";
        public final static String COLUMN_IMAGE = "Image";
        public final static String COLUMN_CATEGORY = "Category";

    }

}
