package com.bitcoin.juejishala.bitcoin.home.ui;

import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bitcoin.juejishala.bitcoin.R;
import com.bitcoin.juejishala.bitcoin.base.BaseActivity;

/**
 * @author yinyayue
 */
public class MainActivity extends BaseActivity {

    private FragmentTabHost mTabHost;
    private FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTabHost = findViewById(R.id.tab_host);
        mContainer = findViewById(R.id.fragment_container);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.fragment_container);
        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.home)).setIndicator(getTabIndicator(getString(R.string.home))),
                HomeFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.news_flash)).setIndicator(getTabIndicator(getString(R.string.news_flash))),
                RankingFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.ranking)).setIndicator(getTabIndicator(getString(R.string.ranking))),
                RankingFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(getString(R.string.mine)).setIndicator(getTabIndicator(getString(R.string.mine))),
                MineFragment.class, null);

    }

    /**
     * 自定义tabIndicator布局
     *
     * @param tabName
     * @return
     */
    private View getTabIndicator(String tabName) {
        View view = View.inflate(MainActivity.this, R.layout.tab_indicator, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon_tab);
        TextView textView = (TextView) view.findViewById(R.id.txt_indicator);
        textView.setText(tabName);
        return view;
    }
}
