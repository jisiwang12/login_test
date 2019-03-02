package com.example.mechrevo.ggboom;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class addcontent extends AppCompatActivity implements View.OnClickListener {
    private Button savebtn, delbtn;
    private EditText editText;
    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_addcontent);
        savebtn = findViewById(R.id.bt_sava);
        delbtn = findViewById(R.id.bt_delete);
        editText = findViewById(R.id.et_content);
        savebtn.setOnClickListener(this);
        delbtn.setOnClickListener(this);
        notesDB = new NotesDB(this);
        dbWriter = notesDB.getWritableDatabase();//获取写入的权限

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_sava:
                addDB();
                finish();
                break;

            case R.id.bt_delete:
                finish();

                break;


        }
    }

    public void addDB() {
        ContentValues cv = new ContentValues();
        cv.put(NotesDB.CONTENT, editText.getText().toString());
        cv.put(notesDB.TIME, getTime());
        dbWriter.insert(NotesDB.TABLE_NAME, null, cv);
    }

    private String getTime() {//获取当前时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date();
        String str = format.format(date);
        return str;
    }
}
