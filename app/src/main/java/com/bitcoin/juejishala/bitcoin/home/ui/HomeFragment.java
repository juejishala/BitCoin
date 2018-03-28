package com.bitcoin.juejishala.bitcoin.home.ui;

        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.bitcoin.juejishala.bitcoin.R;
        import com.bitcoin.juejishala.bitcoin.utils.GlideUtils;

/**
 * @author yinyayue
 * @date 2018/3/16
 */

public class HomeFragment extends Fragment {
    private TextView mTvHome;
    private ImageView mIvHome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTvHome = view.findViewById(R.id.tv_home);
        mTvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setImage();
            }
        });
        mIvHome = view.findViewById(R.id.iv_home);
    }

    private void setImage() {
        String imageURL = "http://test.pan.chaoxing.com/thumbnail/origin/432b922b7bac26197abba2c2d27d1f35";
        imageURL = imageURL.replaceFirst("origin", "100,100,50");
        GlideUtils.displayImage(getContext(), imageURL, mIvHome, R.drawable.ic_launcher);
    }
}
