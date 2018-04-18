package com.davenotdavid.samplepuzzle.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    //FILE DB PROP
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "scores.db";
    //TABLE AND COLUMNS VAR
    //SCRIPT
    private static final String CREATE_TABLE =
            "create table scores(name text primary key,score int, fecha date);";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    public String getTableAsString() {
        SQLiteDatabase db = this.getReadableDatabase();
        String tableString = String.format("Table %s:\n", "scores");
        Cursor allRows = db.rawQuery("SELECT * FROM scores", null);
        if (allRows.moveToFirst()) {
            String[] columnNames = allRows.getColumnNames();
            do {
                for (String name : columnNames) {
                    tableString += String.format("%s: %s\n", name,
                            allRows.getString(allRows.getColumnIndex(name)));
                }
                tableString += "\n";

            } while (allRows.moveToNext());
        }

        return tableString;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS scores");
        onCreate(db);
    }
}