package com.example.thuanhuynh.ktgiuaky;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thuanhuynh on 4/3/18.
 */

public class Helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "HV.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_THUCHI = "TABLE_THUCHI";
    public static final String ID = "ID";
    public static final String NOIDUNG = "NOIDUNG";
    public static final String SOTIEN = "SOTIEN";
    public static final String HINHTHUC = "HINHTHUC";


    public static final String CREATE_TABLE_THUCHI = "CREATE TABLE "+TABLE_THUCHI+"(\n" +
            ID+" INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            NOIDUNG+" TEXT NOT NULL,\n" +
            SOTIEN+" TEXT NOT NULL,\n" +
            HINHTHUC+" TEXT NOT NULL);";

    public Helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_THUCHI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public SQLiteDatabase OpenDatabase(){
        return getWritableDatabase();
    }
    public void CloseDatabase(){
        close();
    }
}
