package com.lamlt.my_day.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.lamlt.my_day.Constants;

import static com.lamlt.my_day.Constants.CREATE_NOTE_TABLE;
import static com.lamlt.my_day.Constants.NOTE_TABLE;

public class DBHelper extends SQLiteOpenHelper{


    public DBHelper(@Nullable Context context) {
        super(context, "myday.sql", null, 1);
        if(Constants.isCreated){
            Log.i("CREATE_NOTE_TABLE", CREATE_NOTE_TABLE);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_NOTE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NOTE_TABLE);
    }
}
