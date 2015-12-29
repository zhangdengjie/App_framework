package com.zdj.app.ui.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zdj.app.R;
import com.zdj.app.base.BaseFragment;

import butterknife.Bind;

/**
 * 空界面
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment {

    @Bind(R.id.my_image_view)
    SimpleDraweeView draweeView;


    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Uri uri = Uri.parse("http://images.55bbs.com/55shuoimg/pic/34/27/ea/3427ea2f91e9ea337700262a46cdbcbc.jpg");
        draweeView.setImageURI(uri);
    }

}
