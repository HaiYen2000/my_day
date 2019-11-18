package com.lamlt.my_day;

public class Constants {

    public static final boolean isCreated = true;

    //Note Table
    public static final String NOTE_TABLE = "note";
    //Column
    public static final String NOTE_ID = "id";
    public static final String NOTE_TITLE = "title";
    public static final String NOTE_CONTENT = "content";
    public static final String NOTE_DATE = "created_date";
    //Query create note(id(integer primary key autoincrement), title (nvarchar(255)), content (nvarchar(255) not null), created_date (text not null)
    public static final String CREATE_NOTE_TABLE = "CREATE TABLE " + NOTE_TABLE + "(" +
            "" + NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            "" + NOTE_TITLE + " NVARCHAR(255)," +
            "" + NOTE_CONTENT + " NCHAR(255) NVARCHAR(255) NOT NULL," +
            "" + NOTE_DATE + " TEXT NOT NULL" +
            ")";

    public static final int NUM_COLUMNS = 2;

}
