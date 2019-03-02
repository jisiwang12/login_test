package com.example.mechrevo.ggboom;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    private TextView contenttv;
    private TextView listTime;
    private LinearLayout layout;
    private Context context;
    private Cursor cursor;

    public MyAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return cursor.getPosition();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        layout = (LinearLayout) inflater.inflate(R.layout.cell, null);
        contenttv = layout.findViewById(R.id.list_content);
        listTime = layout.findViewById(R.id.list_time);
        cursor.moveToPosition(position);            //moveToPosition移动到指定行
        String content=cursor.getString(cursor.getColumnIndex("content")); //getColumnIndex返回列名对应的列索引值，不存在是返回-1
        String time=cursor.getString(cursor.getColumnIndex("time"));
        contenttv.setText(content);//传递参数
        listTime.setText(time);
        return layout;
    }
}
