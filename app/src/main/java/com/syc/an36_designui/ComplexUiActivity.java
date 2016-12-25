package com.syc.an36_designui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class ComplexUiActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private FloatingActionButton fab;
    private ViewPager mVp;
    private String[] navigations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_complex_ui);

        initView();

        navigations = getResources().getStringArray(R.array.navigations);

        //填充菜单
        mToolbar.inflateMenu(R.menu.over_flow_menu);
        //设置溢出菜单的图标
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setOverflowIcon(getDrawable(R.mipmap.ic_menu_more_overflow));
        }

        //开关抽屉
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.closeDrawers();
                }
            }
        });

        //关联ViewPager的适配器
        mVp.setAdapter(new MyAdapter(getSupportFragmentManager()));

        //TabLayout和ViewPager关联在一起
        mTabLayout.setupWithViewPager(mVp, true);
        //添加导航标签
        //mTabLayout.addTab(mTabLayout.newTab().setText());
        //设置指示器的颜色
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#6BFE69"));
        //设置指示器的高度
        mTabLayout.setSelectedTabIndicatorHeight(4);
        //设置文字颜色
        mTabLayout.setTabTextColors(Color.WHITE, Color.parseColor("#F5C838"));
        //导航模式
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        //mTabLayout.addOnTabSelectedListener(new ViewPager.SimpleOnPageChangeListener(){});
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mVp) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                Log.i("TAG", "选中了" + tab.getText());
            }
        });

        //显示SnackBar
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "消息", Snackbar.LENGTH_LONG).setAction("点我", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ComplexUiActivity.this, "点了...", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.WHITE).show();
            }
        });
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //mNavigation = (NavigationView) findViewById(R.id.navigation_view);
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mVp = (ViewPager) findViewById(R.id.vp);
        fab = (FloatingActionButton) findViewById(R.id.fab_content);
    }

    //ViewPager的适配器
    class MyAdapter extends FragmentPagerAdapter {

        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.createFragment(position, navigations[position]);
        }

        @Override
        public int getCount() {
            return navigations.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return navigations[position];
        }
    }
}
