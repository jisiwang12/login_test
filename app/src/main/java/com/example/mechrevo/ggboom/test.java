package com.example.mechrevo.ggboom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class test extends AppCompatActivity {
    private CardView addthing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        addthing=findViewById(R.id.cv_addthings);
    }

    public void addthings(View v)
    {
        Intent intent=new Intent(test.this,Things.class);
        startActivity(intent);

    }
}
