package com.bitcoin.juejishala.bitcoin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Created by yinyayue on 2018/3/25.
 */

public class SyncHorizontalScrollView extends HorizontalScrollView {
    private View mSyncScrollView;

    public SyncHorizontalScrollView(Context context) {
        super(context);
    }

    public SyncHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        //设置联动的滚动view滚动事件
        if (mSyncScrollView != null) {
            mSyncScrollView.scrollTo(l, t);
        }
    }

    public void setmSyncScrollView(View view) {
        this.mSyncScrollView = view;
    }
}
