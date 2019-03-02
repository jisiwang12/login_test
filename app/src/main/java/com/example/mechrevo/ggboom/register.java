package com.example.mechrevo.ggboom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    private EditText ed;
    private EditText editTextpw1;
    private EditText editTexpw2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ed=findViewById(R.id.et_username1);
        editTextpw1=findViewById(R.id.et_passwd1);
        editTexpw2=findViewById(R.id.et_ckpasswd);
        Button button=(Button)findViewById(R.id.register);
    }

    public void register1(View view){
        String u=ed.getText().toString().trim();
        String pw=editTextpw1.getText().toString().trim();
        String ckpw=editTexpw2.getText().toString().trim();
        if(TextUtils.isEmpty(u) || TextUtils.isEmpty(pw) || TextUtils.isEmpty(ckpw)) {

        }
        else {
            if (pw.equals(ckpw)) {               //判断两次密码是否一致
                Intent intent = new Intent(register.this, MainActivity.class);
                SharedPreferences sp = getSharedPreferences("namepw", 0);//Sp方法
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("u" + u, u);
                editor.putString("pw" + u, pw);
                editor.commit();
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(register.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
