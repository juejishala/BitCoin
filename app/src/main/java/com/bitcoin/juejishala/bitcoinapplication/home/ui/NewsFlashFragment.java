package com.bitcoin.juejishala.bitcoinapplication.home.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bitcoin.juejishala.bitcoinapplication.R;

/**
 *
 * @author yinyayue
 * @date 2018/3/16
 */

public class NewsFlashFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, null);
    }
}