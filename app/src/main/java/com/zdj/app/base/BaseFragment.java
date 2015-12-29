package com.zdj.app.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.ButterKnife;

/**
 * 碎片基类
 * Created by dengjie on 2015/12/28.
 */
public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;
    protected View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = getActivity();
        Fresco.initialize(mActivity);
        rootView = inflater.inflate(getLayoutId(), null);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initView();
        initEvent();
    }

    /**
     * 获取布局id <br/>
     * 作者 ：dengjie <br/>
     * created at 2015/12/28 18:34
     */
    protected abstract int getLayoutId();

    /**
     * 初始化事件 <br/>
     * 作者 ：dengjie <br/>
     * created at 2015/12/28 18:36
     */
    protected abstract void initEvent();

    /**
     * 初始化数据 <br/>
     * 作者 ：dengjie <br/>
     * created at 2015/12/28 18:36
     */
    protected abstract void initData();

    /**
     * 初始化view <br/>
     * 作者 ：dengjie <br/>
     * created at 2015/12/28 19:32
     */
    protected abstract void initView();
}
