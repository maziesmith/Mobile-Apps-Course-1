package com.davenotdavid.samplepuzzle.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Angelo on 11/04/2018.
 */

public class DatabaseController {

    private final Context context;
    private DataBaseHelper dbHelper;
    private SQLiteDatabase database;

    public void saveToDatabase(String newScore) {
        String score = newScore.split("\\|")[0];
        String name = newScore.split("\\|")[1];
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("score", score);
        values.put("date", new Date().getTime());

        database.insert("scores", null, values);


    }

    public DatabaseController open() {
        dbHelper = new DataBaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public DatabaseController(Context context) {
        this.context = context;
    }


    public void close() {
        dbHelper.close();
    }

    public ArrayList<String> getSavedData() {
        ArrayList<String> savedData = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String tableString = String.format("Table %s:\n", "scores");
        Cursor allRows = db.rawQuery("SELECT * FROM scores", null);
        if (allRows.moveToFirst()) {
            String[] columnNames = allRows.getColumnNames();
            do {
                for (String name : columnNames) {
                    savedData.add(allRows.getString(allRows.getColumnIndex(name)));
                }
                tableString += "\n";

            } while (allRows.moveToNext());
        }

        return savedData;
    }
}
