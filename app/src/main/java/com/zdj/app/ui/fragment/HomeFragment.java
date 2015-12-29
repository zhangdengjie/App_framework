package com.zdj.app.ui.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zdj.app.R;
import com.zdj.app.base.BaseFragment;
import com.zdj.app.common.adapter.MainAdapter;
import com.zdj.app.ui.helper.UIHelper;
import com.zdj.app.utils.StringUtils;
import com.zdj.app.vo.response.MainInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 主页
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recyclerView)
    EasyRecyclerView recyclerView;

    MainAdapter mainAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    private List<MainInfo> initMainInfo(){
        List<MainInfo> mainInfos = new ArrayList<>();
        MainInfo mainInfo = null;
        for(int i = 0; i < 20; i++){
            mainInfo = new MainInfo();
            mainInfo.name = StringUtils.randomStr(3);
            mainInfo.telephone = StringUtils.randomStr(11);
            mainInfos.add(mainInfo);
            mainInfo = null;
        }
        return mainInfos;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }



    @Override
    protected void initEvent() {
        recyclerView.setRefreshListener(this);
    }

    @Override
    protected void initData() {
        mainAdapter = new MainAdapter(mActivity);
        mainAdapter.addAll(initMainInfo());
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        recyclerView.setAdapterWithProgress(mainAdapter);
        mainAdapter.setMore(R.layout.view_more, this);
        mainAdapter.setNoMore(R.layout.view_nomore);
    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    public void onLoadMore() {
        UIHelper.showToast(mActivity, "加载更多");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mainAdapter.addAll(new ArrayList<MainInfo>());
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        UIHelper.showToast(mActivity, "下拉刷新");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mainAdapter.clear();
                mainAdapter.addAll(initMainInfo());
            }
        }, 2000);
    }
}
