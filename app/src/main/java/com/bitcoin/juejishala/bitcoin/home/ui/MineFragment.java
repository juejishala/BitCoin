package com.bitcoin.juejishala.bitcoin.home.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bitcoin.juejishala.bitcoin.R;
import com.bitcoin.juejishala.bitcoin.view.PullZoomView;

/**
 * @author yinyayue
 * @date 2018/3/16
 */

public class MineFragment extends Fragment {
    private PullZoomView mPullHeader;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mPullHeader = view.findViewById(R.id.zoom_header);
        setZoomHeader();
    }

    private void setZoomHeader() {
        mPullHeader.setIsParallax(true);
        mPullHeader.setIsZoomEnable(true);
        mPullHeader.setSensitive(1.5f);
        mPullHeader.setZoomTime(500);
        mPullHeader.setOnScrollListener(new PullZoomView.OnScrollListener() {
            @Override
            public void onScroll(int l, int t, int oldl, int oldt) {
                System.out.println("onScroll   t:" + t + "  oldt:" + oldt);
            }

            @Override
            public void onHeaderScroll(int currentY, int maxY) {
                System.out.println("onHeaderScroll   currentY:" + currentY + "  maxY:" + maxY);
            }

            @Override
            public void onContentScroll(int l, int t, int oldl, int oldt) {
                System.out.println("onContentScroll   t:" + t + "  oldt:" + oldt);
            }
        });
    }
}
