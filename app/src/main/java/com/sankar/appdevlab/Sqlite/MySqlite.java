package com.sankar.appdevlab.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqlite extends SQLiteOpenHelper {
    public MySqlite(Context context) {
        super(context, "Scriptons.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CROP(ID INTEGER PRIMARY KEY, NAME VARCHAR(50),WATER_LEVEL INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CROP");
        onCreate(db);
    }
    public void insert(String Name,int water_level)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME",Name);
        contentValues.put("WATER_LEVEL",water_level);
        sqLiteDatabase.insert("CROP",null,contentValues);
    }
    public Cursor getData(String Name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM CROP WHERE NAME="+Name+"", null );
        return res;
    }
}
