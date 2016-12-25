package com.syc.an36_designui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class CoordinatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_coordinator);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //处理点击事件
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //展示SnackBar
                Snackbar bar = Snackbar.make(v, "展示的内容.....", Snackbar.LENGTH_LONG).setAction("点我啊", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CoordinatorActivity.this, "点击了..", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.RED);

                //获取SnackBar的背景视图
                View view = bar.getView();
                view.setBackgroundColor(Color.BLUE);
                //不要忘记show出来
                bar.show();
                //bar.dismiss();
            }
        });

    }

}
