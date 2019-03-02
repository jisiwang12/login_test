package com.example.mechrevo.ggboom;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Things extends AppCompatActivity  {
    private FloatingActionButton textbtn;
    private ListView lv;
    private Intent intent;
    private MyAdapter adapter;
    private NotesDB notesDB;
    private Cursor cursor;
    private SQLiteDatabase dbreader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_things);
        initView();
    }


    @Override
    protected void onResume() {
        super.onResume();
        selectdb();
    }


    public void initView() {
        textbtn = findViewById(R.id.text);
        lv = findViewById(R.id.list);
        notesDB = new NotesDB(this);
        dbreader = notesDB.getReadableDatabase();
        textbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Things.this, addcontent.class);
                startActivity(intent);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Cursor corsor1=dbreader.query(NotesDB.TABLE_NAME,null,null,null,null,null,null);
                cursor=dbreader.query(NotesDB.TABLE_NAME,null,null,null,
                        null,null,null);
                    cursor.moveToPosition(position);
                    Intent i = new Intent(Things.this, SelectAct.class);
                    i.putExtra(NotesDB.ID, cursor.getInt(cursor.getColumnIndex(NotesDB.ID)));
                    i.putExtra(NotesDB.CONTENT, cursor.getString(cursor.getColumnIndex(NotesDB.CONTENT)));//getColumnIndex返回某列名对应的列索引值，如果不存在返回-1
                    i.putExtra(NotesDB.TIME, cursor.getString(cursor.getColumnIndex(NotesDB.TIME)));
                    startActivity(i);

            }
        });
    }

    public void selectdb() {
        Cursor corsor = dbreader.query(NotesDB.TABLE_NAME, null, null, null, null, null, null);
        adapter = new MyAdapter(this, corsor);
        lv.setAdapter(adapter);
    }

public void GGG(){

}

}
