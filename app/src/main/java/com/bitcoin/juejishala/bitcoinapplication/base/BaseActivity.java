package com.bitcoin.juejishala.bitcoinapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bitcoin.juejishala.bitcoinapplication.utils.InputMethodUtils;

/**
 * @author yinyayue
 * @date 2018/3/13
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void hideSoftInput() {
        hideSoftInput(null);
    }

    public void hideSoftInput(View view) {
        if (isFinishing()) {
            return;
        }
        View focusView = view;
        if (focusView == null) {
            focusView = getCurrentFocus();
            if (focusView == null) {
                focusView = getWindow().getDecorView().getRootView();
            }
            if (focusView == null) {
                focusView = new View(this);
            }
        }
        InputMethodUtils.hideSoftInput(focusView);
    }

    public void showSoftInput(View view) {
        if (isFinishing()) {
            return;
        }
        InputMethodUtils.showSoftInput(view);
    }
}
