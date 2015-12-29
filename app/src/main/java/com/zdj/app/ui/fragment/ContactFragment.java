package com.zdj.app.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zdj.app.R;
import com.zdj.app.base.BaseFragment;
import com.zdj.app.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 联系人界面
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends BaseFragment {

    @Bind(R.id.rv_contact)
    RecyclerView rv_contact;

    RvAdapter rvAdapter;



    public ContactFragment() {
        // Required empty public constructor
    }



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_contact;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            list.add(StringUtils.randomStr(11));
        }
        rvAdapter = new RvAdapter(list);
    }

    @Override
    protected void initView() {
        rv_contact.setLayoutManager(new LinearLayoutManager(mActivity));
        rv_contact.setAdapter(rvAdapter);
    }

    private class RvAdapter extends RecyclerView.Adapter{

        List<String> res;

        public RvAdapter(List<String> res) {
            this.res = res;
        }

        /**
         * 创建viewholder继承自RecyclerView.ViewHolder
         * 自定义viewholder
         */

        class Viewholder extends RecyclerView.ViewHolder {
            View root;//构造器中传入根节点   通过根节点获得控件对象
            TextView tv_telephone, tv_name;

            public Viewholder(View root) {
                super(root);
                tv_telephone = (TextView) root.findViewById(R.id.tv_telephone);
                tv_name = (TextView) root.findViewById(R.id.tv_name);
            }

            public TextView getTv_telephone() {
                return tv_telephone;
            }

            public TextView getTv_name() {
                return tv_name;
            }
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Viewholder(LayoutInflater.from(mActivity).inflate(R.layout.item_contact, null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Viewholder vh = (Viewholder) holder;
            vh.getTv_telephone().setText(res.get(position));
            vh.getTv_name().setText(res.get(position));
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemCount() {
            return res.size();
        }
    }

}
