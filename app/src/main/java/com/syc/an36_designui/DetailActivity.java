package com.syc.an36_designui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        String logoName = intent.getStringExtra("logo");

        CollapsingToolbarLayout mCollapseLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_layout);
        ImageView ivDetail = (ImageView) findViewById(R.id.iv_detail);
        Toolbar mTool = (Toolbar) findViewById(R.id.tool_detail);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_detail);

        mTool.inflateMenu(R.menu.over_flow_menu);
        mTool.setOverflowIcon(getResources().getDrawable(R.mipmap.ic_menu_more_overflow));
        mTool.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //设置图片
        int mipmap = getResources().getIdentifier(logoName, "mipmap", getPackageName());
        ivDetail.setImageResource(mipmap);

        //设置标题
        mCollapseLayout.setTitle(name);
        //设置折叠时的文字颜色
        mCollapseLayout.setCollapsedTitleTextColor(Color.WHITE);
        //展开式的文字颜色
        mCollapseLayout.setExpandedTitleColor(Color.parseColor("#888888"));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this, "Name=" + name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
