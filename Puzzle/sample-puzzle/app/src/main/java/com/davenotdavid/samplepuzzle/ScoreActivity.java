package com.davenotdavid.samplepuzzle;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.davenotdavid.samplepuzzle.db.DatabaseController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {

    public static final java.lang.String SCORE_EXTRA = "SCORE";
    ArrayList<String> list;
    StableArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Bundle extras = getIntent().getExtras();

        int scoreType = extras.getInt("score");

        ListView scoreList = (ListView) findViewById(R.id.list_score);

        DatabaseController db = new DatabaseController(this);
        if (extras != null) {


            final String newScore = extras.getString(SCORE_EXTRA);

            saveToStorage(newScore, Environment.getExternalStorageDirectory());
            saveToStorage(newScore, getFilesDir());
            db.open();
            db.saveToDatabase(newScore);

        }

        if (Singleton.getInstance().getList() == null) {
            Singleton.getInstance().setList(new ArrayList<String>());
            switch (scoreType) {
                //interna
                case 0:
                    Singleton.getInstance().setList(getScoreFromStorage(getFilesDir()));
                    break;
                //externa
                case 1:
                    Singleton.getInstance().setList(getScoreFromStorage(Environment.getExternalStorageDirectory()));
                    break;
                //db
                case 2:
                    Singleton.getInstance().setList(db.getSavedData());
                    break;
            }
        }
        db.close();


        adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, Singleton.getInstance().getList());
        scoreList.setAdapter(adapter);
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap;

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            mIdMap = new HashMap<String, Integer>();
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }

    public void saveToStorage(String score, File storage) {
        File exportDir = new File(storage + "/" + getString(R.string.app_name), "");
        if (!exportDir.exists()) exportDir.mkdirs();

        File file = new File(exportDir.getAbsolutePath(), "score.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(score);
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getScoreFromStorage(File storage) {
        ArrayList<String> scores = new ArrayList<>();
        File exportDir = new File(storage + "/" + getString(R.string.app_name), "");
        if (!exportDir.exists()) exportDir.mkdirs();

        File file = new File(exportDir.getAbsolutePath(), "score.txt");
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);

            BufferedReader buffer = new BufferedReader(fileReader);
            String line = "";
            while ((line = buffer.readLine()) != null) {
                scores.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }
}
