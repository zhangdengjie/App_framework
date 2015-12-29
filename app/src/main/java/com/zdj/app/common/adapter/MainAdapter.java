package com.zdj.app.common.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zdj.app.common.holder.MainViewholder;
import com.zdj.app.vo.response.MainInfo;

/**
 * 主页列表适配器
 * Created by dengjie on 2015/12/27.
 */
public class MainAdapter extends RecyclerArrayAdapter<MainInfo> {
    public MainAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewholder(parent);
    }
}
