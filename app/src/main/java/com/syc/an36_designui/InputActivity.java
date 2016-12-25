package com.syc.an36_designui;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends Activity {

    private TextInputLayout txtLayout;
    private EditText etName;
    private TextInputEditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        txtLayout = (TextInputLayout) findViewById(R.id.input_layout);
        etName = (EditText) findViewById(R.id.et_name);
        etPass = (TextInputEditText) findViewById(R.id.et_pass);
    }

    //登录
    public void login(View view) {
        String name = etName.getText().toString().trim();
        if ("abc".equals(name)) {
            txtLayout.setErrorEnabled(false);
            txtLayout.setError("正确");
        } else {
            txtLayout.setErrorEnabled(true);
            txtLayout.setError("错误");
        }

        //获取密码
        String pass = etPass.getText().toString();
        if ("123".equals(pass)) {
            etPass.setError("正确");
        } else {
            etPass.setError("错误");
        }
    }
}
