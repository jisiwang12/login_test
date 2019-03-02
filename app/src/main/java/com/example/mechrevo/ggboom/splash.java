package com.example.mechrevo.ggboom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import static java.lang.Thread.sleep;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread() {//创建子线程


            public void run() {
                try {
                    sleep(1000);//使程序休眠1秒
                    Intent intent = new Intent(splash.this, MainActivity.class);//启动MainActivity
                    startActivity(intent);
                    finish();//关闭当前活动
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();//启动线程
    }
}



