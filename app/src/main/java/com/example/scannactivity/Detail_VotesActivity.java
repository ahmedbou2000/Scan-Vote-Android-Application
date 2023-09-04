package com.example.scannactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Detail_VotesActivity extends AppCompatActivity {

    private ListView listView ;
    private List<Votes> vt= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_votes);

        listView = findViewById(R.id.listView);


        SQLiteDatabase db = DatabaseHelper.getInctance(getApplicationContext()).getReadableDatabase();

        Cursor cursor = db.rawQuery("select ref,count(*) as count , choix from votes group by choix,ref ORDER BY ref,count",null);
        while (cursor.moveToNext()){
            Votes vote = new Votes();
            vote.setRef(cursor.getString(0));
            vote.setCount(cursor.getInt(1));
            vote.setChoix(cursor.getString(2));
            vt.add(vote);
        }
        ArrayAdapter<Votes> adapter = new ArrayAdapter<Votes>(getApplicationContext(),
                R.layout.vote_item,R.id.item,vt);
        listView.setAdapter(adapter);

    }
}