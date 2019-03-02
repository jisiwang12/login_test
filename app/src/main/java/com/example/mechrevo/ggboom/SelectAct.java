package com.example.mechrevo.ggboom;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectAct extends AppCompatActivity implements View.OnClickListener {
    private Button del,cancel;
    private EditText content;
    private NotesDB notesDB;
    private SQLiteDatabase dbwriter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_select);
        //System.out.println(getIntent().getIntExtra(NotesDB.ID,0));
        initView();
    }

    public void initView() {
        del=findViewById(R.id.bt_del);
        cancel=findViewById(R.id.bt_cancel);
        content=findViewById(R.id.tv_saved);
        notesDB=new NotesDB(this);
        dbwriter=notesDB.getWritableDatabase();
        del.setOnClickListener(this);
        cancel.setOnClickListener(this);
        content.setText(getIntent().getStringExtra(NotesDB.CONTENT));
    }

    @Override
    public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.bt_del:
                    delDate();
                    finish();
                    break;

                case R.id.bt_cancel:
                    delDate();
                    addDB();
                    finish();
                        break;

            }
    }
    public void addDB() {
        ContentValues cv = new ContentValues();
        cv.put(NotesDB.CONTENT, content.getText().toString());
        cv.put(notesDB.TIME, getTime());
        dbwriter.insert(NotesDB.TABLE_NAME, null, cv);
    }
    private String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date();
        String str = format.format(date);
        return str;
    }
    public void delDate(){
        dbwriter.delete(NotesDB.TABLE_NAME,
                "_id="+getIntent().getIntExtra(NotesDB.ID,0),null);

    }
}
