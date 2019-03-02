package com.example.mechrevo.ggboom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private EditText editTextun;
    private EditText editTextpw;
    private Button button;
    private CheckBox checkBox;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextun = (EditText) findViewById(R.id.et_username);
        editTextpw = (EditText) findViewById(R.id.et_passwd);
        button = (Button) findViewById(R.id.button);
        CheckBox checkBox=(CheckBox) findViewById(R.id.checkBox);
        checkBox.setChecked(true);
        SharedPreferences sp=getSharedPreferences("namepw",0);
        //使用SP将保存的用户名取出来
        String username1  = editTextun.getText().toString().trim();
        String a=sp.getString("u"+"a","");
        editTextun.setText(a);
    }
    public void zuce (View view){                        //点击跳转注册页面
        Intent intent=new Intent(MainActivity.this,register.class);
        startActivity(intent);

    }
    //点击进入主页面
    public void login(View view) {
        String username1  = editTextun.getText().toString().trim();
        String passwd1    = editTextpw.getText().toString().trim();
        Intent intent = new Intent(MainActivity.this, test.class);
            if (TextUtils.isEmpty(username1) || TextUtils.isEmpty(passwd1)) {
                Toast.makeText(MainActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences sp = getSharedPreferences("namepw", 0);
                //获取用户名和密码
                String a = sp.getString("u"+username1, "");
                String b = sp.getString("pw"+username1, "");
                //判断用户名和密码是否正确
                if (username1.equals(a) && passwd1.equals(b)) {
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }

        }

}
