package com.syc.an36_designui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void start(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    public void coordinator(View view) {
        start(CoordinatorActivity.class);
    }

    public void inputEdit(View view) {
        start(InputActivity.class);
    }

    public void complexUi(View view) {
        start(ComplexUiActivity.class);
    }
}
