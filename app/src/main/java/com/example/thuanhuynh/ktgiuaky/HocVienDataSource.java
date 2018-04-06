package com.example.thuanhuynh.ktgiuaky;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by thuanhuynh on 4/3/18.
 */

public class HocVienDataSource {
    Context context;
    Helper helper;
    public HocVienDataSource(Context context) {
        this.context = context;
        helper = new Helper(context,Helper.DATABASE_NAME,null,Helper.DATABASE_VERSION);
    }
    public void ThemHocVien(HocVien hv){
        ContentValues content = new ContentValues();
        content.put(Helper.NOIDUNG,hv.getnoiDung());
        content.put(Helper.SOTIEN,hv.getsoTien());
        content.put(Helper.HINHTHUC,hv.gethinhThuc());
        SQLiteDatabase db = helper.OpenDatabase();
        db.insert(Helper.TABLE_THUCHI,null,content);
    }
    public ArrayList<HocVien> LietKeHV(){
        ArrayList<HocVien> listHocVien = new ArrayList<HocVien>();
        SQLiteDatabase db = helper.OpenDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Helper.TABLE_THUCHI,null);
        c.moveToFirst();
        if (c.getCount()>0){
            while (!c.isAfterLast()){
                listHocVien.add(new HocVien(c.getString(1),c.getString(2),c.getInt(3)));
                c.moveToNext();
            }
        }
        helper.CloseDatabase();
        return listHocVien;
    }
}
